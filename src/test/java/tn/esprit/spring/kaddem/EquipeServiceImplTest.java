package tn.esprit.spring.kaddem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipeServiceImplTest {

    @Mock
    private EquipeRepository equipeRepository;

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllEquipes() {
        // Arrange
        Equipe equipe1 = new Equipe(1, "Equipe1", Niveau.JUNIOR);
        Equipe equipe2 = new Equipe(2, "Equipe2", Niveau.SENIOR);
        List<Equipe> equipeList = Arrays.asList(equipe1, equipe2);

        when(equipeRepository.findAll()).thenReturn(equipeList);

        // Act
        List<Equipe> result = equipeService.retrieveAllEquipes();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Equipe1", result.get(0).getNomEquipe());
        verify(equipeRepository, times(1)).findAll();
    }

    @Test
    void testAddEquipe() {
        // Arrange
        Equipe equipe = new Equipe("Equipe3", Niveau.EXPERT);
        when(equipeRepository.save(equipe)).thenReturn(equipe);

        // Act
        Equipe result = equipeService.addEquipe(equipe);

        // Assert
        assertNotNull(result);
        assertEquals("Equipe3", result.getNomEquipe());
        assertEquals(Niveau.EXPERT, result.getNiveau());
        verify(equipeRepository, times(1)).save(equipe);
    }

    @Test
    void testDeleteEquipe() {
        // Arrange
        Integer idEquipe = 1;
        Equipe equipe = new Equipe(idEquipe, "Equipe4", Niveau.SENIOR);
        when(equipeRepository.findById(idEquipe)).thenReturn(Optional.of(equipe));
        doNothing().when(equipeRepository).delete(equipe);

        // Act
        equipeService.deleteEquipe(idEquipe);

        // Assert
        verify(equipeRepository, times(1)).findById(idEquipe);
        verify(equipeRepository, times(1)).delete(equipe);
    }

    @Test
    void testRetrieveEquipe() {
        // Arrange
        Integer idEquipe = 2;
        Equipe equipe = new Equipe(idEquipe, "Equipe5", Niveau.JUNIOR);
        when(equipeRepository.findById(idEquipe)).thenReturn(Optional.of(equipe));

        // Act
        Equipe result = equipeService.retrieveEquipe(idEquipe);

        // Assert
        assertNotNull(result);
        assertEquals("Equipe5", result.getNomEquipe());
        assertEquals(Niveau.JUNIOR, result.getNiveau());
        verify(equipeRepository, times(1)).findById(idEquipe);
    }

    @Test
    void testUpdateEquipe() {
        // Arrange
        Equipe equipe = new Equipe(3, "Equipe6", Niveau.JUNIOR);
        when(equipeRepository.save(equipe)).thenReturn(equipe);

        // Act
        Equipe result = equipeService.updateEquipe(equipe);

        // Assert
        assertNotNull(result);
        assertEquals("Equipe6", result.getNomEquipe());
        assertEquals(Niveau.JUNIOR, result.getNiveau());
        verify(equipeRepository, times(1)).save(equipe);
    }

}
