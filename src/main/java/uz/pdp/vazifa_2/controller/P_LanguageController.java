package uz.pdp.vazifa_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vazifa_2.payload.ApiResponse;
import uz.pdp.vazifa_2.payload.P_LanguageDto;
import uz.pdp.vazifa_2.payload.UserDto;
import uz.pdp.vazifa_2.service.P_LanguageService;
import uz.pdp.vazifa_2.service.UserService;

@RestController
@RequestMapping("/p_language")
public class P_LanguageController {

    @Autowired
    P_LanguageService p_languageService;

    @GetMapping
    public HttpEntity<?> getAll() {

        ApiResponse apiResponse = p_languageService.getAll();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = p_languageService.getOne(id);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody P_LanguageDto p_languageDto) {
        ApiResponse apiResponse = p_languageService.saveOrEdit(p_languageDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestBody P_LanguageDto p_languageDto) {
        ApiResponse apiResponse = p_languageService.saveOrEdit(p_languageDto);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = p_languageService.delete(id);
        return ResponseEntity.ok(apiResponse);
    }
}
