package tn.esprit.rh.achat.services.facture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.entities.DetailFacture;
import tn.esprit.rh.achat.entities.Reglement;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FactureServiceTest 
{

    @Mock
    FactureRepository factureRepository;

    @InjectMocks
    FactureServiceImpl factureService;
    
  //  Facture facture = new Facture(1L ,1 ,new Date() ,new Date() ,20 ,20 ,1);

    @Test
    public void testRetrieveFacture() {

        Facture facture = new Facture(1L, 100, 500, null, null, null, null, null, null);

        facture.setIdFacture(1L);

        Mockito.when(factureRepository.findById(1L)).thenReturn(Optional.of(facture));
        factureService.retrieveFacture(1L);
        Assertions.assertNotNull(facture);

        System.out.println(facture);
        System.out.println(" Retrieve is working correctly...!!");

    }
	@Test
	@Order(2)
	void addFacture_ok() {
		List<Facture> factures = factureService.retrieveAllFactures();
		int currentSize = factures.size();
		Facture facture = new Facture();
		facture.setMontantFacture(250);
		facture.setMontantRemise(200);
		/*facture.setDateCreationFacture();*/
		/*facture.setDateDerniereModificationFacture();*/
		
		 Set<DetailFacture> detailsFacture  = new HashSet<>();
		facture.setDetailsFacture(detailsFacture);
		Set<Reglement> reglement = new  HashSet<>();
		facture.setReglements(reglement);
		/*Fournisseur fournisseur = new Fournisseur();
		facture.setFournisseur(fournisseur);*/
		
		
		Facture savedFacture = factureService.addFacture(facture);
		assertEquals(currentSize + 1, factureService.retrieveAllFactures().size());
	}


    /*@Test
    public void createFactureTest()
    {
        Facture facture2 = new Facture(2L, 100, 500, null, null, null, null, null, null);
        facture2.setIdFacture(2L);

        factureService.addFacture(facture2);
        verify(factureRepository, times(1)).save(facture2);
        System.out.println(facture2);
        System.out.println(" Create is working correctly...!!");
    }


    @Test
    public void getAllFactureTest()
    {
        List<Facture> Facturelist = new ArrayList<Facture>() {

            {
            	 add(new Facture(3L, 100, 700, null, null, null, null, null, null));
                 add(new Facture(4L, 200, 800, null, null, null, null, null, null));
                 add(new Facture(5L, 300, 900, null, null, null, null, null, null));
            }};


        when(factureService.retrieveAllFactures()).thenReturn(Facturelist);
        //test
        List<Facture> factureList = factureService.retrieveAllFactures();
        assertEquals(3, factureList.size());
        System.out.println(" Retrieve all is working correctly...!!");
    }

*/


}