package grpg;

import static grpg.Direccion.*
import grpg.tablero.Tablero
import grpg.tablero.Casillero

import org.junit.Before
import org.junit.Test

class TableroTests {

	static final int RADIO = 3

	Tablero tablero
	
	@Before void setUp() {
		tablero = new Tablero(RADIO)
	}

	@Test void iterador() {
		tablero.each { casillero ->
			println casillero
		}
	}		
	
}
