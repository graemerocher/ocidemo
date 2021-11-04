/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

/**
 *
 * @author graemerocher
 */
@KafkaClient
public interface BookProducer {
    @Topic("events")
    void sendNewBook(Book title);
}
