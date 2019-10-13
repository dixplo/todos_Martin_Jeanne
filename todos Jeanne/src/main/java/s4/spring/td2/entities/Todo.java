package s4.spring.td2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String todo;

	public Todo() {
		this.id = (long) 0;
		this.todo = "";
	}
	
	public String getTodo() {return todo;}
	public void setTodo(String todo) {this.todo = todo;}
	public Long getId() {return id;}
	public void setId(Long id) {this.id=id;}
}
