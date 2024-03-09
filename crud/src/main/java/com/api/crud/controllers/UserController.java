package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.servicios.UserService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/user") //definimos la ruta
public class UserController {

    @Autowired
    private UserService userService; //inyecta las dependencias del servicio para poder usar sus metodos (userService) con el controlador

    @GetMapping
    public ArrayList<UserModel> getUser() { //uso el dato que cree que en el modelo, creo un metodo getUsers
        return this.userService.getUser(); //que me devuelva los usuarios

    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
    return this.userService.saveUser(user);
    }
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable  Long id) {
return this.userService.getById(id);
    }
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, Long id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "User with id " + id + "deleted!";
        } else {
            return "Error, you can't delete user ";

        }

    }
}












