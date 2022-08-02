package ru.kinonavigator.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.kinonavigator.model.MovieRequest;

@Service
public class KafkaProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, MovieRequest> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, MovieRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

    }

    public void sendMessage(MovieRequest request){
        LOGGER.info(String.format("Message sent %s", request.toString()));
        kafkaTemplate.send(topicName, request);
    }
}