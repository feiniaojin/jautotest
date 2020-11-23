package com.feiniaojin.jautotest.controller;

import com.feiniaojin.jautotest.dto.ItemDto;
import com.feiniaojin.jautotest.entity.Item;
import com.feiniaojin.jautotest.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @GetMapping("/{id}")
    public Item getById(@PathVariable Long id) {
        return itemService.getById(id);
    }

    @PutMapping
    public void create(@RequestBody ItemDto itemDto) {
        itemService.create(itemDto);
    }

}
