package board.CRUDBoard.controller;

import board.CRUDBoard.board.Board;
import board.CRUDBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/new")
    public String createForm() {
        return "boards/createBoardForm";
    }

    @PostMapping("/new")
    public String create(BoardForm form) {
        Board board = new Board();
        board.setPassword(form.getPassword());
        board.setContent(form.getContent());
        board.setTitle(form.getTitle());
        boardService.writing(board);
        return "redirect:/";
    }

    @GetMapping("/contents")
    public String list(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        System.out.println("boards.size() = " + boards.size());
        return "boards/contents";
    }

}
