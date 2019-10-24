package com.example.demo.controllers;

import com.example.demo.model.Archive;
import com.example.demo.model.Checking;
import com.example.demo.services.impls.ArchiveServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/archive")
@Controller
public class ArchiveWebController {
    @Autowired
    ArchiveServiceImpls archiveServiceImpls;

    @RequestMapping("/list")
    String showAll(Model model){
        List<Archive> list=archiveServiceImpls.getAll();
        model.addAttribute("checkings",list);
        return "archiveList";
    }
}
