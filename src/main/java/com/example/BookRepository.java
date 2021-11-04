/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;

/**
 *
 * @author graemerocher
 */
@JdbcRepository(dialect=Dialect.ORACLE)
public interface BookRepository extends CrudRepository<Book, Long>{

    @Override
    public List<Book> findAll();

    public Book findByTitle(String title);
}
