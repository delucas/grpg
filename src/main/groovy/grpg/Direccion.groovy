package grpg

enum Direccion {

	NE([1, -1]),
	NO([0, -1]),
	O ([-1, 0]),
	SO([-1, 1]),
	SE([0, 1]),
	E ([1, 0])

	def offset

	Direccion(offset) {
		this.offset = offset
	}
}
