package org.springframework.samples.petclinic.service

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.then
import com.nhaarman.mockitokotlin2.willReturn
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.samples.petclinic.model.PetType
import org.springframework.samples.petclinic.repository.OwnerRepository
import org.springframework.samples.petclinic.repository.PetRepository
import org.springframework.samples.petclinic.repository.VetRepository
import org.springframework.samples.petclinic.repository.VisitRepository

@ExtendWith(MockitoExtension::class)
class ClinicServiceImplTest {
    @Mock
    lateinit var petRepository: PetRepository
    @Mock
    lateinit var vetRepository: VetRepository
    @Mock
    lateinit var ownerRepository: OwnerRepository
    @Mock
    lateinit var visitRepository: VisitRepository

    @InjectMocks
    lateinit var clinicServiceImpl: ClinicServiceImpl

    @Test
    fun findPetTypes() {
        //given
        given { petRepository.findPetTypes() } willReturn { arrayListOf(PetType()) }
        //when
        val petTypes = clinicServiceImpl.findPetTypes()
        //then
        then(petRepository).should().findPetTypes()
        Assertions.assertThat(petTypes).isNotNull
        Assertions.assertThat(petTypes.size).isEqualTo(1)

    }
}
