package board.CRUDBoard.repository;

import board.CRUDBoard.board.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);

    Board remove(Board board);

    Optional<Board> findById(Long id);

    List<Board> findAll();
}
