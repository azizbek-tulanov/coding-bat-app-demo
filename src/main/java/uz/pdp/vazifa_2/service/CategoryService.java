package uz.pdp.vazifa_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.vazifa_2.entity.Category;
import uz.pdp.vazifa_2.entity.User;
import uz.pdp.vazifa_2.payload.ApiResponse;
import uz.pdp.vazifa_2.payload.CategoryDto;
import uz.pdp.vazifa_2.repo.CategoryRepo;
import uz.pdp.vazifa_2.repo.P_LanguageRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    P_LanguageRepo p_languageRepo;

    public ApiResponse getAll() {
        List<Category> all = categoryRepo.findAll();
        return new ApiResponse(true,"All",all);
    }

    public ApiResponse getOne(Integer id) {
        Optional<Category> optionalUser = categoryRepo.findById(id);
        if (optionalUser.isEmpty()) {
            return new ApiResponse(false,"Not found");
        }
        return new ApiResponse(true,"By id",optionalUser.get());
    }

    public ApiResponse delete(Integer id) {
        try {
            categoryRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }
        catch (Exception e) {
            return new ApiResponse(false,"Not found");
        }
    }

    public ApiResponse saveOrEdit(CategoryDto categoryDto) {
        Category category=new Category();
        if (categoryDto.getId()!=null) {
            category=categoryRepo.getById(categoryDto.getId());
        }
        category.setName(categoryDto.getName());
        category.setP_language(p_languageRepo.getById(categoryDto.getP_languageId()));
        categoryRepo.save(category);
        return new ApiResponse(true,categoryDto.getId()!=null?"Edited":"Saved");
    }
}
