package com.altamiracorp.securegraph.presentation;


import org.securegraph.*;
import org.securegraph.accumulo.AccumuloAuthorizations;

public class Example02_QueryVertex {
    public static void main(String[] args) throws Exception {
        Graph graph = Util.createGraph();

        Authorizations authA = new AccumuloAuthorizations("a");
        Authorizations authAandB = new AccumuloAuthorizations("a", "b");

        System.out.println("--------------------------------------------------------------");
        Vertex v1 = graph.getVertex("v1", authA);
        System.out.println("authA: name: " + v1.getPropertyValue("name"));
        System.out.println("authA: dateOfBirth: " + v1.getPropertyValue("dateOfBirth"));

        System.out.println("--------------------------------------------------------------");
        v1 = graph.getVertex("v1", authAandB);
        System.out.println("authAandB: name: " + v1.getPropertyValue("name"));
        System.out.println("authAandB: dateOfBirth: " + v1.getPropertyValue("dateOfBirth"));

        System.out.println("--------------------------------------------------------------");
        Iterable<Edge> edges = v1.getEdges(Direction.BOTH, authA);
        for (Edge e : edges) {
            System.out.println("edge: " + e);
        }
    }
}
