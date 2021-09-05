package br.com.estudoscrud.Todo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity //Marca a classe como um objeto persistente para associar a uma tabela de mesmo nome no banco
@Data //gera todos os sets, gets, equals e toString
@NoArgsConstructor //gera um construtor sem argumentos
@AllArgsConstructor //gera um construtor com todos os atributos
@Builder // cria um builder seguindo as design patterns para facilitar a crição dos objetos
public class Todo {

    @Id //chave primaria na tabela no banco
    @GeneratedValue //geralmente usado na chave primaria, define o tipo de geração da chave
    @Column(updatable = false, nullable = false) // cria uma coluna na tabela
    Long id;

    @Column
    String title;

    @Column
    String description;

    @Column
    TodoStatus todoStatus;

    @CreationTimestamp //cria um registro imutavel de tempo do momento da criação do objeto
    @Column(updatable = false)
    Timestamp dateCreated;

    @UpdateTimestamp //cria um registro de tempo da ultima modificação do objeto
    Timestamp lastModified;

}
