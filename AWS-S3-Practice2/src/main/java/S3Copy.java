import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3Copy {

    public static void main(String[] args) {

        // Create AmazonS3 object for doing S3 operations
        AmazonS3 s3 = AmazonS3ClientBuilder
                .standard()
                .withRegion("us-west-2")
                .build();

        // Write code to do the following:
        // 1. get name of file to be copied from the command line
        // 2. get name of S3 bucket from the command line
        String file_name = new String();
        String bucket_name = new String();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            file_name = reader.readLine();
            bucket_name = reader.readLine();
        } catch (IOException e) {
            System.err.println(e);
        }

        // 3. upload file to the specified S3 bucket using the file name as the S3 key
        if (s3.doesBucketExistV2(bucket_name)) {
            System.out.format("Bucket %s already exists.\n", bucket_name);
        } else {
            try {
                s3.createBucket(bucket_name);
            } catch (AmazonS3Exception e) {
                System.err.println(e.getErrorMessage());
            }
        }
        try {
            s3.putObject(bucket_name, file_name, new File(file_name));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }
}