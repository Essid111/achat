package tn.esprit.rh.achat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;
import org.junit.Before;
import org.mockito.MockitoAnnotations;




@ExtendWith(MockitoExtension.class)
 class StockServiceImplTest {

	@Mock
	StockRepository stockRepository;
	@InjectMocks
	StockServiceImpl srvce;
	
	@Before
	public void setup(){
	    MockitoAnnotations.initMocks(this); //without this you will get NPE
	}
	
	
	@Test
	 void TestretrieveAllStocks()
	{
		Stock stock1 = new Stock("TestMock1",10,2);
		Stock stock2= new Stock("TestMock2",4,1);
		Stock stock3 = new Stock("TestMock3",100,85);
		List<Stock> stocks = Arrays.asList(stock1,stock2,stock3) ;
		
		BDDMockito.given(stockRepository.findAll()).willReturn(stocks);
		
		//test
		assertThat(srvce.retrieveAllStocks()).hasSize(3).contains(stock1,stock2,stock3);
		
	}
	@Test
	 void TestretrieveStock()
	{
		Stock stock = new Stock(1L, "stock Ariana",50,5,null);
		
		
		Mockito.when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
		Stock s = srvce.retrieveStock(1L);
		Assertions.assertNotNull(s);
		
		//System.out.println(stock); 
		System.out.println(" Retrieve works");  	 	
	}
	
	@Test
	 void TestaddStock()
	{
		Stock stock = new Stock(1L,"addStock",100,50);
		when(stockRepository.save(stock)).thenReturn(stock);
		assertEquals(stock, srvce.addStock(stock));
	}
	
	@Test
	 void TestupdateStock()
	{
		Stock stock = new Stock(1L,"addStock",100,50);
		when(stockRepository.save(stock)).thenReturn(stock);
		stock.setLibelleStock("updatestok");
		stock.setQte(90);
		assertEquals(stock, srvce.updateStock(stock));
	}
	
	
	
	

	
	
	
	
	
	

}


