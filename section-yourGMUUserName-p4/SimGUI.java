//TODO: Nothing, all done.

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.KKLayout; //undirected graphs
import edu.uci.ics.jung.algorithms.layout.CircleLayout; //undirected and directed graphs
import edu.uci.ics.jung.algorithms.layout.ISOMLayout; //directed graphs

import edu.uci.ics.jung.algorithms.generators.random.ErdosRenyiGenerator;
import edu.uci.ics.jung.algorithms.generators.random.ErdosRenyiGeneratorDirected;

import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;

import java.util.*;

import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.geom.Ellipse2D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *  GUI for graph interactions.
 *  
 *  @author Katherine (Raven) Russell
 */
class SimGUI {
	/**
	 *  Frame for the GUI.
	 */
	private JFrame frame;
	
	/**
	 *  Current algorithm simulation.
	 */
	private ThreeTenAlg alg = null;
	
	/**
	 *  The panel containing the graph display.
	 */
	private Graph<GraphNode, GraphEdge> graph = null;
	
	/**
	 *  The panel containing the graph display.
	 */
	private VisualizationViewer<GraphNode, GraphEdge> visServer = null;
	
	/**
	 *  Editing model for mouse.
	 */
	private EditingModalGraphMouse<GraphNode, GraphEdge> gm;
	
	/**
	 *  The panel containing the step, reset, and play buttons.
	 */
	private JPanel buttonPanel = null;
	
	/**
	 *  Whether or not a simulation is currently playing with
	 *  the play button (i.e. automatically playing).
	 */
	private boolean playing = false;
	
	/**
	 *  The seed to use for the random number generator
	 *  associated with the algorithm simulation.
	 */
	private final Random rand;
	
	/**
	 *  The probability that two nodes are connected with
	 *  an edge (used for graph generation).
	 */
	private final double prob;
	
	/**
	 *  The number of nodes the user requested the graphs
	 *  have when they are generated.
	 */
	private final int numNodes;
	
