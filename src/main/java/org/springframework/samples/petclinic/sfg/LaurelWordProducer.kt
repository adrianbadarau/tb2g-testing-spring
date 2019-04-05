package org.springframework.samples.petclinic.sfg

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary
class LaurelWordProducer : WordProducer {
    override fun getWord(): String {
        return "Laurel"
    }
}
