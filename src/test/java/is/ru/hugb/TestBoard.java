package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;

public class TestBoard {

        Board b;

        @Before
        public void setUp() {
          b = new Board();
        }

        @Test
        public void testCheckLegalMove(){
        	assertEquals(false, b.checkLegalMove(3,3));
            assertEquals(true, b.checkLegalMove(0,0));
        }

        @Test
        public void testIsFull(){
          assertEquals(false, b.isFull());
        }

        @Test
        public void testWinRow(){
          b.updateCell('x', 0, 0);
          b.updateCell('x', 1, 0);
          b.updateCell('x', 2, 0);
          assertEquals(true, b.checkWin());
        }

        @Test
        public void testWinCol(){
          b.updateCell('x', 1, 0);
          b.updateCell('x', 1, 1);
          b.updateCell('x', 1, 2);
          assertEquals(true, b.checkWin());
        }

        @Test
        public void testWinDiag(){
          b.updateCell('o', 0, 0);
          b.updateCell('o', 1, 1);
          b.updateCell('o', 2, 2);
          assertEquals(true, b.checkWin());
        }

        public void testChangePlayer(){
            assertEquals('o', b.changePlayer('x'));
        }
}
