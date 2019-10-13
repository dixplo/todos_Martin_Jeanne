package s4.spring.td2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import s4.spring.td2.entities.Todo;
import s4.spring.td2.repositories.TodoRepositorie;

@Controller
@RequestMapping("/test/")
public class testControllers {
	@Autowired
	private TodoRepositorie todorepo;
	
	@GetMapping("hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("todo/{name}")
	public @ResponseBody String user(@PathVariable String todo) {
		Todo test = new Todo();
		test.setId(Long.parseLong("15"));
		test.setTodo("Martin");
		todorepo.save(test);
		return test.getTodo();
	}
}
