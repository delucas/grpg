package grpg.piezas

import grpg.tablero.Casillero

class Personaje {
	
	Casillero casillero
	
	void caminar(direccion) {
		casillero.vecino(direccion).pieza = this
	}
	
}
