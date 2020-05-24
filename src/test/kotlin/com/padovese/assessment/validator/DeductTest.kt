package com.padovese.assessment.validator

import com.padovese.assessment.enm.MaritalStatus
import com.padovese.assessment.model.RiskProfile
import com.padovese.assessment.runner.TestRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@RunWith(TestRunner::class)
class DeductTest {

    @Autowired
    private lateinit var deduct: Deduct

    @Test
    fun `DeductTest - UnderThirtyYearsOld`() {
        val riskProfile = riskProfileMock(25, 0)

        deduct.validate(riskProfile)

        Assert.assertEquals(1, riskProfile.autoScore)
        Assert.assertEquals(1, riskProfile.disabilityScore)
        Assert.assertEquals(1, riskProfile.homeScore)
        Assert.assertEquals(1, riskProfile.lifeScore)
    }

    @Test
    fun `DeductTest - BetweenThirtyAndFourtyYearsOld`() {
        val riskProfile = riskProfileMock(35, 0)

        deduct.validate(riskProfile)

        Assert.assertEquals(2, riskProfile.autoScore)
        Assert.assertEquals(2, riskProfile.disabilityScore)
        Assert.assertEquals(2, riskProfile.homeScore)
        Assert.assertEquals(2, riskProfile.lifeScore)
    }

    @Test
    fun `DeductTest - MoreThanTwoHundredThousandIncome`() {
        val riskProfile = riskProfileMock(50, 300000)

        deduct.validate(riskProfile)

        Assert.assertEquals(2, riskProfile.autoScore)
        Assert.assertEquals(2, riskProfile.disabilityScore)
        Assert.assertEquals(2, riskProfile.homeScore)
        Assert.assertEquals(2, riskProfile.lifeScore)
    }

    private fun riskProfileMock(age: Int, income: Int) =
            RiskProfile(
                    age = age,
                    dependents = 0,
                    house = null,
                    income = income,
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