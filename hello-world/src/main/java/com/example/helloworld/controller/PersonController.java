package com.example.helloworld.controller;

import com.example.helloworld.model.Person;
import com.example.helloworld.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/create")
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @GetMapping("/list")
    public List<Person> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public Person detail(@RequestParam Integer id){
        return personService.detail(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@RequestParam Integer id){
        personService.delete(id);
        return "Success delete data id "+id;
    }

}