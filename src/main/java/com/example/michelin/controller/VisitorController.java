package com.example.michelin.controller;

import com.example.michelin.model.Visitor;
import com.example.michelin.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/visitors")
public class VisitorController {
    @Autowired
    private VisitorRepository visitorRepository;

    @GetMapping()
    public @ResponseBody
    Iterable<Visitor> getAllVisitors(){
        return visitorRepository.findAll();
    }

    @PostMapping()
    public @ResponseBody Visitor addNewVisitor(){
        Visitor newVisitor = new Visitor();
        visitorRepository.save(newVisitor);
        return newVisitor;
    }
}
