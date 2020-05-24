package com.padovese.assessment.api

import com.padovese.assessment.runner.TestRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(TestRunner::class)
class InsurancePlanControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `InsurancePlanControllerTest - A real integration test with the application up`() {
        val request = """{
                          "age": 35,
                          "dependents": 2,
                          "house": {"ownership_status": "owned"},
                          "income": 0,
                          "marital_status": "married",
                          "risk_questions": [0, 1, 0],
                          "vehicle": {"year": 2018}
                        }"""

        val response = """{
                            "auto": "regular",
                            "disability": "ineligible",
                            "home": "economic",
                            "life": "regular"
                        }"""


        mockMvc.perform(MockMvcRequestBuilders.post("/insurance-plan")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().json(response))
    }
}