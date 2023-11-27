package valter.gabriell.io.moneyproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import valter.gabriell.io.moneyproject.infra.entities.Categoria;
import valter.gabriell.io.moneyproject.infra.entities.FormaPgto;
import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;
import valter.gabriell.io.moneyproject.ports.ItemServicePort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DynamicData implements CommandLineRunner {

    private final ItemServicePort itemServicePort;

    public DynamicData(ItemServicePort itemServicePort) {
        this.itemServicePort = itemServicePort;
    }


    @Override
    public void run(String... args) throws Exception {
        itemServicePort.deleteAll().thenMany(
                        Flux.fromIterable(createItemEntities())
                                .flatMap(itemEntity -> Mono.from(itemServicePort.save(itemEntity))))
                                .subscribe(System.out::println);
    }

    private static List<ItemEntity> createItemEntities() {
        List<ItemEntity> itemEntities = new ArrayList<>();

        // Adicione quantas instâncias de ItemEntity você desejar
        itemEntities.add(new ItemEntity("Desc1", Categoria.ALIMENTACAO, FormaPgto.CREDITO, 123, LocalDate.now()));
        itemEntities.add(new ItemEntity("Desc2", Categoria.ALIMENTACAO, FormaPgto.CREDITO, 456, LocalDate.now()));
        itemEntities.add(new ItemEntity("Desc3", Categoria.ALIMENTACAO, FormaPgto.CREDITO, 789, LocalDate.now()));

        return itemEntities;
    }
}
