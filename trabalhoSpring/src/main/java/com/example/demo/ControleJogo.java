package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControleJogo {

    private Game game = new Game();

    @GetMapping("/")
    public String showGame(Model model) {
        model.addAttribute("board", game.getBoard());
        model.addAttribute("currentPlayer", game.getCurrentPlayer());
        model.addAttribute("playerXWins", game.getPlayerXWins());
        model.addAttribute("playerOWins", game.getPlayerOWins());
        return "jogovelha"; // Nome do template Thymeleaf
    }  

    @PostMapping("/makeMove")
    public String makeMove(@RequestParam int row, @RequestParam int col) {
        game.makeMove(row, col);
        return "redirect:/";
    }

    @RequestMapping("/resetScore")
    public String resetScore() {
        game.resetScore();
        return "redirect:/";
    }
}
