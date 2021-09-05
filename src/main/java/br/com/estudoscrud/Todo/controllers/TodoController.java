package br.com.estudoscrud.Todo.controllers;


import br.com.estudoscrud.Todo.models.Todo;
import br.com.estudoscrud.Todo.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    //recebe uma requisição do tipo GET e retorna uma lista de todos os "todo"s como resposta
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todos = todoService.getTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

}
