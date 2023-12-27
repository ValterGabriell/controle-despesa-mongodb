package valter.gabriell.io.moneyproject.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import valter.gabriell.io.moneyproject.domain.IItemServiceImpl;
import valter.gabriell.io.moneyproject.domain.ReportsServiceImpl;
import valter.gabriell.io.moneyproject.infra.adapter.IItemAdapterJpa;
import valter.gabriell.io.moneyproject.ports.IQueueManager;
import valter.gabriell.io.moneyproject.ports.IItemPersistencePort;
import valter.gabriell.io.moneyproject.ports.IItemServicePort;
import valter.gabriell.io.moneyproject.ports.IReportServicePort;

@Configuration
public class ProjectConfig {

    @Bean
    public IItemServicePort getService() {
        return new IItemServiceImpl(getPersistencePort());
    }

    @Bean
    public IItemPersistencePort getPersistencePort() {
        return new IItemAdapterJpa();
    }

    @Bean
    public IQueueManager queueManager() {
        return new QueueSender();
    }

    @Bean
    public IReportServicePort reportServicePort() {
        return new ReportsServiceImpl(getPersistencePort());
    }
}
