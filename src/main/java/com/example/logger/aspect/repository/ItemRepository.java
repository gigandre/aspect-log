package com.example.logger.aspect.repository;

import com.example.logger.aspect.dto.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {
    private final List<Item> items = new ArrayList<>();

    public List<Item> findAll() {
        return items;
    }

    public Item findById(Integer id) {
        return items.stream()
                .filter(item -> item.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Item update(Integer id, Item item) {
        items.removeIf(existingItem -> existingItem.id().equals(id));
        items.add(item);
        return item;
    }

    public Item save(Item item) {
        items.add(item);
        return item;
    }

    public void delete(Integer id) {
        items.stream()
                .filter(item -> item.id().equals(id))
                .findFirst()
                .ifPresent(items::remove);
    }

}
