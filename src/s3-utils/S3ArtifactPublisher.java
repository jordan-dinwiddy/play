package com.dinwiddy.webevents.artifactpub;

import java.io.File;
import java.io.IOException;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3ArtifactPublisher implements ArtifactPublisher {

	private final AmazonS3 s3client;
	
	public S3ArtifactPublisher(File awsCredsFile) throws IOException {

		s3client = new AmazonS3Client(new PropertiesCredentials(awsCredsFile));
	}
	
	public S3ArtifactPublisher(AmazonS3 s3client) {
		
		this.s3client = s3client;
	}
	
	public void publishArtifact(File artifactFile, String bucketName, String destKeyName) {
		
		if(!artifactFile.exists()) {
			throw new RuntimeException("File " + artifactFile.getAbsolutePath() + " does not exist");
		}
		
		long fileSizeBytes = artifactFile.length();
		double fileSizeMBytes = fileSizeBytes / 1024d / 1024d;

		println(String.format("Uploading %s (%.2f MB) to %s/%s...", 
				artifactFile.getAbsolutePath(), fileSizeMBytes, bucketName, destKeyName));
		
		try {
			long startTime = System.currentTimeMillis();
            s3client.putObject(new PutObjectRequest(bucketName, destKeyName, artifactFile));
            long endTime = System.currentTimeMillis();
            
            println(String.format("Upload complete in %.2f seconds", (endTime - startTime) / 1000d));
         } catch (Exception e) {
            throw new RuntimeException("Upload of artifact failed", e);
         }
	}
	
	private void println(String msg) {
		
		System.out.println(msg);
	}

}
