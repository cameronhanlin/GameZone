import com.detroitlabs.GameZone.Sudoku.data.SudokuRepository;
import com.detroitlabs.GameZone.Sudoku.model.SudokuBoard;
import com.detroitlabs.GameZone.Sudoku.service.SudokuService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    void return_Board_From_API(){

        SudokuRepository sudokuRepository = SudokuService.getRawBoard();
        assertNotNull(sudokuRepository.getBoard());
        sudokuRepository.printBoard();
    }


}