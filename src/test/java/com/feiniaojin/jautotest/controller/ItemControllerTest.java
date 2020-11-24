package com.feiniaojin.jautotest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feiniaojin.jautotest.dto.ItemDto;
import com.feiniaojin.jautotest.entity.Item;
import com.feiniaojin.jautotest.service.ItemServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
class ItemControllerTest {

    @Mock
    private ItemServiceImpl itemService;

    @InjectMocks
    private ItemController itemController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }

    @Test
    void getById() throws Exception {

        Item build = Item.ItemBuilder.anItem()
                .withId(1L)
                .withItemName("testController")
                .withCreateTime(new Date())
                .withItemCount(1).build();
        Mockito.when(itemService.getById(Mockito.anyLong())).thenReturn(build);

        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.get("/item/{id}", 1);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();

        Assertions.assertNotNull(contentAsString);

        ObjectMapper mapper = new ObjectMapper();
        Item fromJson = mapper.readValue(contentAsString, Item.class);
        Assertions.assertNotNull(fromJson);
        Assertions.assertEquals(1L, fromJson.getId());
    }

    @Test
    void create() throws Exception {

        ItemDto testCreate = ItemDto.ItemDtoBuilder.anItemDto()
                .withId(999L)
                .withItemCount(999)
                .withCreateTime(new Date())
                .withItemName("testCreate")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String asString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(testCreate);

        Mockito.doNothing()
                .when(itemService)
                .create(Mockito.any());

        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.put("/item")
                        .content(asString)
                        .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        Assertions.assertNotNull(contentAsString);
    }

    @Test
    void createException() throws Exception {

        ItemDto testCreate = ItemDto.ItemDtoBuilder.anItemDto()
                .withId(999L)
                .withItemCount(999)
                .withCreateTime(new Date())
                .withItemName("testCreate")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String asString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(testCreate);

        Mockito.doThrow(new RuntimeException())
                .when(itemService)
                .create(Mockito.any());

        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.put("/item")
                        .content(asString)
                        .contentType(MediaType.APPLICATION_JSON);


        Assertions.assertThrows(Exception.class, () -> {
            MvcResult result = mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        });
    }
}