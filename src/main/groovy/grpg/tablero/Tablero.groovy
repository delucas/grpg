package grpg.tablero

import grpg.CoordenadasHelper
import grpg.piezas.Personaje

class Tablero {

	transient coordenadasHelper = CoordenadasHelper.instance
	
	def posiciones
	def radio
	
	Tablero build (Integer dimension) {
		new Tablero(dimension)
	}
	
	private Tablero(Integer radio) {
		this.radio = radio
		
		Integer dimension = radio * 2 + 1
		posiciones = new Casillero[dimension][dimension]
		
//		llenarConNulos()
		llenarConValidos()
		
	}
	
//	private llenarConNulos() {
//		posiciones.eachWithIndex { fila, i ->
//			fila.eachWithIndex { casillero, j ->
//				def posicion = coordenadasHelper.toAxial(i, j, this.dimension)
//				posiciones[i, j] = new CasilleroNulo(this, posicion.q, posicion.r)
//			}
//		}
//	}
	
	private llenarConValidos() {
		(-3..3).each { q ->
			(-3..3).each { r ->
				def enOffset = coordenadasHelper.toOffset(q, r, this.radio)
				posiciones[enOffset.i][enOffset.j] = new Casillero(this, q, r)
			}
		}
	}
	
	Casillero get(q, r) {
		def enOffset = coordenadasHelper.toOffset(q, r, this.radio)
		posiciones[enOffset.i][enOffset.j]
	}
	
	def iterator() {
		// XXX: El iterador no debería recorrer casilleros nulos. Recorrer axiales!
		new Iterator(){
			Integer q = - radio
			Integer r = - radio
			boolean hasNext() { q < radio || (q == radio && r <= radio) };
			def next() {
				def retorno = get(q, r)
				if (r == radio) { r = -radio; q++; }
				else { r++ }
				retorno
			};
			void remove() { throw new UnsupportedOperationException("No se pueden remover casilleros de un tablero")};
		}
	}
	
//	void mover(personaje, direccion) {
//		posiciones[personaje] = posiciones[personaje] + direccion.offset
//	}
	
//	void colocarPieza(q, r, pieza) {
//		posiciones[pieza] = new Casillero(q: q, r: r)
//		pieza.tablero = this
//	}
	
}
