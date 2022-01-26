package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VetControllerTest implements ControllerTests {

    VetService vetService;
    SpecialtyService specialtyService;
    VetController vetController;

    @BeforeEach
    void setUp() {
        this.specialtyService = new SpecialityMapService();
        this.vetService = new VetMapService(specialtyService);
        this.vetController = new VetController(vetService);

        Vet vet1 = new Vet(1l, "Joe", "Buck", null);
        Vet vet2 = new Vet(2L, "Jimmy", "Smith", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        ModelMapImpl model = new ModelMapImpl();
        String view = vetController.listVets(model);
        assertEquals("vets/index", view);
        Set modelAttribute = (Set) model.getMap().get("vets");
        assertEquals(modelAttribute.size(), 2);
    }
}