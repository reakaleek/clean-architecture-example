package at.technikum.cleanarchitecture.dataaccess

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

interface HibernateInsuranceRepository : JpaRepository<HibernateInsurance, Long>

@Entity
@Table(name = "insurance")
data class HibernateInsurance(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val name: String,
        val min: Int,
        val max: Int,
        val price: Float
)

