package br.com.estudoscrud.Todo.services;

import br.com.estudoscrud.Todo.models.Todo;
import br.com.estudoscrud.Todo.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //registra a classe como um serviço para o spring gerenciar
public class TodoServiceImp implements TodoService{

    TodoRepository todoRepository;

    public TodoServiceImp(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public Todo insert(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Long id, Todo todo) {
        //recebe um objeto como parametro, cria um novo objeto puxando do banco com base no id
        //'seta' os novos atributos do objeto vindodo banco usando as informações
        //do objeto recebido no parametro
        //logo em seguida salva o objeto no banco
        Todo todoFromDb = todoRepository.findById(id).get();
        System.out.println(todoFromDb.toString());
        todoFromDb.setTodoStatus(todo.getTodoStatus());
        todoFromDb.setDescription(todo.getDescription());
        todoFromDb.setTitle(todo.getTitle());
        todoRepository.save(todoFromDb);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

}
