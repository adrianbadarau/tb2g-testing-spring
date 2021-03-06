package org.springframework.samples.petclinic.sfg

import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(classes = [BaseConfig::class])
internal class HearingInterpreterTest {

    @Autowired
    lateinit var hearingInterpreter: HearingInterpreter

    @Autowired
    @Qualifier("yannyInterpreter")
    lateinit var yannyHearingInterpreter: HearingInterpreter

    @Test
    fun whatIheard() {
        val whatIheard = hearingInterpreter.whatIheard()
        Assert.assertEquals("Laurel", whatIheard)
    }

    @Test
    fun testThatYannyInterpreterWorks(){
        val whatIheard = yannyHearingInterpreter.whatIheard()
        Assert.assertEquals("Yanny", whatIheard)
    }
}
