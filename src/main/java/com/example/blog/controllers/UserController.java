package com.example.blog.controllers;

import com.example.blog.payloads.UserDto;
import com.example.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
//    create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
    UserDto createUserDto = this.userService.createUser(userDto);
    return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
// update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer userId){
       UserDto updatedUser =  this.userService.updateUser(userDto,userId);
        return ResponseEntity.ok(updatedUser);
    }
//    delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.ok(Map.of("message","User delete Successfully"));
    }
//    get users
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return  ResponseEntity.ok(this.userService.geAllUser());
    }
//    get single user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
    return  ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
