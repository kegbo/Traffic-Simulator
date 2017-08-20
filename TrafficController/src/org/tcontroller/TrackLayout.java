package org.tcontroller;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TrackLayout extends JFrame {

	private JPanel contentPane;
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	ArrayList<Car> carss;
	ArrayList<Node> nodes;
	ArrayList<Edge> edges;
	HashMap<JComboBox, Object> selection = new HashMap<JComboBox, Object>();
	String[] speedLimitValues = { "30", "50", "70", "80", "100" };
	String[] roadConditionList = { "icy", "severe", "wet", "dry", "snow" };
	private String[] roadCapacity = { "100", "300", "500", "700" };
	private String[] weatherCondition = { "rainy", "snowy", "sunny", "fog", "hail" };
	private String[] roadType = { "dirt road", "smooth road", "potholes" };
	private String[] obstructions = { "parked truck", "accident" };
	private JComboBox edgeList;
	private JButton btnStart;
	private MyComponent myComponent;
	private JComboBox RoadCapacityComboBox;
	private JComboBox speedLimitComboBox;
	private JComboBox RoadConditionComboBox;
	private JComboBox weatherConditionComboBox;
	private JComboBox obstructionComboBox;
	private JComboBox startNodeComboBox;
	private JButton btnUpdate;
	private JComboBox destinationNodeComboBox;
	private ButtonGroup modegroup;
	private JComboBox modeComboBox;
	private String[] mode = { "centralized", "decentralized" };

	/**
	 * Create the frame.
	 */
	public TrackLayout() {
		setTitle("Traffic Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 537, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0,
				0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		myComponent = new MyComponent();
		this.carss = myComponent.getcarList();
		this.nodes = myComponent.getNodeList();
		this.edges = myComponent.getEdgesList();

		JLabel lblEdges = new JLabel("SET EDGE WEIGHTS");
		GridBagConstraints gbc_lblEdges = new GridBagConstraints();
		gbc_lblEdges.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdges.gridx = 5;
		gbc_lblEdges.gridy = 1;
		contentPane.add(lblEdges, gbc_lblEdges);

		JLabel lblEdde = new JLabel("Egde");
		GridBagConstraints gbc_lblEdde = new GridBagConstraints();
		gbc_lblEdde.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdde.gridx = 2;
		gbc_lblEdde.gridy = 2;
		contentPane.add(lblEdde, gbc_lblEdde);

		edgeList = new JComboBox(edges.toArray());
		// selection.put(edgeList, edges.get(0));
		edgeList.setSelectedIndex(1);
		edgeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == edgeList) {
					JComboBox temp = (JComboBox) e.getSource();
					Edge edge = (Edge) temp.getSelectedItem();
					addSelection(selection, edge, temp);

				}
			}
		});
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 2;
		contentPane.add(edgeList, gbc_comboBox_1);

		btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStart) {
					startProgram(selection, myComponent);
				}
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 15;
		gbc_btnStart.gridy = 2;
		contentPane.add(btnStart, gbc_btnStart);

		JLabel lblOptions = new JLabel("OPTIONS");
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.insets = new Insets(0, 0, 5, 5);
		gbc_lblOptions.gridx = 5;
		gbc_lblOptions.gridy = 3;
		contentPane.add(lblOptions, gbc_lblOptions);

		JLabel lblNewLabel = new JLabel("MODE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 10;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		modeComboBox = new JComboBox(mode);
		modeComboBox.setSelectedIndex(1);
		// selection.put(modeComboBox, mode[0]);
		GridBagConstraints gbc_modeComboBox = new GridBagConstraints();
		gbc_modeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_modeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_modeComboBox.gridx = 11;
		gbc_modeComboBox.gridy = 3;
		contentPane.add(modeComboBox, gbc_modeComboBox);

		modeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == modeComboBox) {
					JComboBox temp = (JComboBox) e.getSource();
					String mde = (String) temp.getSelectedItem();
					addSelection(selection, mde, temp);
				}
			}
		});

		JLabel lblTotalCost = new JLabel("TOTAL COST");
		GridBagConstraints gbc_lblTotalCost = new GridBagConstraints();
		gbc_lblTotalCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCost.gridx = 15;
		gbc_lblTotalCost.gridy = 3;
		contentPane.add(lblTotalCost, gbc_lblTotalCost);

		JLabel lblSpeedLimit = new JLabel("Speed Limit");
		GridBagConstraints gbc_lblSpeedLimit = new GridBagConstraints();
		gbc_lblSpeedLimit.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpeedLimit.gridx = 2;
		gbc_lblSpeedLimit.gridy = 4;
		contentPane.add(lblSpeedLimit, gbc_lblSpeedLimit);

		speedLimitComboBox = new JComboBox(speedLimitValues);
		speedLimitComboBox.setSelectedIndex(1);
		// selection.put(speedLimitComboBox, speedLimitValues[0]);
		speedLimitComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == speedLimitComboBox) {
					JComboBox temp = (JComboBox) e.getSource();
					String spdl = (String) temp.getSelectedItem();
					addSelection(selection, Arrays.asList(speedLimitValues).indexOf(spdl), temp);
				}
			}
		});
		GridBagConstraints gbc_speedLimitComboBox = new GridBagConstraints();
		gbc_speedLimitComboBox.anchor = GridBagConstraints.WEST;
		gbc_speedLimitComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_speedLimitComboBox.gridx = 4;
		gbc_speedLimitComboBox.gridy = 4;
		contentPane.add(speedLimitComboBox, gbc_speedLimitComboBox);

		JLabel lblRoadCondition = new JLabel("Road Condition");
		GridBagConstraints gbc_lblRoadCondition = new GridBagConstraints();
		gbc_lblRoadCondition.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoadCondition.gridx = 6;
		gbc_lblRoadCondition.gridy = 4;
		contentPane.add(lblRoadCondition, gbc_lblRoadCondition);

		RoadConditionComboBox = new JComboBox(roadConditionList);
		RoadConditionComboBox.setSelectedIndex(1);
		// selection.put(RoadConditionComboBox, roadConditionList[0]);
		RoadConditionComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == RoadConditionComboBox) {
					JComboBox temp = (JComboBox) e.getSource();
					String rdcon = (String) temp.getSelectedItem();
					addSelection(selection, Arrays.asList(roadConditionList).indexOf(rdcon), temp);
				}
			}
		});
		GridBagConstraints gbc_RoadConditionComboBox = new GridBagConstraints();
		gbc_RoadConditionComboBox.anchor = GridBagConstraints.WEST;
		gbc_RoadConditionComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_RoadConditionComboBox.gridx = 8;
		gbc_RoadConditionComboBox.gridy = 4;
		contentPane.add(RoadConditionComboBox, gbc_RoadConditionComboBox);

		JLabel totalCostValueLbl = new JLabel("10");
		GridBagConstraints gbc_totalCostValueLbl = new GridBagConstraints();
		gbc_totalCostValueLbl.insets = new Insets(0, 0, 5, 5);
		gbc_totalCostValueLbl.gridx = 15;
		gbc_totalCostValueLbl.gridy = 4;
		contentPane.add(totalCostValueLbl, gbc_totalCostValueLbl);

		JLabel lblRoadCapacity = new JLabel("Road Capacity");
		GridBagConstraints gbc_lblRoadCapacity = new GridBagConstraints();
		gbc_lblRoadCapacity.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoadCapacity.gridx = 2;
		gbc_lblRoadCapacity.gridy = 5;
		contentPane.add(lblRoadCapacity, gbc_lblRoadCapacity);

		RoadCapacityComboBox = new JComboBox(roadCapacity);
		RoadCapacityComboBox.setSelectedIndex(1);
		// selection.put(RoadCapacityComboBox, roadCapacity[0]);
		RoadCapacityComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == RoadCapacityComboBox) {
					JComboBox temp = (JComboBox) e.getSource();
					String rdcap = (String) temp.getSelectedItem();
					addSelection(selection, Arrays.asList(roadCapacity).indexOf(rdcap), temp);
				}
			}
		});
		GridBagConstraints gbc_RoadCapacityComboBox = new GridBagConstraints();
		gbc_RoadCapacityComboBox.anchor = GridBagConstraints.WEST;
		gbc_RoadCapacityComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_RoadCapacityComboBox.gridx = 4;
		gbc_RoadCapacityComboBox.gridy = 5;
		contentPane.add(RoadCapacityComboBox, gbc_RoadCapacityComboBox);

		JLabel lblWeatherCondition = new JLabel("Weather Condition");
		GridBagConstraints gbc_lblWeatherCondition = new GridBagConstraints();
		gbc_lblWeatherCondition.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeatherCondition.gridx = 6;
		gbc_lblWeatherCondition.gridy = 5;
		contentPane.add(lblWeatherCondition, gbc_lblWeatherCondition);

		weatherConditionComboBox = new JComboBox(weatherCondition);
		selection.put(weatherConditionComboBox, weatherCondition[0]);
		weatherConditionComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == weatherConditionComboBox) {
					JComboBox temp = (JComboBox) e.getSource();
					String wthcon = (String) temp.getSelectedItem();
					addSelection(selection, Arrays.asList(weatherCondition).indexOf(wthcon), temp);
				}
			}
		});
		GridBagConstraints gbc_weatherConditionComboBox = new GridBagConstraints();
		gbc_weatherConditionComboBox.anchor = GridBagConstraints.WEST;
		gbc_weatherConditionComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_weatherConditionComboBox.gridx = 8;
		gbc_weatherConditionComboBox.gridy = 5;
		contentPane.add(weatherConditionComboBox, gbc_weatherConditionComboBox);

		JLabel lblTime = new JLabel("TIME");
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTime.gridx = 15;
		gbc_lblTime.gridy = 5;
		contentPane.add(lblTime, gbc_lblTime);

		JLabel lblObstruction = new JLabel("Obstruction");
		GridBagConstraints gbc_lblObstruction = new GridBagConstraints();
		gbc_lblObstruction.insets = new Insets(0, 0, 5, 5);
		gbc_lblObstruction.gridx = 6;
		gbc_lblObstruction.gridy = 6;
		contentPane.add(lblObstruction, gbc_lblObstruction);

		obstructionComboBox = new JComboBox(obstructions);
		selection.put(obstructionComboBox, obstructions[0]);
		obstructionComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == obstructionComboBox) {
					JComboBox temp = (JComboBox) e.getSource();
					String obst = (String) temp.getSelectedItem();
					int val = Arrays.asList(obstructions).indexOf(obst);
					addSelection(selection, val, temp);

				}
			}
		});
		GridBagConstraints gbc_obstructionComboBox = new GridBagConstraints();
		gbc_obstructionComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_obstructionComboBox.anchor = GridBagConstraints.WEST;
		gbc_obstructionComboBox.gridx = 8;
		gbc_obstructionComboBox.gridy = 6;
		contentPane.add(obstructionComboBox, gbc_obstructionComboBox);

		JLabel lblStartNode = new JLabel("Start Node");
		GridBagConstraints gbc_lblStartNode = new GridBagConstraints();
		gbc_lblStartNode.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartNode.gridx = 10;
		gbc_lblStartNode.gridy = 6;
		contentPane.add(lblStartNode, gbc_lblStartNode);

		startNodeComboBox = new JComboBox(nodes.toArray());
		startNodeComboBox.setSelectedIndex(1);
		// selection.put(startNodeComboBox, nodes.get(1));
		startNodeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == startNodeComboBox) {
					JComboBox temp = (JComboBox) e.getSource();
					Node node = (Node) temp.getSelectedItem();
					addSelection(selection, node, temp);
				}
			}
		});
		GridBagConstraints gbc_startNodeComboBox = new GridBagConstraints();
		gbc_startNodeComboBox.anchor = GridBagConstraints.WEST;
		gbc_startNodeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_startNodeComboBox.gridx = 11;
		gbc_startNodeComboBox.gridy = 6;
		contentPane.add(startNodeComboBox, gbc_startNodeComboBox);

		JLabel timeValueLbl = new JLabel("20sec");
		GridBagConstraints gbc_timeValueLbl = new GridBagConstraints();
		gbc_timeValueLbl.insets = new Insets(0, 0, 5, 5);
		gbc_timeValueLbl.gridx = 15;
		gbc_timeValueLbl.gridy = 6;
		contentPane.add(timeValueLbl, gbc_timeValueLbl);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSelection(selection, myComponent);
			}
		});
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 5;
		gbc_btnUpdate.gridy = 7;
		contentPane.add(btnUpdate, gbc_btnUpdate);

		JLabel lblDestinationNode = new JLabel("Destination Node");
		GridBagConstraints gbc_lblDestinationNode = new GridBagConstraints();
		gbc_lblDestinationNode.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinationNode.gridx = 10;
		gbc_lblDestinationNode.gridy = 7;
		contentPane.add(lblDestinationNode, gbc_lblDestinationNode);

		destinationNodeComboBox = new JComboBox(nodes.toArray());
		destinationNodeComboBox.setSelectedIndex(3);
		// selection.put(destinationNodeComboBox, nodes.get(2));
		destinationNodeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == destinationNodeComboBox) {
					JComboBox temp = (JComboBox) e.getSource();
					Node node = (Node) temp.getSelectedItem();
					addSelection(selection, node, temp);
				}
			}
		});
		GridBagConstraints gbc_destinationNodeComboBox = new GridBagConstraints();
		gbc_destinationNodeComboBox.anchor = GridBagConstraints.WEST;
		gbc_destinationNodeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_destinationNodeComboBox.gridx = 11;
		gbc_destinationNodeComboBox.gridy = 7;
		contentPane.add(destinationNodeComboBox, gbc_destinationNodeComboBox);

		JLabel lblFinished = new JLabel("FINISHED");
		GridBagConstraints gbc_lblFinished = new GridBagConstraints();
		gbc_lblFinished.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinished.gridx = 15;
		gbc_lblFinished.gridy = 8;
		contentPane.add(lblFinished, gbc_lblFinished);

		GridBagConstraints gbc_myComponent = new GridBagConstraints();
		gbc_myComponent.gridwidth = 11;
		gbc_myComponent.fill = GridBagConstraints.BOTH;
		gbc_myComponent.insets = new Insets(0, 0, 5, 5);
		gbc_myComponent.gridx = 2;
		gbc_myComponent.gridy = 9;
		contentPane.add(myComponent, gbc_myComponent);
		modegroup = new ButtonGroup();
	}

	/**
	 * Start comonent timer when start button pressed.
	 */
	protected void startProgram(HashMap<JComboBox, Object> selection, MyComponent component) {

		Node start = (Node) startNodeComboBox.getSelectedItem();
		Node end = (Node) destinationNodeComboBox.getSelectedItem();
		Car mycar = (Car) component.getcarList().get(0);
		mycar.setSource(start);
		mycar.setDestination(end);
		component.start();

	}

	/**
	 * Recalculate shortest path and update agent when update button pressed
	 */
	protected void updateSelection(HashMap<JComboBox, Object> selection, MyComponent component) {

		for (HashMap.Entry<JComboBox, Object> entry : selection.entrySet()) {
			JComboBox key = (JComboBox) entry.getKey();
			Object value = entry.getValue();

			if (key.equals(edgeList)) {

				Edge temp = (Edge) value;

				temp.getWeightObject().setObstruction(obstructionComboBox.getSelectedIndex());
				temp.getWeightObject().setRoad_condition(RoadConditionComboBox.getSelectedIndex());
				temp.getWeightObject().setWeather_condition(weatherConditionComboBox.getSelectedIndex());
				temp.getWeightObject().setRoad_capacity(RoadCapacityComboBox.getSelectedIndex());
				temp.getWeightObject().setSpeed_limit(speedLimitComboBox.getSelectedIndex());
				break;
			}

		}
		component.setShortestPath();
	}

	/**
	 * add selected items to selectios hashmap.
	 */
	private void addSelection(HashMap<JComboBox, Object> selection, Object selected, JComboBox jbox) {

		for (JComboBox key : selection.keySet()) {
			if (key.equals(jbox)) {
				selection.put(key, selected);
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackLayout frame = new TrackLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
