package board.CRUDBoard.controller;

import board.CRUDBoard.board.Board;
import board.CRUDBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("{id}/remove")
    public String remove(BoardForm boardForm, @PathVariable("id") Long id) {
        Optional<Board> board = boardService.findOne(id);
        if (board.get().getPassword().equals(boardForm.getPassword())) {
            boardService.removing(board.get());
        }
        return "redirect:/";
    }

    @GetMapping("{id}/fetch")
    public String content(Model model, @PathVariable("id") Long id) {
        Optional<Board> board = boardService.findOne(id);
        model.addAttribute("board", board.get());
        return "view/fetch";
    }

    @PostMapping("{id}/fetch")
    public String update(BoardForm form, @PathVariable("id") Long id) {
        Optional<Board> board = boardService.findOne(id);
        Board newBoard = new Board();
        newBoard.setPassword(form.getPassword());
        newBoard.setContent(form.getContent());
        newBoard.setTitle(form.getTitle());
        if (board.get().getPassword().equals(form.getPassword())) {
            boardService.removing(board.get());
            boardService.updating(newBoard, id);
        }
        return "redirect:/";
    }
}
