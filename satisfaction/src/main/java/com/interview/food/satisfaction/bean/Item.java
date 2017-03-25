package com.interview.food.satisfaction.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This is a POJO class. Will contain below variables
 * 
 * @param itemId
 *            Signifies item number
 * @param satisfactionAmount
 *            Signifies amount of satisfaction, got by consuming this item
 * @param timeTaken
 *            Signifies time taken to consume the item
 * @param satisfactionIndex
 *            Signifies generated satisfaction index based on satisfaction level
 *            and time taken
 *            
 * @author Arindam           
 */

public class Item {

	private int itemId;
	private int satisfactionAmount;
	private int timeTaken;
	private double satisfactionIndex;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getSatisfactionAmount() {
		return satisfactionAmount;
	}

	public void setSatisfactionAmount(int satisfactionAmount) {
		this.satisfactionAmount = satisfactionAmount;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public double getSatisfactionIndex() {
		return satisfactionIndex;
	}

	public void setSatisfactionIndex() {
		
		//Code for making proper divide with remainder
		BigDecimal bigTime,bigSatisfaction,bigSatisfactionIndex;
		bigSatisfaction=new BigDecimal(satisfactionAmount);
		bigTime= new BigDecimal(timeTaken);
		bigSatisfactionIndex=bigSatisfaction.divide(bigTime, 2, RoundingMode.HALF_EVEN);
		this.satisfactionIndex = bigSatisfactionIndex.doubleValue();
	}

}
