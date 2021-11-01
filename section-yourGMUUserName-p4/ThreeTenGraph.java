//TODO:
//  (1) Implement the graph!
//  (2) Update this code to meet the style and JavaDoc requirements.
//			Why? So that you get experience with the code for a graph!
//			Also, this happens a lot in industry (updating old code
//			to meet your new standards).

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedGraph;

import edu.uci.ics.jung.graph.util.Pair;
import edu.uci.ics.jung.graph.util.EdgeType;

import org.apache.commons.collections15.Factory;

import java.util.Collection;
import java.util.ArrayList;


class ThreeTenGraph implements Graph<GraphNode,GraphEdge>, UndirectedGraph<GraphNode,GraphEdge> {
	//you may not have any other class variables, only this one
	//if you make more class variables your graph class will receive a 0,
	//no matter how well it works
	private static final int MAX_NUMBER_OF_NODES = 200;
	
	
	//you may not have any other instance variables, only this one
	//if you make more instance variables your graph class will receive a 0,
	//no matter how well it works
	private GraphComp[][] storage = null;
	
	
	
	//this is the only allowed constructor
	public ThreeTenGraph() {
		
	}
	
    /**
     * Returns a view of all edges in this graph. In general, this
     * obeys the Collection contract, and therefore makes no guarantees 
     * about the ordering of the vertices within the set.
     * @return a Collection view of all edges in this graph
     */
    public Collection<GraphEdge> getEdges() {
		//O(n^2) amortized where n is the max number of vertices in the graph
		
		//Hint: this method returns a Collection, look at the imports for
		//what collections you could return here.
		
		return null;
	}
    
    /**
     * Returns a view of all vertices in this graph. In general, this
     * obeys the Collection contract, and therefore makes no guarantees 
     * about the ordering of the vertices within the set.
     * @return a Collection view of all vertices in this graph
     */
    public Collection<GraphNode> getVertices() {
		//O(n) amortized where n is the max number of vertices in the graph
		
		//Hint: this method returns a Collection, look at the imports for
		//what collections you could return here.
		
		return null;
	}
    
    /**
     * Returns the number of edges in this graph.
     * @return the number of edges in this graph
     */
    public int getEdgeCount() {
		//O(n^2) where n is the max number of vertices in the graph
		
		return -1;
	}
    
    /**
     * Returns the number of vertices in this graph.
     * @return the number of vertices in this graph
     */
    public int getVertexCount() {
		//O(n) where n is the max number of vertices in the graph
		
		return -1;
	}

    /**
     * Returns true if this graph's vertex collection contains vertex.
     * Equivalent to getVertices().contains(vertex).
     * @param vertex the vertex whose presence is being queried
     * @return true iff this graph contains a vertex vertex
     */
    public boolean containsVertex(GraphNode vertex) {
		//O(1)
		
		return false;
	}
    
    /**
     * Returns the collection of vertices which are connected to vertex
     * via any edges in this graph.
     * If vertex is connected to itself with a self-loop, then 
     * it will be included in the collection returned.
     * 
     * @param vertex the vertex whose neighbors are to be returned
     * @return  the collection of vertices which are connected to vertex, 
     * or null if vertex is not present
     */
    public Collection<GraphNode> getNeighbors(GraphNode vertex) {
		//O(n) amortized where n is the max number of vertices in the graph
		
		return null;
	}
    
    /**
     * Returns the number of vertices that are adjacent to vertex
     * (that is, the number of vertices that are incident to edges in vertex's
     * incident edge set).
     * 
     * <p>Equivalent to getNeighbors(vertex).size().
     * @param vertex the vertex whose neighbor count is to be returned
     * @return the number of neighboring vertices
     */
    public int getNeighborCount(GraphNode vertex) {
		//O(n) where n is the max number of vertices in the graph
		
		return -1;
	}
    
