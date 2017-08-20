package org.tcontroller;

public class Weights {

	private int length;
	private int speed_limit;
	private int road_capacity;
	private String road_type;
	private int road_condition;
	private int weather_condition;
	private int number_of_lanes;
	private int obstruction;
	private int tail_gate_distance;
	private int current_capacity;

	public Weights(int length, int speed_limit, int road_capacity, String road_type, int road_condition,
			int weather_condition, int number_of_lanes, int obstruction, int tail_gate_distance) {

		this.length = length;
		this.speed_limit = speed_limit;
		this.road_capacity = road_capacity;
		this.road_type = road_type;
		this.road_condition = road_condition;
		this.weather_condition = weather_condition;
		this.number_of_lanes = number_of_lanes;
		this.obstruction = obstruction;
		this.tail_gate_distance = tail_gate_distance;

	}

	public Weights() {

	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getSpeed_limit() {
		return speed_limit;
	}

	public void setSpeed_limit(int speed_limit) {
		this.speed_limit = speed_limit;
	}

	public int getRoad_capacity() {
		return road_capacity;
	}

	public void setRoad_capacity(int road_capacity) {
		this.road_capacity = road_capacity;
	}

	public String getRoad_type() {
		return road_type;
	}

	public void setRoad_type(String road_type) {
		this.road_type = road_type;
	}

	public int getRoad_condition() {
		return road_condition;
	}

	public void setRoad_condition(int road_condition) {
		this.road_condition = road_condition;
	}

	public int getWeather_condition() {
		return weather_condition;
	}

	public void setWeather_condition(int weather_condition) {
		this.weather_condition = weather_condition;
	}

	public int getNumber_of_lanes() {
		return number_of_lanes;
	}

	public void setNumber_of_lanes(int number_of_lanes) {
		this.number_of_lanes = number_of_lanes;
	}

	public int getObstruction() {
		return obstruction;
	}

	public void setObstruction(int obstruction) {
		this.obstruction = obstruction;
	}

	public int getTail_gate_distance() {
		return tail_gate_distance;
	}

	public void setTail_gate_distance(int tail_gate_distance) {
		this.tail_gate_distance = tail_gate_distance;
	}

	public int getCurrent_capacity() {
		return current_capacity;
	}

	public void setCurrent_capacity(int current_capacity) {
		this.current_capacity = current_capacity;
	}

	public int current_road_volume() {
		return this.length * this.current_capacity;
	}

	public int road_volume() {
		return this.length * this.road_capacity;
	}

	public int road_state() {
		return this.road_condition * this.weather_condition;
	}

	/**
	 * Numerical value of weight object
	 */
	public double weight_value() {

		double weight = road_volume() * road_state() * this.obstruction;
		return weight;
	}

}
