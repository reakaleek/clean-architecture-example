package at.technikum.cleanarchitecture.presenter

import at.technikum.cleanarchitecture.entities.Insurance
import at.technikum.cleanarchitecture.entities.Range
import at.technikum.cleanarchitecture.usecases.insurance.CreateInsuranceViewModel
import at.technikum.cleanarchitecture.usecases.insurance.InsurancePresenter
import at.technikum.cleanarchitecture.usecases.insurance.InsuranceViewModel

class InsurancePresenterImpl : InsurancePresenter {
    override fun map(insurance: CreateInsuranceViewModel): Insurance {
        return Insurance(
                null,
                insurance.name,
                insurance.price,
                Range(insurance.min, insurance.max)
        )
    }

    override fun map(insurance: Insurance): InsuranceViewModel {
        return InsuranceViewModel(
                insurance.name,
                "%.2f €".format(insurance.price)
        )
    }
}