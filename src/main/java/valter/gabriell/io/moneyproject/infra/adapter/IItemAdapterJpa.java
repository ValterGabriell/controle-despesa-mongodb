package valter.gabriell.io.moneyproject.infra.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;
import valter.gabriell.io.moneyproject.infra.repository.ItemRepository;
import valter.gabriell.io.moneyproject.ports.IItemPersistencePort;

import java.util.List;

@Service
public class IItemAdapterJpa implements IItemPersistencePort {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }

    @Override
    public ItemEntity save(ItemEntity itemEntity) {
        return itemRepository.save(itemEntity);
    }

    @Override
    public List<ItemEntity> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public ItemEntity findById(String id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public List<ItemEntity> findAllByCategory(Category category) {
        return itemRepository.findAllByCategory(category);
    }
}
