package sr.unasat.A.D;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVeldPost("Afobaka"); //0
        g.addVeldPost("Brownsweg"); //1
        g.addVeldPost("Apura"); //2
        g.addVeldPost("Moengo"); //3
        g.addVeldPost("Stichting Experimentele Landbouw"); //4
        g.addVeldPost("Nieuw Nickerie"); //5
        g.addVeldPost("Marowijne"); //6
        g.addVeldPost("Wanica"); //7
        g.addVeldPost("Paranam"); //8
        g.addVeldPost("Paramaribo"); //9


//          (DIJKSTRA)
        g.addEdge(0, 1, 100);
        g.addEdge(0, 4, 80);
        g.addEdge(1, 2, 200);
        g.addEdge(1, 4, 40);
        g.addEdge(2, 3, 45);
        g.addEdge(3, 4, 420);
        g.addEdge(3, 7, 300);
        g.addEdge(3, 9, 250);
        g.addEdge(4, 5, 20);
        g.addEdge(5, 6, 100);
        g.addEdge(6, 7, 140);
        g.addEdge(6, 8, 560);
        g.addEdge(7, 8, 90);
        g.addEdge(8, 9, 100);

//          (DFS EN BFS)

//        g.addEdge(0, 1);
//        g.addEdge(0, 4);
//        g.addEdge(1, 2);
//        g.addEdge(1, 4);
//        g.addEdge(2, 3);
//        g.addEdge(3, 4);
//        g.addEdge(3, 7);
//        g.addEdge(3, 9);
//        g.addEdge(4, 5);
//        g.addEdge(5, 6);
//        g.addEdge(6, 7);
//        g.addEdge(6, 8);
//        g.addEdge(7, 8);
//        g.addEdge(8, 9);


//          (DFS)
//        System.out.println("De veldposten bestaan in: ");
//        g.dfs();
//        System.out.println();

//          (BFS)
//        System.out.println("De veldposten die adjacent aan elkaar zijn:  ");
//        g.bfs();
//        System.out.println();

//          (CHEAPEST PATH)
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Voer uw huidige locatie in: ");
//        String start = scan.next();
//
//        System.out.println("De goedkoopste weg is: ");
//        g.findIndexOf(start);
//        int userGiven = g.findIndexOf(start);
//        g.cheapestpath(userGiven);
//
//        System.out.println();
//        scan.close();

//          (EXPENSIVE PATH)

        Scanner scan = new Scanner(System.in);
        System.out.println("Voer uw huidige locatie in: ");
        String item = scan.next();

        System.out.println("De duurste weg is: ");
        g.findIndexOf(item);
        int userGiven = g.findIndexOf(item);
        g.expensivePath(userGiven);
        System.out.println();
        scan.close();

    }
}
