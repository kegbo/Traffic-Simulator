package org.tcontroller;

import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * Graph edge subclass
 */
@SuppressWarnings("serial")
public class Edge extends DefaultWeightedEdge {

	private Node sourceNode;
	private Node targetNode;
	private Weights edgeWeight;
	private double weightValue;
	String image;
	private String direction;

	public Edge() {
		super();

	}

	protected double getWeight() {
		return weightValue;
	}

	public void setWeightObject(Weights weight) {
		edgeWeight = weight;
	}

	public Weights getWeightObject() {
		return edgeWeight;
	}

	public void setWeight(Weights weight) {
		weightValue = weight.weight_value();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String img) {
		image = img;
	}

	public Node getSourceNode() {
		return sourceNode;
	}

	public void setSourceNode(Node node) {
		sourceNode = node;

	}

	public Node getTargetNode() {
		return targetNode;
	}

	public void setTargetNode(Node node) {
		targetNode = node;

	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return this.getSource().toString() + " -- " + this.getTarget().toString();
	}

}
