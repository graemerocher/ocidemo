/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import com.example.BookControllerTest.BookClient;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author graemerocher
 */
@MicronautTest
public class BookControllerTest {

    @Test
    void listBooks(BookClient client) {
        

        Book book = client.save("The Stand", 1000);

        Assertions.assertNotNull(book);

        List<Book> results = client.list();
        Assertions.assertEquals(2, results.size());
    }


    @Client("/books")
    interface BookClient {
        @Get("/")
        List<Book> list();

        @Post
        Book save(String title, int pages);
    }
}
