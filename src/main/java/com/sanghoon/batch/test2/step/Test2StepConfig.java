package com.sanghoon.batch.test2.step;

import com.sanghoon.batch.test2.tasklet.Test2Tasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class Test2StepConfig {

    private final JobRepository jobRepository;

    private final PlatformTransactionManager transactionManager;

    private final Test2Tasklet tasklet;

    public Test2StepConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager, Test2Tasklet tasklet) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.tasklet = tasklet;
    }

    public Step test2StepOne() {
        return new StepBuilder("Test2StepOne", jobRepository)
                .tasklet(tasklet::executeStepOne, transactionManager)
                .build();
    }

    public Step test2StepTwo() {
        return new StepBuilder("Test2StepTwo", jobRepository)
                .tasklet(tasklet::executeStepTwo, transactionManager)
                .build();
    }

    public Step test2StepThree() {
        return new StepBuilder("Test2StepThree", jobRepository)
                .tasklet(tasklet::executeStepThree, transactionManager)
                .build();
    }

}
