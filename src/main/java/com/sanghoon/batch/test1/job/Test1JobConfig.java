package com.sanghoon.batch.test1.job;

import com.sanghoon.batch.test1.step.Test1StepConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Test1JobConfig {

    private final JobRepository jobRepository;

    private final Test1StepConfig stepConfig;

    public Test1JobConfig(JobRepository jobRepository, Test1StepConfig stepConfig) {
        this.jobRepository = jobRepository;
        this.stepConfig = stepConfig;
    }

    @Bean(name = "test1Job")
    public Job test1Job() {
        return new JobBuilder("test1Job", jobRepository).start(stepConfig.test1StepOne())
                                                        .next(stepConfig.test1StepTwo())
                                                        .next(stepConfig.test1StepThree())
                                                        .build();
    }

}
