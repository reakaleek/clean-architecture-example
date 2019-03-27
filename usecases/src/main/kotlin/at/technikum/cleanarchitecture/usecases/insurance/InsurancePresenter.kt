package at.technikum.cleanarchitecture.usecases.insurance

import at.technikum.cleanarchitecture.entities.Insurance

interface InsurancePresenter {
    fun map(insurance: Insurance): InsuranceViewModel
    fun map(insurance: CreateInsuranceViewModel): Insurance
}