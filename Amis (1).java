//Peter El-Hadad 20206705
//Mariel Leano 20218008

import java.util.*;
import java.io.*;

class Graph{


    private int V;

    // Array of lists for Adjacency
// List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[V];

        for(int i = 0; i < V; i++)
        {
            adj[i] = new LinkedList();
        }
    }

    // Adds a relation as a two way edge of
// undirected graph.
    public void addRelation(int v, int w)
    {
        v--;
        w--;
        adj[v].add(w);
        adj[w].add(v);
    }


    int countUtil(int v, boolean visited[])
    {
        int count = 1;
        visited[v] = true;


        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                count = count + countUtil(n, visited);
        }
        return count;
    }


    void countGroups()
    {


        int existing_groups = 0, new_groups = 1;


        boolean[] visited=new boolean[V];
        for(int i=0; i<V ;i++){
            if(!visited[i]){
                existing_groups++;
                countUtil(i,visited);
            }
        }

        for(int i=0; i<V ;i++) {
           if(adj[i].isEmpty()){
               new_groups*=2;

           }
        }
        new_groups-=existing_groups;
        System.out.println("No. of existing groups are " +
                existing_groups);
        System.out.println("No. of new groups that " +
                "can be formed are " +
                new_groups);
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 6;


        Graph g = new Graph(n);
        g.addRelation(1, 2);
        g.addRelation(3, 4);
        g.addRelation(5, 6);

        g.countGroups();

        // OUTPUT:
        //No. of existing groups are 3
        //No. of new groups that can be formed are 8
    }
}

