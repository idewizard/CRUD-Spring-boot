package br.com.estudoscrud.Todo.services;

import br.com.estudoscrud.Todo.models.Todo;

import java.util.List;

//a interface abaixo tem as operações básicas do CRUD, como Criar, Ler, Atualizar e Apagar
//sendo necessário criara uma classe para implementar a interface
public interface TodoService {

    //recupera a lista de todos os "todo"s
    List<Todo> getTodos();

    Todo getTodoById(Long id); //recupera 1 objeto do banco pelo id

    Todo insert(Todo todo); //insere objeto no banco

    void updateTodo(Long id, Todo todo); //atualiza objeto

    void deleteTodo(Long todoId); //deleta objeto

}
