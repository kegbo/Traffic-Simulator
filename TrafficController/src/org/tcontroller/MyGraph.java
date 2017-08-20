package org.tcontroller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;

/**
 * Create Graph Object
 */

public class MyGraph implements Graph {
	final DefaultDirectedWeightedGraph<Node, Edge> nodeGraph;
	final HashMap<String, Node> map;

	public MyGraph() {
		map = new HashMap<>();
		nodeGraph = createStringGraph(map);

	}

	public DefaultDirectedWeightedGraph<Node, Edge> getGraph() {
		return nodeGraph;
	}

	public Map<String, Node> getMap() {
		return map;
	}

	private static DefaultDirectedWeightedGraph<Node, Edge> createStringGraph(HashMap<String, Node> map) {
		DefaultDirectedWeightedGraph<Node, Edge> g = new DefaultDirectedWeightedGraph<>(Edge.class);

		String[] node_names = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z", "A1", "A2", "A3", "A4" };
		//
		// int[] vector = { 0, 31, 38, 53, 65, 53, 30, 45, 62, 19, 29, 38, 41,
		// 44, 60, 57, 85, 90, 129, 129, 104, 77, 102,
		// 82, 103, 104, 94, 136, 129, 127 };
		//
		// int[] angle = { 0, 90, 270, 270, 305, 315, 308, 327, 337, 0, 49, 0,
		// 62, 29, 20, 0, 14, 23, 14, 9, 11, 0, 0, 340,
		// 351, 345, 325, 337, 347, 352 };

		int[] xCord = { 50, 50, 50, 50, 236, 236, 145, 236, 335, 145, 145, 236, 145, 236, 335, 335, 435, 435, 675, 675,
				552, 435, 552, 435, 552, 552, 435, 675, 675, 675 };
		int[] yCord = { 500, 655, 310, 235, 235, 310, 378, 378, 378, 500, 602, 500, 655, 602, 602, 500, 602, 655, 655,
				602, 602, 500, 500, 360, 420, 360, 235, 235, 360, 420 };

		for (int i = 0; i < node_names.length; i++) {
			String name = node_names[i];
			int x = xCord[i];
			int y = yCord[i];
			Node node = new Node(name, x, y, true);
			map.put(node.getName(), node);
			g.addVertex(node);
		}

		/**
		 * add graph edges.
		 */

		Edge tokyo = g.addEdge(map.get("A"), map.get("B"));
		Edge newyork = g.addEdge(map.get("C"), map.get("A"));
		Edge saopaulo = g.addEdge(map.get("D"), map.get("C"));
		Edge seoul = g.addEdge(map.get("D"), map.get("E"));
		Edge mexicocity = g.addEdge(map.get("C"), map.get("F"));
		Edge osaka = g.addEdge(map.get("A"), map.get("J"));
		Edge manila = g.addEdge(map.get("B"), map.get("M"));
		Edge mubai = g.addEdge(map.get("M"), map.get("K"));
		Edge delhi = g.addEdge(map.get("K"), map.get("J"));
		Edge jarkata = g.addEdge(map.get("G"), map.get("J"));
		Edge lagos = g.addEdge(map.get("G"), map.get("H"));
		Edge kolkata = g.addEdge(map.get("J"), map.get("L"));
		Edge cairo = g.addEdge(map.get("K"), map.get("N"));
		Edge losangeles = g.addEdge(map.get("N"), map.get("L"));
		Edge buenosaires = g.addEdge(map.get("L"), map.get("H"));
		Edge moscow = g.addEdge(map.get("H"), map.get("F"));
		Edge shangai = g.addEdge(map.get("F"), map.get("E"));
		Edge karachi = g.addEdge(map.get("H"), map.get("I"));
		Edge paris = g.addEdge(map.get("L"), map.get("P"));
		Edge istanbul = g.addEdge(map.get("P"), map.get("O"));
		Edge nagoya = g.addEdge(map.get("P"), map.get("I"));
		Edge beijing = g.addEdge(map.get("P"), map.get("V"));
		Edge chigago = g.addEdge(map.get("O"), map.get("Q"));
		Edge london = g.addEdge(map.get("V"), map.get("W"));
		Edge shenzen = g.addEdge(map.get("V"), map.get("X"));
		Edge essen = g.addEdge(map.get("X"), map.get("A1"));
		Edge tehran = g.addEdge(map.get("A1"), map.get("A2"));
		Edge bogota = g.addEdge(map.get("X"), map.get("Z"));
		Edge lima = g.addEdge(map.get("Q"), map.get("R"));
		Edge bangkok = g.addEdge(map.get("Q"), map.get("U"));
		Edge jburg = g.addEdge(map.get("U"), map.get("T"));
		Edge chennai = g.addEdge(map.get("U"), map.get("W"));
		Edge taipai = g.addEdge(map.get("W"), map.get("Y"));
		Edge baghdad = g.addEdge(map.get("Y"), map.get("Z"));
		Edge santiago = g.addEdge(map.get("Z"), map.get("A3"));
		Edge bangalore = g.addEdge(map.get("Y"), map.get("A4"));
		Edge hyderbad = g.addEdge(map.get("A2"), map.get("A3"));
		Edge stpetersburg = g.addEdge(map.get("A3"), map.get("A4"));
		Edge philly = g.addEdge(map.get("A4"), map.get("T"));
		Edge lahore = g.addEdge(map.get("T"), map.get("S"));
		Edge islamabad = g.addEdge(map.get("E"), map.get("A1"));
		Edge pretoria = g.addEdge(map.get("M"), map.get("R"));
		Edge havana = g.addEdge(map.get("R"), map.get("S"));

		Edge tokyo1 = g.addEdge(map.get("B"), map.get("A"));
		Edge newyork1 = g.addEdge(map.get("A"), map.get("C"));
		Edge saopaulo1 = g.addEdge(map.get("C"), map.get("D"));
		Edge seoul1 = g.addEdge(map.get("E"), map.get("D"));
		Edge mexicocity1 = g.addEdge(map.get("F"), map.get("C"));
		Edge osaka1 = g.addEdge(map.get("J"), map.get("A"));
		Edge manila1 = g.addEdge(map.get("M"), map.get("B"));
		Edge mubai1 = g.addEdge(map.get("K"), map.get("M"));
		Edge delhi1 = g.addEdge(map.get("J"), map.get("K"));
		Edge jarkata1 = g.addEdge(map.get("J"), map.get("G"));
		Edge lagos1 = g.addEdge(map.get("H"), map.get("G"));
		Edge kolkata1 = g.addEdge(map.get("L"), map.get("J"));
		Edge cairo1 = g.addEdge(map.get("N"), map.get("K"));
		Edge losangeles1 = g.addEdge(map.get("L"), map.get("N"));
		Edge buenosaires1 = g.addEdge(map.get("H"), map.get("L"));
		Edge moscow1 = g.addEdge(map.get("F"), map.get("H"));
		Edge shangai1 = g.addEdge(map.get("E"), map.get("F"));
		Edge karachi1 = g.addEdge(map.get("I"), map.get("H"));
		Edge paris1 = g.addEdge(map.get("P"), map.get("L"));
		Edge istanbul1 = g.addEdge(map.get("O"), map.get("P"));
		Edge nagoya1 = g.addEdge(map.get("I"), map.get("P"));
		Edge beijing1 = g.addEdge(map.get("V"), map.get("P"));
		Edge chigago1 = g.addEdge(map.get("Q"), map.get("O"));
		Edge london1 = g.addEdge(map.get("W"), map.get("V"));
		Edge shenzen1 = g.addEdge(map.get("X"), map.get("V"));
		Edge essen1 = g.addEdge(map.get("A1"), map.get("X"));
		Edge tehran1 = g.addEdge(map.get("A2"), map.get("A1"));
		Edge bogota1 = g.addEdge(map.get("Z"), map.get("X"));
		Edge lima1 = g.addEdge(map.get("R"), map.get("Q"));
		Edge bangkok1 = g.addEdge(map.get("U"), map.get("Q"));
		Edge jburg1 = g.addEdge(map.get("T"), map.get("U"));
		Edge chennai1 = g.addEdge(map.get("W"), map.get("U"));
		Edge taipai1 = g.addEdge(map.get("Y"), map.get("W"));
		Edge baghdad1 = g.addEdge(map.get("Z"), map.get("Y"));
		Edge santiago1 = g.addEdge(map.get("A3"), map.get("Z"));
		Edge bangalore1 = g.addEdge(map.get("A4"), map.get("Y"));
		Edge hyderbad1 = g.addEdge(map.get("A3"), map.get("A2"));
		Edge stpetersburg1 = g.addEdge(map.get("A4"), map.get("A3"));
		Edge philly1 = g.addEdge(map.get("T"), map.get("A4"));
		Edge lahore1 = g.addEdge(map.get("S"), map.get("T"));
		Edge islamabad1 = g.addEdge(map.get("A1"), map.get("E"));
		Edge pretoria1 = g.addEdge(map.get("R"), map.get("M"));
		Edge havana1 = g.addEdge(map.get("S"), map.get("R"));

		g.setEdgeWeight(tokyo, 20.0);
		g.setEdgeWeight(newyork, 20.0);
		g.setEdgeWeight(saopaulo, 20.0);
		g.setEdgeWeight(seoul, 20.0);
		g.setEdgeWeight(mexicocity, 20.0);
		g.setEdgeWeight(osaka, 20.0);
		g.setEdgeWeight(manila, 20.0);
		g.setEdgeWeight(mubai, 20.0);
		g.setEdgeWeight(delhi, 20.0);
		g.setEdgeWeight(jarkata, 20.0);
		g.setEdgeWeight(lagos, 20.0);
		g.setEdgeWeight(kolkata, 20.0);
		g.setEdgeWeight(cairo, 20.0);
		g.setEdgeWeight(losangeles, 20.0);
		g.setEdgeWeight(buenosaires, 20.0);
		g.setEdgeWeight(moscow, 20.0);
		g.setEdgeWeight(shangai, 20.0);
		g.setEdgeWeight(karachi, 20.0);
		g.setEdgeWeight(paris, 20.0);
		g.setEdgeWeight(istanbul, 20.0);
		g.setEdgeWeight(nagoya, 20.0);
		g.setEdgeWeight(beijing, 20.0);
		g.setEdgeWeight(chigago, 20.0);
		g.setEdgeWeight(london, 20.0);
		g.setEdgeWeight(shenzen, 20.0);
		g.setEdgeWeight(essen, 20.0);
		g.setEdgeWeight(tehran, 20.0);
		g.setEdgeWeight(bogota, 20.0);
		g.setEdgeWeight(lima, 20.0);
		g.setEdgeWeight(bangkok, 20.0);
		g.setEdgeWeight(jburg, 20.0);
		g.setEdgeWeight(chennai, 20.0);
		g.setEdgeWeight(taipai, 20.0);
		g.setEdgeWeight(baghdad, 20.0);
		g.setEdgeWeight(santiago, 20.0);
		g.setEdgeWeight(bangalore, 20.0);
		g.setEdgeWeight(hyderbad, 20.0);
		g.setEdgeWeight(stpetersburg, 20.0);
		g.setEdgeWeight(philly, 20.0);
		g.setEdgeWeight(lahore, 20.0);
		g.setEdgeWeight(islamabad, 20.0);
		g.setEdgeWeight(pretoria, 20.0);
		g.setEdgeWeight(havana, 20.0);

		g.setEdgeWeight(tokyo1, 20.0);
		g.setEdgeWeight(newyork1, 20.0);
		g.setEdgeWeight(saopaulo1, 20.0);
		g.setEdgeWeight(seoul1, 20.0);
		g.setEdgeWeight(mexicocity1, 20.0);
		g.setEdgeWeight(osaka1, 20.0);
		g.setEdgeWeight(manila1, 20.0);
		g.setEdgeWeight(mubai1, 20.0);
		g.setEdgeWeight(delhi1, 20.0);
		g.setEdgeWeight(jarkata1, 20.0);
		g.setEdgeWeight(lagos1, 20.0);
		g.setEdgeWeight(kolkata1, 20.0);
		g.setEdgeWeight(cairo1, 20.0);
		g.setEdgeWeight(losangeles1, 20.0);
		g.setEdgeWeight(buenosaires1, 20.0);
		g.setEdgeWeight(moscow1, 20.0);
		g.setEdgeWeight(shangai1, 20.0);
		g.setEdgeWeight(karachi1, 20.0);
		g.setEdgeWeight(paris1, 20.0);
		g.setEdgeWeight(istanbul1, 20.0);
		g.setEdgeWeight(nagoya1, 20.0);
		g.setEdgeWeight(beijing1, 20.0);
		g.setEdgeWeight(chigago1, 20.0);
		g.setEdgeWeight(london1, 20.0);
		g.setEdgeWeight(shenzen1, 20.0);
		g.setEdgeWeight(essen1, 20.0);
		g.setEdgeWeight(tehran1, 20.0);
		g.setEdgeWeight(bogota1, 20.0);
		g.setEdgeWeight(lima1, 20.0);
		g.setEdgeWeight(bangkok1, 20.0);
		g.setEdgeWeight(jburg1, 20.0);
		g.setEdgeWeight(chennai1, 20.0);
		g.setEdgeWeight(taipai1, 20.0);
		g.setEdgeWeight(baghdad1, 20.0);
		g.setEdgeWeight(santiago1, 20.0);
		g.setEdgeWeight(bangalore1, 20.0);
		g.setEdgeWeight(hyderbad1, 20.0);
		g.setEdgeWeight(stpetersburg1, 20.0);
		g.setEdgeWeight(philly1, 20.0);
		g.setEdgeWeight(lahore1, 20.0);
		g.setEdgeWeight(islamabad1, 20.0);
		g.setEdgeWeight(pretoria1, 20.0);
		g.setEdgeWeight(havana1, 20.0);

		return g;
	}

	@Override
	public Set getAllEdges(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEdge(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EdgeFactory getEdgeFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object addEdge(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEdge(Object sourceVertex, Object targetVertex, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVertex(Object v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsVertex(Object v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set edgesOf(Object vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAllEdges(Collection edges) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set removeAllEdges(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAllVertices(Collection vertices) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object removeEdge(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeEdge(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVertex(Object v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEdgeSource(Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEdgeTarget(Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getEdgeWeight(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}
}

// End HelloJGraphT.java