package board.CRUDBoard.service;

import board.CRUDBoard.board.Board;
import board.CRUDBoard.repository.BoardRepository;

import java.util.List;

public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository=boardRepository;
    }

    public Long writing(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    public List<Board> findBoards(){
        return boardRepository.findAll();
    }
}
