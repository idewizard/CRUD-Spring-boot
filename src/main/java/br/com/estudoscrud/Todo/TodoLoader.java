package br.com.estudoscrud.Todo;

import br.com.estudoscrud.Todo.models.Todo;
import br.com.estudoscrud.Todo.models.TodoStatus;
import br.com.estudoscrud.Todo.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //marca como um componente para o spring gerenciar
public class TodoLoader implements CommandLineRunner {

    public final TodoRepository todoRepository;

    public TodoLoader(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTodos();
    }

    private void loadTodos() {
        if (todoRepository.count() == 0){
            todoRepository.save(
                    Todo.builder()
                        .title("Vá ao mercado")
                        .description("Comprar ovos")
                        .todoStatus(TodoStatus.NOT_COMPLETED)
                        .build()
            );
            todoRepository.save(
                    Todo.builder()
                            .title("Ir malhar na smart")
                            .description("Ficar blindão")
                            .todoStatus(TodoStatus.NOT_COMPLETED)
                            .build()
            );
            System.out.println("Todos carregados!");
        }

    }
}
