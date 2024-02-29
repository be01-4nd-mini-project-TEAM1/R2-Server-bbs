package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.todo.entity.TodoEntity2;
import com.todo.security.userrole.UserRole;
import com.todo.service.TeamTodoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamTodoController {

	@Autowired
	public final TeamTodoService teamTodoService;

	/*
	 * @RequestMapping("/session-login/teamtodo") public String teamRoot() { return
	 * "teamtodo"; }
	 */
//	@RequestMapping("/session-login/todo/teamtodo")
//	public String listAll(Model model) {
//		List<TodoEntity2> toDoEntityList2 = this.teamTodoService.showTodoAll();
//		model.addAttribute("toDoEntityList2", toDoEntityList2);
//		return "teamtodo";
//	}
	
	
	@RequestMapping("/session-login/todo/teamtodo_admin")
	public String checkAdmin2(@SessionAttribute (name = "role", required = false) UserRole role) {
		if(!role.equals(UserRole.ADMIN)) {
			return "teamtodo";
		}
		return "teamtodo_admin";
	}
	
	@RequestMapping("/session-login/todo/teamtodo")
	public String listAll(@SessionAttribute (name = "teamId", required = false) Long team_id, Model model, @SessionAttribute (name = "role", required = false) UserRole role) {
		if(role.equals(UserRole.ADMIN)) {
			return "redirect:/session-login/todo/teamtodo/all";
		}
		List<TodoEntity2> toDoEntityList2 = this.teamTodoService.showTodoById(team_id);
		model.addAttribute("toDoEntityList2", toDoEntityList2);
		return "teamtodo";
	}
	
	@RequestMapping("/session-login/todo/teamtodo/all")
	public String listAll(Model model) {
		List<TodoEntity2> toDoEntityList2 = this.teamTodoService.showTodoAll();
		model.addAttribute("toDoEntityList2", toDoEntityList2);
		return "teamtodo_admin";
	}

	// create
	@PostMapping("/session-login/todo/teamtodo/insert")
	public String insertTodo(@SessionAttribute (name = "teamId", required = false) Long team_id, @RequestParam String team_content, @RequestParam String date) {

		TodoEntity2 todo = new TodoEntity2();
		Long personal_id = todo.getPersonal_id();
		
		if(date.isBlank()) date = "미정";
		if(team_content.isBlank()) team_content = "미정";
		todo.setDate(date);
		todo.setTeam_content(team_content);
		todo.setPersonal_id(personal_id);
		todo.setTeam_id(team_id);
		todo.setCompleted(false);

		this.teamTodoService.insertTodo(todo);
		return "redirect:/session-login/todo/teamtodo/" + team_id;
	}

	// read
	@RequestMapping("session-login/todo/teamtodo/{id}")
	public String list(@PathVariable("id") Long team_id, Model model, @SessionAttribute (name = "role", required = false) UserRole role) {
		List<TodoEntity2> toDoEntityList2 = this.teamTodoService.showTodoById(team_id);
		model.addAttribute("toDoEntityList2", toDoEntityList2);
		if(role.equals(UserRole.ADMIN) ) {
			return "teamtodo_admin";
		}
		return "teamtodo";
	}

	// read
	@ResponseBody
	@GetMapping("/get/{id}")
	public List<TodoEntity2> showTodoById(@PathVariable("id") Long team_id) {
		return teamTodoService.showTodoById(team_id);
	}

	// update
	@PutMapping("/session-login/todo/teamtodo/update/{team_id}/{content_id}")
	public String updateTodo(@PathVariable("team_id") Long team_id, @PathVariable("content_id") Long content_id,
			@RequestBody TodoEntity2 todo) {
		if(todo.getDate().isBlank()) todo.setDate("미정");
		if(todo.getTeam_content().isBlank()) todo.setTeam_content("미정");
		teamTodoService.updateTodo(team_id, content_id, todo);

		return "redirect:/session-login/todo/teamtodo";
	}

	@PutMapping("/session-login/todo/teamtodo/updateCompleted/{team_id}/{content_id}")
	public String updateCompleted(@PathVariable Long team_id, @PathVariable Long content_id) {
		teamTodoService.updateCompleted(team_id, content_id);
		return "redirect:/session-login/todo/teamtodo";
	}

	// delete
	@DeleteMapping("/session-login/todo/teamtodo/delete/{team_id}/{content_id}")
	public String deleteTodo(@PathVariable("team_id") Long team_id, @PathVariable("content_id") Long content_id) {
		teamTodoService.deleteTodo(team_id, content_id);
		return "redirect:/session-login/todo/teamtodo";
	}
}
