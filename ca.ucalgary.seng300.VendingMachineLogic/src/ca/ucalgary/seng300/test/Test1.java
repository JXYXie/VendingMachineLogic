package ca.ucalgary.seng300.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.ucalgary.seng300.VendingMachineLogic.*;
import org.lsmr.vending.Coin;
import org.lsmr.vending.hardware.VendingMachine;

public class Test1 {
	
	private VendingMachine vm;
	@Before
	public void setUp() throws Exception {
		
		int[] coinValues = {5, 10, 25, 100, 200}; //Nickels, dimes, quarters, loonies, toonies (all values in cents)
		int btnCount = 6; //Testing with 6 different kinds of pop
		int coinRackCapacity = 15;
		int popRackCapacity = 10;
		int receptacleCapacity = 200;
		
		vm = new VendingMachine(coinValues, btnCount, coinRackCapacity, popRackCapacity, receptacleCapacity);
		new VendingMachineLogic(vm);
		
		List<String> popNames = new ArrayList<String>(); //List of pop names
		
		popNames.add("Water");
		popNames.add("Pepsi");
		popNames.add("Sprite");
		popNames.add("Mountain Dew");
		popNames.add("Orange Crush");
		popNames.add("Gatorade");
		
		List<Integer> costs = new ArrayList<Integer>(); //List of pop costs
		
		for (int i = 0; i < popNames.size(); i++ ) {
			costs.add(250); //everything costs 2.50
		}
		
		vm.configure(popNames, costs);
		
	}

	@Test
	public void test() {
		
		Coin nickel = new Coin(5);
		Coin dime = new Coin(10);
		Coin quarter = new Coin(25);
		Coin loonie = new Coin(100);
		Coin toonie = new Coin(200);
		
		// TODO ZACH implement the rest, it should be very similar to your tests from individual assignment 2. Remember to use ASSERTS
		
	}

}
