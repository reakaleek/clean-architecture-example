package at.technikum.cleanarchitecture.web

import at.technikum.cleanarchitecture.dataaccess.InsuranceGatewayImpl
import at.technikum.cleanarchitecture.presenter.InsurancePresenterImpl
import at.technikum.cleanarchitecture.usecases.insurance.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Wiring @Autowired constructor(
        private val insuranceRepositoryImpl: InsuranceGatewayImpl
){

    @Bean
    fun getInsuranceRepository(): InsuranceGateway {
        return insuranceRepositoryImpl
        //return MockInsuranceRepositoryImpl()
    }

    @Bean
    fun getGetRecommendedInsurances(): GetRecommendedInsurances {
        return GetRecommendedInsurances(
                getInsuranceRepository(),
                getInsurancePresenter()
        )
    }

    @Bean
    fun getCreateInsurance(): CreateInsurance {
        return CreateInsurance(getInsuranceRepository(), getInsurancePresenter())
    }

    @Bean
    fun getInsurancePresenter(): InsurancePresenter {
        return InsurancePresenterImpl()
    }
}