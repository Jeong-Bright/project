package database.Controller;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class LoginForm {

    @NotBlank
    private String id;
    @NotBlank
    private String password;

}
