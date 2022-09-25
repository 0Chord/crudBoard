package board.CRUDBoard.repository;

import board.CRUDBoard.board.Board;

import java.util.*;

public class BoardMemoryRepository implements BoardRepository {

    private static Map<Long, Board> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Board save(Board board) {
        board.setId(++sequence);
        store.put(board.getId(), board);
        return board;
    }

    @Override
    public Board remove(Board board) {
        store.remove(board.getId(), board);
        return board;
    }

    @Override
    public Board fetch(Board board, Long id) {
        System.out.println("board = " + board.getContent());
        board.setId(id);
        store.put(board.getId(), board);
        return board;
    }

    @Override
    public Optional<Board> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

}
