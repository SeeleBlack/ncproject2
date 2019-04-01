package com.cassandra;

import com.datastax.driver.core.exceptions.NoHostAvailableException;

public class OpenConnection {
        public static void main(String[] args) {

                String ipAddress = null;
                Integer port = null;

                try {
                        CassandraConnector client = new CassandraConnector();
                        //Проверка ввода IP и порта
                        if (ipAddress == null)
                                ipAddress = "localhost";

                        if (port == null)
                                port = 9042;

                        System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
                        client.connect(ipAddress, port);

                        new CreateKeyspace(client);

                        new CreatingTable(client);

                        new Update(1, 93.5, client);

                        Query ask = new Query();
                        Double answer = ask.getBalance(12, client);
                        System.out.println("Баланс пользователя " + answer);


                        new Delete(1, client);

                        /*        ChangeServer change = new ChangeServer("testhost", 99388482, client);*/

                        new CloseConnection(client);


                }

                catch (NoHostAvailableException e1) {
                        System.out.println("Не найден сервер. Проверь IP, Port или доступность сервера");
                }
/*
        String ipAddress = args.length > 0 ? args[0] : "localhost";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;
*/




        }
}
