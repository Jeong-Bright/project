package database.controller;

import database.domain.Student;
import database.service.PasswordEditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class PasswordEditController {

    private final PasswordEditService ps;


    @GetMapping("info/edit")
    public String editPwdPage(@ModelAttribute("editForm") EditForm editForm) {
        return "basic/editPassword";
    }

    @PostMapping("info/edit")
    public String editPwd(@SessionAttribute(name = "studentLogin", required = false) Student student,
                          EditForm editForm,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }

        String editPwd = editForm.getEditPwd();
        String checkPwd = editForm.getCheckPwd();

        if(ps.checkPassword(student.getPassword()) && (Objects.equals(editPwd, checkPwd))) {
            ps.editPassword(editPwd, student.getId());
            return "redirect:/info";
        }

        else {
            System.out.println("PasswordEditController.editPwd");
            return "redirect:/";
        }


    }

}
