package com.haulmatic.controllers;

import com.haulmatic.models.Role;
import com.haulmatic.repositories.RoleRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Role getRoleById(@PathVariable("id") ObjectId id) {
        return roleRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") String id, @RequestBody Role role) {
        role.setId(id);
        roleRepository.save(role);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Role createPet(@RequestBody Role role) {
        role.setId(role.getId());
        roleRepository.save(role);
        return role;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        roleRepository.delete(roleRepository.findBy_id(id));
    }
}
