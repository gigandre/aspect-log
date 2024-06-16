package com.example.logger.aspect.service;

import com.example.logger.aspect.dto.Item;
import com.example.logger.aspect.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Integer id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item update(Integer id, Item item) {
        return itemRepository.update(id, item);
    }

    public void delete(Integer id) {
        itemRepository.delete(id);
    }

}
