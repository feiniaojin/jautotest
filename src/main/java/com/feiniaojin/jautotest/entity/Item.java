package com.feiniaojin.jautotest.entity;

import java.util.Date;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
public class Item {

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

    public static final class ItemBuilder {
        private Long id;
        private String itemName;
        private Integer itemCount;
        private Date createTime;

        private ItemBuilder() {
        }

        public static ItemBuilder anItem() {
            return new ItemBuilder();
        }

        public ItemBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ItemBuilder withItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public ItemBuilder withItemCount(Integer itemCount) {
            this.itemCount = itemCount;
            return this;
        }

        public ItemBuilder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Item build() {
            Item item = new Item();
            item.setId(id);
            item.setItemName(itemName);
            item.setItemCount(itemCount);
            item.setCreateTime(createTime);
            return item;
        }
    }
}
