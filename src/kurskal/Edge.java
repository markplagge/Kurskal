package kurskal;

/**
 * The Edge class captures the properties of an edge in a graph.
 * 
 * @author Mark Plagge
 * @version 2013
 */
public class Edge 
{
    private int v1;   //one vertex in the edge
    private int v2;   //the other vertex in the edge
    private int weight;  //the weight of the edge

    /**
     * Constructor for objects of class Edge
     */
    public Edge(int v1, int v2, int weight)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
    public int getV1()
    {
        return v1;
    }
    public int getV2()
    {
        return v2;
    }
    public int getWeight()
    {
        return weight;
    }
    public String toString()
    {
        return "\n(" + v1 + "," + v2 + ") weight: " + weight;
    }
    
}