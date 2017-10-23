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
        public void testChangePlayer(){
            assertEquals('o', b.changePlayer('x'));
        }
}
