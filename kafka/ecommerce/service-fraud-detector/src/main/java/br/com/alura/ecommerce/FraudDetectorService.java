package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class FraudDetectorService {

    public static void main(String[] args) {

        FraudDetectorService fraudDetectorService = new FraudDetectorService();

        try (var kafkaService = new KafkaService<Order>(FraudDetectorService.class.getSimpleName(),
                "ECOMMERCE_NEW_ORDER",
                fraudDetectorService::parse,
                Order.class,
                Map.of())) {

            kafkaService.run();

        }

    }

    private void parse(ConsumerRecord<String, Order> record) {
        System.out.println("--------------------------------------------");
        System.out.println("Processing new order. Checking for fraud");
        System.out.println("key:" + record.key());
        System.out.println("value:" + record.value());
        System.out.println("partition:" + record.partition());
        System.out.println("offset:" + record.offset());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order processed");
    }

}
