package com.example.michelin.controller;

import com.example.michelin.model.Visitor;
import com.example.michelin.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "api/visitors")
public class VisitorController {
    @Autowired
    private VisitorRepository visitorRepository;

    @GetMapping()
    public @ResponseBody
    Iterable<Visitor> getVisitors(){
        return visitorRepository.findAll();
    }

    @PostMapping()
    public @ResponseBody
    Visitor createVisitor(@RequestBody Visitor newVisitor){
        return visitorRepository.save(newVisitor);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Visitor getVisitorById(@PathVariable Integer id) {
        return visitorRepository.findById(id)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Visitor updateVisitor(@PathVariable Integer id, @RequestBody Visitor updateVisitor) {
        return visitorRepository.findById(id)
                .map(visitor -> {
                    visitor.setFirstName(updateVisitor.getFirstName());
                    visitor.setLastName(updateVisitor.getLastName());
                    return visitorRepository.save(visitor);
                }).orElseGet(() -> {
                    updateVisitor.setId(id);
                    return visitorRepository.save(updateVisitor);
                });
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void deleteVisitor(@PathVariable Integer id) {
        visitorRepository.deleteById(id);
    }
}
