package Graphs;

import java.util.*;

public class GraphBasics {

    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
        vis[src] = true;
        System.out.print(src + " ");
        for(int i=0;i<list.get(src).size();i++)
        {
            if(!vis[list.get(src).get(i)])
            {
                dfs(list.get(src).get(i), list, vis);
            }
        }
    }

    static void bfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        vis[src] = true;
        while(!que.isEmpty())
        {
            Integer top = que.poll();
            System.out.print(top + " ");
            for(int i=0;i<list.get(top).size();i++)
            {
                if(! vis[list.get(top).get(i)])
                {
                    vis[list.get(top).get(i)] = true;
                    que.add(list.get(top).get(i));
                }
            }
        }
    }

    static void topologicalSort(int v, ArrayList<ArrayList<Integer>> list) {
        int[] indeggree = new int[v];
        for(int i=0;i<list.size();i++) {
            for(int node : list.get(i)) {
                indeggree[node]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<indeggree.length;i++) {
            if(indeggree[i] == 0) {
                que.add(i);
            }
        }

        int visitedCnt = 0;
        ArrayList<Integer> order = new ArrayList<>();
        while(!que.isEmpty()) {
            int top = que.poll();
            order.add(top);
            for(int node : list.get(top)) {
                indeggree[node] --;
                if(indeggree[node] == 0) {
                    que.add(node);
                }
            }
            visitedCnt ++;
        }
        if(visitedCnt != v) {
            System.out.println("graph is cyclic");
            return ;
        }
        for(int i:order) {
            System.out.print( i + " ");
        }

    }

    static boolean isCyclicInDirected(ArrayList<ArrayList<Integer>> list, int v) {
        // you can just use topologicalSot to find cycle
        boolean[] stackElements = new boolean[v];
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(isCycleInDirectedUtil(i, list, stackElements, visited)) {
                return true;
            }
        }
        return false;
    }

    static boolean isCycleInDirectedUtil(int src, ArrayList<ArrayList<Integer>> list, boolean[] stackElements, boolean[] visited) {
        visited[src] = true;
        stackElements[src] = true;
        for(int node : list.get(src)) {
            if(visited[node] && stackElements[node]) {
                return true;
            }
            else if(!visited[node]) {
                if(isCycleInDirectedUtil(node, list, stackElements, visited)) {
                    return true;
                }
            }
        }
        stackElements[src] = false;
        return false;
    }

    static boolean isCycleInUndirected(ArrayList<ArrayList<Integer>> list, int v) {
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++) {
            if(!visited[i]) {
                if(isCycleInUndirectedUtil(list,  visited , i, -1)) {
                    return  true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleInUndirectedUtil(ArrayList<ArrayList<Integer>> list, boolean[] visited, int src, int parent) {
        visited[src] = true;
        for(int node : list.get(src)) {
            if(!visited[node]) {
                if(isCycleInUndirectedUtil(list, visited, node, src)) {
                    return true;
                }
            } else if(node != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for(int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            bfs(0, list, vis);
            System.out.println();
        }
    }
}
