package org.tcontroller.mapf;

import java.util.ArrayList;
import java.util.HashMap;

import org.jgrapht.alg.shortestpath.AStarShortestPath;
import org.tcontroller.Car;
import org.tcontroller.Edge;
import org.tcontroller.MyGraph;
import org.tcontroller.Node;

/**
 * Utility Class for shortest path solution
 */
public class PathGenerator {

	/**
	 * Create the frame.
	 */
	public static ArrayList<Edge> shortestPath(Node source, Node destination, MyGraph graph) {
		ArrayList<Edge> path;
		Heuristics hue = new Heuristics(source, destination);
		AStarShortestPath aStar = new AStarShortestPath(graph.getGraph(), hue);
		path = (ArrayList<Edge>) aStar.getPath(source, destination).getEdgeList();
		return path;
	}

	// generate solution
	public static void generateSolution(ArrayList<Car> agents, MyGraph graph, HashMap<Car, ArrayList<Edge>> solution) {
		ArrayList<Edge> temp;
		for (int i = 0; i < agents.size(); i++) {
			temp = shortestPath(agents.get(i).getSource(), agents.get(i).getDestination(), graph);
			solution.put(agents.get(i), temp);
		}
	}

	// set paths for agents
	public static void setAgentPaths(HashMap<Car, ArrayList<Edge>> solution) {
		for (HashMap.Entry m : solution.entrySet()) {
			Car car = (Car) m.getKey();
			ArrayList<Edge> path = (ArrayList<Edge>) m.getValue();
			car.setPath(path);
		}
	}

}
