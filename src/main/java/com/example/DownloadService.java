/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import io.micronaut.http.server.types.files.StreamedFile;
import reactor.core.publisher.Mono;

/**
 *
 * @author graemerocher
 */
public interface DownloadService {
    Mono<StreamedFile> download();
}
