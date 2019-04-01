package com.cassandra;

import com.datastax.driver.core.exceptions.InvalidConfigurationInQueryException;

public class CreatingTable {

    CreatingTable(CassandraConnector client)
    {
        try {
            final String createTableCql =
                    "CREATE TABLE if not exists ncproject.balance (id int, balance double, PRIMARY KEY(id, balance))";
            client.getSession().execute(createTableCql);
            System.out.println("Table balance created");
        }
        catch (InvalidConfigurationInQueryException e){
            System.out.println("Ошибка в CreatingTable. Проверь запрос");
        }
    }
}
