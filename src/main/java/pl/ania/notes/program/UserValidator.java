package pl.ania.notes.program;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserValidator implements org.springframework.validation.Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserModel userModel = (UserModel) target;
        String password = userModel.getPassword();
        String confPassword = userModel.getConfPassword();
        if (!password.equals(confPassword)) {
            errors.rejectValue("password", "userModel.password.missMatch");
        }
    }
}
//
//    Customer customer = (Customer)target;
//    int age = customer.getAge();
//    String password = customer.getPassword();
//    String confPassword = customer.getConfPassword();
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "customer.age.empty");
//
//                //Business validation
//                if(!password.equals(confPassword)){
//                errors.rejectValue("password","customer.password.missMatch");
