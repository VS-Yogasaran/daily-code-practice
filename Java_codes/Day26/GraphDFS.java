import java.util.*;

public class GraphDFS {

    int vertices;
    LinkedList<Integer>[] adjList;

    GraphDFS(int v) {

        vertices = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    void dfs(int node, boolean[] visited) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {

        GraphDFS g = new GraphDFS(5);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);

        boolean[] visited = new boolean[5];

        System.out.print("DFS Traversal: ");
        g.dfs(0, visited);
    }
}
