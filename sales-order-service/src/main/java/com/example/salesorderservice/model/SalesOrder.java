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
    //private PetType petType;

    // Lazy fetch is better for performance than eager
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id")
//    private Owner owner;

//    @OneToMany(
//            mappedBy = "pet",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    private List<Visit> visits = new ArrayList<>();

    public SalesOrder() {

    }

    public SalesOrder(String email, String description, double price, Date date) {
        this.date = date;
        this.email = email;
        this.description = description;
        this.price = price;
    }



    //    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public PetType getPetType() {
//        return petType;
//    }
//
//    public void setPetType(PetType petType) {
//        this.petType = petType;
//    }
//
//    // Update the relationship between Owner and Pet when adding an Owner
//    public void addOwner(Owner owner) {
//
//        addOwner(owner, true);
//    }
//
//    public void addOwner(Owner owner, Boolean updateRelationship) {
//
//        this.owner = owner;
//        if (updateRelationship) {
//            owner.addPet(this, false);
//        }
//    }
//
//    // Update the relationship between Owner and Pet when removing an Owner
//    public void removeOwner(Owner owner) {
//
//        removeOwner(owner, true);
//    }
//
//    public void removeOwner(Owner owner, Boolean updateRelationship) {
//
//        this.owner = null;
//        if (updateRelationship) {
//            owner.removePet(this, false);
//        }
//    }
//
//    // Update the relationship between Visit and Pet when adding a Visit
//    public void addVisit(Visit visit) {
//
//        addVisit(visit, true);
//    }
//
//    public void addVisit(Visit visit, Boolean updateRelationship) {
//
//        visits.add(visit);
//        if (updateRelationship) {
//            visit.addPet(this, false);
//        }
//    }
//
//    // Update the relationship between Visit and Pet when removing a Visit
//    public void removeVisit(Visit visit) {
//
//        removeVisit(visit, true);
//    }
//
//    public void removeVisit(Visit visit, Boolean updateRelationship) {
//
//        visits.remove(visit);
//        if (updateRelationship) {
//            visit.removePet(this, false);
//        }
//    }
//
//    public Owner getOwner() {
//        return owner;
//    }
//
//    public List<Visit> getVisits() {
//        return this.visits;
//    }

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

//        public PetBuilder withOwner(Owner owner) {
//            pet.addOwner(owner);
//            owner.getPets().add(pet);
//            return this;
//        }
//
//        public PetBuilder withVisit(Visit visit) {
//            pet.addVisit(visit);
//            visit.addPet(pet);
//            return this;
//        }

        public SalesOrder build() {
            return salesOrder;
        }
    }
}
