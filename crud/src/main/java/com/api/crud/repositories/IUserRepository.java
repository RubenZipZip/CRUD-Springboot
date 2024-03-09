package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*en Jpa Repository definimos un repositorio que nos permita realizar las operaciones CRUD contra UserModel
básicas contra el modelo que hemos creado con anterioridad. Solo especificamos los tipos genericos de
la interfaz: la clase de la entidad(UserModel) y el tipo de campo de su Id(Long)
 */
@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {


}
