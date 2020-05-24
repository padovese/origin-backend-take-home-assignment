package com.padovese.assessment.validator

import com.padovese.assessment.dto.HouseDTO
import com.padovese.assessment.dto.YearDTO
import com.padovese.assessment.enm.MaritalStatus
import com.padovese.assessment.enm.OwnershipStatus
import com.padovese.assessment.model.RiskProfile
import com.padovese.assessment.runner.TestRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
@RunWith(TestRunner::class)
class AddTest {

    @Autowired
    private lateinit var add: Add

    @Test
    fun `AddTest - HouseConditions`() {
        val riskProfile = riskProfileMock(HouseDTO(OwnershipStatus.MORTGAGED), 0, MaritalStatus.SINGLE, null)

        add.validate(riskProfile)

        Assert.assertEquals(3, riskProfile.autoScore)
        Assert.assertEquals(4, riskProfile.disabilityScore)
        Assert.assertEquals(4, riskProfile.homeScore)
        Assert.assertEquals(3, riskProfile.lifeScore)
    }

    @Test
    fun `AddTest - DependentsConditions`() {
        val riskProfile = riskProfileMock(null, 2, MaritalStatus.SINGLE, null)

        add.validate(riskProfile)

        Assert.assertEquals(3, riskProfile.autoScore)
        Assert.assertEquals(4, riskProfile.disabilityScore)
        Assert.assertEquals(3, riskProfile.homeScore)
        Assert.assertEquals(4, riskProfile.lifeScore)
    }

    @Test
    fun `AddTest - MaritalConditions`() {
        val riskProfile = riskProfileMock(null, 0, MaritalStatus.MARRIED, null)

        add.validate(riskProfile)

        Assert.assertEquals(3, riskProfile.autoScore)
        Assert.assertEquals(2, riskProfile.disabilityScore)
        Assert.assertEquals(3, riskProfile.homeScore)
        Assert.assertEquals(4, riskProfile.lifeScore)
    }

    @Test
    fun `AddTest - VehicleConditions`() {
        val riskProfile = riskProfileMock(null, 0, MaritalStatus.SINGLE, YearDTO(LocalDate.now().year))

        add.validate(riskProfile)

        Assert.assertEquals(4, riskProfile.autoScore)
        Assert.assertEquals(3, riskProfile.disabilityScore)
        Assert.assertEquals(3, riskProfile.homeScore)
        Assert.assertEquals(3, riskProfile.lifeScore)
    }

    private fun riskProfileMock(house: HouseDTO?, dependents: Int, maritalStatus: MaritalStatus, vehicle: YearDTO?) =
            RiskProfile(
                    age = 0,
                    dependents = dependents,
                    house = house,
                    income = 0,
                    maritalStatus = maritalStatus,
                    vehicle = vehicle,
                    vehicleBinary = 0,
                    houseBinary = 0,
                    autoScore = 3,
                    disabilityScore = 3,
                    homeScore = 3,
                    lifeScore = 3
            )
}