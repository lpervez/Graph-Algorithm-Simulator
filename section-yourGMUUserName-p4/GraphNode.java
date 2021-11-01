//TODO: Nothing, all done.

import org.apache.commons.collections15.Factory;

import java.awt.Color;

/**
 *  A node representation for the graph simulation.
 *  
 *  @author Katherine (Raven) Russell
 */
class GraphNode extends GraphComp {
	/**
	 *  The text on this node.
	 */
	private String text;
	
	/**
	 *  Fetches the text of the node.
	 *  
	 *  @return the text of the node
	 */
	public String getText() { return text; }
	
	/**
	 *  Sets the text of the node.
	 *  
	 *  @param text the text of the node
	 */
	public void setText(String text) { this.text = text; }
	
	/**
	 *  Constructs a node with a given id.
	 *  
	 *  @param id the unique id of the node
	 */
	public GraphNode(int id) { this.id = id; this.text = ""+id; this.color = Color.WHITE; }
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ""+text;
	}
	
	/**
	 *  The number of nodes created so far (for gerating unique ids
	 *  from the factory method).
	 */
	public static int nodeCount = 0;
	
	/**
	 *  Generates a new node with a (probably) unique id.
	 *  
	 *  @return a new node
	 */
	public static Factory<GraphNode> getFactory() { 
		return new Factory<GraphNode> () {
			public GraphNode create() {
				return new GraphNode(nodeCount++);
			}
		};
	}
}
