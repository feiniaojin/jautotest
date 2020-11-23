package com.feiniaojin.jautotest.service;

import com.feiniaojin.jautotest.dto.ItemDto;
import com.feiniaojin.jautotest.entity.Item;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
public interface ItemService {

    Item getById(Long id);

    void create(ItemDto itemDto);

}
