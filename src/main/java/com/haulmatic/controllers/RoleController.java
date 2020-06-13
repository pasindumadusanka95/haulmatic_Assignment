package com.haulmatic.controllers;

import com.haulmatic.models.Role;
import com.haulmatic.repositories.RoleRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleRepository repository;

    public RoleController(RoleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/addUser")
    public String saveUser(@RequestBody Role role){
        repository.save(role);
        return "Added user with id: " + role.getId();
    }

    @GetMapping("/findAll")
    public List<Role> getRoles(){
        return repository.findAll();
    }

    @GetMapping("/findUser/{id}")
    public Optional<Role> getUser(@PathVariable String id){
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
        repository.deleteById(id);
        return "role deleted with id:" +id;
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable String id,@RequestBody Role role){
        role.setId(id);
        repository.save(role);
        return "user update with id:" +id;
    }

    @GetMapping("/findrole/{nic}")
    public String findroleBynic(@PathVariable String nic)
    {
        Role role =  repository.findroleBynic(nic);
        return "user role:"+ role.getRoleType();

    }

//    @GetMapping("/findAllRoles/{organization}/{nic}")
//    public List<Role> findRoles(@PathVariable String organization,@PathVariable String nic)
//    {
//        List<Role> roles= new ArrayList<>();
//       /* users = repository.findroleByorganizationroletype(organization,nic);
//        for(User user : users) {
//            System.out.println("user nic"+user.getNicNo());
//        }*/
//        return repository.findroleByorganizationroletype(organization,nic);
//
//
//
//    }

}
