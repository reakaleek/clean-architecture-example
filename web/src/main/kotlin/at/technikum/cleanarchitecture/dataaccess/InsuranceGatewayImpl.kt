package at.technikum.cleanarchitecture.dataaccess

import at.technikum.cleanarchitecture.entities.Insurance
import at.technikum.cleanarchitecture.entities.Range
import at.technikum.cleanarchitecture.usecases.insurance.InsuranceGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InsuranceGatewayImpl @Autowired constructor(
        val hibernateInsuranceRepository: HibernateInsuranceRepository
) : InsuranceGateway {
    override fun create(insurance: Insurance): Insurance {
        hibernateInsuranceRepository.saveAndFlush(insurance.toHibernateEntity())
        return insurance
    }

    override fun findAll(): List<Insurance> {
        return hibernateInsuranceRepository.findAll().map { it.toInsuranceEntity() }
    }
}

fun Insurance.toHibernateEntity(): HibernateInsurance =
        HibernateInsurance(id, name, range.min, range.max, price)

fun HibernateInsurance.toInsuranceEntity(): Insurance =
        Insurance(id, name, price, Range(min,max))