package grpg;

import static grpg.Direccion.*
import grpg.piezas.Personaje
import grpg.tablero.Tablero

import org.junit.Before
import org.junit.Test

class ConceptoTests {

	static final int RADIO = 3

	Tablero tablero
	Personaje personaje

	@Before void setUp() {
		tablero = new Tablero(RADIO)
		personaje = new Personaje()

		tablero.get(0, 0).pieza = personaje
	}

	boolean posicionEs(posicion, casillero) {
		posicion[0] == casillero.q && posicion[1] == casillero.r
	}

	@Test void testPersonajeEnInicio() {
		assert posicionEs([0, 0], personaje.casillero)
	}

	@Test void testCaminarEste() {
		personaje.caminar(E)
		assert posicionEs([1, 0], personaje.casillero)
	}

	@Test void testCaminarOeste() {
		personaje.caminar(O)
		assert posicionEs([-1, 0], personaje.casillero)
	}

	@Test void testCaminarOesteDosVeces() {
		personaje.caminar(O)
		personaje.caminar(O)
		assert posicionEs([-2, 0], personaje.casillero)
	}

	@Test void testCaminarOesteLuegoSurEste() {
		personaje.caminar(O)
		personaje.caminar(SE)
		assert posicionEs([-1, 1], personaje.casillero)
	}

}
