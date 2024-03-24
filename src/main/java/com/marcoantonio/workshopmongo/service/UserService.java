package com.marcoantonio.workshopmongo.service;

import com.marcoantonio.workshopmongo.domain.User;
import com.marcoantonio.workshopmongo.dto.UserDTO;
import com.marcoantonio.workshopmongo.repository.UserRepository;
import com.marcoantonio.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> userOptional = repo.findById(id);
        return userOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!!"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        User user = findById(id);
        repo.delete(user);
    }

    public User update(User obj){
        User newObj = repo.findById(obj.getId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getNome(), objDto.getEmail());
    }
}
