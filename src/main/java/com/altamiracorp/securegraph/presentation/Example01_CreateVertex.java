package com.altamiracorp.securegraph.presentation;

import org.securegraph.Authorizations;
import org.securegraph.Graph;
import org.securegraph.Vertex;
import org.securegraph.Visibility;
import org.securegraph.accumulo.AccumuloAuthorizations;

public class Example01_CreateVertex {
    public static void main(String[] args) throws Exception {
        Graph graph = Util.createGraph();

        Visibility visA = new Visibility("a");
        Visibility visAandB = new Visibility("a&b");
        Authorizations authA = new AccumuloAuthorizations("a");

        Vertex v1 = graph.prepareVertex("v1", visA)
                .setProperty("name", "Joe Ferner", visA)
                .setProperty("dateOfBirth", "1977/10/30", visAandB)
                .save(authA);

        Vertex v2 = graph.prepareVertex("v2", visA)
                .setProperty("name", "Charlie Greenbacker", visA)
                .save(authA);

        graph.addEdge("e1", v1, v2, "knows", visA, authA);

        graph.flush();
    }
}
