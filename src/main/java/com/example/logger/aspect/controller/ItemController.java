package com.example.logger.aspect.controller;

import com.example.logger.aspect.dto.Item;
import com.example.logger.aspect.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable Integer id) {
        Item item = itemService.findById(id);
        if (item == null) {
            return ResponseEntity.notFound().build(); // Handle not found case
        }
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Item> save(@RequestBody Item item) {
        Item savedItem = itemService.save(item);
        return ResponseEntity.ok(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Integer id, @RequestBody Item item) {
        Item updatedItem = itemService.update(id, item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build(); // 204 No Content on successful delete
    }
}
