package com.vilkas.aws.accounting.handler;

import com.vilkas.aws.accounting.model.InputType;
import com.vilkas.aws.accounting.model.TypeRecogniser;
import com.vilkas.aws.accounting.service.SQSService;

public class FileHandler {

    public String sendFilenameToFittingListQueue(String filename) {
        InputType inputType = new TypeRecogniser()
                .getInputTypeForFile(filename);
        return new SQSService()
                .sendMessage(inputType.getQueueName(), filename);
    }


}
