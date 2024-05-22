package com.efrei.toutdoux.service;

import com.efrei.toutdoux.model.Board;
import com.efrei.toutdoux.model.Task;
import com.efrei.toutdoux.model.User;
import com.efrei.toutdoux.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public List<Task> findByBoard(Board board) {
        return taskRepository.findByBoard(board);
    }

    public Task findById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.orElse(null);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
