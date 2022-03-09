package uz.pdp.vazifa_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.vazifa_2.entity.User;
import uz.pdp.vazifa_2.payload.ApiResponse;
import uz.pdp.vazifa_2.payload.UserDto;
import uz.pdp.vazifa_2.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public ApiResponse getAll() {
        List<User> all = userRepo.findAll();
        return new ApiResponse(true,"All",all);
    }

    public ApiResponse getOne(Integer id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isEmpty()) {
            return new ApiResponse(false,"Not found");
        }
        return new ApiResponse(true,"By id",optionalUser.get());
    }

    public ApiResponse saveOrEdit(UserDto userDto) {
        User user=new User();
        if (userDto.getId()!=null) {
            user=userRepo.getById(userDto.getId());
        }
        user.setFio(userDto.getFio());
        user.setMail(userDto.getMail());
        user.setPassword(userDto.getPassword());
        userRepo.save(user);
        return new ApiResponse(true,userDto.getId()!=null?"Edited":"Saved");
    }

    public ApiResponse delete(Integer id) {
        try {
            userRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }
        catch (Exception e) {
            return new ApiResponse(false,"Not found");
        }
    }
}
