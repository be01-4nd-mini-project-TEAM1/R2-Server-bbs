package com.todo.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.todo.entity.TodoEntity1;
import com.todo.security.userrole.UserRole;
import com.todo.service.TodoServiceImpl1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController extends TodoEntity1 {

	private final TodoServiceImpl1 toDoService;

	@GetMapping("/session-login/todo/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response,
				SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/session-login";
	}

	@RequestMapping("/session-login/todo")
	public String list(Model model, @SessionAttribute (name = "userId", required = false) Long userId, @SessionAttribute (name = "role", required = false) UserRole role) {
		if(role.equals(UserRole.ADMIN)) {
			return "redirect:/session-login/todo/all";
		}
		
		List<TodoEntity1> toDoEntityList = this.toDoService.findByCustomerNum(userId);
		model.addAttribute("toDoEntityList", toDoEntityList);
		return "Todo";
	}
	
	@RequestMapping("/session-login/todo/all")
	public String listAll(Model model, @SessionAttribute (name = "role", required = false) UserRole role) {
		if(!role.equals(UserRole.ADMIN)) {
			return "Todo";
		}
		List<TodoEntity1> toDoEntityList = this.toDoService.showAll();
		model.addAttribute("toDoEntityListAll", toDoEntityList);
		return "Todo_admin";
	}

	@RequestMapping("/")
	public String root() {
		return "redirect:/session-login/login";
	}

	@PostMapping("/todo/create")
	public String todoCreate(@RequestParam String content, @RequestParam String date, @SessionAttribute (name = "userId", required = false) Long userId) {
		if(date.isBlank())  date = "미정";
		if(content.isBlank()) content = "미정";
		this.toDoService.create(content, date, userId);
		return "redirect:/session-login/todo";
	}

	@DeleteMapping("/session-login/todo/delete/{id}")
	public String todoDelete(@PathVariable Integer id) {
		this.toDoService.delete(id);
		return "redirect:/session-login/todo";
	}

	@PutMapping("/session-login/todo/update/{id}")
	public String todoUpdate(@RequestBody TodoEntity1 todo, @PathVariable Integer id) {
		if(todo.getDate().isBlank())  todo.setDate("미정");
		if(todo.getContent().isBlank()) todo.setContent("미정");
		this.toDoService.update(id, todo);
		return "redirect:/session-login/todo";
	}

	@PutMapping("/session-login/todo/completedUpdate/{id}")
	public String completedUpdate(@PathVariable Integer id) {
		this.toDoService.completedUpdate(id);
		return "redirect:/session-login/todo";
	}

}
