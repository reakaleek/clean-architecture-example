package at.technikum.cleanarchitecture.entities

class Range(
    val min: Int,
    val max: Int
) {
    fun contains(value: Int): Boolean {
        return value in min..max
    }
}

class Insurance(
        val id: Long?,
        val name: String,
        val price: Float,
        val range: Range
)