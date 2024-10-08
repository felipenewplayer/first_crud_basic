package com.Crud.demo.controller;

import com.Crud.demo.Dto.UserDto;
import com.Crud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> listarTodos(){
    return userService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody UserDto usuario){
        userService.inserir(usuario);
    }
    @PutMapping
    public  UserDto alterar(@RequestBody UserDto usuario){
       return userService.alterar(usuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        userService.excluir(id);
        return  ResponseEntity.ok().build();
    }
}
