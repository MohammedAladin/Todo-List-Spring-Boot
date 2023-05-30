package com.SpringBoot.Course.springnoot.Repositry;

import com.SpringBoot.Course.springnoot.Models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends MongoRepository<Todo,String> {

    Todo findByTitle(String title);

}
