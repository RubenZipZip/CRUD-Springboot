package com.api.crud.servicios;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/*en Service inyectamos una instancia de userRepository pra proder acceder a cualquiera de sus metodos (findAll,add...)
Repository hereda de CrudRepository
 */
@Service
public class UserService {

    @Autowired //inyeccion de dependencias
    IUserRepository userRepository;
    public ArrayList<UserModel> getUser(){
        return (ArrayList<UserModel>)
 userRepository.findAll() ;}

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){ //DUDAS ID O id
        return userRepository.findById(id);
    }
    public UserModel updateById(UserModel request, Long id){
//esto seria como hacer un put
       UserModel user = userRepository.findById(id).get();
       user.setFirstname(request.getFirstname());
       user.setLastName(request.getLastName());
       user.setEmail(request.getEmail());
       return user;

    }

    //para el borrado usamos un boolean por si por cualquier motivo no se borrase
    public Boolean deleteUser (Long id){
        try{
            userRepository.deleteById(id);
            return true;

        }catch (Exception e){
            return false;
        }
    }
}
