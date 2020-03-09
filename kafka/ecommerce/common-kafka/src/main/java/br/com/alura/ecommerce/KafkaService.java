package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;

class KafkaService<T> implements Closeable {

    private final Consumer<String, T> consumer;
    private final ConsumerFunction function;

    KafkaService(String groupId, String topic, ConsumerFunction function, Class<?> type, Map<String, String> properties) {
        this(groupId, function, type, properties);
        this.consumer.subscribe(Collections.singletonList(topic));
    }

    KafkaService(String groupId, Pattern pattern, ConsumerFunction function, Class<?> type, Map<String, String> properties) {
        this(groupId, function, type, properties);
        consumer.subscribe(pattern);
    }

    private KafkaService(String groupId, ConsumerFunction function, Class<?> type, Map<String, String> properties) {
        this.function = function;
        this.consumer = new KafkaConsumer<>(getProperties(groupId, type, properties));
    }

    public void run() {

        while (true) {

            ConsumerRecords<String, T> records = consumer.poll(Duration.ofMillis(100));

            if (!records.isEmpty()) {
                System.out.println("Found " + records.count() + " records");
                for (ConsumerRecord record : records) {
                    function.consume(record);
                }
            }

        }

    }

    private Properties getProperties(String groupId, Class<?> type, Map<String, String> customProperties) {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GsonDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, UUID.randomUUID().toString());
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
        properties.setProperty(GsonDeserializer.TYPE_CONFIG, type.getName());
        properties.putAll(customProperties);
        return properties;
    }

    @Override
    public void close() {
        consumer.close();
    }

    public interface ConsumerFunction<T> {
        void consume(ConsumerRecord<String, T> record);
    }

}
