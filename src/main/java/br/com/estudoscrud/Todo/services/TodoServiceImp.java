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

    }

    @Override
    public void deleteTodo(Long todoId) {

    }

}
