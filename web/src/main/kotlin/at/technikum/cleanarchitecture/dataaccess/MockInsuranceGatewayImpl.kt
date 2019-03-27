package at.technikum.cleanarchitecture.dataaccess

import at.technikum.cleanarchitecture.entities.Insurance
import at.technikum.cleanarchitecture.entities.Range
import at.technikum.cleanarchitecture.usecases.insurance.InsuranceGateway

class MockInsuranceGatewayImpl : InsuranceGateway {

    private var insurances: ArrayList<Insurance> = ArrayList(listOf(
        Insurance(1, "Best Insurance", 100.0f, Range(50, 100)),
        Insurance(2, "LOL Insurance", 50.0f, Range(1, 30)),
        Insurance(3, "Amazing Insurance", 300.0f, Range(100, 200)),
        Insurance(4, "Awesome Insurance", 75.0f, Range(10, 50))
    ))

    override fun create(insurance: Insurance): Insurance {
        insurances.add(insurance)
        return insurance
    }

    override fun findAll(): List<Insurance> {
        return insurances
    }
}