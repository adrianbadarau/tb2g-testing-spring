package org.springframework.samples.petclinic.web

import com.nhaarman.mockitokotlin2.*
import org.assertj.core.api.Assertions
import org.junit.Assert
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.samples.petclinic.model.Vet
import org.springframework.samples.petclinic.model.Vets
import org.springframework.samples.petclinic.service.ClinicService
import org.springframework.samples.petclinic.service.ClinicServiceImpl
import org.springframework.ui.Model
import kotlin.random.Random

@ExtendWith(MockitoExtension::class)
class VetControllerTest {

    @Mock
    lateinit var clinicService: ClinicServiceImpl
    @Spy
    lateinit var model: MutableMap<String, Any>

    @InjectMocks
    lateinit var vetController: VetController

    @BeforeEach
    fun setUp() {
        given { clinicService.findVets() }.willReturn {
            val vets = ArrayList<Vet>()
            for (i in 1..5) {
                val vet = Vet()
                vet.id = i
                vet.firstName = "DR John_$i"
                vet.lastName = "Doe"
                vets.add(vet)
            }
            return@willReturn vets
        }
    }

    @Test
    fun testShowVetList() {
        //when
        val resp = vetController.showVetList(model)
        //then
        Assertions.assertThat(resp).isEqualTo("vets/vetList")
        then(clinicService).should().findVets()
        then(model).should().put(eq("vets"), any<Vets>())
    }

    @Test
    fun testShowResourcesVetList(){
        //when
        val resp = vetController.showResourcesVetList()
        //then
        then(clinicService).should().findVets()
        Assertions.assertThat(resp).isNotNull
        Assertions.assertThat(resp.vetList.size).isEqualTo(5)

    }
}
