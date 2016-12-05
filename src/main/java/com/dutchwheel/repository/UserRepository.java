package com.dutchwheel.repository;

import com.dutchwheel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by antonkazakov on 05.12.16.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * Select user form users table by user token
     * @param apiKey
     * @return
     */
    @Query("SELECT FROM User user WHERE user.api_key =:apiKey")
    @Transactional(readOnly = true)
    List<User> findUserByToken(@Param("api_key") String apiKey);

}
