package board.CRUDBoard.controller;

import board.CRUDBoard.board.Board;
import board.CRUDBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/view")
public class ViewController {

    private final BoardService boardService;

    @Autowired
    public ViewController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("{id}")
    public String view(Model model, @PathVariable("id") Long id) {
        Optional<Board> board = boardService.findOne(id);
        model.addAttribute("board", board.get());
        return "view/content";
    }
}
