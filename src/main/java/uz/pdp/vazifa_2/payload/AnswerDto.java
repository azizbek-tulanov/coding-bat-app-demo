package uz.pdp.vazifa_2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.vazifa_2.entity.Question;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private Integer id;

    private String body;

    private boolean isTrue;

    private Integer questionId;
}
