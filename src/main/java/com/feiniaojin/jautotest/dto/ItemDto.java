package com.feiniaojin.jautotest.dto;

import java.util.Date;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
public class ItemDto {
    private Long id;
    private String itemName;
    private Integer itemCount;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static final class ItemDtoBuilder {
        private Long id;
        private String itemName;
        private Integer itemCount;
        private Date createTime;

        private ItemDtoBuilder() {
        }

        public static ItemDtoBuilder anItemDto() {
            return new ItemDtoBuilder();
        }

        public ItemDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ItemDtoBuilder withItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public ItemDtoBuilder withItemCount(Integer itemCount) {
            this.itemCount = itemCount;
            return this;
        }

        public ItemDtoBuilder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public ItemDto build() {
            ItemDto itemDto = new ItemDto();
            itemDto.setId(id);
            itemDto.setItemName(itemName);
            itemDto.setItemCount(itemCount);
            itemDto.setCreateTime(createTime);
            return itemDto;
        }
    }
}
