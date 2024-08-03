package com.yugiohcounter.yugiohcounter.Controllers;

import com.yugiohcounter.yugiohcounter.Entities.User;
import com.yugiohcounter.yugiohcounter.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> list(){
        return userService.findAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/registrar")
    public ResponseEntity<User> registrar(@RequestBody User user){
        user.setAdmin(false);
        return create(user);
    }
}
