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

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.GET)
    public Role getRoleById(@PathVariable("_id") String _id) {
        return roleRepository.findBy_id(_id);
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
    public void updateRoleById(@PathVariable("_id") String _id, @RequestBody Role role) {
        role.set_id(_id);
        roleRepository.save(role);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Role createRole(@RequestBody Role role) {
        role.set_id(role.get_id());
        roleRepository.save(role);
        return role;
    }

    @RequestMapping(value = "/{_id}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable String _id) {
        roleRepository.delete(roleRepository.findBy_id(_id));
    }
}