    /**
     * Returns the collection of edges in this graph which are connected to vertex.
     * 
     * @param vertex the vertex whose incident edges are to be returned
     * @return  the collection of edges which are connected to vertex, 
     * or null if vertex is not present
     */
    public Collection<GraphEdge> getIncidentEdges(GraphNode vertex) {
		//O(n) amortized where n is the max number of vertices in the graph
		
		return null;
	}
    /**
     * Returns the endpoints of edge as a Pair<GraphNode>.
     * @param edge the edge whose endpoints are to be returned
     * @return the endpoints (incident vertices) of edge
     */
    public Pair<GraphNode> getEndpoints(GraphEdge edge) {
		//O(n^2) where n is the max number of vertices in the graph
		
		return null;
	}

    /**
     * Returns an edge that connects v1 to v2.
     * If this edge is not uniquely
     * defined (that is, if the graph contains more than one edge connecting 
     * v1 to v2), any of these edges 
     * may be returned.  findEdgeSet(v1, v2) may be 
     * used to return all such edges.
     * Returns null if either of the following is true:
     * <ul>
     * <li/>v1 is not connected to v2
     * <li/>either v1 or v2 are not present in this graph
     * </ul> 
     * <p><b>Note</b>: for purposes of this method, v1 is only considered to be connected to
     * v2 via a given <i>directed</i> edge e if
     * v1 == e.getSource() && v2 == e.getDest() evaluates to true.
     * (v1 and v2 are connected by an undirected edge u if 
     * u is incident to both v1 and v2.)
     * 
     * @return  an edge that connects v1 to v2, 
     * or null if no such edge exists (or either vertex is not present)
     * @see Hypergraph#findEdgeSet(Object, Object) 
     */
    public GraphEdge findEdge(GraphNode v1, GraphNode v2) {
		//O(1)
		
		return null;
	}

    /**
     * Returns true if vertex and edge 
     * are incident to each other.
     * Equivalent to getIncidentEdges(vertex).contains(edge) and to
     * getIncidentVertices(edge).contains(vertex).
     * @param vertex
     * @param edge
     * @return true if vertex and edge 
     * are incident to each other
     */
    public boolean isIncident(GraphNode vertex, GraphEdge edge) {
		//O(n) where n is the max number of vertices in the graph
		
		return false;
	}

    /**
     * Adds edge e to this graph such that it connects 
     * vertex v1 to v2.
     * Equivalent to addEdge(e, new Pair<GraphNode>(v1, v2)).
     * If this graph does not contain v1, v2, 
     * or both, implementations may choose to either silently add 
     * the vertices to the graph or throw an IllegalArgumentException.
     * If this graph assigns edge types to its edges, the edge type of
     * e will be the default for this graph.
     * See Hypergraph.addEdge() for a listing of possible reasons
     * for failure.
     * @param e the edge to be added
     * @param v1 the first vertex to be connected
     * @param v2 the second vertex to be connected
     * @return true if the add is successful, false otherwise
     * @see Hypergraph#addEdge(Object, Collection)
     * @see #addEdge(Object, Object, Object, EdgeType)
     */
    public boolean addEdge(GraphEdge e, GraphNode v1, GraphNode v2) {
		//O(n^2) where n is the max number of vertices in the graph
		
		return false;
	}
    
    /**
     * Adds vertex to this graph.
     * Fails if vertex is null or already in the graph.
     * 
     * @param vertex    the vertex to add
     * @return true if the add is successful, and false otherwise
     * @throws IllegalArgumentException if vertex is null
     */
    public boolean addVertex(GraphNode vertex) {
		//O(1)
		
		return false;
	}

    /**
     * Removes edge from this graph.
     * Fails if edge is null, or is otherwise not an element of this graph.
     * 
     * @param edge the edge to remove
     * @return true if the removal is successful, false otherwise
     */
    public boolean removeEdge(GraphEdge edge) {
		//O(n^2) where n is the max number of vertices in the graph
		
		return false;
	}
    
