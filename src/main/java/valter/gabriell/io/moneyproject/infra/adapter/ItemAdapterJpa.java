package valter.gabriell.io.moneyproject.infra.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
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
}
