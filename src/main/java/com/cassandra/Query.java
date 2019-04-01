package com.cassandra;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.exceptions.InvalidQueryException;
import com.datastax.driver.core.exceptions.SyntaxError;


class Query {

    public Double getBalance(int id, CassandraConnector client) {
        Double ans = null;

        try {
            String query = "SELECT * from ncproject.balance WHERE id = ?";
            ResultSet queryResult = client.getSession().execute(query, id);
            Row ansRow = queryResult.one();
            ans = ansRow.getDouble("balance");
        } catch (NullPointerException | InvalidQueryException | SyntaxError e){
            System.out.println("Ошибка в Query. " + e.getMessage());
        }
        return ans;
    }
}