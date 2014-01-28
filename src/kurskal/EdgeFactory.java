/*
 * This class creates and returns a new edge. This is a trivial example of the
 * factory OO patern. I implemented this to demonstrate the technique, as it 
 * isn't very nessicary in the assignment. 
 * 
 * */
package kurskal;

/**
 *
 * @author Mark Plagge
 */
public  class EdgeFactory {
    
    /**
     * for this example, the constructor and class do not need to have any 
     * parameters. Customization could go here.
     */
    public EdgeFactory()
    {
        System.out.println("constructor");
    }
    static 
    {
        System.out.println("hiThere");
    }
    public EdgeFactory(String str)
    {
    
    }
    public EdgeFactory( EdgeFactory ref)
    {
        this(ref, "HI");
    }
    public EdgeFactory( EdgeFactory ref, String str)
    {
        
    }
    

    /**
     * A trivial Edge builder. There is no real advantage here in doing this,
     * but this is an example I wrote for this assignment.
     * 
     * @param v1 The first vertex this Edge will connect.
     * @param v2 The second vertex this Edge will connect.
     * @param weight The weight of this edge.
     * @return A shiny new edge. 
     */
    public Edge buildBasicEdge(int v1, int v2, int weight)
    {
        Edge newEdge = new Edge(v1, v2, weight);
        return newEdge;
        
    }
}
