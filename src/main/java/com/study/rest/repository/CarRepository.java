package com.study.rest.repository;

import com.study.rest.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {

    public List<Car> carList = List.of (
            Car.builder().model("쏘나타").color("화이트").build(),
            Car.builder().model("K5").color("블랙").build());

        public Car findCarByModel(String model) {
            return carList.stream()
                    .filter(car -> car.getModel().equals(model))
                    .collect(Collectors.toList())
                    .get(0);
    }
}
