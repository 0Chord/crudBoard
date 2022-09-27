package board.CRUDBoard.service;

import board.CRUDBoard.board.Board;
import board.CRUDBoard.repository.BoardRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long writing(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    public Long removing(Board board) {
        boardRepository.remove(board);
        return board.getId();
    }

    public Long updating(Board board, Long id) {
        boardRepository.fetch(board, id);
        return id;
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> findOne(Long memberId) {
        return boardRepository.findById(memberId);
    }
}