    /**
     * Removes vertex from this graph.
     * As a side effect, removes any edges e incident to vertex if the 
     * removal of vertex would cause e to be incident to an illegal
     * number of vertices.  (Thus, for example, incident hyperedges are not removed, but 
     * incident edges--which must be connected to a vertex at both endpoints--are removed.) 
     * 
     * <p>Fails under the following circumstances:
     * <ul>
     * <li/>vertex is not an element of this graph
     * <li/>vertex is null
     * </ul>
     * 
     * @param vertex the vertex to remove
     * @return true if the removal is successful, false otherwise
     */
    public boolean removeVertex(GraphNode vertex) {
		//O(n) where n is the max number of vertices in the graph
		
		return false;
	}
	
	/**
	 *  Returns a string of the depth first traversal. If curr is not null,
	 *  the traversal will start at the given vertex. If curr is null, it will pick
	 *  the lowest ID vertex to start. If restart is set to false, the traversal
	 *  will only visit vertices reachable from the chosen starting location. If
	 *  restart is set to true, the depth first traversal will visit the lowest
	 *  ID vertex not yet visited if it runs out of vertices reachable from the starting
	 *  location (until all vertices in the graph have been visited).
	 *  
	 *  @param curr the current vertex being worked on, may be null
	 *  @param visited the list of vertices which have already been visited by the algorithm
	 *  @param restart whether or not to restart if all vertices have not been reached
	 *  @return a string representation of the depth first traversal, or an empty string if the graph is empty
	 */
	public String depthFirstTraversal(GraphNode curr, boolean[] visited, boolean restart) {
		//The next line triggers some things in the automatic tester.
		//If you write a _recursive_ helper method, you should copy
		//this line to that method (just put it as the first line in
		//the helper function).
		RecursionCheck.hasRecursion(); //DO NOT REMOVE THIS LINE
		
		//This method is required to be recursive.
		
		//O(n^2) where n is the max number of vertices in the graph
		
		return null;
	}
	
	//********************************************************************************
	//   testing code goes here... edit this as much as you want!
	//********************************************************************************
	
	public static void main(String[] args) {
		//create a set of nodes and edges to test with
		GraphNode[] nodes = {
			new GraphNode(0), 
			new GraphNode(1), 
			new GraphNode(2), 
			new GraphNode(3), 
			new GraphNode(4), 
			new GraphNode(5), 
			new GraphNode(6), 
			new GraphNode(7), 
			new GraphNode(8), 
			new GraphNode(9)
		};
		
		GraphEdge[] edges = {
			new GraphEdge(0), 
			new GraphEdge(1), 
			new GraphEdge(2),
			new GraphEdge(3), 
			new GraphEdge(4), 
			new GraphEdge(5)
		};
		
		//constructs a graph
		ThreeTenGraph graph = new ThreeTenGraph();
		for(GraphNode n : nodes) {
			graph.addVertex(n);
		}
		
		graph.addEdge(edges[0],nodes[0],nodes[1]);
		graph.addEdge(edges[1],nodes[1],nodes[2]);
		graph.addEdge(edges[2],nodes[3],nodes[2]);
		graph.addEdge(edges[3],nodes[6],nodes[7]);
		graph.addEdge(edges[4],nodes[8],nodes[9]);
		graph.addEdge(edges[5],nodes[9],nodes[0]);
		
		if(graph.getVertexCount() == 10 && graph.getEdgeCount() == 6) {
			System.out.println("Yay 1");
		}
		
		if(graph.containsVertex(new GraphNode(0)) && graph.containsEdge(new GraphEdge(3))) {
			System.out.println("Yay 2");
		}
		
		if(graph.toString().trim().equals("0 1 2 3 9 8 4 5 6 7")) {
			System.out.println("Yay 3");
		}
		
		//lot more testing here...
		
		//If your graph "looks funny" you probably want to check:
		//getVertexCount(), getVertices(), getInEdges(vertex),
		//and getIncidentVertices(incomingEdge) first. These are
		//used by the layout class.
	}
	
	//********************************************************************************
	//   YOU MAY, BUT DON'T NEED TO EDIT THINGS IN THIS SECTION
	//********************************************************************************

