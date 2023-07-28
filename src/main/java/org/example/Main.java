package org.example;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*IgniteConfiguration cfg = IgniteConfig.getConfiguration();

        // Ignite bağlantısını başlat
        Ignite ignite = Ignition.start(cfg);

        // Ignite kullanımı
        // İlgili Ignite işlemlerini burada yapabilirsiniz...
        System.out.println("Ignite sunucusu başlatıldı!");
        // Ignite bağlantısını sonlandır
        ignite.close();*/

        try{
            // JDBC
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
            Connection connection = IgniteConfig.getConnection();
            System.out.println("Connected apache ignite");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM SUBSCRIBER");

            while (rs.next()) {
                int subscId = rs.getInt("SUBSC_ID");
                String subscName = rs.getString("SUBSC_NAME");
                String subscsurname = rs.getString("SUBSC_SURNAME");
                String MSDISN = rs.getString("MSISDN");

                System.out.println("SUBSC_ID: " + subscId + ", SUBSC_NAME: " + subscName+", SUBSC_NAME: " + subscsurname+", MSDISN: " + MSDISN);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}