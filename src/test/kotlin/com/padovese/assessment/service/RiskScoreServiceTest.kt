package com.padovese.assessment.service

import com.padovese.assessment.dto.HouseDTO
import com.padovese.assessment.dto.RiskProfileDTO
import com.padovese.assessment.dto.YearDTO
import com.padovese.assessment.enm.MaritalStatus
import com.padovese.assessment.enm.OwnershipStatus
import com.padovese.assessment.runner.TestRunner
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@RunWith(TestRunner::class)
class RiskScoreServiceTest {

    @Autowired
    private lateinit var riskScoreService: RiskScoreService

    @Test
    fun `RiskScoreServiceTest - HandleRequest`() {
        val riskScoreDTO = riskScoreService.handleRequest(riskProfileDTOMock())
        assertEquals(riskScoreDTO.auto, "regular")
        assertEquals(riskScoreDTO.disability, "ineligible")
        assertEquals(riskScoreDTO.home, "economic")
        assertEquals(riskScoreDTO.life, "regular")

    }

    private fun riskProfileDTOMock() =
            RiskProfileDTO(age = 35,
                    dependents = 2,
                    house = HouseDTO(OwnershipStatus.OWNED),
                    income = 0,
                    maritalStatus = MaritalStatus.MARRIED,
                    riskQuestions = intArrayOf(0, 1, 0),
                    vehicle = YearDTO(2018)
            )
}