package com.cassandra;

import com.datastax.driver.core.exceptions.InvalidQueryException;
import com.datastax.driver.core.exceptions.SyntaxError;

public class Update {
     Update(
            int id, double balance, CassandraConnector client) {
         try {
             client.getSession().execute(
                     "INSERT INTO ncproject.balance (id,balance) VALUES (?, ?)",
                     id, balance);
             System.out.println("Update успешен");
         }
         catch (InvalidQueryException | SyntaxError e) {
             System.out.println("Ошибка в запросе Update. " + e.getMessage());
         }
     }
    }
