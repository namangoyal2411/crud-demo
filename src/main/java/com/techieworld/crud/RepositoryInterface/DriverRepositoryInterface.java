package com.techieworld.crud.RepositoryInterface;

import com.techieworld.crud.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepositoryInterface extends MongoRepository <Driver,String > {

}
