package org.tcontroller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.imageio.ImageIO;

/**
 * Car Object .
 */
public class Car implements Comparable<Car> {

	private Node source;
	private Node destination;
	private Edge currentEdge;
	private int currentLocationX;
	private int currentLocationY;
	private Integer nextLocationX;
	private Integer nextLocationY;
	private int currentSpeed = 1;
	private int crashValue;
	private int stabilityValue;
	private Boolean isCrashed = false;
	private int forwardSensorDistance;
	private int rearSensorDistance;
	public String currentOrientation = "North";
	public final String[] images = { "car_left", "car_right", "car_forward", "car_backward" };
	BufferedImage carEast;
	BufferedImage carNorth;
	BufferedImage carSouth;
	BufferedImage carWest;
	private ArrayList<Edge> path = new ArrayList<Edge>();
	private Stack pathStack;
	BufferedImage currentCar;
	private Weights currentRoadWeight;
	private Boolean waitNow = false;
	private final int lengthofCar = 20;

	public Car() {

		try {
			this.carEast = ImageIO.read((this.getClass().getResource("../../car_east.png")));
			this.carNorth = ImageIO.read((this.getClass().getResource("../../car_north.png")));
			this.carSouth = ImageIO.read((this.getClass().getResource("../../car_south.png")));
			this.carWest = ImageIO.read((this.getClass().getResource("../../car_west.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Car(BufferedImage carEast, BufferedImage carNorth, BufferedImage carSouth, BufferedImage carWest) {
		this.carEast = carEast;
		this.carNorth = carNorth;
		this.carSouth = carSouth;
		this.carWest = carWest;

	}

	public BufferedImage getCarEast() {
		return carEast;
	}

	public void setCarEast(BufferedImage carEast) {
		this.carEast = carEast;
	}

	public BufferedImage getCarNorth() {
		return carNorth;
	}

	public void setCarNorth(BufferedImage carNorth) {
		this.carNorth = carNorth;
	}

	public BufferedImage getCarSouth() {
		return carSouth;
	}

	public void setCarSouth(BufferedImage carSouth) {
		this.carSouth = carSouth;
	}

	public BufferedImage getCarWest() {
		return carWest;
	}

	public void setCarWest(BufferedImage carWest) {
		this.carWest = carWest;
	}

	public Node getDestination() {
		return destination;
	}

	public void setDestination(Node destination) {
		this.destination = destination;
	}

	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
		this.currentLocationX = (int) source.getXCord();
		this.currentLocationY = (int) source.getYCord();
		this.nextLocationX = this.currentLocationX + this.currentSpeed;
		this.nextLocationY = this.currentLocationY + this.currentSpeed;
	}

	public int getCurrentLocationX() {
		return currentLocationX;
	}

	public void setCurrentLocation_X(int current_location_X) {
		this.currentLocationX = current_location_X;
	}

	public int getCurrent_location_Y() {
		return currentLocationY;
	}

	public void setCurrent_location_Y(int current_location_Y) {
		this.currentLocationY = current_location_Y;
		// this.setNextLocationY(this.currentLocationY + this.currentSpeed);
	}

	public int getStability() {
		return stabilityValue;
	}

	public void setStability(int stability) {
		this.stabilityValue = stability;
	}

	public int getForwardSensorDistance() {
		return forwardSensorDistance;
	}

	public void setForwardSensorDistance(int forwardSensorDistance) {
		this.forwardSensorDistance = forwardSensorDistance;
	}

	public int getRearSensorDistance() {
		return rearSensorDistance;
	}

	public void setRearSensorDistance(int rearSensorDistance) {
		this.rearSensorDistance = rearSensorDistance;
	}

	public void accelerate() {
		setCurrentSpeed(+1);
	}

	public void decelarate() {

		setCurrentSpeed(-1);
	}

	public void increase_stability() {
		stabilityValue = +1;
	}

	public void decrease_stability() {
		stabilityValue = -1;
	}

	public Boolean getcrashStatus() {
		return isCrashed;
	}

	public void setcrashStatus(Boolean val) {
		isCrashed = val;
	}

	public Weights getRoadWeight() {
		return currentRoadWeight;
	}

	public void setRoadWeight(Weights weight) {
		currentRoadWeight = weight;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public int getCrashValue() {
		return crashValue;
	}

	public void setCrashValue(int crashValue) {
		this.crashValue = crashValue;
	}

	public String getCurrentOrientation() {
		return currentOrientation;
	}

	public void setCurrentOrientation(Node source, Node destination) {

		if (source.getXCord() > destination.getXCord()) {
			this.currentOrientation = "East";
			// setCurrent_location_Y(currentLocationY + 24);
		} else if (source.getYCord() > destination.getYCord()) {
			this.currentOrientation = "North";
			// setCurrentLocation_X(currentLocationX + 24);
		} else if (source.getXCord() < destination.getXCord()) {
			this.currentOrientation = "West";
		} else if (source.getYCord() < destination.getYCord()) {
			this.currentOrientation = "South";
		}

	}

	public int getNextLocationY() {
		return nextLocationY;
	}

	public void setNextLocationY(int nextLocationY) {
		this.nextLocationY = nextLocationY;
	}

	public int getNextLocationX() {
		return nextLocationX;
	}

	public void setNextLocationX(int nextLocationX) {
		this.nextLocationX = nextLocationX;
	}

	public BufferedImage getCar() {

		if (currentOrientation.equals("North")) {
			currentCar = carNorth;
		} else if (currentOrientation.equals("South")) {
			currentCar = carSouth;
		} else if (currentOrientation.equals("East")) {
			currentCar = carEast;
		} else if (currentOrientation.equals("West")) {
			currentCar = carWest;
		} else {
			currentCar = carNorth;
		}

		return this.currentCar;
	}

	public void setPath(ArrayList<Edge> edge) {
		path = edge;
		currentEdge = path.get(0);
	}

	public ArrayList<Edge> getPath() {
		return path;
	}

	public void addEdgePath(Edge edge) {
		path.add(edge);
	}

	public void currentPath(Edge edge) {

		source = edge.getSourceNode();
		destination = edge.getTargetNode();
		setCurrentOrientation(source, destination);
	}

	public Boolean isArrived() {
		if ((destination.getXCord() == currentLocationX) && destination.getYCord() == currentLocationY) {
			return true;
		}
		return false;
	}

	public Boolean isArrived(Node destination) {
		if ((destination.getXCord() == currentLocationX) && destination.getYCord() == currentLocationY) {
			return true;
		}
		return false;
	}

	public void drawCar(Graphics g) {

		if (currentOrientation.equals("North")) {
			g.drawImage(this.carNorth, currentLocationX + 15, currentLocationY, null);
		} else if (currentOrientation.equals("South")) {
			g.drawImage(this.carSouth, currentLocationX, currentLocationY, null);
		} else if (currentOrientation.equals("East")) {
			g.drawImage(this.carEast, currentLocationX, currentLocationY + 15, null);
		} else if (currentOrientation.equals("West")) {
			g.drawImage(this.carWest, currentLocationX, currentLocationY, null);
		}
		// g.drawImage(getCar(), currentLocationX, currentLocationY, null);
	}

	/**
	 * Update car postion for repaint
	 */
	public void move() {
		if (isArrived() != true) {
			currentEdge = path.get(0);
			Node start = currentEdge.getSourceNode();
			source = start;
			Node end = currentEdge.getTargetNode();
			setCurrentOrientation(start, end);
			if (isArrived(end) == true) {
				path.remove(0);

			} else {
				switch (currentOrientation) {
				case "North":
					if (getWaitNow()) {
						this.setCurrent_location_Y(currentLocationY);
					} else {
						this.setCurrent_location_Y(currentLocationY - currentSpeed);
						this.setNextLocationY(currentLocationY - lengthofCar - 5);
						this.setNextLocationX(currentLocationX);
					}

					break;
				case "South":
					if (getWaitNow()) {
						this.setCurrent_location_Y(currentLocationY);
					} else {
						this.setCurrent_location_Y(currentLocationY + currentSpeed);
						this.setNextLocationY(currentLocationY + lengthofCar + 5);
						this.setNextLocationX(currentLocationX);
					}
					break;
				case "East":
					if (getWaitNow()) {
						this.setCurrentLocation_X(currentLocationX);
					} else {
						this.setCurrentLocation_X(currentLocationX - currentSpeed);
						this.setNextLocationX(currentLocationX - lengthofCar - 5);
						this.setNextLocationY(currentLocationY);
					}
					break;
				case "West":
					if (getWaitNow()) {
						this.setCurrentLocation_X(currentLocationX);
					} else {
						this.setCurrentLocation_X(currentLocationX + currentSpeed);
						this.setNextLocationX(currentLocationX + lengthofCar + 5);
						this.setNextLocationY(currentLocationY);
					}
					break;
				}
			}
		} else {
			this.setCurrentLocation_X((int) destination.getXCord());
			this.setCurrent_location_Y((int) destination.getYCord());
		}

	}

	/**
	 * Perform look ahead for collision.
	 */
	@Override
	public int compareTo(Car c) {

		int temp = 1;
		Integer x = this.nextLocationX;
		Integer y = this.nextLocationY;
		Integer xc = c.nextLocationX;
		Integer yc = c.nextLocationY;
		int checkx = Math.abs(x - (xc));
		int checky = Math.abs(y - (yc));

		if (this.currentEdge.equals(c.currentEdge)) {
			if (c.currentEdge.getDirection().equals("horizontal")) {
				if (this.currentLocationX == c.nextLocationX || c.currentLocationX == this.nextLocationX) {
					return 0;
				}
			} else {
				if (this.currentLocationY == c.nextLocationY || c.currentLocationY == this.nextLocationY) {
					return 0;
				}
			}
		}

		else if (this.currentEdge.getTargetNode().equals(c.currentEdge.getTargetNode())) {

			if (this.currentEdge.getDirection().equals("horizontal")) {
				if (checkx < (c.lengthofCar * 2)) {
					return 0;
				}
			} else {
				if (checky < (c.lengthofCar * 2)) {
					return 0;
				}
			}
		}

		return temp;
	}

	public Boolean getWaitNow() {
		return waitNow;
	}

	public void setWaitNow(Boolean waitNow) {
		this.waitNow = waitNow;
	}

}
