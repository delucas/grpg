package grpg.tablero

class Casillero {

	private Tablero tablero
	private Integer q
	private Integer r
	private def pieza
	
	Casillero(tablero, q, r, pieza = null) {
		this.tablero = tablero
		this.q = q
		this.r = r
		this.pieza = pieza
	}
	
	void setPieza(pieza) {
		this.pieza = pieza
		pieza.casillero = this
	}
	
	Casillero vecino(direccion) {
		def vecino = [q: this.q + direccion.offset.q,
			r: this.r + direccion.offset.r]
		tablero.get(vecino.q, vecino.r)
	}
	
	@Override
	public String toString() {
		"$q, $r"
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((q == null) ? 0 : q.hashCode());
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.is(obj))
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casillero other = (Casillero) obj;
		if (q == null) {
			if (other.q != null)
				return false;
		} else if (!q.equals(other.q))
			return false;
		if (r == null) {
			if (other.r != null)
				return false;
		} else if (!r.equals(other.r))
			return false;
		return true;
	}
	
}
