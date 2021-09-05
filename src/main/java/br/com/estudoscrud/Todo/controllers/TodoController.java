package br.com.estudoscrud.Todo.controllers;


import br.com.estudoscrud.Todo.models.Todo;
import br.com.estudoscrud.Todo.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //marca a classe como uma contoller para o spring gerenciar e receber requisições http
@RequestMapping("/api/v1/todo") //define o caminho raiz para essa controler
public class TodoController {

    TodoService todoService;

    //o construtor resolve a necessidade de usar a notação @autowired do spring
    //porque o spring entende que o serviço deve ser inicializado
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    //recebe uma requisição do tipo GET e retorna uma lista de todos os "todo"s como resposta
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todos = todoService.getTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    //get devolve um item do banco com base no id na URL
    @GetMapping({"/{todoId}"})
    public ResponseEntity<Todo> getTodo(@PathVariable("todoId") Long todoId){
        return new ResponseEntity<>(todoService.getTodoById(todoId),HttpStatus.OK);
    }

    //anotacao para tratar requisições PUT
    @PutMapping({"/{todoId}"})
    public ResponseEntity<Todo> updateTodo(@PathVariable("todoId") Long todoId){
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
