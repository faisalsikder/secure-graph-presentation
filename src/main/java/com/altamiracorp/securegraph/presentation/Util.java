package com.altamiracorp.securegraph.presentation;

import com.altamiracorp.securegraph.Graph;
import com.altamiracorp.securegraph.accumulo.AccumuloGraph;
import com.altamiracorp.securegraph.accumulo.AccumuloGraphConfiguration;
import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Util {
    public static Graph createGraph() throws AccumuloSecurityException, AccumuloException, InterruptedException, IOException, URISyntaxException {
        Map mapConfig = new HashMap();
        mapConfig.put(AccumuloGraphConfiguration.ACCUMULO_INSTANCE_NAME, "demo");
        mapConfig.put(AccumuloGraphConfiguration.ACCUMULO_USERNAME, "root");
        mapConfig.put(AccumuloGraphConfiguration.ACCUMULO_PASSWORD, "password");
        mapConfig.put(AccumuloGraphConfiguration.ZOOKEEPER_SERVERS, "localhost");
        mapConfig.put(AccumuloGraphConfiguration.USE_SERVER_SIDE_ELEMENT_VISIBILITY_ROW_FILTER, false);
        mapConfig.put("search", "com.altamiracorp.securegraph.elasticsearch.ElasticSearchSearchIndex");
        mapConfig.put("search.locations", "127.0.0.1");
        mapConfig.put("search.indexName", "securegraph");
        AccumuloGraphConfiguration graphConfig = new AccumuloGraphConfiguration(mapConfig);
        return AccumuloGraph.create(graphConfig);
    }
}
