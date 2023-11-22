package cn.arcy.testing;

import cn.arcy.testing.services.TestEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        TestEnum.getCodeName();
        SpringApplication.run(Main.class, args);
    }
}