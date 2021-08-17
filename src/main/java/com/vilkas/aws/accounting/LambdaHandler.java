package com.vilkas.aws.accounting;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification.S3EventNotificationRecord;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification.S3ObjectEntity;
import com.vilkas.aws.accounting.handler.FileHandler;
import org.apache.log4j.Logger;

public class LambdaHandler implements RequestHandler<S3Event, String> {

    private static final Logger LOG = Logger.getLogger(LambdaHandler.class);

    @Override
    public String handleRequest(S3Event s3event, Context context) {
        LOG.info("Lambda handler triggered with " + s3event);
        S3EventNotificationRecord record = s3event.getRecords().get(0);
        S3ObjectEntity file = record.getS3().getObject();
        return new FileHandler().sendFilenameToFittingListQueue(file.getKey());
    }
}
