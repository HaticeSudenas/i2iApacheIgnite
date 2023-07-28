package org.example;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class IgniteConfig {
    private static String jdbcUrl = "jdbc:ignite:thin://127.0.0.1:10800/";
    private static String username = "";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl,username,password);
    }
}
