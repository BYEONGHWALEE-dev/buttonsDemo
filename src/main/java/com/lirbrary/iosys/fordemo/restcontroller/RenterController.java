package com.lirbrary.iosys.fordemo.restcontroller;

import com.lirbrary.iosys.fordemo.entity.Renter;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RenterController {

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @PostMapping("/addRenter")
    public String addRenter(@Valid @ModelAttribute("renter") Renter theRenter,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "renter-form";
        }

        else {
            return "redirect:/buttons";
        }
    }
}
