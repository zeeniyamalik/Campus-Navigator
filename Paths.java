public class Paths {
    public static void main(String[] args) {

        Graph graph = new Graph();

        //main campus connections
        graph.addEdge("Parking Lot", "100 Campus");
        graph.addEdge("100 Campus", "99 Campus");
        graph.addEdge("100 Campus", "153 Campus");
        graph.addEdge("100 Campus", "79 Campus - Main Library");
        graph.addEdge("99 Campus", "98 Campus");
        graph.addEdge("99 Campus", "154 Campus");
        graph.addEdge("154 Campus", "153 Campus");
        graph.addEdge("153 Campus", "79 Campus - Main Library");

        //100 internal buildings
        graph.addEdge("100 Campus", "100 Stationary Shop");
        graph.addEdge("100 Campus", "100 Cafeteria");
        graph.addEdge("100 Campus", "100 Reception");
        graph.addEdge("100 Campus", "Academics Office");
        graph.addEdge("100 Campus", "SZABIST Student Council Room");
        graph.addEdge("100 Campus", "Sports Room");

        //99 internal buildings
        graph.addEdge("99 Campus", "99 Cafeteria");
        graph.addEdge("99 Campus", "Seminar Hall");

        //98 internal Buildings
        graph.addEdge("98 Campus", "Master's Library");

        //79 internal Buildings
        graph.addEdge("79 Campus - Main Library", "Finance Office");
        graph.addEdge("79 Campus - Main Library", "Main Library");

        //154 internal buildings
        graph.addEdge("154 Campus", "Media Studio");
        graph.addEdge("154 Campus", "154 Cafeteria");
        graph.addEdge("154 Campus", "Law Library");
        graph.addEdge("154 Campus", "154 Stationary Shop");

        //153 internal buildings
        graph.addEdge("153 Campus", "Admissions Office");

    }
}