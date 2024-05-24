package com.efrei.toutdoux.controller;

import com.efrei.toutdoux.model.State;
import com.efrei.toutdoux.model.Task;
import com.efrei.toutdoux.model.User;
import com.efrei.toutdoux.service.BoardService;
import com.efrei.toutdoux.service.StateService;
import com.efrei.toutdoux.service.TaskService;
import com.efrei.toutdoux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;
    @Autowired
    private StateService stateService;

    @GetMapping
    public String listTasks(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        List<Task> tasks = taskService.findByUser(user);
        model.addAttribute("tasks", tasks);
        model.addAttribute("user", user);
        return "tasks";
    }

    @GetMapping("/{id}")
    public String showTask(@PathVariable Long id, Model model, Principal principal) {
        Task task = taskService.findById(id);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        if (!task.getUser().equals(user)) {
            return "error/403";
        }
        model.addAttribute("task", task);
        return "task";
    }

    @PostMapping
    public String saveTask(@ModelAttribute Task task, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        task.setUser(user);
        taskService.save(task);
        return "redirect:/boards/" + task.getBoard().getId();
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, Principal principal) {
        Task task = taskService.findById(id);
        User user = userService.findByUsername(principal.getName());
        List<State> states = stateService.findByBoard(task.getBoard());
        model.addAttribute("user", user);
        if (!task.getUser().equals(user)) {
            return "error/403";
        }
        model.addAttribute("task", task);
        model.addAttribute("board", task.getBoard());
        model.addAttribute("states", states);
        return "task-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, Model model, Principal principal) {
        Task task = taskService.findById(id);
        String boardId = String.valueOf(task.getBoard().getId());
        User user = userService.findByUsername(principal.getName());
        if (!task.getUser().equals(user)) {
            model.addAttribute("user", user);
            return "error/403";
        }
        taskService.delete(id);
        return "redirect:/boards/" + boardId;
    }
}

