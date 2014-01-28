package kurskal;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * This program is an implementation of Kurskal's algorithm in Java. The program reads in a file,
 * converts it into a graph object, then applies Kurskal's algorithm to find the 
 *
 * @author Mark Plagge
 * @version 2013
 */
public class GraphRunner {

    public static void main(String[] args) throws IOException {
        
  
        System.out.println("Please choose an input file. \n The demo was included as input.grp in the project folder.");
        JFileChooser fileCH = new JFileChooser(".");

        fileCH.showOpenDialog(null);
        String filePth = fileCH.getSelectedFile().getAbsolutePath();
        //load the file here, since it is better to seperate file loading from Grpah algorithms :)
        File inputFile = new File(filePth);

        //file load section -- TODO: insert a menu loop here for users to choose a file if they get the first one wrong.
        String graphData = loadFile(filePth);
        //if GraphData is -1, then the file was invalid.
        if (!graphData.equals("-1")) {


            Graph g = new Graph(graphData);
            System.out.println("Graph loaded");

            ///and display the BFS search:
            Scanner userInput = new Scanner(System.in);
            String loopRunning = "";

            System.out.println(g);
            for (int i = 0; i < g.getNoVertices(); i++) {
                System.out.println("Vertices adjacent to " + i + ": " + g.adjacentVertices(i));
            }

            System.out.println("Minimum weighted spanning tree: \n" + g.getMinimumSpanningTree());
        }
        else
        {
            System.out.println("Sorry, there was an error reading that file.");
        }
    }
///////Helper Functions

    /**
     * loads a graph file into a string representing the file.
     *
     * @param path
     * @return
     */
    public static String loadFile(String path) {
        String returnValue = "-2";

        try (Scanner fileReader = new Scanner(new File(path))) {
            String graphData = "";
            while (fileReader.hasNextLine()) {
                graphData += fileReader.nextLine();
                graphData += "\n";
            }
            returnValue = graphData;
            fileReader.close();
        } catch (Exception e) {
            //error, bad file!
            returnValue = "-1";
            
        }
        finally
        {
            //debug code:
            System.out.println("Input File Read was: ");
            System.out.println(returnValue);
        }
        return returnValue;
    }
}