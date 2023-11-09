package br.com.apijavaspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/*
 @author hulys
*/

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Nome é obrigatório!")
    @Column(name = "name", length = 200, nullable = false)
    private String name;
 
    @NotBlank(message = "E-mail é obrigatório!")
    @Email(message = "Insira um e-mail válido!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "Senha é obrigatório!")
    @Column(name = "password", columnDefinition = "TEXT", nullable = false)
    private String password;

    @NotBlank
    @Column(name = "tel", length = 15, nullable = false)
    private String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}