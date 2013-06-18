package com.dinwiddy.webevents.artifactpub;

import java.io.File;

public interface ArtifactPublisher {

	public void publishArtifact(File artifactFile, String bucketName, String destKeyName); 
}
