package kurskal;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Graph is an object-oriented representation of a mathematical graph. 
 * Added Kurskal's algorithm implementation.
 *
 * @author Mark Plagge
 * @version 2013
 */
public class Graph {

    private int[][] edgeDistance;  //the length of the edge from vertex i to vertex j, -1 if no edge
    private int noVertices;
    private HashSet edges;
    public HashSet spanningTree;
    public ArrayList<HashSet> vertexGroups;

    /**
     * Constructor for objects of class Graph
     */
    public Graph(File filename) throws IOException {
        spanningTree = new HashSet();
        edges = new HashSet();
        
        vertexGroups = new ArrayList<>();

        Scanner scan;
        scan = new Scanner(filename);
        noVertices = scan.nextInt();
        edgeDistance = new int[noVertices][noVertices];
        for (int i = 0; i < noVertices; i++) {
            for (int j = 0; j < noVertices; j++) {
                edgeDistance[i][j] = scan.nextInt();
            }
        }

        scan.close();
        edges = new HashSet();

    }

    public Graph(String graphData) {
        spanningTree = new HashSet();
        edges = new HashSet();
        vertexGroups = new ArrayList<>();

        Scanner scan;
        scan = new Scanner(graphData);
        //debug print statement:
       // System.out.println("--- Graph Data is: \n" + graphData);
        noVertices = scan.nextInt();
        edgeDistance = new int[noVertices][noVertices];
        for (int i = 0; i < noVertices; i++) {
            for (int j = 0; j < noVertices; j++) {
                edgeDistance[i][j] = scan.nextInt();

            }
        }
        edges = new HashSet();



    }

    public HashSet getMinimumSpanningTree() {
        spanningTree = new HashSet();
        vertexGroups = new ArrayList<>();
        for (int i = 0; i < edgeDistance.length; i++) {
            //loop through all of the vertices 
            for (int j = 0; j < edgeDistance.length; j++) {
                if (edgeDistance[i][j] > 0) {
                    Edge x = new Edge(i, j, edgeDistance[i][j]);
                    insert(x);
                    insert(new Edge(j, i, edgeDistance[j][i]));
                }

            }

        }
        for (int i = edgeDistance.length - 1; i >= 0; i--) {
            for (int j = edgeDistance.length - 1; j >= 0; j--) {
                if (edgeDistance[i][j] > 0) {
                    insert(new Edge(i, j, edgeDistance[i][j]));
                }
            }
        }
        return spanningTree;


    }

    HashSet getVertexGroup(Integer vertex) {
        if (vertexGroups != null) {
            for (HashSet<Integer> vertexGroup : vertexGroups) {
                if (vertexGroup.contains(vertex)) {
                    return vertexGroup;
                }
            }
        }
        return null;
    }

    public void insert2(Edge edge) {
    }

    public void insert(Edge edge) {
        Integer vertexA = edge.getV1();
        Integer vertexB = edge.getV2();

        HashSet<Integer> leftHash = getVertexGroup(vertexA);
        HashSet<Integer> rightHash = getVertexGroup(vertexB);

        if (leftHash == null) { //if the left side hash is Null, then we are at 
            //a new node.
            spanningTree.add(edge);
            if (rightHash == null) {
                HashSet<Integer> htNewVertexGroup = new HashSet<>();
                htNewVertexGroup.add(vertexA);
                htNewVertexGroup.add(vertexB);
                vertexGroups.add(htNewVertexGroup);
            } else {
                rightHash.add(vertexA);
            }
        } else {
            if (rightHash == null) {
                leftHash.add(vertexB);
                spanningTree.add(edge);
            } else if (leftHash != rightHash) {
                leftHash.addAll(rightHash);
                vertexGroups.remove(rightHash);
                spanningTree.add(edge);
            }
        }
    }

    public int getNoVertices() {
        return noVertices;
    }
    // edgeDistance - returns the length of the edge from vertex i to vertex j
    //                returns -1 if there is no edge from vertex i to vertex j

    public int edgeDistance(int i, int j) {
        return edgeDistance[i][j];
    }

    public ArrayList adjacentVertices(int u) {
        ArrayList al = new ArrayList();
        for (int i = 0; i < noVertices; i++) {
            if (edgeDistance(u, i) > 0) {
                al.add(i);
            }
        }
        return al;
    }

    @Override
    public String toString() {
        String temp = "\nVertices:";
        for (int i = 0; i < noVertices - 1; i++) {
            temp = temp + i + ",";
        }
        temp = temp + (noVertices - 1);
        temp = temp + "\nEdges:";
        temp = temp + edges.toString();
        return temp;
    }
}