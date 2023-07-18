package com.admin.medical.repository;

import org.springframework.data.repository.CrudRepository;
import com.admin.medical.model.User; 

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserNameAndUserPass(String userName, String userPass);
}
