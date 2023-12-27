package valter.gabriell.io.moneyproject.ports;

import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;

import java.util.List;

public interface IItemPersistencePort {
    void deleteAll();

    ItemEntity save(ItemEntity itemEntity);

    List<ItemEntity> findAll();

    ItemEntity findById(String id);

    List<ItemEntity> findAllByCategory(Category category);
}