    /**
     * Returns true if v1 and v2 share an incident edge.
     * Equivalent to getNeighbors(v1).contains(v2).
     * 
     * @param v1 the first vertex to test
     * @param v2 the second vertex to test
     * @return true if v1 and v2 share an incident edge
     */
    public boolean isNeighbor(GraphNode v1, GraphNode v2) {
		return (findEdge(v1, v2) != null);
	}
    
    /**
     * Returns true if this graph's edge collection contains edge.
     * Equivalent to getEdges().contains(edge).
     * @param edge the edge whose presence is being queried
     * @return true iff this graph contains an edge edge
     */
    public boolean containsEdge(GraphEdge edge) {
		return (getEndpoints(edge) != null);
	}
    
    /**
     * Returns the collection of edges in this graph which are of type edge_type.
     * @param edge_type the type of edges to be returned
     * @return the collection of edges which are of type edge_type, or
     * null if the graph does not accept edges of this type
     * @see EdgeType
     */
    public Collection<GraphEdge> getEdges(EdgeType edge_type) {
		if(edge_type == EdgeType.UNDIRECTED) {
			return getEdges();
		}
		return null;
	}

    /**
     * Returns the number of edges of type edge_type in this graph.
     * @param edge_type the type of edge for which the count is to be returned
     * @return the number of edges of type edge_type in this graph
     */
    public int getEdgeCount(EdgeType edge_type) {
		if(edge_type == EdgeType.UNDIRECTED) {
			return getEdgeCount();
		}
		return 0;
	}
    
    /**
     * Returns the number of edges incident to vertex.  
     * Special cases of interest:
     * <ul>
     * <li/> Incident self-loops are counted once.
     * <li> If there is only one edge that connects this vertex to
     * each of its neighbors (and vice versa), then the value returned 
     * will also be equal to the number of neighbors that this vertex has
     * (that is, the output of getNeighborCount).
     * <li> If the graph is directed, then the value returned will be 
     * the sum of this vertex's indegree (the number of edges whose 
     * destination is this vertex) and its outdegree (the number
     * of edges whose source is this vertex), minus the number of
     * incident self-loops (to avoid double-counting).
     * </ul>
     * <p>Equivalent to getIncidentEdges(vertex).size().
     * 
     * @param vertex the vertex whose degree is to be returned
     * @return the degree of this node
     * @see Hypergraph#getNeighborCount(Object)
     */
    public int degree(GraphNode vertex) {
		return getNeighborCount(vertex);
	}
	
    /**
     * Returns a Collection view of the predecessors of vertex 
     * in this graph.  A predecessor of vertex is defined as a vertex v 
     * which is connected to 
     * vertex by an edge e, where e is an outgoing edge of 
     * v and an incoming edge of vertex.
     * @param vertex    the vertex whose predecessors are to be returned
     * @return  a Collection view of the predecessors of 
     * vertex in this graph
     */
    public Collection<GraphNode> getPredecessors(GraphNode vertex) {
		return getNeighbors(vertex);
	}
    
    /**
     * Returns a Collection view of the successors of vertex 
     * in this graph.  A successor of vertex is defined as a vertex v 
     * which is connected to 
     * vertex by an edge e, where e is an incoming edge of 
     * v and an outgoing edge of vertex.
     * @param vertex    the vertex whose predecessors are to be returned
     * @return  a Collection view of the successors of 
     * vertex in this graph
     */
    public Collection<GraphNode> getSuccessors(GraphNode vertex) {
		return getNeighbors(vertex);
	}
    
    /**
     * Returns true if v1 is a predecessor of v2 in this graph.
     * Equivalent to v1.getPredecessors().contains(v2).
     * @param v1 the first vertex to be queried
     * @param v2 the second vertex to be queried
     * @return true if v1 is a predecessor of v2, and false otherwise.
     */
    public boolean isPredecessor(GraphNode v1, GraphNode v2) {
		return isNeighbor(v1, v2);
	}
    
