package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;

public class TestGame {

	Game g;

    @Before
    public void set() {
        g = new Game();
    }

	public void testChangePlayer(){
    	assertEquals('x', g.changePlayer('x'));
    }
	
}