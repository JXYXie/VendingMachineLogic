package ca.ucalgary.seng300.VendingMachineLogic;

import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class VendingMachineLogic implements CoinSlotListener, DeliveryChuteListener, PopCanRackListener, SelectionButtonListener {

	private VendingMachine vm;
	private int userCredit;
	
	public VendingMachineLogic() {
		
		int[] coinValues = {5, 10, 25, 100, 200}; //Nickels, dimes, quarters, loonies, toonies (all values in cents)
		int buttonCount = 6; //6 kinds of pop
		int coinRackCapacity = 200;
		int popRackCapacity = 10;
		int receptacleCapacity = 200;
		
		vm = new VendingMachine(coinValues, buttonCount, coinRackCapacity, popRackCapacity, receptacleCapacity);
		userCredit = 0;
		
	}
	
	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressed(SelectionButton button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCanAdded(PopCanRack popCanRack, PopCan popCan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCanRemoved(PopCanRack popCanRack, PopCan popCan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansFull(PopCanRack popCanRack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansEmpty(PopCanRack popCanRack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansLoaded(PopCanRack rack, PopCan... popCans) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansUnloaded(PopCanRack rack, PopCan... popCans) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemDelivered(DeliveryChute chute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doorOpened(DeliveryChute chute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doorClosed(DeliveryChute chute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chuteFull(DeliveryChute chute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validCoinInserted(CoinSlot slot, Coin coin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coinRejected(CoinSlot slot, Coin coin) {
		// TODO Auto-generated method stub
		
	}
	
}
