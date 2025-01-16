package org.example.download_document.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.download_document.dto.request.CreateDepartmentRequest;
import org.example.download_document.dto.request.UpdateDepartmentRequest;
import org.example.download_document.service.department.DepartmentInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@RequestMapping("department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentInterface departmentInterface;

    @PostMapping
    public ResponseEntity<?> createDepartment(@Valid @RequestBody CreateDepartmentRequest request) {
        return ResponseEntity.ok(departmentInterface.createDepartment(request));
    }

    @PutMapping
    public ResponseEntity<?> updateDepartment(@Valid @RequestBody UpdateDepartmentRequest request) {
        return ResponseEntity.ok(departmentInterface.updateDepartment(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDepartment() {
        return departmentInterface.getDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable String id) {
        return departmentInterface.getDepartment(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String id) {
        return departmentInterface.deleteDepartment(id);
    }

}
