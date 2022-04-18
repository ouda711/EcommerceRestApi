package com.ecommerce.restapi.Entity;

import javax.persistence.*;

@Table(name="roles")
@Entity
public class Role extends TimestampedEntity {
    @Column(unique = true)
    private String name;
    private String description;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")

    public Role(){}

    public Role(String name){
        this.name = name;
    }

    public Role(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
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


}
