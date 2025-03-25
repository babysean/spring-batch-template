package com.sanghoon.batch.test2.scheduler;

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
public class Test2Scheduler {

    private final JobLauncher jobLauncher;

    private final Job test2Job;

    public Test2Scheduler(JobLauncher jobLauncher, Job test2Job) {
        this.jobLauncher = jobLauncher;
        this.test2Job = test2Job;
    }

    @Scheduled(cron = "0/20 * * * * ?")
    public void runTest2Job() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("currentTime", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(test2Job, jobParameters);
        } catch (JobExecutionException e) {
            e.printStackTrace();
        }
    }

}
