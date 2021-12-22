package com.example.helloworld.controller;

import com.example.helloworld.model.Person;
import com.example.helloworld.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    // Create data person
    @PostMapping("/create")
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    // List all data person
    @GetMapping("/list")
    public List<Person> listAll(){
        return personService.listAll();
    }

    // Get data person berdasarkan id
    @GetMapping("/{id}")
    public Person detail(@PathVariable Integer id){
        System.out.println("id : " + id);

        Person person = personService.detail(id);
        System.out.println("Person : " + person.getFirstName());
        return person;
    }

    // Delete data person berdasarkan id
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        personService.delete(id);
        return "Success delete data id "+id;
    }
}
