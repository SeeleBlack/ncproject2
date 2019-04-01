package com.cassandra;

import static java.lang.System.out;

/**
 * Handles movie persistence access.
 */
public class ChangeServer {
    private final CassandraConnector newclient = new CassandraConnector();

    public ChangeServer(String newHost, int newPort,CassandraConnector client) {
        client.close();
        out.println("Старое подключение закрыто, попытка соединения с новым хостом");
        out.println("Connecting to IP Address " + newHost + ":" + newPort + "...");
        newclient.connect(newHost, newPort);
        close();
    }

    /**
     * Close my underlying Cassandra connection.
     */
    private void close() {
        newclient.close();
    }
}