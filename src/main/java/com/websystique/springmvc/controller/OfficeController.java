package com.websystique.springmvc.controller;


import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.service.OfficeService;
import com.websystique.springmvc.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/offices")
@SessionAttributes("roles")
public class OfficeController {



    @Autowired
    private OfficeService officeService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listOffices(ModelMap model) {

        List<Office> offices = officeService.findAllOffices();
        model.addAttribute("offices", offices);
        model.addAttribute("loggedinoffice", getPrincipal());
        return "officelist";
    }

    @RequestMapping(value = { "/edit-office-{offId}" }, method = RequestMethod.POST)
    public String updateOffice(@Valid Office office, BindingResult result,
                             ModelMap model, @PathVariable int offId) {

        if (result.hasErrors()) {
            return "registration";
        }

        officeService.updateOffice(office);
        model.addAttribute("success", "Office with id " + office.getId()  + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }

    @RequestMapping(value = { "/edit-office-{offId}" }, method = RequestMethod.GET)
    public String editOffice(@PathVariable String offId, ModelMap model) {
        Office office = officeService.findById(Integer.parseInt(offId));
        model.addAttribute("office", office);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "officesaveorupdate";
    }

    @RequestMapping(value = { "/newoffice" }, method = RequestMethod.GET)
    public String newOffice(ModelMap model) {
        Office office = new Office();
        model.addAttribute("office", office);
        model.addAttribute("edit", false);
       // model.addAttribute("loggedinuser", getPrincipal());
        return "officesaveorupdate";
    }

    @RequestMapping(value = { "/newoffice" }, method = RequestMethod.POST)
    public String saveOffice(@Valid Office office, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "officesaveorupdate";
        }

        officeService.saveOffice(office);
        model.addAttribute("success", "Office with id " + office.getId()  + " save successfully");
       // model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccess";
    }

    @RequestMapping(value = { "/delete-office-{offId}" }, method = RequestMethod.GET)
    public String deleteOffice(@PathVariable int offId) {
        officeService.deleteOfficeById(offId);
        return "redirect:/offices/list";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
