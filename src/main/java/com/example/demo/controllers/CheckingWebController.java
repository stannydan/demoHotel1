package com.example.demo.controllers;

import com.example.demo.model.Archive;
import com.example.demo.model.Checking;
import com.example.demo.model.Guest;
import com.example.demo.model.Room;
import com.example.demo.repository.ArchiveRepository;
import com.example.demo.services.impls.ArchiveServiceImpls;
import com.example.demo.services.impls.CheckingServiceImpls;
import com.example.demo.services.impls.GuestServiceImpls;
import com.example.demo.services.impls.RoomServiceImpls;
import com.example.demo.forms.CheckingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/checking")
@Controller
public class CheckingWebController {
    @Autowired
    CheckingServiceImpls serviceImpls;
    @Autowired
    GuestServiceImpls guestServiceImpls;
    @Autowired
    RoomServiceImpls roomServiceImpls;
    @Autowired
    ArchiveServiceImpls archiveServiceImpls;

    int roomnum;

    @RequestMapping("/list")
    String showAll(Model model){
        List<Checking> list=serviceImpls.getAll();
        model.addAttribute("checkings",list);
        return "checkingList";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable(value="id")String id){
        Checking archChecking=serviceImpls.get(id);
        Archive newArchive=new Archive(archChecking.getGuest(),archChecking.getRoom()
        ,archChecking.getCheckIn(),archChecking.getCheckOut());
        if(archChecking.isReserved()==false)archiveServiceImpls.create(newArchive);
        Room newRoom=archChecking.getRoom();
        newRoom.setFreePlaces(newRoom.getFreePlaces()+1);
        roomServiceImpls.update(newRoom);
        serviceImpls.delete(id);

        return "redirect:/checking/list";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createChecking(Model model){
        CheckingForm checkingForm=new CheckingForm();
        List<Guest> listimp=guestServiceImpls.getAll();
       List<String> listGuests=new ArrayList<>();
        for (int i = 0; i <listimp.size() ; i++) {
            String help=listimp.get(i).getId()+" "+listimp.get(i).getName();
            listGuests.add(help);
        }

        Map<String,Integer> listRoom=roomServiceImpls.getAll().stream()
                .collect(Collectors.toMap(Room::getId,Room::getNumber));
        String[] reserved=new String[]{"yes","no"};
        model.addAttribute("listGuests",listGuests);
        model.addAttribute("listRoom",listRoom);
        model.addAttribute("checkingForm",checkingForm);
        model.addAttribute("reserved",reserved);

        return "checkingCreate";
    }

    @RequestMapping(value = "/create",method=RequestMethod.POST)
    public String create(@ModelAttribute("checkingForm")CheckingForm checkingForm){
        String[] guestid=checkingForm.getGuest().split(" ");
        Guest newGuest=guestServiceImpls.get(guestid[0]);
        Room numroom=roomServiceImpls.get(checkingForm.getRoom());
        Room newRoom=roomServiceImpls.get(checkingForm.getRoom());
        LocalDate dateIn= LocalDate.parse(checkingForm.getCheckIn().toString(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate dateOut= LocalDate.parse(checkingForm.getCheckOut().toString(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        if(dateOut.isBefore(dateIn)||dateIn.isBefore(LocalDate.now())){
            return "IncorrectData";
        }
        if(newRoom.getFreePlaces()==0){
            return"NoFreePlaces";
        }
        newRoom.setFreePlaces(newRoom.getFreePlaces()-1);
        roomServiceImpls.update(newRoom);
        Checking newChecking=new Checking(newGuest,newRoom,dateIn,dateOut);
        if(checkingForm.getReserved().equals("yes"))newChecking.setReserved(true);
        else newChecking.setReserved(false);
        serviceImpls.create(newChecking);
        System.out.println(newChecking);

        return "redirect:/checking/list";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String updateChecking(Model model,@PathVariable("id")String id){
        Checking checking=serviceImpls.get(id);
        String checkIn=(String)checking.getCheckIn().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String checkOut=(String)checking.getCheckOut().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));;
        CheckingForm checkingForm=new CheckingForm(checking.getGuest().toString(),
                checking.getRoom().toString(),checkIn,checkOut,"");
        checkingForm.setId(checking.getId());
        if(checking.isReserved()==true) checkingForm.setReserved("yes");
        else checkingForm.setReserved("no");
        List<Guest> listimp=guestServiceImpls.getAll();
        List<String> listGuests=new ArrayList<>();
        for (int i = 0; i <listimp.size() ; i++) {
            String help=listimp.get(i).getId()+" "+listimp.get(i).getName();
            listGuests.add(help);
        }
        Room oldRoom=checking.getRoom();
        roomnum=oldRoom.getNumber();
        Map<String,Integer> listRoom=roomServiceImpls.getAll().stream()
                .collect(Collectors.toMap(Room::getId,Room::getNumber));
        String[] reserved=new String[]{"yes","no"};
        model.addAttribute("listGuests",listGuests);
        model.addAttribute("listRoom",listRoom);
        model.addAttribute("reserved",reserved);
        model.addAttribute("checkingForm",checkingForm);

        return "checkingUpdate";

    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("checkingForm") CheckingForm checkingForm, @PathVariable("id")String id) {
        String[] guestid=checkingForm.getGuest().split(" ");
        Guest newGuest=guestServiceImpls.get(guestid[0]);
        Room newRoom=roomServiceImpls.get(checkingForm.getRoom());
        if(roomnum!=newRoom.getNumber()){
            Room oldRoom=roomServiceImpls.getByNum(roomnum);
            oldRoom.setFreePlaces(oldRoom.getFreePlaces()+1);
            roomServiceImpls.update(oldRoom);
            if(newRoom.getFreePlaces()>0){
                newRoom.setFreePlaces(newRoom.getFreePlaces()-1);
                roomServiceImpls.update(newRoom);
            }
            else return "NoFreePlaces";
        }
        LocalDate dateIn= LocalDate.parse(checkingForm.getCheckIn().toString(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate dateOut= LocalDate.parse(checkingForm.getCheckOut().toString(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        if(dateOut.isBefore(dateIn)||dateIn.isBefore(LocalDate.now())){
            return "IncorrectData";
        }
        if(newRoom.getFreePlaces()==0){
           return"NoFreePlaces";
        }

        Checking newChecking=new Checking(newGuest,newRoom,dateIn,dateOut);
        if(checkingForm.getReserved().equals("yes"))newChecking.setReserved(true);
        else newChecking.setReserved(false);
        newChecking.setId(id);
        serviceImpls.update(newChecking);
        return "redirect:/checking/list";
    }
}
