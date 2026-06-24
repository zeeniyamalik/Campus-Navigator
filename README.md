# Campus-Navigator
<h2>Project Overview</h2>

Campus Navigator is a Java-based desktop application built using Java Swing.
It helps students and visitors find the shortest path between different locations inside the university campus using Breadth-First Search (BFS).

This project is designed for SZABIST Campus (Karachi) and demonstrates how graph algorithms can be applied in real-world navigation systems.

<h3>Key Features:</h3>
<b>1. Shortest Path Finder</b><br>
Finds the shortest route between two selected locations using BFS.
Supports a mandatory stop point (optional), allowing users to add a stopover in their route.
<br><br>
<b>2. Visual Map Interface</b><br>
An interactive campus map where:
- Path is drawn with lines
- Start point is marked in Blue
- Stop point (if any) is marked in Orange
- Destination is marked in Red
<br><br>
<b>3. Clickable Map</b><br>
You can click anywhere on the map to view the exact coordinates (useful for adding new locations).<br><i>*Uses Mouse Listener</i>

<h3>How It Works</h3>

<b>Graph Structure</b>
The campus is represented as a graph:
- Each location is a node
- Each connection is an edge
- BFS is used to find the shortest path between two nodes
  
<b>BFS Pathfinding</b>
The BFS algorithm ensures:
- The shortest path (in terms of number of edges) is found
- Works efficiently even for larger campus maps

<h3>Project Files</h3>
 
```CampNav.java```	-----  Main GUI and map rendering<br>
```Graph.java```	----------------  Graph implementation + BFS algorithm<br>
```Paths.java```	----------------  Example graph builder<br>
```Queue.java```	----------------  Custom queue implementation<br>
```Node.java```	-----------------  Node structure for queue<br>
```campus_map.png```	-----------  Campus map image used in the GUI made in FIGMA<br>
```zab map.jpg``` --------------- Campus's official map 

<h3>How to Run</h3>

1. Make sure you have Java installed (JDK 8 or above).

2. Clone the repository.

3. Compile the files:
```javac *.java```

4. Run the project:
```java CampusNavigator```

<h3>Future Improvements I want to add:</h3>

- Implement Dijkstra’s Algorithm for real distance-based routing.

- Add a search bar for quick location selection.

- Add zoom & pan for the map.

- Multi-stop routes.



