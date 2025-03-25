package com.sanghoon.batch.test2.job;

import com.sanghoon.batch.test2.step.Test2StepConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Test2JobConfig {

    private final JobRepository jobRepository;

    private final Test2StepConfig stepConfig;

    public Test2JobConfig(JobRepository jobRepository, Test2StepConfig stepConfig) {
        this.jobRepository = jobRepository;
        this.stepConfig = stepConfig;
    }

    @Bean(name = "test2Job")
    public Job test2Job() {
        return new JobBuilder("test2Job", jobRepository)
                .start(stepConfig.test2StepOne())
                .next(stepConfig.test2StepTwo())
                .next(stepConfig.test2StepThree())
                .build();
    }

}
