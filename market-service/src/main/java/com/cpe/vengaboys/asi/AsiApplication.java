package com.cpe.vengaboys.asi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsiApplication.class, args);
    }

    // @Bean
    // public DataSource dataSource() {
    //     DriverManagerDataSource dataSource = new DriverManagerDataSource();

        //dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1;MODE=MySQL;NON_KEYWORDS=USER");

        // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // dataSource.setUrl("jdbc:mysql://localhost:3306/card_database");
        // dataSource.setUsername("root");
        // dataSource.setPassword("toto");

        // return dataSource;
    // }
}


