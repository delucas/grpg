package grpg

class Tablero {

	def posiciones = [:]
	
	Personaje generarPersonaje() {
		def personaje = new Personaje(tablero: this)
		posiciones[personaje] = new Casillero(q: 0, r: 0)
		personaje
	}
	
	def dondeEsta(personaje) {
		posiciones[personaje]
	}
	
	void mover(personaje, direccion) {
		posiciones[personaje] = posiciones[personaje] + direccion.offset
	}
	
	void colocarPieza(q, r, pieza) {
		posiciones[pieza] = new Casillero(q: q, r: r)
		pieza.tablero = this
	}
	
}
