package it.coopservice;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageConsumer {

    private final Logger logger = Logger.getLogger(MessageConsumer.class);

    @Incoming("message-in")
    public void receive(Record<Integer, String> record) {
        logger.infof("Got a message: %d - %s", record.key(), record.value());
    }
}
