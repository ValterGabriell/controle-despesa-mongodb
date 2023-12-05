package valter.gabriell.io.moneyproject.adapter;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import valter.gabriell.io.moneyproject.infra.entities.Category;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;
import valter.gabriell.io.moneyproject.ports.ItemServicePort;

@RestController
@RequestMapping("/v1/")
public class ItemController {
    private final ItemServicePort itemServicePort;

    public ItemController(ItemServicePort itemServicePort) {
        this.itemServicePort = itemServicePort;
    }

    @PostMapping("create")
    public Mono<ItemEntity> createItem(@RequestBody ItemEntity itemEntity) {
        return itemServicePort.save(itemEntity);
    }

    @GetMapping(value = "/items")
    public Flux<ItemEntity> getAllItems() {
        return itemServicePort.findAll();
    }

    @GetMapping(value = "/item/{id}")
    public Mono<ItemEntity> getItemById(@PathVariable String id) {
        return itemServicePort.findById(id);
    }

    @GetMapping(value = "/items", params = {"category"})
    public Flux<ItemEntity> getItemByCategory(@RequestParam Category category) {
        return itemServicePort.findAllByCategory(category);
    }

}
