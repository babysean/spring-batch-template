package com.sanghoon.batch.test1.step;

import com.sanghoon.batch.test1.tasklet.Test1Tasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class Test1StepConfig {

    private final JobRepository jobRepository;

    private final PlatformTransactionManager transactionManager;

    private final Test1Tasklet tasklet;

    public Test1StepConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager, Test1Tasklet tasklet) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.tasklet = tasklet;
    }

    public Step test1StepOne() {
        return new StepBuilder("Test1StepOne", jobRepository)
                .tasklet(tasklet::executeStepOne, transactionManager)
                .build();
    }

    public Step test1StepTwo() {
        return new StepBuilder("Test1StepTwo", jobRepository)
                .tasklet(tasklet::executeStepTwo, transactionManager)
                .build();
    }

    public Step test1StepThree() {
        return new StepBuilder("Test1StepThree", jobRepository)
                .tasklet(tasklet::executeStepThree, transactionManager)
                .build();
    }
}
