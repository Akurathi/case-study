package com.example.salesorderservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Item")
@Table(name = "item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;


    private Double price;


    protected Item() {

    }



    // only include id field when generating equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item {");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description=").append(description);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public static final class ItemBuilder {
        private Item item;

        private ItemBuilder() {
            item = new Item();
        }

        public ItemBuilder withId(Long id) {
            item.setId(id);
            return this;
        }

        public ItemBuilder withName(String name) {
            item.setName(name);
            return this;
        }

        public ItemBuilder withDescription(String description) {
            item.setDescription(description);
            return this;
        }

        public ItemBuilder withPrice(double price) {
            item.setPrice(price);
            return this;
        }



        public Item build() {
            return item;
        }
    }
}
