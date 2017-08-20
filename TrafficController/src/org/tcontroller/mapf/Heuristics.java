package org.tcontroller.mapf;

import org.jgrapht.alg.interfaces.AStarAdmissibleHeuristic;
import org.tcontroller.Node;

/**
 * Calculate the Admissible heuristic of Astar
 */
public class Heuristics implements AStarAdmissibleHeuristic {

	Node source;
	Node destination;

	Heuristics(Node source, Node destination) {
		this.source = source;
		this.destination = destination;
	}

	@Override
	public double getCostEstimate(Object sourceVertex, Object targetVertex) {

		return 1;
	}

}
