package at.technikum.cleanarchitecture.web

import at.technikum.cleanarchitecture.usecases.insurance.CreateInsurance
import at.technikum.cleanarchitecture.usecases.insurance.CreateInsuranceViewModel
import at.technikum.cleanarchitecture.usecases.insurance.GetRecommendedInsurances
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController @Autowired constructor(
        private val createInsuranceUseCase: CreateInsurance,
        private val getRecommendedInsurancesUseCase: GetRecommendedInsurances
)  {

    @GetMapping("")
    fun index(): String {
        return "index"
    }

    @GetMapping("recommended")
    @ResponseBody
    fun getRecommendedInsurances(@RequestParam("qm") qm: Int?): ModelAndView {
        if (qm == null) {
            return ModelAndView("index")
        }
        val recommendedInsurances = getRecommendedInsurancesUseCase.getRecommendations(qm ?: 0)
        return ModelAndView("recommended", mapOf(Pair("insurances", recommendedInsurances)))
    }

    @GetMapping("create")
    fun createInsurance(): String {
        return "create"
    }

    @PostMapping("create")
    fun createdInsurance(insurance: CreateInsuranceViewModel, model: Model): String {
        createInsuranceUseCase.create(insurance)
        return "created"
    }
}