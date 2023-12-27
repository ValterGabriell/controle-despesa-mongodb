package valter.gabriell.io.moneyproject.domain;

import valter.gabriell.io.moneyproject.infra.entities.ItemEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetFieldCount<T> {
    public T getCount(List<ItemEntity> listLastMonth) {
        Map<T, Long> categoryCount = new HashMap<>();
        for (ItemEntity value : listLastMonth) {
            if (categoryCount.put((T) value.getCategory(), 1L) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        Map.Entry<T, Long> mostFrequencyCategory = categoryCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        return mostFrequencyCategory.getKey();
    }
}
