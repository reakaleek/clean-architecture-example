package at.technikum.cleanarchitecture.usecases.insurance

class CreateInsurance(
        private val insuranceGateway: InsuranceGateway,
        private val insurancePresenter: InsurancePresenter
) {
    fun create(createInsuranceViewModel: CreateInsuranceViewModel): InsuranceViewModel {
        val insurance = insurancePresenter.map(createInsuranceViewModel)
        val createdInsurance = insuranceGateway.create(insurance)
        return insurancePresenter.map(createdInsurance)
    }
}