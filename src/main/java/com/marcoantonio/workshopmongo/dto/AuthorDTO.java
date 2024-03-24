package com.marcoantonio.workshopmongo.dto;

import com.marcoantonio.workshopmongo.domain.User;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8661409258894251234L;
    private String id;
    private String name;

    public AuthorDTO() {

    }

    public AuthorDTO(User obj){
        id = obj.getId();
        name = obj.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