    /**
     * Returns true if v1 is a successor of v2 in this graph.
     * Equivalent to v1.getSuccessors().contains(v2).
     * @param v1 the first vertex to be queried
     * @param v2 the second vertex to be queried
     * @return true if v1 is a successor of v2, and false otherwise.
     */
    public boolean isSuccessor(GraphNode v1, GraphNode v2) {
		return isNeighbor(v1, v2);
	}
    
    /**
     * If directed_edge is a directed edge in this graph, returns the source; 
     * otherwise returns null. 
     * The source of a directed edge d is defined to be the vertex for which  
     * d is an outgoing edge.
     * directed_edge is guaranteed to be a directed edge if 
     * its EdgeType is DIRECTED. 
     * @param directed_edge
     * @return  the source of directed_edge if it is a directed edge in this graph, or null otherwise
     */
    public GraphNode getSource(GraphEdge directed_edge) {
		return null;
	}

    /**
     * If directed_edge is a directed edge in this graph, returns the destination; 
     * otherwise returns null. 
     * The destination of a directed edge d is defined to be the vertex 
     * incident to d for which  
     * d is an incoming edge.
     * directed_edge is guaranteed to be a directed edge if 
     * its EdgeType is DIRECTED. 
     * @param directed_edge
     * @return  the destination of directed_edge if it is a directed edge in this graph, or null otherwise
     */
    public GraphNode getDest(GraphEdge directed_edge) {
		return null;
	}
	
    /**
     * Returns a Collection view of the incoming edges incident to vertex
     * in this graph.
     * @param vertex    the vertex whose incoming edges are to be returned
     * @return  a Collection view of the incoming edges incident 
     * to vertex in this graph
     */
    public Collection<GraphEdge> getInEdges(GraphNode vertex) {
		return getIncidentEdges(vertex);
	}
    
    /**
     * Returns the collection of vertices in this graph which are connected to edge.
     * Note that for some graph types there are guarantees about the size of this collection
     * (i.e., some graphs contain edges that have exactly two endpoints, which may or may 
     * not be distinct).  Implementations for those graph types may provide alternate methods 
     * that provide more convenient access to the vertices.
     * 
     * @param edge the edge whose incident vertices are to be returned
     * @return  the collection of vertices which are connected to edge, 
     * or null if edge is not present
     */
    public Collection<GraphNode> getIncidentVertices(GraphEdge edge) {
		
		Pair<GraphNode> p = getEndpoints(edge);
		if(p == null) return null;
		
		ArrayList<GraphNode> ret = new ArrayList<>();
		ret.add(p.getFirst());
		ret.add(p.getSecond());
		return ret;
	}
    
    /**
     * Returns a Collection view of the outgoing edges incident to vertex
     * in this graph.
     * @param vertex    the vertex whose outgoing edges are to be returned
     * @return  a Collection view of the outgoing edges incident 
     * to vertex in this graph
     */
    public Collection<GraphEdge> getOutEdges(GraphNode vertex) {
		return getIncidentEdges(vertex);
	}
    
    /**
     * Returns the number of incoming edges incident to vertex.
     * Equivalent to getInEdges(vertex).size().
     * @param vertex    the vertex whose indegree is to be calculated
     * @return  the number of incoming edges incident to vertex
     */
    public int inDegree(GraphNode vertex) {
		return degree(vertex);
	}
    
    /**
     * Returns the number of outgoing edges incident to vertex.
     * Equivalent to getOutEdges(vertex).size().
     * @param vertex    the vertex whose outdegree is to be calculated
     * @return  the number of outgoing edges incident to vertex
     */
    public int outDegree(GraphNode vertex) {
		return degree(vertex);
	}

    /**
     * Returns the number of predecessors that vertex has in this graph.
     * Equivalent to vertex.getPredecessors().size().
     * @param vertex the vertex whose predecessor count is to be returned
     * @return  the number of predecessors that vertex has in this graph
     */
    public int getPredecessorCount(GraphNode vertex) {
		return degree(vertex);
	}
    
