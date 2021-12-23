package com.example.helloworld.controller;

import com.example.helloworld.model.Person;
import com.example.helloworld.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<Object, Object> detail(@PathVariable Integer id){
        System.out.println("id : " + id);
        Person person = personService.detail(id);
        Map<Object, Object> map = new HashMap<>();
        map.put(HttpStatus.OK.toString(), person);

        return map;
    }

    // Delete data person berdasarkan id
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        personService.delete(id);
        return "Success delete data id "+id;
    }
}
