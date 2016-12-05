package com.dutchwheel.dao;

import com.dutchwheel.entities.User;

/**
 * Created by antonkazakov on 04.12.16.
 */
public interface UsersDao {

    User getUserByToken(String apiKey);

    Integer signUp(String phone);

}
