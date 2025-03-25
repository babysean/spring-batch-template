package com.sanghoon.batch.test1.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Test1Scheduler {

    private final JobLauncher jobLauncher;

    private final Job test1Job;

    public Test1Scheduler(JobLauncher jobLauncher, Job test1Job) {
        this.jobLauncher = jobLauncher;
        this.test1Job = test1Job;
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void runMultiStepJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("currentTime", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(test1Job, jobParameters);
        } catch (JobExecutionException e) {
            e.printStackTrace();
        }
    }

}
