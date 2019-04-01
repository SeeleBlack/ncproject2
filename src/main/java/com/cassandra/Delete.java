package com.cassandra;

import com.datastax.driver.core.exceptions.InvalidQueryException;
import com.datastax.driver.core.exceptions.SyntaxError;

public class Delete {
    Delete(int id, CassandraConnector client) {
        try {
            final String deleteString = "DELETE FROM ncproject.balance WHERE id = ?";
            client.getSession().execute(deleteString, id);
            System.out.println("Удаление успешно");
        } catch (SyntaxError|InvalidQueryException e) {
            System.out.println("Ошибка в Delete. " + e.getMessage());
        }
    }
}
