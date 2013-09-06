package grpg

class Personaje {
	
	Tablero tablero
	
	void caminar(direccion) {
		tablero.mover(this, direccion)
	}
	
}
