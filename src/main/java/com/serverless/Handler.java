package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification.S3EventNotificationRecord;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification.S3ObjectEntity;
import com.serverless.handler.TypeRecogniser;
import org.apache.log4j.Logger;

public class Handler implements RequestHandler<S3Event, String> {

    private static final Logger LOG = Logger.getLogger(Handler.class);

    @Override
    public String handleRequest(S3Event s3event, Context context) {
        LOG.info("XXX - LAMBDA STARTED - XXX");
        LOG.info(s3event);
        S3EventNotificationRecord record = s3event.getRecords().get(0);
        S3ObjectEntity file = record.getS3().getObject();
        new TypeRecogniser().recognise(file.getKey());
        return "OK";
    }
}
