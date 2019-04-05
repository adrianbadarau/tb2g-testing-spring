package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitWebConfig(locations = {"classpath:/spring/mvc-core-config.xml", "classpath:/spring/mvc-test-config.xml"})
class OwnerControllerJavaTest {

    MockMvc mockMvc;

    @Autowired
    OwnerController ownerController;

    @Autowired
    ClinicService clinicService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(view().name("owners/createOrUpdateOwnerForm"));

    }

    @Test
    void processFindFormHandlesNullLastNameAndReturnsList() throws Exception {
        given(clinicService.findOwnerByLastName(eq(""))).willReturn(Arrays.asList(new Owner(), new Owner()));
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attributeExists("selections"));
    }

    @Test
    void processFindFormHandlesSingleReturn() throws Exception {
        Owner owner = new Owner();
        owner.setId(1);
        given(clinicService.findOwnerByLastName(startsWith("TEST_"))).willReturn(Arrays.asList(owner));
        mockMvc.perform(get("/owners").param("lastName", "TEST_name"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owners/1"));
    }

    @Test
    void testProcessUpdateOwnerFormSuccess() throws Exception {
        mockMvc.perform(
                post("/owners/{ownerId}/edit", 1)
                        .param("address", "test")
                        .param("city", "test")
                        .param("telephone", "1233211234")
                        .param("firstName", "test")
                        .param("lastName", "test")
        ).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/owners/1"));
    }

    @Test
    void testProcessUpdateOwnerFormError() throws Exception {
        mockMvc.perform(
                post("/owners/{ownerId}/edit", 1)
                        .param("address", "test")
                        .param("city", "test")
                        .param("firstName", "test")
                        .param("lastName", "test")
        ).andExpect(status().isOk()).andExpect(view().name("owners/createOrUpdateOwnerForm"))
        .andExpect(model().attributeHasErrors("owner")).andExpect(model().attributeHasFieldErrors("owner","telephone"));
    }
}
