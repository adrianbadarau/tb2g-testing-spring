package org.springframework.samples.petclinic.sfg

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [BaseConfig::class])
class HearingInterpreterJunit4Test {

    @Autowired
    lateinit var hearingInterpreter: HearingInterpreter

    @Autowired
    @Qualifier("yannyInterpreter")
    lateinit var yannyHearingInterpreter: HearingInterpreter

    @Test
    fun whatIheard() {
        val whatIheard = hearingInterpreter.whatIheard()
        assertEquals("Laurel", whatIheard)
    }

    @Test
    fun testThatYannyInterpreterWorks(){
        val whatIheard = yannyHearingInterpreter.whatIheard()
        assertEquals("Yanny", whatIheard)
    }
}
