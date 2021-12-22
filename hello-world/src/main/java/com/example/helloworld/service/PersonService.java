package com.example.helloworld.service;

import com.example.helloworld.model.Person;
import com.example.helloworld.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    // Buat data person baru dan simpan ke database
    public Person create(Person person){
        return personRepository.save(person);
    }

    // Menampilkan seluruh data person
    public List<Person> listAll(){
        return personRepository.findAll();
    }

    // Detail data person berdasarkan id
    public Person detail(Integer id){
        Person person = personRepository.getById(id);
        return person;
    }

    // Delete data person
    public void delete(Integer id){
        Person person = personRepository.getById(id);
        personRepository.delete(person);
    }

}
