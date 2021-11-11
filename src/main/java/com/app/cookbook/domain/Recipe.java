package com.app.cookbook.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String imageUrl;
    @OneToMany
    private List<Ingredient> ingredientList;
    private String preparation;
    private Long portions;

    @Override
    public String toString() {
        return "<<" + id + ", " + name + ", " + portions + ">>";
    }
}
