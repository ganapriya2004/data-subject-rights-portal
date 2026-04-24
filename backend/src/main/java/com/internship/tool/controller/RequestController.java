package com.internship.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.internship.tool.entity.Request;
import com.internship.tool.service.RequestService;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin
public class RequestController {

    @Autowired
    private RequestService service;

    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        return service.saveRequest(request);
    }

    @GetMapping
    public List<Request> getAllRequests() {
        return service.getAllRequests();
    }
}
