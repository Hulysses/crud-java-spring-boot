package br.com.apijavaspring.service;

import br.com.apijavaspring.model.User;
import br.com.apijavaspring.repository.IUser;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 @author hulys
*/

@Service
public class UserService {

    private IUser repository;
    private PasswordEncoder passwordEncoder;

    public UserService(IUser repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<User> userList() {
        List<User> list = repository.findAll();
        return list;
    }
    
    public User saveUser(User user) {
        String encoder = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encoder);
        User newUser = repository.save(user);
        return newUser;
    }
    
    public User editUser(User user) {
        String encoder = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encoder);
        User editUser = repository.save(user);
        return editUser;
    }
    
    public Boolean deleteUser(Integer id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean passwordValidation(User user) {
        String password = repository.getById(user.getId()).getPassword();
        Boolean validate = passwordEncoder.matches(user.getPassword(), password);
        return validate;
    }  
}