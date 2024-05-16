package com.efrei.toutdoux.controller;

import com.efrei.toutdoux.model.Task;
import com.efrei.toutdoux.model.User;
import com.efrei.toutdoux.service.TaskService;
import com.efrei.toutdoux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

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
        model.addAttribute("task", task);
        model.addAttribute("user", user);
        return "task";
    }

    @GetMapping("/new")
    public String showTaskForm(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("task", new Task());
        model.addAttribute("user", user);
        return "task-form";
    }

    @PostMapping
    public String saveTask(@ModelAttribute Task task, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        task.setUser(user);
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, Principal principal) {
        Task task = taskService.findById(id);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("task", task);
        model.addAttribute("user", user);
        return "task-form";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        Task existingTask = taskService.findById(id);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setUpdatedAt(LocalDateTime.now());
        taskService.save(existingTask);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}

