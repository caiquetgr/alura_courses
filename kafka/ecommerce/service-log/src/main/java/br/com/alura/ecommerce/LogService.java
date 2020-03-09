package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Map;
import java.util.regex.Pattern;

public class LogService {

    public static void main(String[] args) throws InterruptedException {

        final LogService logService = new LogService();

        try (var service = new KafkaService(LogService.class.getSimpleName(),
                Pattern.compile("ECOMMERCE.*"),
                logService::parse,
                String.class,
                Map.of(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()))) {

            service.run();

        }

    }

    private void parse(ConsumerRecord record) {
        System.out.println("--------------------------------------------");
        System.out.println("Log:" + record.topic());
        System.out.println("key:" + record.key());
        System.out.println("value:" + record.value());
        System.out.println("partition:" + record.partition());
        System.out.println("offset:" + record.offset());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
