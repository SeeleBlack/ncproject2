package com.test;

import com.datastax.driver.core.exceptions.NoHostAvailableException;

public class OpenConnection2 {
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

                       Query query = new Query();

                       query.setBalance(1,200,client);

                    System.out.println("Баланс клиента: " + query.getBalance(1,client));


                        client.close();


                }

                catch (NoHostAvailableException e) {
                        System.out.println("Ошибка в OpenConnection. " + e.getMessage());
                }
/*
        String ipAddress = args.length > 0 ? args[0] : "localhost";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;
*/




        }
}
