package it.coopservice;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MessageProducer {

    @Inject @Channel("message-out")
    Emitter<Record<Integer, String>> emitter;

    public void sendMessageToKafka(Message message) {
        emitter.send(Record.of(message.key , message.payload));
    }
}
