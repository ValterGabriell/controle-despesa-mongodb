package valter.gabriell.io.moneyproject.infra.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import valter.gabriell.io.moneyproject.ports.IQueueManager;

@Component
public class QueueSender implements IQueueManager {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    @Override
    public void send(String payload) {
        rabbitTemplate.convertAndSend(this.queue.getName(), payload);
    }
}
