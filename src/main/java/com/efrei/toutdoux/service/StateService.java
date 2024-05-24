package com.efrei.toutdoux.service;

import com.efrei.toutdoux.model.Board;
import com.efrei.toutdoux.model.State;
import com.efrei.toutdoux.model.Task;
import com.efrei.toutdoux.repository.StateRepository;
import com.efrei.toutdoux.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private TaskRepository taskRepository;

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    public List<State> findByBoard(Board board) {
        return stateRepository.findByBoard(board);
    }

    public State findById(Long id) {
        Optional<State> optionalState = stateRepository.findById(id);
        return optionalState.orElse(null);
    }

    public State save(State state) {
        return stateRepository.save(state);
    }

    public void delete(Long id) {
        State state = stateRepository.findById(id).orElse(null);
        if (state != null) {
            // Set the state of all associated tasks to null
            List<Task> tasks = taskRepository.findByState(state);
            for (Task task : tasks) {
                task.setState(null);
            }
            taskRepository.saveAll(tasks);
            stateRepository.delete(state);
        }
    }

}
