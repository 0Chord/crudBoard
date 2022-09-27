package board.CRUDBoard;

import board.CRUDBoard.repository.BoardJpaRepository;
import board.CRUDBoard.repository.BoardRepository;
import board.CRUDBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class AppConfig {

    private final EntityManager em;

    @Autowired
    public AppConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository() {

        return new BoardJpaRepository(em);
    }
}
