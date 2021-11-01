//TODO: Nothing, all done.

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 *  Interface for graph algorithms in the simulator.
 *  
 *  @author Katherine (Raven) Russell
 */
interface ThreeTenAlg {
	/**
	 *  Indicates the edge type required by the algotithm.
	 *  
	 *  @return the edge type expected by the algorithm
	 */
	public EdgeType graphEdgeType();
	
	/**
	 *  What to do before the simulator begins.
	 */
	public void start();
	
	/**
	 *  What to do when the simulator is stepped.
	 *  
	 *  @return whether or not there are more steps.
	 */
	public boolean step();
	
	/**
	 *  What to do after the simulator finishes all steps.
	 */
	public void finish();
	
	/**
	 *  Resets the algorithm for a new graph.
	 *  
	 *  @param graph the new graph
	 */
	public void reset(Graph<GraphNode, GraphEdge> graph);
}