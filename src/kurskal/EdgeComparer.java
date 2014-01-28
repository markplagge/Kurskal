/*
 * EdgeComparer:
 * A quick implementation of the Comparator class and structure
 * While not used in this algorithm, it is a demonstration of the technique. 
 * */
package kurskal;

import java.util.Comparator;

/**
 *
 * @author Mark Plagge
 */
public class EdgeComparer implements Comparator<Edge>{
    @Override
    public int compare(Edge a, Edge b)
    {
        return a.getWeight() - b.getWeight();
    }
}
