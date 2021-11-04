/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.MediaType;
import io.micronaut.http.server.types.files.StreamedFile;
import io.micronaut.oraclecloud.clients.reactor.objectstorage.ObjectStorageReactorClient;
import javax.inject.Singleton;
import reactor.core.publisher.Mono;

/**
 *
 * @author graemerocher
 */
@Singleton
@Requires(env = Environment.ORACLE_CLOUD)
public class OciDownloadService implements DownloadService {

    private final ObjectStorageReactorClient client;

    public OciDownloadService(ObjectStorageReactorClient client) {
        this.client = client;
    }
    
    @Override
    public Mono<StreamedFile> download() {
        GetObjectRequest request = GetObjectRequest
            .builder()
            .namespaceName("cloudnative-devrel")
            .bucketName("mybucket")
            .objectName("profile-image")
            .build();
        return client.getObject(request)
            .map((response) ->
                new StreamedFile(response.getInputStream(), MediaType.IMAGE_JPEG_TYPE)
            ).onErrorResume((e) -> Mono.empty());
    }

}
