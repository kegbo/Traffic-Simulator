package org.tcontroller;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

public class CarGenerator {

	public static ArrayList<Car> generate(int num, ArrayList<Edge> edge) {
		ArrayList<Car> carList = new ArrayList<Car>();
		Class carReflector = Car.class;
		Object carConstructor = null;
		try {
			carConstructor = carReflector.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < num; i++) {
			Car car = null;
			try {
				car = (Car) carConstructor;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			intializeCars(car, edge);
			carList.add(car);

		}
		return carList;
	}

	public ArrayList<Car> setDummyCars(int noOfCars, ArrayList<Edge> edge) {
		ArrayList<Car> carList = new ArrayList<Car>();
		Car car = null;
		for (int i = 0; i < noOfCars; i++) {

			car = new Car();
			intializeCars(car, edge);
			carList.add(car);
		}

		return carList;
	}

	public static void intializeCars(Car car, ArrayList<Edge> edge) {
		Random rand = new Random();
		int val = rand.nextInt(edge.size());
		car.setSource(edge.get(val).getSourceNode());
		car.setDestination(edge.get(val).getTargetNode());
		car.addEdgePath(edge.get(val));
	}

}
