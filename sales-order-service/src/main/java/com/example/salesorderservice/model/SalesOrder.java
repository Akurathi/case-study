package com.example.salesorderservice.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity(name = "SalesOrder")
@Table(name = "salesorder")
@Data
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Date date;

    @Email
    private String email;


    private Double price;


    public SalesOrder() {

    }

    public SalesOrder(String email, String description, double price, Date date) {
        this.date = date;
        this.email = email;
        this.description = description;
        this.price = price;
    }

    // only include id field when generating equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrder item = (SalesOrder) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("sales order {");
        sb.append("id=").append(id);
        sb.append(", date='").append(date).append('\'');
        sb.append(", description=").append(description);
        sb.append(", email=").append(email);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public static final class ItemBuilder {
        private SalesOrder salesOrder;

        private ItemBuilder() {
            salesOrder = new SalesOrder();
        }

        public ItemBuilder withId(Long id) {
            salesOrder.setId(id);
            return this;
        }

        public ItemBuilder withDate(Date date) {
            salesOrder.setDate(date);
            return this;
        }

        public ItemBuilder withDescription(String description) {
            salesOrder.setDescription(description);
            return this;
        }

        public ItemBuilder withPrice(double price) {
            salesOrder.setPrice(price);
            return this;
        }



        public SalesOrder build() {
            return salesOrder;
        }
    }
}
