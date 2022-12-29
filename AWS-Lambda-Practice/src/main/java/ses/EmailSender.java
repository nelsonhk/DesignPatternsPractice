package ses;

// these are the imports for SDK v1
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.regions.Regions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailSender {
        public EmailResult handleRequest(EmailRequest request, Context context) {

            String resultMessage = new String();
            LambdaLogger logger = context.getLogger();
            logger.log("Entering send_email");

            try {
                AmazonSimpleEmailService client =
                        AmazonSimpleEmailServiceClientBuilder.standard()

                                // Replace US_WEST_2 with the AWS Region you're using for
                                // Amazon SES.
                                .withRegion(Regions.US_WEST_2).build();

                // TODO:
                // Use the AmazonSimpleEmailService object to send an email message
                // using the values in the EmailRequest parameter object
                SendEmailRequest sendRequest = new SendEmailRequest()
                        .withDestination(
                                new Destination().withToAddresses(request.getTo()))
                        .withMessage(new Message().withBody(new Body().withHtml(new Content()
                                        .withCharset("UTF-8").withData(request.getHtmlBody()))
                                .withText(new Content().withCharset("UTF-8")
                                        .withData(request.getTextBody()))).withSubject(new Content()
                                .withCharset("UTF-8").withData(request.getSubject())))
                        .withSource(request.getFrom());
//                        // Comment or remove the next line if you are not using a
//                        // configuration set
//                        .withConfigurationSetName("ConfigSet");
                client.sendEmail(sendRequest);
                logger.log("Email sent!");
                resultMessage = "Message sent successfully";
            } catch (Exception ex) {
                logger.log("The email was not sent. Error message: " + ex.getMessage());
                resultMessage = "Message was not sent. Encountered an error";
                throw new RuntimeException(ex);
            } finally {
                logger.log("Leaving send_email");
            }

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            EmailResult emailResult = new EmailResult(resultMessage, date.toString());
            // TODO:
            // Return EmailResult
            return emailResult;

        }
    }

