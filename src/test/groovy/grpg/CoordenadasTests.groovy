package grpg;

import org.junit.Before;
import org.junit.Test;

class CoordenadasTests {

	static final int RADIO = 3
	CoordenadasHelper c

	@Before void setUp() {
		c = CoordenadasHelper.instance
	}
	
	@Test void inicioEnOffset() {
		assert [i: 3, j: 3] == c.toOffset(0, 0, RADIO)
	}
	
	@Test void primerAnilloEnOffset() {
		assert [i: 3, j: 4] == c.toOffset(1, 0, RADIO) // Este
		assert [i: 3, j: 2] == c.toOffset(-1, 0, RADIO) // Oeste
		
		assert [i: 2, j: 3] == c.toOffset(0, -1, RADIO) // Noroeste
		assert [i: 2, j: 4] == c.toOffset(1, -1, RADIO) // Noreste
		
		assert [i: 4, j: 2] == c.toOffset(-1, 1, RADIO) // Suroeste
		assert [i: 4, j: 3] == c.toOffset(0, 1, RADIO) // Sureste
	}
	
	@Test void segundoAnilloEnOffset() {
		// notación "reloj" en los comentarios
		assert [i: 1, j: 4] == c.toOffset(1, -2, RADIO) // 12
		assert [i: 1, j: 5] == c.toOffset(2, -2, RADIO) // 1
		assert [i: 2, j: 5] == c.toOffset(2, -1, RADIO) // 2
		
		assert [i: 3, j: 5] == c.toOffset(2, 0, RADIO) // 3
		assert [i: 4, j: 4] == c.toOffset(1, 1, RADIO) // 4
		assert [i: 5, j: 3] == c.toOffset(0, 2, RADIO) // 5
		
		assert [i: 5, j: 2] == c.toOffset(-1, 2, RADIO) // 6
		assert [i: 5, j: 1] == c.toOffset(-2, 2, RADIO) // 7
		assert [i: 4, j: 1] == c.toOffset(-2, 1, RADIO) // 8
		
		assert [i: 3, j: 1] == c.toOffset(-2, 0, RADIO) // 9
		assert [i: 2, j: 2] == c.toOffset(-1, -1, RADIO) // 10
		assert [i: 1, j: 3] == c.toOffset(0, -2, RADIO) // 11
		
	}
	
	@Test void inicioEnAxial() {
		assert [q: 0, r: 0] == c.toAxial(3, 3, RADIO)
	}
	
	@Test void deAxialEnOffsetEnAxial() {
		(-3..3).each { q ->
			(-3..3).each { r ->
				def enOffset = c.toOffset(q, r, RADIO)
				assert [q: q, r: r] == c.toAxial(enOffset.i, enOffset.j, RADIO)
			}
		}
	}
	
	@Test void deOffsetEnAxialEnOffset() {
		(0..7).each { i ->
			(0..7).each { j ->
				def enAxial = c.toAxial(i, j, RADIO)
				assert [i: i, j: j] == c.toOffset(enAxial.q, enAxial.r, RADIO)
			}
		}
	}

}
