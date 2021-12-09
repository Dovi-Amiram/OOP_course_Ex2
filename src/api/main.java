package api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class main {

    static int checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        }
        else {
            System.out.println("Access granted - You are old enough!");
        }
        return 0;
    }

    public static void main(String[] args) {
        DWGraph graph1 = new DWGraph();
        DWGraph graph2 = new DWGraph();
        Node n1 = new Node(1, new Location(0, 0, 0));
        Node n2 = new Node(2, new Location(1, 1, 0));
        Node n3 = new Node(3, new Location(1, 1, 0));
        Node n4 = new Node(4, new Location(1, 1, 0));
        Node n5 = new Node(5, new Location(1, 1, 0));
        Node n6 = new Node(6, new Location(1, 1, 0));

        graph1.addNode(n1);
        graph1.addNode(n2);
        graph1.addNode(n3);
        graph1.addNode(n4);
        graph1.addNode(n5);
        graph1.addNode(n6);

        graph2.addNode(n1);
        graph2.addNode(n2);
        graph2.addNode(n3);

        graph1.connect(n1.getKey(), n2.getKey(), 2);
        graph1.connect(n1.getKey(), n3.getKey(), 4);
        graph1.connect(n2.getKey(), n4.getKey(), 7);
        graph1.connect(n2.getKey(), n3.getKey(), 1);
        graph1.connect(n4.getKey(), n6.getKey(), 1);
        graph1.connect(n3.getKey(), n5.getKey(), 3);
        graph1.connect(n3.getKey(), n1.getKey(), 3);
        graph1.connect(n5.getKey(), n4.getKey(), 7);
        graph1.connect(n5.getKey(), n6.getKey(), 1);
        graph1.connect(n5.getKey(), n3.getKey(), 5);
        graph1.connect(n6.getKey(), n5.getKey(), 5);
        graph1.connect(n5.getKey(), n6.getKey(), 1);
        graph1.connect(n6.getKey(), n4.getKey(), 1);

        graph2.connect(n1.getKey(), n2.getKey(), 1);
        graph2.connect(n1.getKey(), n3.getKey(), 1);
        graph2.connect(n2.getKey(), n1.getKey(), 5);
        graph2.connect(n2.getKey(), n3.getKey(), 5);
        graph2.connect(n3.getKey(), n2.getKey(), 5);
        graph2.connect(n3.getKey(), n1.getKey(), 5);

        GraphAlgorithm g1 =new GraphAlgorithm();
        g1.init(graph1);
        GraphAlgorithm g2 =new GraphAlgorithm();
        g2.init(graph2);

        double d = g1.shortestPathDist(2,6);
        LinkedList<NodeData> list= (LinkedList<NodeData>) g1.shortestPath(2,4);
        g1.save("shlomo.json");
        g2.load("shlomo.json");
        System.out.println(d);
        //System.out.println(list.get(2).getKey());
        System.out.println(g1.isConnected());
        List<NodeData> check = new LinkedList<>();
        check.add(n2);
        check.add(n3);
        check.add(n4);
        check.add(n5);
        List<NodeData> travel = g1.tsp(check);
        for (int i = 0; i < travel.size()-1; i++) {
            System.out.print(travel.get(i).getKey()+" ->");

        }
        System.out.print(list.get(list.size()-1).getKey());
        System.out.println();
        System.out.println("center g1: "+g1.center().getKey());
        int a = g2.center().getKey();
        System.out.println("center g2: "+a);

    }


}