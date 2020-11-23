package com.feiniaojin.jautotest.dao;

import com.feiniaojin.jautotest.entity.Item;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
public interface ItemMapper {

    Item getById(Long id);

    int create(Item item);
}
