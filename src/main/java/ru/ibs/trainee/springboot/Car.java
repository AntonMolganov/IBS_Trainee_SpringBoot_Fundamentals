package ru.ibs.trainee.springboot;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String manufacturerName;

    private String modelName;

    public Car(String manufacturerName, String modelName) {
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
    }

    public String toString() {
        return String.join(" ", manufacturerName, modelName);
    }
}
