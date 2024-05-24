package com.efrei.toutdoux.controller;

import com.efrei.toutdoux.model.State;
import com.efrei.toutdoux.model.User;
import com.efrei.toutdoux.service.StateService;
import com.efrei.toutdoux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;
    @Autowired
    private UserService userService;

    @GetMapping("/delete/{id}")
    public String deleteState(@PathVariable Long id, Model model, Principal principal) {
        State state = stateService.findById(id);
        if(state == null) {
            return "error/404";
        }
        User user = userService.findByUsername(principal.getName());
        if (!state.getBoard().getUser().equals(user)) {
            model.addAttribute("user", user);
            return "error/403";
        }
        stateService.delete(id);
        return "redirect:/boards/edit/" + state.getBoard().getId();
    }

}
