package uz.pdp.vazifa_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.vazifa_2.entity.Answer;
import uz.pdp.vazifa_2.entity.User;
import uz.pdp.vazifa_2.payload.AnswerDto;
import uz.pdp.vazifa_2.payload.ApiResponse;
import uz.pdp.vazifa_2.payload.UserDto;
import uz.pdp.vazifa_2.repo.AnswerRepo;
import uz.pdp.vazifa_2.repo.QuestionRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    AnswerRepo answerRepo;
    @Autowired
    QuestionRepo questionRepo;

    public ApiResponse getAll() {
        List<Answer> all = answerRepo.findAll();
        return new ApiResponse(true,"All",all);
    }

    public ApiResponse getOne(Integer id) {
        Optional<Answer> optionalUser = answerRepo.findById(id);
        if (optionalUser.isEmpty()) {
            return new ApiResponse(false,"Not found");
        }
        return new ApiResponse(true,"By id",optionalUser.get());
    }

    public ApiResponse saveOrEdit(AnswerDto answerDto) {
        Answer answer=new Answer();
        if (answerDto.getId()!=null) {
            answer=answerRepo.getById(answerDto.getId());
        }
        answer.setBody(answerDto.getBody());
        answer.setTrue(answerDto.isTrue());
        answer.setQuestion(questionRepo.getById(answerDto.getQuestionId()));
        return new ApiResponse(true,answerDto.getId()!=null?"Edited":"Saved");
    }

    public ApiResponse delete(Integer id) {
        try {
            answerRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }
        catch (Exception e) {
            return new ApiResponse(false,"Not found");
        }
    }
}
