package com.marcoantonio.workshopmongo.dto;

import com.marcoantonio.workshopmongo.domain.User;

import java.io.Serial;
import java.io.Serializable;

public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -3991196051269956125L;
    private String id;
    private String nome;
    private String email;

    private UserDTO() {
    }

    public UserDTO(User obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
