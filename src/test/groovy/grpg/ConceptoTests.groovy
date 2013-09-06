package grpg;

import static grpg.Direccion.*

import org.junit.Before
import org.junit.Test

class ConceptoTests {

	Tablero tablero
	Personaje personaje

	@Before void setUp() {
		tablero = new Tablero()
		personaje = tablero.generarPersonaje()
	}

	boolean posicionEs(posicion, casillero) {
		posicion[0] == casillero.q && posicion[1] == casillero.r
	}

	@Test void testPersonajeEnInicio() {
		assert posicionEs([0, 0], tablero.dondeEsta(personaje))
	}

	@Test void testCaminarEste() {
		personaje.caminar(E)
		assert posicionEs([1, 0], tablero.dondeEsta(personaje))
	}

	@Test void testCaminarOeste() {
		personaje.caminar(O)
		assert posicionEs([-1, 0], tablero.dondeEsta(personaje))
	}

	@Test void testCaminarOesteDosVeces() {
		personaje.caminar(O)
		personaje.caminar(O)
		assert posicionEs([-2, 0], tablero.dondeEsta(personaje))
	}

	@Test void testCaminarOesteLuegoSurEste() {
		personaje.caminar(O)
		personaje.caminar(SE)
		assert posicionEs([-1, 1], tablero.dondeEsta(personaje))
	}

	@Test void testQueSePuedeColocarElementosEnElTablero() {
		def pieza = new Roca()
		tablero.colocarPieza(1, 1, pieza)

		assert posicionEs([1, 1], tablero.dondeEsta(pieza))
	}
}
