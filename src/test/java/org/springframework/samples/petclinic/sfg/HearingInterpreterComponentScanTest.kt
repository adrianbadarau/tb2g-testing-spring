package org.springframework.samples.petclinic.sfg

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(classes = [HearingInterpreterComponentScanTest.TestConfig::class])
internal class HearingInterpreterComponentScanTest {

    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.sfg")
    open class TestConfig

    @Autowired
    lateinit var hearingInterpreter: HearingInterpreter

    @Test
    fun whatIheard() {
        val whatIheard = hearingInterpreter.whatIheard()
        assertEquals("Laurel", whatIheard)
    }
}
