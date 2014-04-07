package com.altamiracorp.securegraph.presentation;

import com.altamiracorp.securegraph.Authorizations;
import com.altamiracorp.securegraph.Graph;
import com.altamiracorp.securegraph.Vertex;
import com.altamiracorp.securegraph.Visibility;
import com.altamiracorp.securegraph.accumulo.AccumuloAuthorizations;

public class Example01_CreateVertex {
    public static void main(String[] args) throws Exception {
        Graph graph = Util.createGraph();

        Visibility visA = new Visibility("a");
        Visibility visAandB = new Visibility("a&b");
        Authorizations authA = new AccumuloAuthorizations("a");

        Vertex v1 = graph.prepareVertex("v1", visA, authA)
                .setProperty("name", "Joe Ferner", visA)
                .setProperty("dateOfBirth", "1977/10/30", visAandB)
                .save();

        Vertex v2 = graph.prepareVertex("v2", visA, authA)
                .setProperty("name", "Charlie Greenbacker", visA)
                .save();

        graph.addEdge("e1", v1, v2, "knows", visA, authA);

        graph.flush();
    }
}
