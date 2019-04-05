package org.springframework.samples.petclinic.sfg

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class BaseConfig {
    @Bean
    open fun hearingInterpreter(wordProducer: WordProducer): HearingInterpreter {
        return HearingInterpreter(wordProducer)
    }

    @Bean
    open fun laurelWordProducer(): LaurelWordProducer {
        return LaurelWordProducer()
    }
}
