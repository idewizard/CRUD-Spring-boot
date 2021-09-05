package br.com.estudoscrud.Todo.repositories;

import br.com.estudoscrud.Todo.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //marca a interface como um repositorio para que o spring gerencie
public interface TodoRepository extends CrudRepository<Todo, Long> {

    //Essa interface recebe o model do objeto que deve ser gerenciado e o tipo do ID
    //permitindo que seja possível usar os metodos, save(), findOne(), findByID() e outros

}
