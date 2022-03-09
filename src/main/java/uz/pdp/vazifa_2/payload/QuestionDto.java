package uz.pdp.vazifa_2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private Integer id;

    private String title;

    private String body;

    private String exemple;

    private Integer categoryId;
}

