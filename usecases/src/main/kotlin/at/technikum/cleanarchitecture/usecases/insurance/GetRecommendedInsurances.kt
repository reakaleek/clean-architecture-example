package at.technikum.cleanarchitecture.usecases.insurance

class GetRecommendedInsurances(
        private val insuranceGateway: InsuranceGateway,
        private val insurancePresenter: InsurancePresenter
) {
    fun getRecommendations(squareMeters: Int): List<InsuranceViewModel> {
        return insuranceGateway.findAll().filter { it.range.contains(squareMeters) }
                .map { insurancePresenter.map(it) }
    }
}