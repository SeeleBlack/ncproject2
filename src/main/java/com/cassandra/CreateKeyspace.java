package com.cassandra;

import com.datastax.driver.core.exceptions.SyntaxError;

public class CreateKeyspace {

    CreateKeyspace(CassandraConnector client)
    {
        try {
            final String createKeyspaceCql =
                    "CREATE KEYSPACE IF NOT EXISTS ncproject WITH replication = {\n" +
                            "  'class': 'SimpleStrategy',\n" +
                            "  'replication_factor': '2'\n" +
                            "};";
            client.getSession().execute(createKeyspaceCql);
            System.out.println("Keyspace ncproject created");
        }
        catch (SyntaxError e) {
            System.out.println("Ошибка в CreateKeyspace. Проверь синтаксис");
        }
    }
}
