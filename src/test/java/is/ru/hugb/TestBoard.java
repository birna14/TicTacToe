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
        	assertEquals(true, b.checkLegalMove());
        }

        @Test
        public void testIsFull(){
          assertEquals(false, b.isFull());
        }
}
