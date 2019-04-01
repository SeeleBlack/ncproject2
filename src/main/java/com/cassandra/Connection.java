package com.cassandra;

public interface Connection {
    CassandraConnector openConnection(String ipAddress, Integer port);
}
