import java.util.*;
import java.util.Queue;

public class Graph {
    private Map<String, List<String>> graph = new HashMap<>();

    public void addNode(String node) {
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
    }

    public void printGraph() {                                      //for special purposes only
        for (String node : graph.keySet()) {
            System.out.println(node + " -> " + graph.get(node));
        }
    }


    public void addEdge(String src, String dest) {
        addNode(src);
        addNode(dest);

        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    private void printPath(Map<String,String> parent, String start, String destination){
        List<String> path = new ArrayList<>();
        String current = destination;

        while(current != null){
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);

        System.out.println("Shortest path: " + String.join(" -> ", path));
    }

    public void bfs(String start, String destination){
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();

        visited.add(start);
        queue.add(start);
        parent.put(start, null);

        System.out.println("BFS Traversal starting from " + start + ":");

        if (!graph.containsKey(start) || !graph.containsKey(destination)) {
            System.out.println("Start or destination does not exist in the map.");
            return;
        }

        while(!queue.isEmpty()){
            String current = queue.poll();
            // System.out.println(current);

            if (current.equals(destination)) {
                System.out.println("Your Destination is Found.");
                printPath(parent, start, destination);
                return;
            }

            for(String neighbour : graph.get(current)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);

                    parent.put(neighbour, current);
                }
            }
        }
        System.out.println("Destination cannot be reached.");
    }
    public List<String> bfsPath(String start, String destination) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();

        if (!graph.containsKey(start) || !graph.containsKey(destination)) {
            return null;
        }

        visited.add(start);
        queue.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(destination)) {
                List<String> path = new ArrayList<>();
                while (current != null) {
                    path.add(current);
                    current = parent.get(current);
                }
                Collections.reverse(path);
                return path;
            }

            for (String neighbour : graph.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                    parent.put(neighbour, current);
                }
            }
        }
        return null;
    }
}