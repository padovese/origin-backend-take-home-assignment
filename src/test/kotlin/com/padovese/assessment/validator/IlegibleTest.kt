package com.padovese.assessment.validator

import com.padovese.assessment.dto.HouseDTO
import com.padovese.assessment.dto.YearDTO
import com.padovese.assessment.enm.MaritalStatus
import com.padovese.assessment.enm.OwnershipStatus
import com.padovese.assessment.model.RiskProfile
import com.padovese.assessment.runner.TestRunner
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@RunWith(TestRunner::class)
class IlegibleTest {

    @Autowired
    private lateinit var ineligible: Ineligible

    @Test
    fun `IneligibleTest - Validate`() {
        val riskProfile = RiskProfileMock()
        ineligible.validate(riskProfile)

        assertEquals(Int.MIN_VALUE, riskProfile.autoScore)
        assertEquals(Int.MIN_VALUE, riskProfile.disabilityScore)
        assertEquals(Int.MIN_VALUE, riskProfile.homeScore)
        assertEquals(Int.MIN_VALUE, riskProfile.lifeScore)
    }

    private fun RiskProfileMock() =
            RiskProfile(
                    age = 70,
                    dependents = 0,
                    house = null,
                    income = 0,
                    maritalStatus = MaritalStatus.SINGLE,
                    vehicle = null,
                    vehicleBinary = 0,
                    houseBinary = 0,
                    autoScore = 3,
                    disabilityScore = 3,
                    homeScore = 3,
                    lifeScore = 3
            )
}