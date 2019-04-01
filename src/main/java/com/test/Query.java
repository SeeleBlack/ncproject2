package com.test;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.exceptions.InvalidQueryException;
import com.datastax.driver.core.exceptions.SyntaxError;

public class Query implements Interface {
    @Override
    public Double getBalance(int id, CassandraConnector client) {
        Double ans = null;
        try {
            String query = "SELECT * from ncprojectd.balance WHERE id = ?";
            ResultSet queryResult = client.getSession().execute(query, id);
            Row ansRow = queryResult.one();
            ans = ansRow.getDouble("balance");
        } catch (NullPointerException | InvalidQueryException | SyntaxError e){
            System.out.println("Ошибка в Query. " + e.getMessage());
        }
        return ans;
    }

    @Override
    public void setBalance(int id, double balance, CassandraConnector client) {
        try {
            client.getSession().execute(
                    "INSERT INTO ncproject.balance (id,balance) VALUES (?, ?)",
                    id, balance);
            System.out.println("Update успешен");
        }
        catch (InvalidQueryException|SyntaxError e) {
            System.out.println("Ошибка в запросе Update. " + e.getMessage());
        }
    }
}
