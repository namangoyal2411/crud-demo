//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
//import com.techieworld.crud.dto.EmployeeTO;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaConsumerConfig {
//
//    @Bean
//    public ConsumerFactory<String, EmployeeTO> consumerFactory() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, "employee-group");
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        config.put("spring.kafka.consumer.properties.spring.json.trusted.packages", "*");
//
//        return new DefaultKafkaConsumerFactory<>(
//                config,
//                new StringDeserializer(),
//                new JsonDeserializer<>(EmployeeTO.class, false)
//        );
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, EmployeeTO> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, EmployeeTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//}
