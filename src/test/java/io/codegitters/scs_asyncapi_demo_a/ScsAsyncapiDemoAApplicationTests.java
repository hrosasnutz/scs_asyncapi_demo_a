package io.codegitters.scs_asyncapi_demo_a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codegitters.scs_asyncapi_demo_a.notification.NotificationMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@SpringBootTest
class ScsAsyncapiDemoAApplicationTests {
	
	@Autowired
	private ObjectMapper mapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		var notification = NotificationMessage.builder()
				.id(UUID.randomUUID())
				.subject("Meet with customers.")
				.message("Hello dears, this messages is a ...")
				.receptors(Set.of("jhondoe@mymail.com", "janedoe@mymail.com"))
				.order(1L)
				.status(NotificationMessage.GreetingMessageStatus.SENT)
				.timestamp(LocalDateTime.now())
				.build();
		var json = mapper.writeValueAsString(notification);
		System.out.println(json);
		System.out.println(mapper.readValue(json, NotificationMessage.class));		
	}

}
