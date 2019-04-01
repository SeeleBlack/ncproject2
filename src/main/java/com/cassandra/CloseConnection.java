package com.cassandra;

public class CloseConnection {
    CloseConnection(CassandraConnector client) {
        client.close();
    }
}
