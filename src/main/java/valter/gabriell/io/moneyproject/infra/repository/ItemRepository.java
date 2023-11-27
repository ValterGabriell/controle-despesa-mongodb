package valter.gabriell.io.moneyproject.infra.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;

@Repository
public interface ItemRepository extends ReactiveMongoRepository<ItemEntity, String> {
    Flux<ItemEntity> findAllByCategory(Category category);
}
