/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.server.types.files.StreamedFile;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import reactor.core.publisher.Mono;

/**
 *
 * @author graemerocher
 */
@Controller("/books")
public class BookController {
    private final BookRepository repository;
    private final DownloadService downloadService;

    public BookController(BookRepository repository, DownloadService downloadService) {
        this.repository = repository;
        this.downloadService = downloadService;
    }

    /**
     * List all of the books
     */
    @Get("/")
    List<Book> list() {
        return repository.findAll();
    }

    /**
     * Find a book by title
     *
     * @param title The title of the book
     */
    @Get("/{title}")
    Book find(String title) {
        return repository.findByTitle(title);
    }

    @Get("/download")
    Mono<StreamedFile> download() {
        return downloadService.download();
    }

    @Post
    Book save(
        @NotBlank @Size(max=50) String title, 
        @Max(10000) @Positive int pages) {
        return repository.save(new Book(title, pages));
    }

}