	/**
	 *  Load up the GUI.
	 *  
	 *  @param numNodes the number of nodes in the graph
	 *  @param prob the probability that two nodes are connected with an edge
	 *  @param seed seed for the random number generator in 
	 */
	public SimGUI(int numNodes, double prob, int seed) {
		this.rand = new Random(seed);
		this.numNodes = numNodes;
		this.prob = prob;
		
		frame = new JFrame("Algorithm Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);
		frame.getContentPane().setLayout(new FlowLayout());
		
		resetAlg();
		makeMenu(); //needs to go after so gm is set
		
		frame.setVisible(true);
	}
	
	/**
	 *  Makes the menu for the simulation.
	 */
	public void makeMenu() {
		frame.setJMenuBar(null);
		JMenuBar menuBar = new JMenuBar();
		
		//exit option
		JMenu simMenu = new JMenu("Simulation");
		simMenu.setPreferredSize(new Dimension(80,20)); // Change the size 
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		simMenu.add(exit);
		menuBar.add(simMenu);
		
		//graph editing options
		JMenu modeMenu = gm.getModeMenu();
		modeMenu.setText("Mode");
		modeMenu.setIcon(null); // I'm using this in a main menu
		modeMenu.setPreferredSize(new Dimension(50,20)); // Change the size 
		menuBar.add(modeMenu);
		
		frame.setJMenuBar(menuBar);
	}
	
	/**
	 *  Makes the graph components.
	 */
	public void makeGraphPanel() {
		if(alg == null) return;
		if(visServer != null) frame.remove(visServer);
		
		//Layout (KKLayout, ISOMLayout, and CircleLayout look good)
		Layout<GraphNode, GraphEdge> layout = new CircleLayout<GraphNode, GraphEdge>(graph);
		layout.setSize(new Dimension(550,550));
		visServer = new VisualizationViewer<GraphNode, GraphEdge>(layout);
		visServer.setPreferredSize(new Dimension(600,600));
		
		visServer.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		RenderContext<GraphNode, GraphEdge> context = visServer.getRenderContext();
		
		//label edges with toString()
		context.setEdgeLabelTransformer(
			new Transformer<GraphEdge,String>(){
				public String transform(GraphEdge e) {
					return e.toString();
				}
			}
		);
		
		//color arrows with edge color
		context.setArrowFillPaintTransformer(
			new Transformer<GraphEdge,Paint>(){
				public Paint transform(GraphEdge e) {
					return e.getColor();
				}
			}
		);
		
		//color lines with edge color
		context.setEdgeDrawPaintTransformer(
			new Transformer<GraphEdge,Paint>(){
				public Paint transform(GraphEdge e) {
					return e.getColor();
				}
			}
		);
		
		//set edge line stroke to bolder
		context.setEdgeStrokeTransformer(
			new Transformer<GraphEdge,Stroke>(){
				public Stroke transform(GraphEdge e) {
					return new BasicStroke(3);
				}
			}
		);
		
		//move edge labels off the lines
		context.setLabelOffset(-5);
		
		//make nodes bigger
		context.setVertexShapeTransformer(
			new Transformer<GraphNode,Shape>(){
				public Shape transform(GraphNode v) {
					int s = 30;
					return new Ellipse2D.Double(-s/2.0, -s/2.0, s, s);
				}
			}
		);
		
		//label vertices with toString()
		context.setVertexLabelTransformer(
			new Transformer<GraphNode,String>(){
				public String transform(GraphNode v) {
					return v.toString();
				}
			}
		);
		
		//color vertices with node color
		context.setVertexFillPaintTransformer(
			new Transformer<GraphNode,Paint>(){
				public Paint transform(GraphNode v) {
					return v.getColor();
				}
			}
		);
		
		//Add user interactions
		gm = new EditingModalGraphMouse<>(context, GraphNode.getFactory(), GraphEdge.getFactory());
		gm.setMode(ModalGraphMouse.Mode.EDITING);
		visServer.setGraphMouse(gm);
		
		frame.add(visServer, 0);
		frame.revalidate();
	}
	
	/**
	 *  Makes the panel containing the step, reset, and play buttons.
	 */
	public void makeBottomButtons() {
		if(alg == null) return;
		if(buttonPanel != null) frame.remove(buttonPanel);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		
		//step button
		JButton step = new JButton("Step");
		step.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				step();
			}
		});
		buttonPanel.add(step);
		
		//reset button
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				resetAlg();
			}
		});
		buttonPanel.add(reset);
		
		//play button
		JButton play = new JButton("Play");
		play.addActionListener(new ActionListener() {
			private void toggle() {
				//toggle playing and not playing
				playing = !playing;
				buttonPanel.getComponent(0).setEnabled(!playing);
				buttonPanel.getComponent(1).setEnabled(!playing);
				((JButton)buttonPanel.getComponent(2)).setText((playing ? "Stop" : "Play"));
			}
			
			public void actionPerformed(ActionEvent event) {
				toggle();
				
				//if playing, kick off a timer
				if(playing) {
					new javax.swing.Timer(1000, new ActionListener() {
						public void actionPerformed(ActionEvent event) {
							//someone hit the stop button
							if(!playing) {
								((javax.swing.Timer)event.getSource()).stop();
								return;
							}
							else {
								if(!step()) toggle();
							}
						}
					}).start();
				}
			}
		});
		buttonPanel.add(play);
		
		frame.add(buttonPanel, 1);
		frame.revalidate();
	}
	
	/**
	 *  Calls the step button on the simulation and updates
	 *  the GUI to display the result.
	 *  
	 *  @return whether or not the simulation was able to step
	 */
	public boolean step() {
		boolean ret = alg.step();
		visServer.repaint();
		return ret;
	}
	
	/**
	 *  Generates a new graph, resetting all the appropriate static variables
	 *  for nodes and edges.
	 */
	public void genGraph() {
		GraphNode.nodeCount = 0;
		GraphEdge.edgeCount = 0;
		
		Factory<GraphNode> nodeFactory = GraphNode.getFactory();
		Factory<GraphEdge> edgeFactory = GraphEdge.getFactory();
		
		if(alg.graphEdgeType() == EdgeType.DIRECTED) {
			/*
			//For directed graph algorithms, you need (1) a directed graph class
			//instead of ThreeTenGraph and (2) this different generator class. So...
			//replace "ThreeTenGraph" below with your undirected graph class below
			//and uncomment.
			
			ErdosRenyiGeneratorDirected<GraphNode, GraphEdge> gen = new ErdosRenyiGeneratorDirected<>(
					ThreeTenGraph.<GraphNode,GraphEdge>getFactory(),
					nodeFactory, edgeFactory,
					this.numNodes,this.prob
				);
			gen.setSeed(this.rand.nextInt());
			graph = gen.create();
			*/
		}
		else {
			ErdosRenyiGenerator<GraphNode, GraphEdge> gen = new ErdosRenyiGenerator<>(
					ThreeTenGraph.<GraphNode,GraphEdge>getFactory(),
					nodeFactory, edgeFactory,
					this.numNodes,this.prob
				);
			gen.setSeed(this.rand.nextInt());
			graph = gen.create();
		}
	}
	
	/**
	 *  Load a new simulation.
	 */
	public void resetAlg() {
		if(alg == null) alg = new ThreeTenPrim();
		
		genGraph();
		alg.reset(graph);
		
		makeGraphPanel();
		makeMenu();
		makeBottomButtons();
	}
	
	/**
	 *  A main method to run the simulation with GUI.
	 *  
	 *  @param args [0] = the seed for the alg's random number generator
	 */
	public static void main(String[] args) {
		if(args.length == 0) {
			new SimGUI(8,0.5,0);
		}
		else if(args.length == 1) {
			new SimGUI(Integer.parseInt(args[0]),0.5,0);
		}
		else if(args.length == 2) {
			new SimGUI(Integer.parseInt(args[0]),Double.parseDouble(args[1]),0);
		}
		else if(args.length == 3) {
			new SimGUI(Integer.parseInt(args[0]),Double.parseDouble(args[1]),Integer.parseInt(args[2]));
		}
		else {
			System.out.println("Call with one of the following:\njava SIMGui\njava SIMGui [numNodes]\njava SIMGui [numNodes] [connectProb]\njava SIMGui [numNodes] [connectProb] [seed]");
		}
	}
}
