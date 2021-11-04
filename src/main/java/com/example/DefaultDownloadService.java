/*
 * 
 * 
 */

package com.example;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.server.types.files.StreamedFile;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

/**
 *
 * @author graemerocher
 */
@Singleton
@Requires(missingBeans=DownloadService.class)
public class DefaultDownloadService implements DownloadService {

    @Override
    public Mono<StreamedFile> download() {
        return Mono.empty();
    }

}
