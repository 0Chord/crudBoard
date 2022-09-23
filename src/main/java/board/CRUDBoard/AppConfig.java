package board.CRUDBoard;

import board.CRUDBoard.repository.BoardMemoryRepository;
import board.CRUDBoard.repository.BoardRepository;
import board.CRUDBoard.service.BoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BoardService boardService(){return new BoardService(boardRepository());}

    @Bean
    public BoardRepository boardRepository() {
        return new BoardMemoryRepository();
    }
}
