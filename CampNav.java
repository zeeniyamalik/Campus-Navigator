import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class CampNav extends JFrame {

    private Map<String, Point> locations;
    private MapPanel mapPanel;
    private JComboBox<String> fromCombo;
    private JComboBox<String> stopCombo;
    private JComboBox<String> toCombo;
    private Graph campusGraph;

    //merge sort:
    private void mergeSort(List<String> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            merge(list, left, mid, right);
        }
    }

    private void merge(List<String> list, int left, int mid, int right) {
        List<String> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (list.get(i).compareTo(list.get(j)) <= 0) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }
        while (i <= mid) {
            temp.add(list.get(i));
            i++;
        }
        while (j <= right) {
            temp.add(list.get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }

    void connectAll(List<String> campLocation) {
        for (int i = 0; i < campLocation.size(); i++) {
            for (int j = i + 1; j < campLocation.size(); j++) {
                campusGraph.addEdge(campLocation.get(i), campLocation.get(j));
            }
        }
    }

    public CampNav() {
        setTitle("Campus Navigator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        locations = new HashMap<>();

        locations.put("Parking Lot", new Point(1094, 55));
        locations.put("100 Campus", new Point(991, 154));
        locations.put("99 Campus", new Point(929, 367));
        locations.put("98 Campus", new Point(1048, 448));
        locations.put("154 Campus", new Point(723, 371));
        locations.put("153 Campus", new Point(344, 372));
        locations.put("79 Campus - Main Library", new Point(152, 368));

        locations.put("100 Stationary Shop", new Point(823, 108));
        locations.put("First Aid Room", new Point(963, 72));
        locations.put("Lost n Found", new Point(970, 132));

        locations.put("154 Stationary Shop", new Point(765, 404));
        locations.put("Master's Library", new Point(1072, 403));
        locations.put("Law Library", new Point(656, 401));
        locations.put("Main Library", new Point(105, 468));
        locations.put("100 Cafeteria", new Point(884, 85));
        locations.put("99 Cafeteria", new Point(1020, 481));
        locations.put("154 Cafeteria", new Point(677, 549));
        locations.put("Admissions Office", new Point(424, 494));
        locations.put("SZABIST Student Council Room", new Point(839, 76));
        locations.put("Academics Office", new Point(895, 133));
        locations.put("Finance Office", new Point(61, 592));
        locations.put("Seminar Hall", new Point(930, 534));
        locations.put("Sports Room", new Point(869, 202));
        locations.put("100 Reception", new Point(933, 160));
        locations.put("HBL ATM", new Point(608, 370));

        campusGraph = new Graph();

        campusGraph.addEdge("Parking Lot", "100 Campus");
        campusGraph.addEdge("100 Campus", "99 Campus");
        campusGraph.addEdge("100 Campus", "153 Campus");
        campusGraph.addEdge("100 Campus", "154 Campus");
        campusGraph.addEdge("100 Campus", "79 Campus - Main Library");
        campusGraph.addEdge("99 Campus", "98 Campus");
        campusGraph.addEdge("99 Campus", "154 Campus");
        campusGraph.addEdge("99 Campus", "153 Campus");
        campusGraph.addEdge("99 Campus", "79 Campus - Main Library");
        campusGraph.addEdge("154 Campus", "153 Campus");
        campusGraph.addEdge("153 Campus", "79 Campus - Main Library");

        campusGraph.addEdge("100 Campus", "100 Stationary Shop");
        campusGraph.addEdge("100 Campus", "First Aid Room");
        campusGraph.addEdge("100 Campus", "100 Cafeteria");
        campusGraph.addEdge("100 Campus", "100 Reception");
        campusGraph.addEdge("100 Campus", "Academics Office");
        campusGraph.addEdge("100 Campus", "SZABIST Student Council Room");
        campusGraph.addEdge("100 Campus", "Sports Room");
        campusGraph.addEdge("100 Campus", "Lost n Found");

        campusGraph.addEdge("99 Campus", "99 Cafeteria");
        campusGraph.addEdge("99 Campus", "Seminar Hall");

        campusGraph.addEdge("98 Campus", "Master's Library");

        campusGraph.addEdge("79 Campus - Main Library", "Finance Office");

        campusGraph.addEdge("99 Campus", "HBL ATM");
        campusGraph.addEdge("153 Campus", "HBL ATM");
        campusGraph.addEdge("154 Campus", "HBL ATM");
        campusGraph.addEdge("79 Campus - Main Library", "HBL ATM");

        campusGraph.addEdge("79 Campus - Main Library", "Main Library");
        campusGraph.addEdge("154 Campus", "154 Cafeteria");
        campusGraph.addEdge("154 Campus", "Law Library");
        campusGraph.addEdge("154 Campus", "154 Stationary Shop");
        campusGraph.addEdge("153 Campus", "Admissions Office");
        campusGraph.addEdge("153 Campus", "99 Campus");
        campusGraph.addEdge("154 Campus", "79 Campus - Main Library");


        List<String> location100 = Arrays.asList(
                "100 Cafeteria",
                "100 Reception",
                "100 Stationary Shop",
                "SZABIST Student Council Room",
                "Sports Room",
                "First Aid Room",
                "Lost n Found",
                "Academics Office"
        );
        connectAll(location100);


        List<String> location99 = Arrays.asList(
                "99 Cafeteria",
                "Seminar Hall",
                "98 Campus"
        );
        connectAll(location99);


        List<String> location154 = Arrays.asList(
                "154 Cafeteria",
                "Law Library",
                "154 Stationary Shop"
        );
        connectAll(location154);


        List<String> location153 = Arrays.asList(
                "Academic Office"
        );
        connectAll(location153);


        List<String> location98 = Arrays.asList(
                "Master's Library"
        );
        connectAll(location98);


        List<String> location79 = Arrays.asList(
                "Main Library",
                "Finance Office"
        );
        connectAll(location79);


        JPanel topBar = new JPanel();
        List<String> locList = new ArrayList<>(locations.keySet());
        Collections.sort(locList);

        fromCombo = new JComboBox<>(locList.toArray(new String[0]));
        stopCombo = new JComboBox<>();
        stopCombo.addItem("None");
        for (String loc : locList) stopCombo.addItem(loc);
        toCombo = new JComboBox<>(locList.toArray(new String[0]));
        JButton startButton = new JButton("Start");

        topBar.add(new JLabel("From:"));
        topBar.add(fromCombo);
        topBar.add(new JLabel("Stop:"));
        topBar.add(stopCombo);
        topBar.add(new JLabel("To:"));
        topBar.add(toCombo);
        topBar.add(startButton);

        add(topBar, BorderLayout.NORTH);

        mapPanel = new MapPanel();
        add(mapPanel, BorderLayout.CENTER);

        startButton.addActionListener(e -> {
            String from = (String) fromCombo.getSelectedItem();
            String stop = (String) stopCombo.getSelectedItem();
            String to = (String) toCombo.getSelectedItem();

            List<String> finalPath;

            if (stop.equals("None")) {
                finalPath = campusGraph.bfsPath(from, to);
            } else {
                List<String> p1 = campusGraph.bfsPath(from, stop);
                List<String> p2 = campusGraph.bfsPath(stop, to);
                if (p1 == null || p2 == null) {
                    JOptionPane.showMessageDialog(this, "No path found!");
                    return;
                }
                finalPath = new ArrayList<>(p1);
                p2.remove(0);
                finalPath.addAll(p2);
            }

            List<Point> pts = new ArrayList<>();
            for (String s : finalPath) pts.add(locations.get(s));

            Point stopPoint = stop.equals("None") ? null : locations.get(stop);
            mapPanel.setPath(pts, stopPoint);
        });

        setVisible(true);
    }

    class MapPanel extends JPanel {
        private Image mapImage;
        private List<Point> pathPoints;
        private Point stopPoint;

        public MapPanel() {
            mapImage = new ImageIcon("campus_map.png").getImage();
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Clicked at: " + e.getX() + ", " + e.getY());
                }
            });
        }

        public void setPath(List<Point> pts, Point stopPt) {
            pathPoints = pts;
            stopPoint = stopPt;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);

            if (pathPoints == null || pathPoints.size() < 2) return;

            g.setColor(Color.BLUE);
            for (int i = 0; i < pathPoints.size() - 1; i++) {
                Point a = pathPoints.get(i);
                Point b = pathPoints.get(i + 1);
                g.drawLine(a.x, a.y, b.x, b.y);
            }

            // START POINT
            Point start = pathPoints.get(0);
            g.setColor(Color.BLUE);
            g.fillOval(start.x - 8, start.y - 8, 16, 16);
            g.setColor(Color.WHITE);
            g.fillOval(start.x - 5, start.y - 5, 10, 10);

            // STOP POINT
            if (stopPoint != null) {
                g.setColor(Color.ORANGE);
                g.fillOval(stopPoint.x - 8, stopPoint.y - 8, 16, 16);
                g.setColor(Color.BLACK);
                g.fillOval(stopPoint.x - 5, stopPoint.y - 5, 10, 10);
            }

            // END POINT
            Point end = pathPoints.get(pathPoints.size() - 1);
            g.setColor(Color.RED);
            g.fillOval(end.x - 8, end.y - 8, 16, 16);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CampNav::new);
    }
}
