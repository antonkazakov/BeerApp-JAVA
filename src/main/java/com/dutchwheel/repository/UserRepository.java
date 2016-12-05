package com.dutchwheel.repository;

import com.dutchwheel.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by antonkazakov on 05.12.16.
 */
public interface UserRepository extends Repository<User,Integer> {

    @Query("SELECT FROM User user  WHERE owner.lastName LIKE :lastName")
    @Transactional(readOnly = true)
    Collection<User> findByLastName(@Param("lastName") String lastName);

}