    /**
     * Returns the number of successors that vertex has in this graph.
     * Equivalent to vertex.getSuccessors().size().
     * @param vertex the vertex whose successor count is to be returned
     * @return  the number of successors that vertex has in this graph
     */
    public int getSuccessorCount(GraphNode vertex) {
		return degree(vertex);
	}
    
    /**
     * Returns the vertex at the other end of edge from vertex.
     * (That is, returns the vertex incident to edge which is not vertex.)
     * @param vertex the vertex to be queried
     * @param edge the edge to be queried
     * @return the vertex at the other end of edge from vertex
     */
    public GraphNode getOpposite(GraphNode vertex, GraphEdge edge) {
		Pair<GraphNode> p = getEndpoints(edge);
		if(p.getFirst().equals(vertex)) {
			return p.getSecond();
		}
		else {
			return p.getFirst();
		}
	}
    
    /**
     * Returns all edges that connects v1 to v2.
     * If this edge is not uniquely
     * defined (that is, if the graph contains more than one edge connecting 
     * v1 to v2), any of these edges 
     * may be returned.  findEdgeSet(v1, v2) may be 
     * used to return all such edges.
     * Returns null if v1 is not connected to v2.
     * <br/>Returns an empty collection if either v1 or v2 are not present in this graph.
     *  
     * <p><b>Note</b>: for purposes of this method, v1 is only considered to be connected to
     * v2 via a given <i>directed</i> edge d if
     * v1 == d.getSource() && v2 == d.getDest() evaluates to true.
     * (v1 and v2 are connected by an undirected edge u if 
     * u is incident to both v1 and v2.)
     * 
     * @return  a collection containing all edges that connect v1 to v2, 
     * or null if either vertex is not present
     * @see Hypergraph#findEdge(Object, Object) 
     */
    public Collection<GraphEdge> findEdgeSet(GraphNode v1, GraphNode v2) {
		GraphEdge edge = findEdge(v1, v2);
		if(edge == null) {
			return null;
		}
		
		ArrayList<GraphEdge> ret = new ArrayList<>();
		ret.add(edge);
		return ret;
		
	}
	
    /**
     * Returns true if vertex is the source of edge.
     * Equivalent to getSource(edge).equals(vertex).
     * @param vertex the vertex to be queried
     * @param edge the edge to be queried
     * @return true iff vertex is the source of edge
     */
    public boolean isSource(GraphNode vertex, GraphEdge edge) {
		return getSource(edge).equals(vertex);
	}
    
    /**
     * Returns true if vertex is the destination of edge.
     * Equivalent to getDest(edge).equals(vertex).
     * @param vertex the vertex to be queried
     * @param edge the edge to be queried
     * @return true iff vertex is the destination of edge
     */
    public boolean isDest(GraphNode vertex, GraphEdge edge) {
		return getDest(edge).equals(vertex);
	}
    
    /**
     * Adds edge e to this graph such that it connects 
     * vertex v1 to v2.
     * Equivalent to addEdge(e, new Pair<GraphNode>(v1, v2)).
     * If this graph does not contain v1, v2, 
     * or both, implementations may choose to either silently add 
     * the vertices to the graph or throw an IllegalArgumentException.
     * If edgeType is not legal for this graph, this method will
     * throw IllegalArgumentException.
     * See Hypergraph.addEdge() for a listing of possible reasons
     * for failure.
     * @param e the edge to be added
     * @param v1 the first vertex to be connected
     * @param v2 the second vertex to be connected
     * @param edgeType the type to be assigned to the edge
     * @return true if the add is successful, false otherwise
     * @see Hypergraph#addEdge(Object, Collection)
     * @see #addEdge(Object, Object, Object)
     */
    public boolean addEdge(GraphEdge e, GraphNode v1, GraphNode v2, EdgeType edgeType) {
		//NOTE: Only directed edges allowed
		
		if(edgeType == EdgeType.DIRECTED) {
			throw new IllegalArgumentException();
		}
		
		return addEdge(e, v1, v2);
	}
    
