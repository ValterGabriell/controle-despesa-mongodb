package valter.gabriell.io.moneyproject;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MoneyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneyProjectApplication.class, args);
    }

}
