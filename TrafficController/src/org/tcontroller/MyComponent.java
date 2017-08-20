package org.tcontroller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

import org.tcontroller.mapf.PathGenerator;

public class MyComponent extends JComponent implements ActionListener {
	MyGraph graph = new MyGraph();
	private int x = 50;
	private int y = 280;
	Timer timer;
	BufferedImage v_rd;
	BufferedImage h_rd;
	int rdWidth;
	Car myCar;
	ArrayList<Car> cars = new ArrayList<Car>();
	ArrayList<Edge> graphEdgeSet = new ArrayList<Edge>();
	ArrayList<Node> graphNodeSet = new ArrayList<Node>();
	BufferedImage carEast;
	BufferedImage carNorth;
	BufferedImage carSouth;
	BufferedImage carWest;
	int trafficVolume;
	HashMap<Car, ArrayList<Edge>> solution = new HashMap<Car, ArrayList<Edge>>();

	// cars.add(carsss);
	// cars.add(new Car(200, 100));

	public MyComponent() {

		timer = new Timer(80, this);
		setGraphEdges(graph);
		setGraphNodes(graph);
		try {
			v_rd = ImageIO.read((this.getClass().getResource("../../vertical_road.png")));
			h_rd = ImageIO.read((this.getClass().getResource("../../horizontal_road.png")));
			this.carEast = ImageIO.read((this.getClass().getResource("../../my_car_east.png")));
			this.carNorth = ImageIO.read((this.getClass().getResource("../../my_car_north.png")));
			this.carSouth = ImageIO.read((this.getClass().getResource("../../my_car_south.png")));
			this.carWest = ImageIO.read((this.getClass().getResource("../../my_car_west.png")));
			rdWidth = h_rd.getWidth();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDummyCars(20, graphEdgeSet);
	}

	public void start() {
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {

			drawTrack(g);

			for (Car car : cars) {
				if (!car.isArrived()) {
					car.drawCar(g);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setGraphEdges(MyGraph g) {
		Set<Edge> edge = g.getGraph().edgeSet();
		Iterator<Edge> iterator = edge.iterator();
		while (iterator.hasNext()) {
			Edge graphedge = iterator.next();
			graphedge.setSourceNode(g.getGraph().getEdgeSource(graphedge));
			graphedge.setTargetNode(g.getGraph().getEdgeTarget(graphedge));
			graphedge.setWeight(new Weights());
			this.graphEdgeSet.add(graphedge);
		}
	}

	private void setGraphNodes(MyGraph g) {
		Set<Edge> edge = g.getGraph().edgeSet();
		for (Entry<String, Node> entry : g.getMap().entrySet()) {
			this.graphNodeSet.add(entry.getValue());
		}
	}

	private void setDummyCars(int noOfCars, ArrayList<Edge> edge) {
		Car car = null;
		for (int i = 0; i < noOfCars; i++) {

			if (i == 1) {
				myCar = new Car(carEast, carNorth, carSouth, carWest);
				intializeCars(myCar, graphEdgeSet);
				cars.add(myCar);
			} else {
				car = new Car();
			}
			intializeCars(car, graphEdgeSet);
			cars.add(car);
		}
		setShortestPath(cars, graph, solution);
	}

	private void intializeCars(Car car, ArrayList<Edge> edge) {
		Random rand = new Random();
		int val = rand.nextInt(edge.size());
		int val2 = rand.nextInt(edge.size());
		car.setSource(edge.get(val).getSourceNode());
		car.setDestination(edge.get(val2).getTargetNode());

	}

	private void setShortestPath(ArrayList<Car> agents, MyGraph graph, HashMap<Car, ArrayList<Edge>> solution) {
		PathGenerator.generateSolution(agents, graph, solution);
		PathGenerator.setAgentPaths(solution);
	}

	public void setShortestPath() {
		PathGenerator.generateSolution(cars, graph, solution);
		PathGenerator.setAgentPaths(solution);
	}

	private ArrayList<Edge> setCarPath(Car car) {

		// car.setPath(edge);
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// myCar.move();
		// repaint();
		Thread th = new Thread(new Runnable() {
			public void run() {
				int count = 0;
				for (Car car : cars) {

					car.move();
					repaint();

					for (int y = cars.indexOf(car) + 1; y < cars.size(); y++) {

						if (car.compareTo(cars.get(y)) == 0) {
							car.setWaitNow(true);
						} else {
							car.setWaitNow(false);

						}
					}

				}
			}
		});
		th.start();

	}

	private void drawTrack(Graphics g) throws IOException {
		g.setColor(Color.black);

		for (int i = 0; i < graphNodeSet.size(); i++) {
			Node node = graphNodeSet.get(i);
			g.drawString(node.getName(), (int) node.getXCord(), (int) node.getYCord());
		}

		Iterator<Edge> iterator = graphEdgeSet.iterator();
		while (iterator.hasNext()) {
			Edge graphedge = iterator.next();
			int x1 = (int) graphedge.getSourceNode().getXCord();
			int y1 = (int) graphedge.getSourceNode().getYCord();
			int x2 = (int) graphedge.getTargetNode().getXCord();
			int y2 = (int) graphedge.getTargetNode().getYCord();
			// System.out.println(x1 + "" + y1 + "" + x2 + "" + y2);

			if (Math.abs(x2 - x1) == 0) {
				graphedge.setImage("vertical_road.png");
				graphedge.setDirection("vertical");
				for (int i = (y1 - 30); i < (y2 + 30); i++) {
					g.drawImage(v_rd, x1 - (rdWidth / 2), i, null);
				}
			}
			if (Math.abs(y2 - y1) == 0) {
				graphedge.setImage("horizontal_road.png");
				graphedge.setDirection("horizontal");
				for (int i = (x1 - 30); i < (x2 + 30); i++) {
					g.drawImage(h_rd, i, y1 - (rdWidth / 2), null);
				}

			}
		}

	}

	public ArrayList<Car> getcarList() {
		// TODO Auto-generated method stub
		return cars;
	}

	public ArrayList<Node> getNodeList() {
		// TODO Auto-generated method stub
		return graphNodeSet;
	}

	public ArrayList<Edge> getEdgesList() {
		// TODO Auto-generated method stub
		return graphEdgeSet;
	}

}
