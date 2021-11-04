/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;

/**
 *
 * @author graemerocher
 */
@KafkaListener
public class BookListener {
    @Topic("events")
    void receive(Book book) {
        System.out.println("Title " + book.getTitle());
    }
}
