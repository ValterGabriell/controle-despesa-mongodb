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
    public ItemServiceImpl(ItemPersistencePort itemPersistencePort) {
        this.itemPersistencePort = itemPersistencePort;
    }

    @Override
    public Mono<Void> deleteAll() {
        return itemPersistencePort.deleteAll();
    }

    @Override
    public Mono<ItemEntity> save(ItemEntity itemEntity) {
        return itemPersistencePort.save(itemEntity);
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
