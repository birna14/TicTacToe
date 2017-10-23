package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestBoard {

        @Test
        public void testCheckLegalMove(){
        	assertEquals(true, Board.checkLegalMove());
        }
        @Test
        // ath. þetta er vitlaust eins og er, á að skila false
        public void testIsFull(){
          assertEquals(true, Board.isFull());
        }
}
