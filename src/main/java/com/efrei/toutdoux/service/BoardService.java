package com.efrei.toutdoux.service;

import com.efrei.toutdoux.model.Board;
import com.efrei.toutdoux.model.User;
import com.efrei.toutdoux.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

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
        boardRepository.deleteById(id);
    }

    public void deleteAllByUser(User user) {
        boardRepository.deleteAllByUser(user);
    }
}
