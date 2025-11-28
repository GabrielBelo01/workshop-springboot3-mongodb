package dev.belo.workshopmongo.services;

import dev.belo.workshopmongo.domain.User;
import dev.belo.workshopmongo.dto.UserDTO;
import dev.belo.workshopmongo.repository.UserRepository;
import dev.belo.workshopmongo.services.exception.ObjectNotFoundException;
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

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert (User obj){
        return repo.insert(obj);
    }

    public User FromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
