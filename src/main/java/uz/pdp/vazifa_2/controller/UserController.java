package uz.pdp.vazifa_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vazifa_2.payload.ApiResponse;
import uz.pdp.vazifa_2.payload.UserDto;
import uz.pdp.vazifa_2.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public HttpEntity<?> getAll() {

        ApiResponse apiResponse = userService.getAll();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.getOne(id);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody UserDto userDto) {
        ApiResponse apiResponse = userService.saveOrEdit(userDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestBody UserDto userDto) {
        ApiResponse apiResponse = userService.saveOrEdit(userDto);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.delete(id);
        return ResponseEntity.ok(apiResponse);
    }
}
