package database.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditForm {

    @NotBlank
    private String beforePwd;
    @NotBlank
    private String editPwd;
    @NotBlank
    private String checkPwd;


}
