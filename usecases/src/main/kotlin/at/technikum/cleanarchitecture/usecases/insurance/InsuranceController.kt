package at.technikum.cleanarchitecture.usecases.insurance

interface InsuranceController {
    fun getRecommendedInsurances(squareMeters: Int): List<InsuranceViewModel>
    fun createInsurance(insurance: CreateInsuranceViewModel): InsuranceViewModel
}