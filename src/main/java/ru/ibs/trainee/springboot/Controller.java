package ru.ibs.trainee.springboot;

import com.example.boot.starter.services.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class Controller {

    @Autowired
    private CarRepository carRepository;


    // этот бин должен придти из нашего кастомного стартера, в данном приложении мы руками его не поднимаем, только лишь добавляем dependency custom-example-stater в pom.xml
    @Autowired
    private SomeService someService;

    @PostConstruct
    private void postConstruct() {
        // только лишь для примера
    }

    // просто открываем http://localhost:8080/ и должен выдать все автомобили из таблицы Car созданные в части spring-data
    @GetMapping("/")
    public List<Car> test() {
        return StreamSupport
                .stream(carRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
