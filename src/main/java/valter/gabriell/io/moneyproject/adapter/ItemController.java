package valter.gabriell.io.moneyproject.adapter;

import org.springframework.web.bind.annotation.*;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;
import valter.gabriell.io.moneyproject.ports.IItemServicePort;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class ItemController {
    private final IItemServicePort IItemServicePort;

    public ItemController(IItemServicePort IItemServicePort) {
        this.IItemServicePort = IItemServicePort;
    }

    @PostMapping("create")
    public ItemEntity createItem(@RequestBody ItemEntity itemEntity) {
        return IItemServicePort.save(itemEntity);
    }

    @GetMapping(value = "/items")
    public List<ItemEntity> getAllItems() {
        return IItemServicePort.findAll();
    }

    @GetMapping(value = "/item/{id}")
    public ItemEntity getItemById(@PathVariable String id) {
        return IItemServicePort.findById(id);
    }

    @GetMapping(value = "/items", params = {"category"})
    public List<ItemEntity> getItemByCategory(@RequestParam Category category) {
        return IItemServicePort.findAllByCategory(category);
    }

}
