package valter.gabriell.io.moneyproject.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import valter.gabriell.io.moneyproject.domain.ItemServiceImpl;
import valter.gabriell.io.moneyproject.infra.adapter.ItemAdapterJpa;
import valter.gabriell.io.moneyproject.infra.config.QueueSender;
import valter.gabriell.io.moneyproject.ports.IQueueManager;
import valter.gabriell.io.moneyproject.ports.ItemPersistencePort;
import valter.gabriell.io.moneyproject.ports.ItemServicePort;

@Configuration
public class ProjectConfig {

    @Bean
    public ItemServicePort getService(){
        return new ItemServiceImpl(getPersistencePort());
    }
    @Bean
    public ItemPersistencePort getPersistencePort(){
        return new ItemAdapterJpa();
    }

    @Bean
    public IQueueManager queueManager(){
        return new QueueSender();
    }
}
