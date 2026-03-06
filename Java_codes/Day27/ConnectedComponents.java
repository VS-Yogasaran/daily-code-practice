import java.util.*;

public class ConnectedComponents {

    int vertices;
    LinkedList<Integer>[] adj;

    ConnectedComponents(int v) {

        vertices = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    void dfs(int node, boolean[] visited) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj[node])
            if (!visited[neighbor])
                dfs(neighbor, visited);
    }

    void findComponents() {

        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {

            if (!visited[i]) {
                System.out.print("Component: ");
                dfs(i, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        ConnectedComponents g = new ConnectedComponents(5);

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,4);

        g.findComponents();
    }
}
