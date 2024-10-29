package tn.esprit.spring.kaddem.services;

import antlr.ASTNULLType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class EquipeServiceImplTest {

    private EquipeServiceImpl mapper;
    private EquipeRepository equipeRepository;



    @Test
    void testMethod1() {


    }


    @BeforeEach
    void setUp() {
        mapper =new EquipeServiceImpl();
        EquipeRepository equipeRepository;

    }


    @Test
    void retrieveAllEquipes() {

    }

    @Test
    void addEquipe() {



            Equipe newEquipe = new Equipe("barca", "JUNIOR"); // Create a new Equipe instance
            Equipe addedEquipe = mapper.addEquipe(newEquipe); // Call the addEquipe method

            // Check if the returned object is not null and has the expected properties
            assertNotNull(addedEquipe);
            assertEquals(newEquipe.getIdEquipe(), addedEquipe.getIdEquipe());
            assertEquals(newEquipe.getNomEquipe(), addedEquipe.getNomEquipe());

            // Verify that the equipe has been added to the repository

        List<Equipe> allEquipes = (List<Equipe>) equipeRepository.findAll();
            assertEquals(3, allEquipes.size()); // Now there should be 3 equipes in total


    }
//aaaaa
    @Test
    void deleteEquipe() {
    }

    @Test
    void retrieveEquipe() {
    }

    @Test
    void updateEquipe() {
    }

    @Test
    void evoluerEquipes() {
    }
}