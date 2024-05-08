package io.codegitters.scs_asyncapi_demo_a;

import io.codegitters.messages.notification.NotificationDataMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication
public class ScsAsyncapiDemoAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScsAsyncapiDemoAApplication.class, args);
	}

	@Bean
	public Supplier<Message<NotificationDataMessage>> notificationMessagePub() {
		return () -> MessageBuilder.withPayload(NotificationDataMessage.builder()
						.id(UUID.randomUUID().toString())
						.subject("Hello")
						.content("Hello customers.")
						.order(1L)
						.receptor("jhondoe@mymail.com")
						.status(NotificationDataMessage.Status.SENT)
						.timestamp(LocalDateTime.now())
				.build())
				.setHeader(KafkaHeaders.KEY, UUID.randomUUID().toString().getBytes())
				.build();
	}
}
