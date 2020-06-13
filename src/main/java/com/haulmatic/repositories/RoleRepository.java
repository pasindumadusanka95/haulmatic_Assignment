package com.haulmatic.repositories;

import com.haulmatic.models.Role;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

    @Query(value = "{ 'nicNo' : ?0 }", fields="{ 'firstName' : 1,'lastName' : 1,'nicNo' : 1 ,'organization' : 1 ,'roleType' : 1}")
    Role findroleBynic(@Param("nicNo") String nicNo);

    @Query(value = "{ $and: [ { 'organization' : ?0 }, { 'nicNo' :?1 }]}", fields="{ 'firstName' : 1,'lastName' : 1,'nicNo' : 1 }")
    List<Role> findroleByorganizationroletype(@Param("organization") String organization, @Param("nicNo") String nicNo);
}
