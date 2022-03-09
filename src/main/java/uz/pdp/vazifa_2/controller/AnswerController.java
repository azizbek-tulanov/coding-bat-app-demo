package uz.pdp.vazifa_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vazifa_2.payload.AnswerDto;
import uz.pdp.vazifa_2.payload.ApiResponse;
import uz.pdp.vazifa_2.payload.UserDto;
import uz.pdp.vazifa_2.service.AnswerService;
import uz.pdp.vazifa_2.service.UserService;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @GetMapping
    public HttpEntity<?> getAll() {

        ApiResponse apiResponse = answerService.getAll();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = answerService.getOne(id);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody AnswerDto answerDto) {
        ApiResponse apiResponse = answerService.saveOrEdit(answerDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestBody AnswerDto answerDto) {
        ApiResponse apiResponse = answerService.saveOrEdit(answerDto);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = answerService.delete(id);
        return ResponseEntity.ok(apiResponse);
    }
}
