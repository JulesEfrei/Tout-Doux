package com.efrei.toutdoux.service;

import com.efrei.toutdoux.model.Board;
import com.efrei.toutdoux.model.User;
import com.efrei.toutdoux.repository.BoardRepository;
import com.efrei.toutdoux.repository.StateRepository;
import com.efrei.toutdoux.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private StateService stateService;
    @Autowired
    private StateRepository stateRepository;

    public List<Board> findByUser(User user) {
        return boardRepository.findByUser(user);
    }

    public Board findById(Long id) {
        Optional<Board> optionalTask = boardRepository.findById(id);
        return optionalTask.orElse(null);
    }

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public void delete(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        taskRepository.findByBoard(board.get()).forEach(task -> taskRepository.deleteById(task.getId()));
        stateRepository.findByBoard(board.get()).forEach(state -> stateService.delete(state.getId()));
        boardRepository.deleteById(id);
    }

    public void deleteAllByUser(User user) {
        boardRepository.deleteAllByUser(user);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}
