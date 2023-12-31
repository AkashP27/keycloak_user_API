package com.test.userservice.controller;

import com.test.userservice.DTO.UserDTO;
import com.test.userservice.service.KeyCloakService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class KeyCloakController {

    @Autowired
    KeyCloakService service;

    @PostMapping
    public String addUser(@RequestBody UserDTO userDTO){
        service.addUser(userDTO);
        return "User Added Successfully.";
    }

    @GetMapping(path = "/{userName}")
    public List<UserRepresentation> getUser(@PathVariable("userName") String userName){
        return service.getUser(userName);
    }

    @PutMapping(path = "/{userId}")
    public String updateUser(@PathVariable("userId") String userId, @RequestBody UserDTO userDTO){
        service.updateUser(userId, userDTO);
        return "User Details Updated Successfully.";
    }

    @DeleteMapping(path = "/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        service.deleteUser(userId);
        return "User Deleted Successfully.";
    }

    @GetMapping()
    public String addRole(@RequestParam("role") String role_name){
        service.addRole(role_name);
        return "Role Added Successfully.";
    }
}
