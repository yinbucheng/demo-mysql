package com.example.demomysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoMysqlApplication {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoMysqlApplication.class, args);
        DemoMysqlApplication bean = applicationContext.getBean(DemoMysqlApplication.class);
//        while (true) {
            for (int i = 0; i < 20; i++) {
                try {
                    bean.test();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            System.out.println("invoke select 1 finish");
//            Thread.sleep(60 * 1000 * 2);
//        }
        Thread.sleep(Integer.MAX_VALUE);
    }

    public void test() {
        jdbcTemplate.execute("select 1");
    }

}
