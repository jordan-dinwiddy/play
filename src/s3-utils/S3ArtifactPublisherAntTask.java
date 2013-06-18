package com.dinwiddy.webevents.ant;

import java.io.File;
import java.io.IOException;

import com.dinwiddy.webevents.artifactpub.ArtifactPublisher;
import com.dinwiddy.webevents.artifactpub.S3ArtifactPublisher;

public class S3ArtifactPublisherAntTask {

	private String bucketName; 
	private String awsCredsFileName;
	private String srcFileName; 
	private String destFileName;
	
	public void execute() {
		
		try {
			publishArtifact();
		} catch(Exception e) {
			throw new RuntimeException("Unable to publish artifact", e);
		}
	}

	private void publishArtifact() throws IOException {
		
		File awsCredsFile = new File(awsCredsFileName);
		ArtifactPublisher publisher = new S3ArtifactPublisher(awsCredsFile);
		
		File srcFile = new File(srcFileName);
		publisher.publishArtifact(srcFile, bucketName, destFileName);
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public String getDestFileName() {
		return destFileName;
	}

	public void setDestFileName(String destFileName) {
		this.destFileName = destFileName;
	}

	public String getAwsCredsFileName() {
		return awsCredsFileName;
	}

	public void setAwsCredsFileName(String awsCredsFileName) {
		this.awsCredsFileName = awsCredsFileName;
	}
}
