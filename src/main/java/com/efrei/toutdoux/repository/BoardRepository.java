package com.efrei.toutdoux.repository;

import com.efrei.toutdoux.model.Board;
import com.efrei.toutdoux.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByUser(User user);

    void deleteAllByUser(User user);
}
