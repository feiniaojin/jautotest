package com.feiniaojin.jautotest.service;

import com.feiniaojin.jautotest.dao.ItemMapper;
import com.feiniaojin.jautotest.dto.ItemDto;
import com.feiniaojin.jautotest.entity.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public Item getById(Long id) {
        return itemMapper.getById(id);
    }

    @Override
    public void create(ItemDto itemDto) {
        Item item = Item.ItemBuilder.anItem()
                .withItemCount(itemDto.getItemCount())
                .withItemName(itemDto.getItemName())
                .withCreateTime(new Date()).build();
        itemMapper.create(item);
    }
}
