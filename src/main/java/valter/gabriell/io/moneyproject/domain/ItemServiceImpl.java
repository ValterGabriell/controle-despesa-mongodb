package valter.gabriell.io.moneyproject.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;
import valter.gabriell.io.moneyproject.ports.IQueueManager;
import valter.gabriell.io.moneyproject.ports.ItemPersistencePort;
import valter.gabriell.io.moneyproject.ports.ItemServicePort;

public class ItemServiceImpl implements ItemServicePort {
    private final ItemPersistencePort itemPersistencePort;

    private final IQueueManager queueManager;

    public ItemServiceImpl(ItemPersistencePort itemPersistencePort, IQueueManager queueManager) {
        this.itemPersistencePort = itemPersistencePort;
        this.queueManager = queueManager;
    }

    @Override
    public Mono<Void> deleteAll() {
        return itemPersistencePort.deleteAll();
    }

    @Override
    public Mono<ItemEntity> save(ItemEntity itemEntity) {
        Mono<ItemEntity> save = itemPersistencePort.save(itemEntity);
        queueManager.send(save.toString());
        return save;
    }

    @Override
    public Flux<ItemEntity> findAll() {
        return itemPersistencePort.findAll();
    }

    @Override
    public Mono<ItemEntity> findById(String id) {
        return itemPersistencePort.findById(id);
    }

    @Override
    public Flux<ItemEntity> findAllByCategory(Category category) {
        return itemPersistencePort.findAllByCategory(category);
    }
}
