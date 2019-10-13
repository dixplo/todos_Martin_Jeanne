package s4.spring.td2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import s4.spring.td2.entities.Todo;

@Repository
public interface TodoRepositorie extends JpaRepository<Todo, Long>{
}

