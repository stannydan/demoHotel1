package com.example.demo.controllers;


import com.example.demo.model.Guest;
import com.example.demo.services.impls.GuestServiceImpls;
import com.example.demo.forms.GuestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequestMapping("/guest")
@Controller
public class GuestWebController {
    @Autowired
    GuestServiceImpls service;

    @RequestMapping("/list")
    String showAll(Model model){
        List<Guest>list=service.getAll();
        model.addAttribute("guests",list);
        return "guestList";
    }

    @RequestMapping("delete/{id}")
    RedirectView delete(@PathVariable(value = "id") String id){
    service.delete(id);
    return new RedirectView("/guest/list");
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createGuest(Model model){
        GuestForm guestForm=new GuestForm();
        model.addAttribute("guestForm",guestForm);
        return "guestCreate";
    }

    @RequestMapping(value = "/create",method=RequestMethod.POST)
    public String create(@ModelAttribute("guestForm")GuestForm guestForm){
    Guest newGuest=new Guest(
            guestForm.getName(),
            guestForm.getForname(),
            guestForm.getPassData(),
            guestForm.getComment()
    );
    newGuest.setComment(guestForm.getComment());
        service.create(newGuest);
    return "redirect:/guest/list";
    }

    @RequestMapping(value = "/update/{id}",method =RequestMethod.GET)
    public String updateGuest(Model model,@PathVariable("id")String id){
    Guest guestToUpdate=service.get(id);
    GuestForm guestForm=new GuestForm(guestToUpdate.getName(),guestToUpdate.getForname(),
            guestToUpdate.getPassData(),guestToUpdate.getComment());
    guestForm.setId(guestToUpdate.getId());
    model.addAttribute("guestForm",guestForm);
    return "guestUpdate";
    }

    @RequestMapping(value = "/update/{id}",method=RequestMethod.POST)
    public String update(Model model,@ModelAttribute("guestForm")GuestForm guestForm,
                         @PathVariable(value = "id") String id){
        Guest newGuest=new Guest(guestForm.getName(),guestForm.getForname(),guestForm.getPassData(),
                guestForm.getComment());
        newGuest.setId(guestForm.getId());
        service.update(newGuest);

        return "redirect:/guest/list";
    }

}
