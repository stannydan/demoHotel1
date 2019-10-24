package com.example.demo.controllers;


import com.example.demo.forms.CheckingForm;
import com.example.demo.model.Comfort;
import com.example.demo.model.Room;
import com.example.demo.services.impls.RoomServiceImpls;
import com.example.demo.forms.RoomForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequestMapping("/room")
@Controller
public class RoomWebController {
    @Autowired
    RoomServiceImpls service;

    @RequestMapping("/list")
    String showAll(Model model){
        List<Room> list=service.getAll();
        model.addAttribute("rooms",list);

        return "roomList";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable(value="id")String id){
        service.delete(id);
        return "redirect:/room/list";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createRoom(Model model){
        RoomForm roomForm=new RoomForm();
        List<String> comf=new ArrayList<>();
        comf.add(Comfort.Standart.toString());
        comf.add(Comfort.Halflux.toString());
        comf.add(Comfort.Lux.toString());
        model.addAttribute("roomForm",roomForm);
        model.addAttribute("comf",comf);

        return "roomCreate";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String create(@ModelAttribute("roomForm")RoomForm roomForm){
        Room newRoom=new Room(roomForm.getNumber(),roomForm.getComfort(),
                roomForm.getCapacity(),roomForm.getPrice(),roomForm.isBusy());
        service.create(newRoom);
        return "redirect:/room/list";

    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String updateRoom(Model model,@PathVariable("id")String id){
        Room room=service.get(id);
        RoomForm roomForm=new RoomForm(room.getNumber(),room.getComfort(),
                room.getCapacity(),room.getPrice());
        List<String> comf=new ArrayList<>();
        comf.add(Comfort.Standart.toString());
        comf.add(Comfort.Halflux.toString());
        comf.add(Comfort.Lux.toString());
        String[] busy=new String[]{"yes","no"};
        model.addAttribute("roomForm",roomForm);
        model.addAttribute("comf",comf);
        model.addAttribute("busy",busy);

        return "roomUpdate";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String update(Model model,@ModelAttribute("roomForm")RoomForm roomForm,@PathVariable("id")String id){
        Room newRoom=new Room(roomForm.getNumber(),roomForm.getComfort(),
                roomForm.getCapacity(),roomForm.getPrice(),roomForm.isBusy());
        newRoom.setId(id);
        service.update(newRoom);
        return "redirect:/room/list";
    }


}
