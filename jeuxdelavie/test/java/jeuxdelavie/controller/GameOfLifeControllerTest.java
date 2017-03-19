package jeuxdelavie.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import generics.cellule.Cellule;
import jeuxdelavie.cellule.GameOfLifeCellule;
import jeuxdelavie.model.GameOfLifeModel;

public class GameOfLifeControllerTest {

	GameOfLifeController controller = new GameOfLifeController();

	@Test
	public void testFaireEvoluerPasserVivanteInitVivante() {
		// arrange
		GameOfLifeModel model = new GameOfLifeModel(3, 3);
		GameOfLifeCellule[][] cellulesInitiales = model.getCellules();

		// Exactement 3 cellules vivantes
		cellulesInitiales[0][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[1][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[2][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[0][1].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[0][2].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		GameOfLifeCellule cellule = model.getCellule(1, 1);
		Assert.assertTrue(cellule.isVivante());

		// act
		controller.faireEvoluer(cellule, model);

		// assert
		Assert.assertTrue(cellule.isVivante());
	}

	@Test
	public void testFaireEvoluerPasserVivanteInitMorte() {
		// arrange
		GameOfLifeModel model = new GameOfLifeModel(3, 3);
		GameOfLifeCellule[][] cellulesInitiales = model.getCellules();

		// Exactement 3 cellules vivantes
		cellulesInitiales[0][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[1][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[2][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[0][1].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[0][2].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		// Cellule de test initialement morte
		GameOfLifeCellule cellule = model.getCellule(1, 1);
		cellule.change();
		Assert.assertTrue(cellule.isMorte());

		// act
		controller.faireEvoluer(cellule, model);

		// assert
		Assert.assertTrue(cellule.isVivante());
	}
	
	@Test
	public void testFaireEvoluerPasserMorteInitVivante1() {
		// arrange
		GameOfLifeModel model = new GameOfLifeModel(3, 3);
		GameOfLifeCellule[][] cellulesInitiales = model.getCellules();

		// Exactement 1 cellules vivantes
		cellulesInitiales[0][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[1][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[2][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[0][1].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[0][2].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());
		
		cellulesInitiales[1][2].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());
		
		cellulesInitiales[2][2].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		// Cellule de test initialement vivante
		GameOfLifeCellule cellule = model.getCellule(1, 1);
		Assert.assertTrue(cellule.isVivante());

		// act
		controller.faireEvoluer(cellule, model);

		// assert
		Assert.assertTrue(cellule.isMorte());
	}
	
	@Test
	public void testFaireEvoluerPasserMorteInitVivante2() {
		// arrange
		GameOfLifeModel model = new GameOfLifeModel(3, 3);
		GameOfLifeCellule[][] cellulesInitiales = model.getCellules();

		// plus de 3 cellules vivantes strictement
		cellulesInitiales[0][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[1][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[2][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[0][1].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		// Cellule de test initialement vivante
		GameOfLifeCellule cellule = model.getCellule(1, 1);
		Assert.assertTrue(cellule.isVivante());

		// act
		controller.faireEvoluer(cellule, model);

		// assert
		Assert.assertTrue(cellule.isMorte());
	}
	
	@Test
	public void testGetNombreCellulesVoisinesVivantes() {
		// arrange
		GameOfLifeModel model = new GameOfLifeModel(3, 3);
		GameOfLifeCellule[][] cellulesInitiales = model.getCellules();

		// Exactement 3 cellules vivantes
		cellulesInitiales[0][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[1][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[2][0].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[0][1].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		cellulesInitiales[0][2].change();
		Assert.assertTrue(cellulesInitiales[0][0].isMorte());

		GameOfLifeCellule cellule = model.getCellule(1, 1);

		// act
		int result = controller.getNombreCellulesVoisinesVivantes(cellule, model);

		// assert
		Assert.assertEquals(3, result);
	}
	

	@Test
	public void testGetCellulesVoisinesInMiddle() {

		// arrange
		GameOfLifeModel model = new GameOfLifeModel(3, 3);
		GameOfLifeCellule cellule = model.getCellule(1, 1);

		// act
		List<Cellule> results = controller.getCellulesVoisines(cellule, model);

		// assert
		Assert.assertEquals(8, results.size());

	}
	
	@Test
	public void testGetCellulesVoisinesInCorner() {

		// arrange
		GameOfLifeModel model = new GameOfLifeModel(3, 3);
		GameOfLifeCellule cellule = model.getCellule(0, 0);

		// act
		List<Cellule> results = controller.getCellulesVoisines(cellule, model);

		// assert
		Assert.assertEquals(3, results.size());

	}
	
	@Test
	public void testGetCellulesVoisinesInBorder() {

		// arrange
		GameOfLifeModel model = new GameOfLifeModel(3, 3);
		GameOfLifeCellule cellule = model.getCellule(1, 0);

		// act
		List<Cellule> results = controller.getCellulesVoisines(cellule, model);

		// assert
		Assert.assertEquals(5, results.size());

	}

}
