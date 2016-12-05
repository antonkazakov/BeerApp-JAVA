package com.dutchwheel.validator;

import com.dutchwheel.entities.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by antonkazakov on 05.12.16.
 */
public class SignUpValidator implements Validator {

    /**
     * If aClass equals User
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone","NO PHONE");
        User user = (User) o;
        /**
         * Check phone contains 10 digits
         */
        if (user.getPhone().length()!=10){
            errors.rejectValue("phone", "incorrect length");
        }
        if (!user.getPhone().matches("[0-9]+")){
            errors.rejectValue("phone", "incorrect format");
        }

    }

}
