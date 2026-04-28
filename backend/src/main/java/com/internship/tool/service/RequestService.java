package com.internship.tool.service;

import com.internship.tool.entity.Request;
import com.internship.tool.repository.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    // ✅ CREATE REQUEST
    public Request createRequest(Request request) {
        request.setStatus("PENDING"); // default status
        return repository.save(request);
    }

    // ✅ GET ALL WITH PAGINATION
    public Page<Request> getAllRequests(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // ✅ GET BY ID (WITH 404 ERROR)
    public Request getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found with id: " + id));
    }
}