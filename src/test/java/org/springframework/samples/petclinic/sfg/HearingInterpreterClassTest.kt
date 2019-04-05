package org.springframework.samples.petclinic.sfg

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(classes = [HearingInterpreterClassTest.TestConfig::class])
internal class HearingInterpreterClassTest {

    @Configuration
    open class TestConfig {
        @Bean
        open fun hearingInterpreter(): HearingInterpreter {
            return HearingInterpreter(YannyWordProducer())
        }
    }

    @Autowired
    lateinit var hearingInterpreter: HearingInterpreter

    @Test
    fun whatIheard() {
        val whatIheard = hearingInterpreter.whatIheard()
        assertEquals("Yanny", whatIheard)
    }
}
