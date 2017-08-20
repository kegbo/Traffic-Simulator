package org.tcontroller;

public class Node {

	private final String name;
	private int vector;
	private int angle;
	private double xCord;
	private double yCord;
	private Boolean manual;
	public Boolean isOccupied = false;

	public Node(String name, int vector, int angle) {
		super();
		this.name = name;
		this.vector = vector;
		this.angle = angle;
		this.yCord = vector * Math.cos(Math.toRadians((double) angle));
		this.xCord = vector * Math.sin(Math.toRadians((double) angle));

	}

	public Node(String name, int xCord, int yCord, Boolean manualSetting) {
		super();
		this.name = name;
		this.yCord = (double) yCord - 220;
		this.xCord = (double) xCord;
		this.manual = manualSetting;

	}

	public String getName() {
		return name;
	}

	public int getVector() {
		return vector;
	}

	public int getAngle() {
		return angle;
	}

	public double getXCord() {
		return xCord;
	}

	public double getYCord() {
		return yCord;
	}

	public void manualOveride(int x, int y) {
		this.yCord = y;
		this.xCord = x;

	}

	public Boolean isOcuppied(Car car) {
		Boolean occupied = false;
		if (car.getCurrent_location_Y() == this.xCord && car.getCurrentLocationX() == this.yCord) {
			occupied = true;
			System.out.println("occupied");
		}
		return occupied;
	}

	@Override
	public String toString() {
		return name;
	}
}
