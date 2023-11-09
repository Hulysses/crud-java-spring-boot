package br.com.apijavaspring.controlles;

import br.com.apijavaspring.model.User;
import br.com.apijavaspring.service.UserService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 @author hulys
*/

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

    private UserService userSevice;
    
    public UserController(UserService userSevice) {
        this.userSevice = userSevice;
    }
    
    @GetMapping
    public  ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.status(200).body( userSevice.userList());
    }

    @PostMapping
    public ResponseEntity<User> cerateUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(201).body(userSevice.saveUser(user));
    }

    @PutMapping
    public ResponseEntity<User> editUser(@Valid @RequestBody User user) { 
        return ResponseEntity.status(201).body(userSevice.editUser(user));
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> passwordValidation(@Valid @RequestBody User user) {
        Boolean validate = userSevice.passwordValidation(user);
        if (!validate) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.status(200).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userSevice.deleteUser(id);
        return ResponseEntity.status(204).build();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String erroMessage = error.getDefaultMessage();
            errors.put(fieldName, erroMessage);
        });
        return errors;
    }
}