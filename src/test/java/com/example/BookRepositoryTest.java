package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class BookRepositoryTest {

    @Test
    void testCount(BookRepository repository) {
        repository.save(new Book("The Stand", 1000));
        Assertions.assertEquals(2, repository.count());
    }
}