package ca.ucalgary.seng300.VendingMachineLogic;

import java.util.ArrayList;
import java.util.List;

import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class VendingMachineLogic implements CoinSlotListener, PopCanRackListener, SelectionButtonListener {

	private VendingMachine vm;
	private int userCredit;
	private List<SelectionButton> buttonList = new ArrayList<>();
	private String event;
	
	
	public VendingMachineLogic(VendingMachine vm) {
		
		this.vm = vm;
		userCredit = 0;
		
		for (int i = 0; i < vm.getNumberOfSelectionButtons(); i++) { 
			//For loop to iterate through all the available buttons
			SelectionButton sb = vm.getSelectionButton(i); //Stores it
			sb.register(this); //And registers the relevant listeners
			buttonList.add(sb); //into an ArrayList for later use
		}
		
		for (int i = 0; i < vm.getNumberOfPopCanTacks(); i++) {
			PopCanRack pcr = vm.getPopCanRack(i); 
			pcr.register(this); //Registers the relevant listeners
		}
		
		for (int i = 0; i < vm.get; i++) {
			PopCanRack pcr = vm.getPopCanRack(i); 
			pcr.register(this);
		}
		
		vm.getCoinSlot().register(this);
		
		
	}
	
	
	/**
	 * @return the current event
	 */
	public String getEvent() {
		return event;
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
		event = "Added a " + popCan.getName();
	}

	@Override
	public void popCanRemoved(PopCanRack popCanRack, PopCan popCan) {
		event = "Removed a " + popCan.getName();
	}


	@Override
	public void popCansLoaded(PopCanRack rack, PopCan... popCans) {
		event = "Loaded " + popCans.length + " cans of" + popCans[0].getName();
	}

	@Override
	public void popCansUnloaded(PopCanRack rack, PopCan... popCans) {
		event = "Unloaded " + popCans.length + " cans of" + popCans[0].getName();
	}
	@Override
	public void validCoinInserted(CoinSlot slot, Coin coin) {
		userCredit += coin.getValue();
		event = "Inserted $"+coin.getValue();
	}

	@Override
	public void coinRejected(CoinSlot slot, Coin coin) {
		event = "Invalid coin inserted";
	}
	
}