    /**
     * Adds edge to this graph.
     * Fails under the following circumstances:
     * <ul>
     * <li/>edge is already an element of the graph 
     * <li/>either edge or vertices is null
     * <li/>vertices has the wrong number of vertices for the graph type
     * <li/>vertices are already connected by another edge in this graph,
     * and this graph does not accept parallel edges
     * </ul>
     * 
     * @param edge
     * @param vertices
     * @return true if the add is successful, and false otherwise
     * @throws IllegalArgumentException if edge or vertices is null, 
     * or if a different vertex set in this graph is already connected by edge, 
     * or if vertices are not a legal vertex set for edge 
     */
	@SuppressWarnings("unchecked")
    public boolean addEdge(GraphEdge edge, Collection<? extends GraphNode> vertices) {
		if(edge == null || vertices == null || vertices.size() != 2) {
			return false;
		}
		
		GraphNode[] vs = (GraphNode[])vertices.toArray();
		return addEdge(edge, vs[0], vs[1]);
	}

    /**
     * Adds edge to this graph with type edge_type.
     * Fails under the following circumstances:
     * <ul>
     * <li/>edge is already an element of the graph 
     * <li/>either edge or vertices is null
     * <li/>vertices has the wrong number of vertices for the graph type
     * <li/>vertices are already connected by another edge in this graph,
     * and this graph does not accept parallel edges
     * <li/>edge_type is not legal for this graph
     * </ul>
     * 
     * @param edge
     * @param vertices
     * @return true if the add is successful, and false otherwise
     * @throws IllegalArgumentException if edge or vertices is null, 
     * or if a different vertex set in this graph is already connected by edge, 
     * or if vertices are not a legal vertex set for edge 
     */
	@SuppressWarnings("unchecked")
    public boolean addEdge(GraphEdge edge, Collection<? extends GraphNode> vertices, EdgeType edge_type) {
		if(edge == null || vertices == null || vertices.size() != 2) {
			return false;
		}
		
		GraphNode[] vs = (GraphNode[])vertices.toArray();
		return addEdge(edge, vs[0], vs[1], edge_type);
	}
	
	//********************************************************************************
	//   DO NOT EDIT ANYTHING BELOW THIS LINE
	//********************************************************************************
	
	/**
     * Returns a {@code Factory} that creates an instance of this graph type.
     * @param <GraphNode> the vertex type for the graph factory
     * @param <GraphEdge> the edge type for the graph factory
     */
	public static <GraphNode,GraphEdge> Factory<UndirectedGraph<GraphNode,GraphEdge>> getFactory() { 
		return new Factory<UndirectedGraph<GraphNode,GraphEdge>> () {
			@SuppressWarnings("unchecked")
			public UndirectedGraph<GraphNode,GraphEdge> create() {
				return (UndirectedGraph<GraphNode,GraphEdge>) new ThreeTenGraph();
			}
		};
	}
    
    /**
     * Returns the edge type of edge in this graph.
     * @param edge
     * @return the EdgeType of edge, or null if edge has no defined type
     */
    public EdgeType getEdgeType(GraphEdge edge) {
		return EdgeType.UNDIRECTED;
	}
    
    /**
     * Returns the default edge type for this graph.
     * 
     * @return the default edge type for this graph
     */
    public EdgeType getDefaultEdgeType() {
		return EdgeType.UNDIRECTED;
	}
    
    /**
     * Returns the number of vertices that are incident to edge.
     * For hyperedges, this can be any nonnegative integer; for edges this
     * must be 2 (or 1 if self-loops are permitted). 
     * 
     * <p>Equivalent to getIncidentVertices(edge).size().
     * @param edge the edge whose incident vertex count is to be returned
     * @return the number of vertices that are incident to edge.
     */
    public int getIncidentCount(GraphEdge edge) {
		return 2;
	}
	
	/**
	 *  {@inheritDoc}
	 */
	public String toString() {
		return depthFirstTraversal(null, new boolean[MAX_NUMBER_OF_NODES], true);
	}
}
