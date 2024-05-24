package com.efrei.toutdoux.controller;

import com.efrei.toutdoux.model.Board;
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
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private StateService stateService;

    @GetMapping
    public String listBoards(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        List<Board> boards = boardService.findByUser(user);
        model.addAttribute("boards", boards);
        model.addAttribute("user", user);
        return "boards";
    }

    @GetMapping("/{id}")
    public String showBoard(@PathVariable Long id, Model model, Principal principal) {
        Board board = boardService.findById(id);
        User user = userService.findByUsername(principal.getName());
        List<Task> tasks = taskService.findByBoard(board);

        model.addAttribute("board", board);
        model.addAttribute("user", user);
        model.addAttribute("tasks", tasks);
        if (!board.getUser().equals(user)) {
            return "error/403";
        }
        return "board";
    }

    @GetMapping("/new")
    public String showBoardForm(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Board board = new Board();
        board.setUser(user);
        boardService.save(board);
        model.addAttribute("board", board);
        model.addAttribute("user", user);
        model.addAttribute("states", stateService.findByBoard(board));
        return "board-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, Principal principal) {
        Board board = boardService.findById(id);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        if (!board.getUser().equals(user)) {
            return "error/403";
        }
        model.addAttribute("board", board);
        model.addAttribute("states", stateService.findByBoard(board));
        return "board-form";
    }

    @PostMapping
    public String saveBoard(@ModelAttribute Board board, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        board.setUser(user);
        boardService.save(board);
        return "redirect:/boards";
    }

    @PostMapping("/update/{id}")
    public String updateBoard(@PathVariable Long id, @ModelAttribute Board board, Model model, Principal principal) {
        Board existingBoard = boardService.findById(id);
        User user = userService.findByUsername(principal.getName());
        if (!existingBoard.getUser().equals(user)) {
            model.addAttribute("user", user);
            return "error/403";
        }
        board.setId(id);
        boardService.save(board);
        return "redirect:/boards";
    }

    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id, Model model, Principal principal) {
        Board board = boardService.findById(id);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        if (!board.getUser().equals(user)) {
            return "error/403";
        }
        boardService.delete(board.getId());
        return "redirect:/boards";
    }

    //State
    @GetMapping("/{id}/new-state")
    public String addState(@PathVariable Long id, Model model, Principal principal) {
        Board board = boardService.findById(id);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        if (!board.getUser().equals(user)) {
            return "error/403";
        }
        model.addAttribute("board", board);
        model.addAttribute("state", new State());
        return "state-form";
    }

    @PostMapping("/{id}/new-state")
    public String saveState(@PathVariable Long id, @ModelAttribute State state, Model model, Principal principal) {
        Board board = boardService.findById(id);
        User user = userService.findByUsername(principal.getName());
        if (!board.getUser().equals(user)) {
            model.addAttribute("user", user);
            return "error/403";
        }
        state.setBoard(board);
        stateService.save(state);
        return "redirect:/boards/edit/" + id;
    }

    @GetMapping("/{id}/state/{stateId}/edit")
    public String editState(@PathVariable Long id, @PathVariable Long stateId, Model model, Principal principal) {
        State state = stateService.findById(stateId);
        Board board = boardService.findById(id);
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        if (!board.getUser().equals(user)) {
            return "error/403";
        }
        model.addAttribute("board", board);
        model.addAttribute("state", state);
        return "state-form";
    }

    //Task
    @GetMapping("/{id}/new-task")
    public String addTask(@PathVariable Long id, Model model, Principal principal) {
        Board board = boardService.findById(id);
        User user = userService.findByUsername(principal.getName());
        List<State> states = stateService.findByBoard(board);
        model.addAttribute("user", user);
        if (!board.getUser().equals(user)) {
            return "error/403";
        }
        model.addAttribute("board", board);
        model.addAttribute("states", states);
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/{id}/new-task")
    public String saveTask(@PathVariable Long id, @ModelAttribute Task task, Model model, Principal principal) {
        Board board = boardService.findById(id);
        User user = userService.findByUsername(principal.getName());
        if (!board.getUser().equals(user)) {
            model.addAttribute("user", user);
            return "error/403";
        }
        task.setBoard(board);
        task.setUser(user);
        taskService.save(task);
        return "redirect:/boards/" + id;
    }

}
