/*
 * This program will Implement 11.6 algorithm and extend it so that a user can read graph description from a file. 
 * This data can then be used by setEdge function to build the graph.This program will then demo 
 * different graph functions. 
 * 
 * Vilvesh Srinivasan
 * COSC 2436
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import static java.lang.System.out;
import java.util.Scanner;


public class A13 {
  
  public static void main ( String[] args){
    
    Scanner CONSOLE1 = new Scanner(System.in);
    Scanner CONSOLE2 = new Scanner(System.in); 
    Scanner CONSOLE3 = new Scanner(System.in); 
    Scanner CONSOLE4 = new Scanner(System.in); 

    
    int i, p, check;
    int size;
    String path;
    int[][] gm = null;
    
    i = 1;
    
    while(i == 1) {
      
    out.println("Before continuing make sure that the .txt file being used has data inputed in similar format.");
    out.println("The number of rows is the size of the graph that you will later be asked to input.");
    out.println("");
    out.println(" ***Example***");
    out.println("");
    out.println("    0 2 1");
    out.println("    2 3 4");
    out.println("    3 2 5");
    out.println("    2 1 6");
    out.println("**************");
    out.println("");
                
    out.println("Is your file in similar format?");
    System.out.println("If no enter 0  to exit. if yes enter any integer to continue.");
    check = CONSOLE1.nextInt();
    
    if (check == 0) {
        out.println("Please fix format then run program again. Bye!");
        break;
       }
    
        
                
    out.println("What is the size of the graph?");
    size = CONSOLE2.nextInt();
    Graphm g = new Graphm(size);
    out.println("Enter the path:");
    path = CONSOLE3.nextLine();
    try{
    gm = g.buildfromfile(path);
    }catch(IOException e){
       out.println("File could not be found!");
    }
    
    if(gm != null){
      //Demo
      out.println("***Edges***");
      int numCol = gm[0].length;
        int numRow = gm.length;
        for(int x = 0; x < numRow; x++){
          for(int y = 0; y < numCol; y++){
            if(g.isEdge(x, y)){
              out.println("<"+x+","+y+">");
            }
        }
      }
    }
    
    System.out.println("Do you wish to continue? To exit enter 0 or to continue enter any integer");
       
       p = CONSOLE4.nextInt();
       
       if ( p == 0) {
        out.println("Bye!");
        break;
       }
} 
}
  
  
/** Graph ADT */
public interface Graph {
// Graph class ADT
/** Initialize the graph
@param n The number of vertices */
public void Init(int n);
/** @return The number of vertices */
public int n();
/** @return The current number of edges */
public int e();
/** @return v�s first neighbor */
public int first(int v);
/** @return v�s next neighbor after w */
public int next(int v, int w);
/** Set the weight for an edge
@param i,j The vertices
@param wght Edge weight */
public void setEdge(int i, int j, int wght);
/** Delete an edge
@param i,j The vertices */
public void delEdge(int i, int j);
/** Determine if an edge is in the graph
@param i,j The vertices
@return true if edge i,j has non-zero weight */
public boolean isEdge(int i, int j);
/** @return The weight of edge i,j, or zero
@param i,j The vertices */
public int weight(int i, int j);
/** Set the mark value for a vertex
@param v The vertex
@param val The value to set */
public void setMark(int v, int val);
/** Get the mark value for a vertex
@param v The vertex
@return The value of the mark */
public int getMark(int v);
} 

/** Graph: Adjacency matrix */
static class Graphm implements Graph {
private int[][] matrix;
// The edge matrix
private int numEdge;
// Number of edges
public int[] Mark;
// The mark array
public Graphm() {}
// Constructors
public Graphm(int n) {
Init(n);
}
public void Init(int n) {
Mark = new int[n];
matrix = new int[n][n];
numEdge = 0;
}
public int n() { return Mark.length; } // # of vertices
public int e() { return numEdge; }
// # of edges
/** @return v�s first neighbor */
public int first(int v) {
for (int i=0; i<Mark.length; i++)
if (matrix[v][i] != 0) return i;
return Mark.length; // No edge for this vertex
}
/** @return v�s next neighbor after w */
public int next(int v, int w) {
for (int i=w+1; i<Mark.length; i++)
if (matrix[v][i] != 0)
return i;
return Mark.length; // No next edge;
}
/** Set the weight for an edge */
public void setEdge(int i, int j, int wt) {
assert wt!=0 : "Cannot set weight to 0";
if (matrix[i][j] == 0) numEdge++;
matrix[i][j] = wt;
}
/** Delete an edge */
public void delEdge(int i, int j) { // Delete edge (i, j)
if (matrix[i][j] != 0) numEdge--;
matrix[i][j] = 0;
}
/** Determine if an edge is in the graph */
public boolean isEdge(int i, int j)
{ return matrix[i][j] != 0; }


/** @return an edge�s weight */
public int weight(int i, int j) {
return matrix[i][j];
}

/** Set/Get the mark value for a vertex */
public void setMark(int v, int val){ 
Mark[v] = val;
}

public int getMark(int v){ 
return Mark[v]; 
}

/** Create Graph from user file */
public int[][] buildfromfile(String path) throws IOException {
BufferedReader br2  = new BufferedReader(new FileReader(path));
String line;
int count = 0;
while ((line = br2.readLine()) != null){
String[] st = line.split("\\s+");
int ind1 = Integer.parseInt(st[0]);
int ind2 = Integer.parseInt(st[1]);
int wt = Integer.parseInt(st[2]);
setEdge(ind1, ind2, wt);
}
return matrix;
}
}
}
  