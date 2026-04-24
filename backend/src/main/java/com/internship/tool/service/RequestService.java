package com.internship.tool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.internship.tool.entity.Request;
import com.internship.tool.repository.RequestRepository;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public Request saveRequest(Request request) {
        request.setStatus("PENDING");
        return repository.save(request);
    }

    public List<Request> getAllRequests() {
        return repository.findAll();
    }
}