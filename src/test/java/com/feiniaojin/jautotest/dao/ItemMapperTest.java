package com.feiniaojin.jautotest.dao;

import com.feiniaojin.jautotest.AbstractBaseTest;
import com.feiniaojin.jautotest.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
class ItemMapperTest extends AbstractBaseTest {

    @Resource
    private ItemMapper itemMapper;

    @Test
    @DisplayName("ItemMapper:根据id查询")
    void getById() {
        Item byId = itemMapper.getById(1L);
        Assertions.assertNotNull(byId);
        Assertions.assertEquals(1L, byId.getId());
    }

    @Test
    @DisplayName("ItemMapper:创建item")
    void create() {
        Item item = Item.ItemBuilder.anItem()
                .withItemCount(100)
                .withCreateTime(new Date())
                .withItemName("testCreate")
                .withId(1000L).build();
        int i = itemMapper.create(item);
        Assertions.assertEquals(1, i);
    }
}