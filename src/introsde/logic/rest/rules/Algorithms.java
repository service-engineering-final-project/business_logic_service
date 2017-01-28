package introsde.logic.rest.rules;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {
	
	public Algorithms() {
		// Empty constructor
	}
	
	public double getGoalInitValue(String goalName) {
		double startingValue = 0;
		
		// ritorna il final_value
		return startingValue;
	}
	
	public double getGoalFinalValue(String goalName) {
		double targetValue = 0;
		
		// ritorna il final_value
		return targetValue;
	}
	
	public double getActualGoalValue(String goalName) {
		double actualValue = 0;
		
		// ritorna il valore attuale della misurazione
		return actualValue;
	}
	
	public boolean isOnTheTrack(String goalName, double actualValue, double targetValue) {
		boolean isOnTheTrack = false;
		
		if (goalName.equals("sodium")) {
			if (actualValue<=targetValue) {
				isOnTheTrack = true;
			}
		} else if (goalName.equals("steps")) {
			if (actualValue>=targetValue) {
				isOnTheTrack = true;
			}
		} else if (goalName.equals("sleep_hours")) {
			if ((actualValue>=6)&&(actualValue<=targetValue)) {
				isOnTheTrack = true;
			}
		} else if (goalName.equals("proteins")||goalName.equals("carbohydrates")||
				goalName.equals("lipids")||goalName.equals("calories")) {
			double targetValueMinRange = targetValue - (targetValue*10.0)/100.0;
			double targetValueMaxRange = targetValue + (targetValue*10.0)/100.0;
			
			if ((actualValue>=targetValueMinRange)&&(actualValue<=targetValueMaxRange)) {
				isOnTheTrack = true;
			}
		} else if (goalName.equals("weight")) {
			isOnTheTrack = computeWeightTrend(goalName);
		} else {
			System.out.println("There is no business logic for that goal!");
		}
		
		// è in linea con quanto stabilito
		return isOnTheTrack;
	}
	
	public boolean computeWeightTrend(String goalName) {
		boolean isOnTheTrack = false;
		List<Double> weightList = new ArrayList<>();
		
		double initValue = this.getGoalInitValue(goalName);
		double finalValue = this.getGoalFinalValue(goalName);
		double slope = 0;
		
		// compute the slope using the weightList
		
		if(slope==0) {
			// se lo slope intercetta x prima della x del final value, yo!
		}
		
		// è in linea?
		return isOnTheTrack;
	}
	
	public boolean computeGeneralTrend(int goalsNumber, int goalsOnTheTrack) {
		boolean isOnTheTrack = false;
		
		if (goalsOnTheTrack>=(goalsNumber/2)) {
			isOnTheTrack = true;
		}
		
		return isOnTheTrack;
	}
}