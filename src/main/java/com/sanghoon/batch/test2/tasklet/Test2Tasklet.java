package com.sanghoon.batch.test2.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class Test2Tasklet {
    public RepeatStatus executeStepOne(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Test 2 Step One: Data Extraction Completed.");
        return RepeatStatus.FINISHED;
    }

    public RepeatStatus executeStepTwo(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Test 2 Step Two: Data Transformation Completed.");
        return RepeatStatus.FINISHED;
    }

    public RepeatStatus executeStepThree(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Test 2 Step Three: Data Loading Completed.");
        return RepeatStatus.FINISHED;
    }
}
