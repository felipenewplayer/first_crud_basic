package com.Crud.demo.service;

import com.Crud.demo.Dto.UserDto;
import com.Crud.demo.entity.User;
import com.Crud.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserDto> listarTodos(){
        List<User> user = userRepository.findAll();
        return user.stream().map(UserDto::new).toList();
    }

    public void inserir (UserDto usuario){
        User user = new User(usuario);
        userRepository.save(user);
    }
    public UserDto alterar (UserDto usuario){
        User user = new User(usuario);
        return new UserDto(userRepository.save(user));
    }

    public void excluir(Long id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);    ;

    }


    public UserDto buscarPorID(Long id){
        return new UserDto(userRepository.findById(id).get());
    }
}
