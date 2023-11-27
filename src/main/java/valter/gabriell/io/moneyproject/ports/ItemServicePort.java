package valter.gabriell.io.moneyproject.ports;

import reactor.core.publisher.Mono;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;

public interface ItemServicePort {
    Mono<Void> deleteAll();

    Mono<ItemEntity> save(ItemEntity itemEntity);
}
