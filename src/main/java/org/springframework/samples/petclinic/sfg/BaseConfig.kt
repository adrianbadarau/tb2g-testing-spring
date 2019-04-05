package org.springframework.samples.petclinic.sfg

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
open class BaseConfig {
    @Bean
    open fun hearingInterpreter(wordProducer: WordProducer): HearingInterpreter {
        return HearingInterpreter(wordProducer)
    }

    @Bean(name = ["yannyInterpreter"])
    open fun yannyInterpreter(yannyWordProducer: YannyWordProducer): HearingInterpreter {
        return HearingInterpreter(yannyWordProducer)
    }

    @Bean
    @Primary
    open fun laurelWordProducer(): LaurelWordProducer {
        return LaurelWordProducer()
    }

    @Bean
    open fun yannyWordProducer(): YannyWordProducer {
        return YannyWordProducer()
    }
}
