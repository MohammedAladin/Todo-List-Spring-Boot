package com.SpringBoot.Course.springnoot.Repositry;

import com.SpringBoot.Course.springnoot.Models.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AppUser,String> {
     AppUser findByEmail(String email);


}
