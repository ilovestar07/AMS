package com.fintech.fintech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
    private UsersService service;

    @RequestMapping("login")
    public Users page1(Users users) {
        return service.findByNameAndPassword(users);
    }
}
