package org.springframework.samples.petclinic.sfg

import org.springframework.stereotype.Component

@Component
class YannyWordProducer : WordProducer {
    override fun getWord(): String {
        return "Yanny"
    }
}
