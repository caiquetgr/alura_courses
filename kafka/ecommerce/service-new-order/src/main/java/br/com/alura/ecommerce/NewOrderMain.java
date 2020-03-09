package br.com.alura.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try (KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();
             KafkaDispatcher<Email> emailDispatcher = new KafkaDispatcher<>()) {

            for (int i = 0; i < 10; i++) {

                var userId = UUID.randomUUID().toString();
                var orderId = UUID.randomUUID().toString();
                var ammount = new BigDecimal(Math.random() * 5000 + 1);

                var order = new Order(userId, orderId, ammount);

                orderDispatcher.send("ECOMMERCE_NEW_ORDER", userId, order);

                var email = "Thank you for your order! We are processing it";
                emailDispatcher.send("ECOMMERCE_SEND_EMAIL", userId, new Email(email, email));

            }
            
        }

    }


}
