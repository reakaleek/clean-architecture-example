package at.technikum.cleanarchitecture.usecases.insurance

data class CreateInsuranceViewModel(
    val name: String,
    val price: Float,
    val min: Int,
    val max: Int
)