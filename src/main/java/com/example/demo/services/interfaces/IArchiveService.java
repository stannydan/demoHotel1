package com.example.demo.services.interfaces;

import com.example.demo.model.Archive;
import com.example.demo.model.Checking;

import java.util.List;

public interface IArchiveService {
    List<Archive> getAll();
    Archive create(Archive archive);
    Archive get(String id);
}
