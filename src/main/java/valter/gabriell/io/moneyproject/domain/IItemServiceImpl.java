package valter.gabriell.io.moneyproject.domain;

import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;
import valter.gabriell.io.moneyproject.ports.IItemPersistencePort;
import valter.gabriell.io.moneyproject.ports.IItemServicePort;

import java.util.List;

public class IItemServiceImpl implements IItemServicePort {
    private final IItemPersistencePort IItemPersistencePort;

    public IItemServiceImpl(IItemPersistencePort IItemPersistencePort) {
        this.IItemPersistencePort = IItemPersistencePort;
    }

    @Override
    public ItemEntity save(ItemEntity itemEntity) {
        return IItemPersistencePort.save(itemEntity);
    }

    @Override
    public List<ItemEntity> findAll() {
        return IItemPersistencePort.findAll();
    }

    @Override
    public ItemEntity findById(String id) {
        return IItemPersistencePort.findById(id);
    }

    @Override
    public List<ItemEntity> findAllByCategory(Category category) {
        return IItemPersistencePort.findAllByCategory(category);
    }

    @Override
    public void deleteAll() {
        IItemPersistencePort.deleteAll();
    }
}
