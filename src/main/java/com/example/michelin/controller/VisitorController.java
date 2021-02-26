package com.example.michelin.controller;

import com.example.michelin.dto.VisitorReturnDto;
import com.example.michelin.model.Visitor;
import com.example.michelin.repository.ReviewRepository;
import com.example.michelin.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/visitors")
public class VisitorController {
    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping()
    public List<Visitor> getVisitors(){
        return visitorRepository.findAll();
    }

    @PostMapping()
    public Visitor createVisitor(@RequestBody Visitor newVisitor){
        return visitorRepository.save(newVisitor);
    }

    @GetMapping("/{id}")
    public VisitorReturnDto getVisitorById(@PathVariable Integer id) {
        VisitorReturnDto returnVisitor = new VisitorReturnDto();
        return visitorRepository.findById(id).map(visitor -> {
            returnVisitor.setId(visitor.getId());
            returnVisitor.setFirstName(visitor.getFirstName());
            returnVisitor.setLastName(visitor.getLastName());
            returnVisitor.setReviews(visitor.getReviews());
            return returnVisitor;
        }).orElseThrow();
    }

    @PutMapping("/{id}")
    public Visitor updateVisitor(@PathVariable Integer id, @RequestBody Visitor updateVisitor) {
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
    public void deleteVisitor(@PathVariable Integer id) {
        visitorRepository.deleteById(id);
    }
}
