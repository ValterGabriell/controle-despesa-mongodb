package valter.gabriell.io.moneyproject.infra.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;
import valter.gabriell.io.moneyproject.infra.repository.ItemRepository;
import valter.gabriell.io.moneyproject.ports.ItemPersistencePort;

@Service
public class ItemAdapterJpa implements ItemPersistencePort {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Mono<Void> deleteAll() {
       return itemRepository.deleteAll();
    }

    @Override
    public Mono<ItemEntity> save(ItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }

    @Override
    public Flux<ItemEntity> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Mono<ItemEntity> findById(String id) {
        return itemRepository.findById(id);
    }

    @Override
    public Flux<ItemEntity> findAllByCategory(Category category) {
        return itemRepository.findAllByCategory(category);
    }
}
