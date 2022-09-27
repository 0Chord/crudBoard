package board.CRUDBoard.repository;

import board.CRUDBoard.board.Board;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BoardJpaRepository implements BoardRepository {

    private final EntityManager em;

    public BoardJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public Board remove(Board board) {
        em.remove(board);
        return board;
    }

    @Override
    public Board fetch(Board board, Long id) {
        em.remove(board);
        em.persist(board);
        return board;
    }

    @Override
    public Optional<Board> findById(Long id) {
        Board board = em.find(Board.class, id);
        return Optional.ofNullable(board);
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }
}
