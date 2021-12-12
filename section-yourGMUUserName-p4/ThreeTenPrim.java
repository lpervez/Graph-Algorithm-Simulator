//TODO: Fill in anything that says YOUR_CODE_HERE

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *  Simulation of Prim's shortest path algorithm.
 *  
 *  @author Katherine (Raven) Russell
 */
class ThreeTenPrim implements ThreeTenAlg {
	/**
	 *  Wrapper class for nodes to add additional properties
	 *  associated with this algorithm.
	 */
	private class NodeForAlg implements Comparable<NodeForAlg> {
		/**
		 *  The actual node from the graph.
		 */
		GraphNode graphNode = null;
		
		/**
		 *  The parent of the node (indicates the shortest path trail).
		 */
		GraphNode parent = null;
		
		/**
		 *  Whether or not the node is considered "done".
		 */
		boolean done = false;
		
		/**
		 *  The cost to the node.
		 */
		int cost = Integer.MAX_VALUE;
		
		/**
		 *  Constructs a new algorithm node from a graph node.
		 *  
		 *  @param node the graph node to wrap		 */
		public NodeForAlg(GraphNode node) { this.graphNode = node; }
		
		/**
		 *  {@inheritDoc}
		 */
		@Override
		public int compareTo(NodeForAlg o) {
			if(this.cost == o.cost)
				return this.graphNode.compareTo(o.graphNode);
			return this.cost - o.cost;
		}
	}
	
	/**
	 *  The graph the algorithm will run on.
	 */
	Graph<GraphNode, GraphEdge> graph;
	
	/**
	 *  Whether or not the algorithm has been started.
	 */
	boolean started = false;
	
	/**
	 *  The priority queue of nodes for the algorithm.
	 */
	WeissPriorityQueue<NodeForAlg> queue;
	
	/**
	 *  A mapping of graph nodes to algorithm nodes.
	 */
	HashMap<GraphNode,NodeForAlg> graphNodesToAlgNodes;
	
	/**
	 *  The last minimum node chosen by the algorithm.
	 */
	NodeForAlg lastMin = null;
	
	/**
	 *  The color when a node is "done".
	 */
	public static final Color COLOR_DONE_NODE = Color.GREEN;
	
	/**
	 *  The color when an edge is done AND in use for a shortest path.
	 */
	public static final Color COLOR_DONE_EDGE_1 = Color.GREEN.darker();
	
	/**
	 *  The color when an edge is done AND NOT in use for a shortest path.
	 */
	public static final Color COLOR_DONE_EDGE_2 = Color.LIGHT_GRAY;
	
	/**
	 *  The color when a node has been selected as the minimum.
	 */
	public static final Color COLOR_ACTIVE_NODE_1 = Color.RED;
	
	/**
	 *  The color when a node has been updated by the minimum.
	 */
	public static final Color COLOR_ACTIVE_NODE_2 = Color.YELLOW;
	
	/**
	 *  The color when an edge has been used for an update.
	 */
	public static final Color COLOR_ACTIVE_EDGE = Color.ORANGE;
	
	/**
	 *  The color when a node has "no color".
	 */
	public static final Color COLOR_NONE_NODE = Color.WHITE;
	
	/**
	 *  The color when an edge has "no color".
	 */
	public static final Color COLOR_NONE_EDGE = Color.BLACK;
	
	/**
	 *  The infinity sign.
	 */
	public static final String INFINITY_SIGN = "\u221e";
	
