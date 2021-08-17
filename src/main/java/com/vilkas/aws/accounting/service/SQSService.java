package com.vilkas.aws.accounting.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.vilkas.aws.accounting.model.InputType;
import org.apache.log4j.Logger;

public class SQSService {

    private static final Logger LOG = Logger.getLogger(SQSService.class);

    public String sendMessage(String queue, String filename) {
        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

        SendMessageRequest sendMsgRequest = new SendMessageRequest()
                .withQueueUrl(queue)
                .withMessageBody(filename);

        LOG.info("sending " + filename + "to " + queue);
        String messageId = sqs.sendMessage(sendMsgRequest)
                .getMessageId();
        LOG.info("queue message sended, message id : " + messageId);
        return String.format("%s was send to queue: %s, messageId is %s",
                filename,
                queue,
                messageId);
    }

}
