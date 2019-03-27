package at.technikum.cleanarchitecture.usecases.insurance

import at.technikum.cleanarchitecture.entities.Insurance

interface InsuranceGateway {
    fun findAll(): List<Insurance>
    fun create(insurance: Insurance): Insurance
}