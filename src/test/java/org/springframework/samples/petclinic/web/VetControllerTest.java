package org.springframework.samples.petclinic.web;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.*;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    private ClinicService clinicService;

    @InjectMocks
    private VetController vetController;

    @Mock
    Map<String, Object> model;
    List<Vet> vetsList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        vetsList.add(new Vet());
        given(clinicService.findVets()).willReturn(vetsList);
    }

    @Test
    void showVetList() {

        // When
        String view = vetController.showVetList(model);

        // Then
        then(clinicService).should().findVets();
        then(model).should().put(anyString(), any());
        assertThat("vets/vetList").isEqualTo(view);


    }

    @Test
    void showResourcesVetList() {

        // When
        Vets vets = vetController.showResourcesVetList();

        // Then
        assertNotNull(vets);
        assertEquals(1, vets.getVetList().size());
        verify(clinicService, atLeastOnce()).findVets();
    }
}