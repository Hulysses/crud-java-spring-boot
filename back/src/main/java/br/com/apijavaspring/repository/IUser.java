package br.com.apijavaspring.repository;

import br.com.apijavaspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 @author hulys
*/

public interface IUser extends JpaRepository<User, Integer>{
}