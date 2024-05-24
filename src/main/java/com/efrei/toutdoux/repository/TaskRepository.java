package com.efrei.toutdoux.repository;

import com.efrei.toutdoux.model.Board;
import com.efrei.toutdoux.model.State;
import com.efrei.toutdoux.model.Task;
import com.efrei.toutdoux.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);

    List<Task> findByBoard(Board board);

    List<Task> findByState(State state);
}