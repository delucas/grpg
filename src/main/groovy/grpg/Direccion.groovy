package grpg

enum Direccion {

	NE([q: 1, r: -1]),
	NO([q: 0, r: -1]),
	O ([q: -1, r: 0]),
	SO([q: -1, r: 1]),
	SE([q: 0, r: 1]),
	E ([q: 1, r: 0])

	def offset

	Direccion(offset) {
		this.offset = offset
	}
}
