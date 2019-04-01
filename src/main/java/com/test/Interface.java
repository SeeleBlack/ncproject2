package com.test;


public interface Interface {
    Double getBalance(int id, CassandraConnector client);
    void setBalance(int id, double balance, CassandraConnector client);
}