	/**
	 *  {@inheritDoc}
	 */
	public EdgeType graphEdgeType() {
		return EdgeType.UNDIRECTED;
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public void reset(Graph<GraphNode, GraphEdge> graph) {
		this.graph = graph;
		started = false;
	}
	
	/**
	 *  Gets the next minimum id node from the available nodes. This
	 *  is chosen as the starting spot for the shortest path algorithm.
	 *  
	 *  @return the node with the minimum id
	 */
	public GraphNode getMinimumIdNode() {
		GraphNode minIdNode = null;
		
		//Using your graph (the graph is named "graph"), get the
		//vertex with the minimum ID return it. This may not be 
		//the node with ID 0 because that node could have been deleted
		//using the graph editor.
		
		//YOUR_CODE_HERE
		for (GraphNode vertex: graph.getVertices()) {
			if (minIdNode == null) {
				minIdNode = vertex;
			}

			if (minIdNode.getId() > vertex.getId()) {
				minIdNode = vertex;
			}
		}
		
		return minIdNode;
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public void start() {
		//sets all nodes to infinity sign except one with
		//the minimum id, which is set to 0
		
		//Add/change anything you want here.
		
		this.started = true;
		this.lastMin = null;
		
		for(GraphNode v : graph.getVertices()) {
			v.setText(INFINITY_SIGN);
		}
		
		GraphNode minIdNode = getMinimumIdNode();
		minIdNode.setText("0");
		
		queue = new WeissPriorityQueue<>();
		graphNodesToAlgNodes = new HashMap<>();
		
		for(GraphNode v : graph.getVertices()) {
			//NodeForAlg is a "wrapper class" around the
			//graph node, it has fields like "cost" to
			//track properties related to the algorithm
			NodeForAlg n = new NodeForAlg(v);
			
			//YOUR_CODE_HERE
			//if the vertex is the minimum ID node, set
			//it's cost (in it's wrapper class) appropriately
			//for the cost of the starting node in Prim's algorithm
			if (v == minIdNode) {
				n.cost = 0;
			}
			
			graphNodesToAlgNodes.put(v,n);
			queue.add(n);
		}
	}
	
	/**
	 *  Returns all the unused edges in the graph (for recoloring
	 *  at the end).
	 *  
	 *  @return a collection of edges not used for any path
	 */
	public Collection<GraphEdge> getUnusedEdges() {
		ArrayList<GraphEdge> l = new ArrayList<>();
		
		for(GraphEdge e : graph.getEdges()) {
			if(e.getColor() == COLOR_NONE_EDGE) {
				l.add(e);
			}
		}
		
		return l;
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public void finish() {
		//sets all unused edges to grey color
		for(GraphEdge e : getUnusedEdges()) {
			e.setColor(COLOR_DONE_EDGE_2);
		}
	}
	
	/**
	 *  Sets the node to a given cost (or infinity if appropriate).
	 *  
	 *  @param n the node to set
	 *  @param cost the cost to set
	 */
	public void setNodeText(GraphNode n, int cost) {
		String text = (cost == Integer.MAX_VALUE ? INFINITY_SIGN : ""+cost);
		n.setText(text);
	}
	
	/**
	 *  Sets the node next to a given cost (or infinity if appropriate)
	 *  while also displaying the change from a previous value.
	 *  
	 *  @param n the node to set
	 *  @param oldCost the previous cost
	 *  @param newCost the new cost
	 */
	public void setNodeText(GraphNode n, int oldCost, int newCost) {
		String text = (oldCost == Integer.MAX_VALUE ? INFINITY_SIGN : ""+oldCost);
		n.setText("" + text + "->" + newCost);
	}
	
	/**
	 *  Recolors things after the last step and updates the text.
	 */
	public void cleanUpLastStep() {
		if(lastMin != null) {
			//mark the node as "done"
			lastMin.done = true;
		
			//reset last selected node to green (done)
			lastMin.graphNode.setColor(COLOR_DONE_NODE);
			
			//reset the last selected node to display it's ID
			lastMin.graphNode.setText(""+lastMin.graphNode.getId());
			
			//change arrows from orange highlight back to black (not done)
			for(GraphEdge e : graph.getOutEdges(lastMin.graphNode)) {
				if(e.getColor() == COLOR_ACTIVE_EDGE) {
					e.setColor(COLOR_NONE_EDGE);
				}
			}
			
			//reset all non-finished nodes back to white (not done) and appropriate text
			for(NodeForAlg n : queue) {
				n.graphNode.setColor(COLOR_NONE_NODE);
				setNodeText(n.graphNode, n.cost);
				String text = (n.cost == Integer.MAX_VALUE ? INFINITY_SIGN : ""+n.cost);
				n.graphNode.setText(text);
			}
		}
	}
	
	/**
	 *  Gets the next minimum and sets up the next step of the algorithm.
	 *  
	 *  @return whether or not a new minimum was found
	 */
	public boolean setupNextMin() {
		if(queue.isEmpty()) return false;
		
		//YOUR_CODE_HERE
		//replace the following line of code so that the current min
		//is set to the next thing from the queue (removing it from
		//the queue);
		NodeForAlg currMin = queue.remove();
		
		//set color of next node and path to it (if not first node)
		currMin.graphNode.setColor(COLOR_ACTIVE_NODE_1);
		
		//only unreachable nodes left
		if(currMin.cost == Integer.MAX_VALUE) {
			lastMin = currMin;
			return true;
		}
		
		//attach to parent
		if(currMin.parent != null) {
			graph.findEdge(currMin.parent, currMin.graphNode).setColor(COLOR_DONE_EDGE_1);
		}
		
		lastMin = currMin;
		return true;
	}
	
	/**
	 *  Updates the neighbors of the current minimum cost node.
	 */
	public void doUpdates() {
		//if the next min does not have an cost of infinity...
		if(lastMin.cost == Integer.MAX_VALUE) {
			return;
		}
		
		//highlight outgoing edges and neighbors in orange (to update)
		Collection<GraphEdge> outEdges = graph.getOutEdges(lastMin.graphNode);
		for(GraphEdge e : outEdges) {
			GraphNode n = graph.getOpposite(lastMin.graphNode, e);
			NodeForAlg algNode = graphNodesToAlgNodes.get(n);
			
			//YOUR_CODE_HERE
			//Replace the following line of code so the cost of the neighbors
			//will be set appropriately for Prim's algorithm. (Note: you may want
			//to read the code around this location to determine the value that
			//goes here.)
			int newCost = e.getWeight();
			
			if(!algNode.done && newCost < algNode.cost) {
				
				//set colors and text
				e.setColor(COLOR_ACTIVE_EDGE);
				n.setColor(COLOR_ACTIVE_NODE_2);
				
				String text = (algNode.cost == Integer.MAX_VALUE ? "\u221e" : ""+algNode.cost);
				setNodeText(n, algNode.cost, newCost);
				
				//update in queue
				algNode.cost = newCost;
				algNode.parent = lastMin.graphNode;
				queue.update(algNode);
			}
		}
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public boolean step() {
		if(!started) {
			start();
			return true;
		}
		
		cleanUpLastStep();
		if(!setupNextMin()) {
			finish();
			return false;
		}
		doUpdates();
		
		return true;
	}
}