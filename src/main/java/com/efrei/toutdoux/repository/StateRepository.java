package com.efrei.toutdoux.repository;

import com.efrei.toutdoux.model.Board;
import com.efrei.toutdoux.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByBoard(Board board);
}
