/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.controller;

import monhoc.doan2.shoponline.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;

/**
 *
 * @author NhutKha
 */
@Controller
public class UserValidation implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;

        if (user.getUserName().length() == 0) {
            errors.rejectValue("userName", "NotEmpty");
        }

        if (user.getUserEmail().length() == 0) {
            errors.rejectValue("userEmail", "NotEmpty");
        } else if (new EmailValidator().validate(user.getUserEmail()) == false) {
            errors.rejectValue("userEmail", "Error.Email.Format");
        }

        if (user.getUserPass().length() == 0) {
            errors.rejectValue("userPass", "NotEmpty");
        } else if (user.getUserPass().length() < 5 || user.getUserPass().length() > 20) {
            errors.rejectValue("userPass", "Error.Pass.Size");
        }
    }

}
