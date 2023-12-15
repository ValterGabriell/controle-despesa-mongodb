package valter.gabriell.io.moneyproject.infra.adapter;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import valter.gabriell.io.moneyproject.dto.MessageInput;
import valter.gabriell.io.moneyproject.infra.repository.ItemRepository;
import valter.gabriell.io.moneyproject.ports.IQueueManager;

@Component
@EnableScheduling
public class SendEmailAtEndOfMonth implements IEmail {
    private final ItemRepository itemRepository;
    private final IQueueManager queueManager;
    private static final String TIME_ZONE = "America/Sao_Paulo";


    public SendEmailAtEndOfMonth(ItemRepository itemRepository, IQueueManager queueManager) {
        this.itemRepository = itemRepository;
        this.queueManager = queueManager;
    }

    private MessageInput obterDadosParaEmail() {
        return new MessageInput("it", "will", "be", "implemented");
    }

    @Override
    @Scheduled(cron = "0 0 0 1 * ?", zone = TIME_ZONE)
    public void send() {
        //relatorio de gastos
        queueManager.send(obterDadosParaEmail().toString());
    }
}