package com.example;

import io.micronaut.context.env.Environment;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import jakarta.inject.Singleton;
import javax.transaction.Transactional;

@OpenAPIDefinition(
    info = @Info(
            title = "ocidemo",
            version = "0.0"
    )
)
@Singleton
public class Application {

    private final BookRepository repository;
    private final BookProducer producer;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);        
    }

    public Application(BookRepository repository, BookProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @EventListener
    @Transactional
    void startup(StartupEvent startupEvent) {
        Book book = repository.save(new Book("The Stand", 1000));
        producer.sendNewBook(book);
    }
}
