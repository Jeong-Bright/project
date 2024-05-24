package database.controller;

import database.service.PasswordEditService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PasswordEditController {

    private final PasswordEditService ps;

    @PostMapping("/edit")
    public String edit(@Valid EditForm editForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/edit";
        }

        String editPwd = editForm.getEditPwd();
        String checkPwd = editForm.getCheckPwd();
        boolean pwd = ps.checkPassword(editForm.getBeforePwd());

        if(pwd && editPwd.equals(checkPwd)) {
//            ps.
        }

        else {
            return "/edit";
        }



        return "redirect:/info";
    }


}
