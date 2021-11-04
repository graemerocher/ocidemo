package com.example;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.GeneratedValue.Type;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

/**
 *
 * @author graemerocher
 */
@MappedEntity
public class Book {
    @GeneratedValue(Type.IDENTITY)
    @Id
    private final Long id;
    private final String title;
    private final int pages;

    @Creator
    public Book(@Nullable Long id, String title, int pages) {
        this.id = id;
        this.title = title;
        this.pages = pages;
    }

    public Book(String title, int pages) {
        this.id = null;
        this.title = title;
        this.pages = pages;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }
    
}
