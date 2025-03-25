package com.sanghoon.batch.test1.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class Test1Tasklet {
    public RepeatStatus executeStepOne(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Test 1 Step One: Data Extraction Completed.");
        return RepeatStatus.FINISHED;
    }

    public RepeatStatus executeStepTwo(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Test 1 Step Two: Data Transformation Completed.");
        return RepeatStatus.FINISHED;
    }

    public RepeatStatus executeStepThree(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Test 1 Step Three: Data Loading Completed.");
        return RepeatStatus.FINISHED;
    }
}
