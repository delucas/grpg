package grpg

import static java.lang.Math.*

class CoordenadasHelper {

	private static instance = new CoordenadasHelper()

	static getInstance(){
		return instance
	}

	private CoordenadasHelper() { }
	
	public toAxial(i, j, dimension) {
		def r = i - dimension
		[q: j - dimension - min(0, abs(r)), r: r]
	}
	
	public toOffset(q, r, dimension) {
		[i: r + dimension, j: q + dimension + min(0, abs(r))]
	}
}
