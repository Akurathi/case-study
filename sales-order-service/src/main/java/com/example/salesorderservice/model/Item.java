package com.example.salesorderservice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Item")
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;


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

    protected Item() {

    }

    public Item(String name, String description, double price) {

        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

        public Item build() {
            return item;
        }
    }
}
