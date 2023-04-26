
//Peter El-Hadad 20206705
//Mariel leano 20218008
package dev4_2015;

import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple {
    int first, second, third; 
    Tuple(int first, int second, int third) {
        this.first = first; 
        this.second = second;
        this.third = third; 
    }
}
class Solution {
    public int CheapestFLight(int n,int flights[][],int src,int dst,int K) {

    	List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.third - b.third);
        pq.add(new Tuple(src, 0, 0));

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int node = curr.first;
            int cost = curr.second;
            int stops = curr.third;

            if (node == dst) {
                return cost;
            }

            if (stops > K) {
                continue;
            }

            for (Pair neighbor : graph.get(node)) {
                int v = neighbor.first;
                int w = neighbor.second;
                pq.add(new Tuple(v, cost + w, stops + 1));
            }
        }

        return -1; 
            
    }
}

class Vols {

    public static void main(String[] args) {
       
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        Solution obj = new Solution();
        int ans = obj.CheapestFLight(n,flights,src,dst,K);
        
        System.out.print(ans);
        System.out.println();

    }
}
