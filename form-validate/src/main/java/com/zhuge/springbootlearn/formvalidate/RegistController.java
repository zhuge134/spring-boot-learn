package com.zhuge.springbootlearn.formvalidate;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/*@RestController*/
@Controller
@RequestMapping(path = "/regist")
public class RegistController {

    @GetMapping(path = "/success")
    public String results() {
        return "success.html";
    }

    @PostMapping(path = "/", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String regist(@Valid PersonForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/regist/";
        } else {
            return "redirect:/regist/success";
        }
    }

    @GetMapping("/")
    public String form(PersonForm personForm) {
        return "form.html";
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity errors(Exception e) {
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .build();
    }
}
