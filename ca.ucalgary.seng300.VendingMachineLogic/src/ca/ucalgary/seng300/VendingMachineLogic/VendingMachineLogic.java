package ca.ucalgary.seng300.VendingMachineLogic;

import java.util.ArrayList;
import java.util.List;

import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class VendingMachineLogic implements CoinSlotListener, PopCanRackListener, SelectionButtonListener {

	private VendingMachine vm;
	private int userCredit;
	private List<SelectionButton> buttonList = new ArrayList<>();
	
	public VendingMachineLogic(VendingMachine vm) {
		
		this.vm = vm;
		userCredit = 0;
		
		for (int i = 0; i < vm.getNumberOfSelectionButtons(); i++) { //For loop to iterate through all the available buttons
			SelectionButton sb = vm.getSelectionButton(i); //Stores it
			sb.register(this); //And registers the relevant listeners
			buttonList.add(sb); //into an ArrayList for later use
		}
		
	}
	
	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		//Leave Empty
	}

	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		//Leave Empty		
	}

	@Override
	public void pressed(SelectionButton button) {
		
		int btnIndex = buttonList.indexOf(button) ; //Which button did the user press
		
		if (btnIndex == -1) { //Unregistered button is pressed
			//Nothing happens for now
		}
		
		int cost = vm.getPopKindCost(btnIndex);
		
		if (cost < userCredit) { //Not enough money!!!
			//Nothing happens for now
		} else {
			PopCanRack pr = vm.getPopCanRack(btnIndex); //Matches the button with the pop rack
			try {
				pr.dispensePopCan(); //Dispenses the relevant pop
				vm.getCoinReceptacle().storeCoins(); //Stores the change
				userCredit -= cost; //Deduct the pay from the available credit
			} catch (DisabledException | EmptyException | CapacityExceededException e) {
				throw new SimulationException(e);
			}
		}
	}

	@Override
	public void popCanAdded(PopCanRack popCanRack, PopCan popCan) {
		//Leave Empty
	}

	@Override
	public void popCanRemoved(PopCanRack popCanRack, PopCan popCan) {
		// TODO Auto-generated method stub
	}

	@Override
	public void popCansFull(PopCanRack popCanRack) {
		//Leave Empty
	}

	@Override
	public void popCansEmpty(PopCanRack popCanRack) {
		//Leave Empty
	}

	@Override
	public void popCansLoaded(PopCanRack rack, PopCan... popCans) {
		//Leave Empty
	}

	@Override
	public void popCansUnloaded(PopCanRack rack, PopCan... popCans) {
		//Leave Empty
	}

	@Override
	public void validCoinInserted(CoinSlot slot, Coin coin) {
		userCredit += coin.getValue();
	}

	@Override
	public void coinRejected(CoinSlot slot, Coin coin) {
		//Leave Empty
	}
	
}
