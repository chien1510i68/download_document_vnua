package org.example.download_document.service.department;

import org.example.download_document.dto.request.CreateDepartmentRequest;
import org.example.download_document.dto.request.UpdateDepartmentRequest;
import org.example.download_document.model.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentInterface {
    ResponseEntity<?> getDepartment(String id);

    ResponseEntity<?> createDepartment(CreateDepartmentRequest request);

    ResponseEntity<?> updateDepartment(UpdateDepartmentRequest request);

    ResponseEntity<?> deleteDepartment(String id);

    ResponseEntity<?> getDepartments();

}
