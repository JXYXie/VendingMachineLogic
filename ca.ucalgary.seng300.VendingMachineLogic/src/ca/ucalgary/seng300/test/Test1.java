package ca.ucalgary.seng300.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import ca.ucalgary.seng300.VendingMachineLogic.*;
import org.lsmr.vending.Coin;
import org.lsmr.vending.PopCan;
import org.lsmr.vending.hardware.SimulationException;
import org.lsmr.vending.hardware.VendingMachine;

public class Test1 {
	
	private String[] pops = {
			"Water", "Pepsi", "Sprite","Mountain Dew", "Orange Crush", "Gatorade"
			};
	private VendingMachine vm;
	private VendingMachineLogic vml;
	@Before
	public void setUp() throws Exception {

		int[] coinValues = {5, 10, 25, 100, 200}; //Nickels, dimes, quarters, loonies, toonies (all values in cents)
		int btnCount = 6; //Testing with 6 different kinds of pop
		int coinRackCapacity = 15;
		int popRackCapacity = 10;
		int receptacleCapacity = 200;

		vm = new VendingMachine(coinValues, btnCount, coinRackCapacity, popRackCapacity, receptacleCapacity);
		vml = new VendingMachineLogic(vm);

		List<String> popNames = new ArrayList<String>(); //List of pop names
		for(String pop : pops){
			popNames.add(pop); // convert the array to an array list
		}

		List<Integer> costs = new ArrayList<Integer>(); //List of pop costs
		for (int i = 0; i < popNames.size(); i++ ) {
			costs.add(250); //everything costs 2.50
		}

		vm.configure(popNames, costs);

	}

	@Test
	public void test() throws Exception  {
		//make all coins and add them to a coin array
				Coin nickel = new Coin(5);
				Coin dime = new Coin(10);
				Coin quarter = new Coin(25);
				Coin loonie = new Coin(100);
				Coin toonie = new Coin(200);
				
				Coin[] coins = {nickel,dime,quarter,loonie,toonie};
				
		

		// TODO ZACH implement the rest, it should be very similar to your tests f
	@Test
	public void validCoins(){
		Coin nickel = new Coin(5);
		vml.insterCoin(nickel);
		assertEquals(vml.getEvent(),"Inserted $"+nickel.getValue());
		assertEquals(vml.getUserCredit(),nickel.getValue());
	}
	@Test
	public void invalidCoin(){
		Coin doublePenny = new Coin(2);
		vml.insterCoin(doublePenny);
		assertEquals(vml.getUserCredit(),0); //show that it has not been counted
		assertEquals(vml.getEvent(),"Invalid coin inserted");
	}
	@Test(expected = SimulationException.class)
	public void coinOverFlow() {
		Coin nickel = new Coin(5);
		for(int i = 0; i< 1000;i++){
			System.out.println(i);
			vml.insterCoin(nickel);
		}
		
	}
	@Test 
	public void canRacksEmpty(){
		assertEquals(0,vm.getPopCanRack(0).size());
		assertEquals(0,vm.getPopCanRack(1).size());
		assertEquals(0,vm.getPopCanRack(2).size());
		assertEquals(0,vm.getPopCanRack(3).size());
		assertEquals(0,vm.getPopCanRack(4).size());
		assertEquals(0,vm.getPopCanRack(5).size());
		
	}
	
	@Test
	public void addSodas(){
		PopCan pepsi = new PopCan("Pepsi");
		vm.getPopCanRack(1).load(pepsi,pepsi,pepsi,pepsi); //load 4 pepsi into the rack 
	}
	@Test
	public void DispenseSodas(){
		
	}

}
