package org.springframework.samples.petclinic.sfg

import org.springframework.stereotype.Service

@Service
class HearingInterpreter(
        private val wordProducer: WordProducer
) {

    fun whatIheard(): String {
        val word = wordProducer.getWord()
        println("THE word $word")
        return word
    }
}
