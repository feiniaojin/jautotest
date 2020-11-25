package com.feiniaojin.jautotest.service;

import com.feiniaojin.jautotest.dao.ItemMapper;
import com.feiniaojin.jautotest.dto.ItemDto;
import com.feiniaojin.jautotest.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
class ItemServiceTest {

    @InjectMocks
    private ItemServiceImpl itemService;

    @Mock
    private ItemMapper itemMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("ItemService:根据id查询")
    void getById() {

        Mockito.when(itemMapper.getById(Mockito.anyLong()))
                .thenReturn(Item.ItemBuilder.anItem().withId(1L)
                        .withItemCount(1).withCreateTime(new Date()).withItemName("test").build());

        Item byId = itemService.getById(Mockito.anyLong());

        Assertions.assertNotNull(byId);
        Assertions.assertEquals(1L, byId.getId());
    }

    @Test
    @DisplayName("ItemService:创建item")
    void create() {

        ItemDto build = ItemDto.ItemDtoBuilder.anItemDto().withId(1L)
                .withItemCount(1).withCreateTime(new Date()).withItemName("test").build();

        Mockito.when(itemMapper.create(Mockito.any()))
                .thenReturn(1);

        itemService.create(build);
    }

    @Test
    @DisplayName("ItemService:创建item，名称为空")
    void createWithItemNameIsNull() {

        ItemDto build = ItemDto.ItemDtoBuilder.anItemDto().withId(1L)
                .withItemCount(1).withCreateTime(new Date()).withItemName(null).build();

        Mockito.when(itemMapper.create(Mockito.any()))
                .thenReturn(1);

        itemService.create(build);
    }
}