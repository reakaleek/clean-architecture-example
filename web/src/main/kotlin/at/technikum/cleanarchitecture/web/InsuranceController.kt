package at.technikum.cleanarchitecture.web

import at.technikum.cleanarchitecture.usecases.insurance.*
import at.technikum.cleanarchitecture.usecases.insurance.InsuranceController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class InsuranceController @Autowired constructor(
        private val createInsuranceUseCase: CreateInsurance,
        private val getRecommendedInsurancesUseCase: GetRecommendedInsurances
) : InsuranceController {


    @PostMapping("/api/insurance")
    override fun createInsurance(@RequestBody insurance: CreateInsuranceViewModel): InsuranceViewModel {
        return createInsuranceUseCase.create(insurance)
    }

    @GetMapping("/api/insurance/{squareMeters}")
    override fun getRecommendedInsurances(@PathVariable("squareMeters") squareMeters: Int): List<InsuranceViewModel> {
        return getRecommendedInsurancesUseCase.getRecommendations(squareMeters)
    }
}