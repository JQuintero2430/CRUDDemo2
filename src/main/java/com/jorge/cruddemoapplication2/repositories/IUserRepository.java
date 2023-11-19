package com.jorge.cruddemoapplication2.repositories;

import com.jorge.cruddemoapplication2.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
}
