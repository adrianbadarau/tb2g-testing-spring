package org.springframework.samples.petclinic.sfg

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class HearingInterpreterTest {

    lateinit var hearingInterpreter: HearingInterpreter

    @BeforeEach
    internal fun setUp() {
        hearingInterpreter = HearingInterpreter(LaurelWordProducer())
    }

    @Test
    fun whatIheard() {
        val whatIheard = hearingInterpreter.whatIheard()
        assertEquals(whatIheard, "Laurel")
    }
}
