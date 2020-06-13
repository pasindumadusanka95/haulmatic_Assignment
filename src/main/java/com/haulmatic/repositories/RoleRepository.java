package com.haulmatic.repositories;

import com.haulmatic.models.Role;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findBy_id(ObjectId id);
}
