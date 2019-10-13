package s4.spring.td2.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.td2.entities.Todo;
import s4.spring.td2.repositories.TodoRepositorie;

@Controller
@RequestMapping("/todos/")
public class TodosControllers {
	
	@Autowired
	private TodoRepositorie todoRepo;
	
	@GetMapping("index")
	public String index(ModelMap map) {
		List<Todo> todo = todoRepo.findAll();
		map.put("todo", todo);
		return "index";
	}
	
	@GetMapping("add")
	public String newTodos() {
		return "newTodos";
	}
	
	@PostMapping("addNew")
	public RedirectView addnew(@RequestParam String id, @RequestParam String todo) {
		Todo newTodo = new Todo();
		newTodo.setId(Long.parseLong(id));
		newTodo.setTodo(todo);
		todoRepo.save(newTodo);
		return new RedirectView("/todos/index");
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable String id, ModelMap map, HttpServletResponse reponse) throws IOException {
		Optional<Todo> todo = todoRepo.findById(Long.parseLong(id));
		if (todo.isPresent() ) {
			map.put("todo", todo);
			return "edtittodo";
		}
		return "index";
	}
	@PostMapping("edtittodo/{id}")
	public RedirectView editOrga (@PathVariable String id, @RequestParam String todos) {
		Todo todo = new Todo();
		todo.setId(Long.parseLong(id));
		todo.setTodo(todos);
		todoRepo.save(todo);
		return new RedirectView("/todos/index");
	}
}
