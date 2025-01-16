package org.example.download_document.service.department;

import lombok.RequiredArgsConstructor;
import org.example.download_document.dto.request.CreateDepartmentRequest;
import org.example.download_document.dto.request.UpdateDepartmentRequest;
import org.example.download_document.dto.response.BaseItemResponse;
import org.example.download_document.dto.response.BaseListResponse;
import org.example.download_document.dto.response.ErrorResponse;
import org.example.download_document.exception.DataNotFoundException;
import org.example.download_document.model.Department;
import org.example.download_document.repository.DepartmentRepository;
import org.example.download_document.repository.SubjectRepository;
import org.example.download_document.service.department.createCommcand.CreateDepartmentContext;
import org.example.download_document.service.department.createCommcand.CreateDepartmentProcessingCommandChain;
import org.example.download_document.service.subjects.SubjectInterface;
import org.example.download_document.service.subjects.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements DepartmentInterface {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    private final SubjectInterface subjectInterface;
    private final SubjectRepository subjectRepository;
    private final SubjectService subjectService;
    private final CreateDepartmentProcessingCommandChain processingCommandChain ;

    @Override
    public ResponseEntity<?> getDepartment(String id) {
        BaseItemResponse baseItemResponse = new BaseItemResponse();
        baseItemResponse.successData(findDepartmentById(id));
        return ResponseEntity.ok(baseItemResponse);
    }

    @Override
    public ResponseEntity<?> createDepartment(CreateDepartmentRequest request) {
//        if (checkExitsByCode(request.getCode())) {
//            return ResponseEntity.ok().body(new ErrorResponse(500, "Department existed ", null));
//        }
//        Department department = modelMapper.map(request, Department.class);
//        department.setId(UUID.randomUUID().toString());
//        List<Subject> subjects = new ArrayList<>();
//        department.setCreatedAt(new Timestamp(new Date().getTime()));
//        if (!request.getSubjectRequests().isEmpty() && request.getSubjectRequests() != null) {
//            request.getSubjectRequests().forEach(subjectRequest -> {
//                if (subjectRepository.existsByCode(subjectRequest.getCode())) {
//                    Subject subject = subjectRepository.findByCode(subjectRequest.getCode());
//
//                    subjectInterface.updateSubject(subjectRequest);
//                    subjects.add(subjectRepository.findByCode(subjectRequest.getCode()));
//                } else {
//                    Subject subject = subjectInterface.createSubject(subjectRequest);
//                    List<Department> departments = subject.getDepartments();
//                    departments.add(department);
//                    subject.setDepartments(departments);
//                    subjects.add(subject);
//
//                }
//
//            });
//        }
//        department.setListSubject(subjects);
//        departmentRepository.save(department);
//        BaseItemResponse baseItemResponse = new BaseItemResponse();
//        baseItemResponse.successData(department);
//        return ResponseEntity.ok(baseItemResponse);
        CreateDepartmentContext context = new CreateDepartmentContext();
        context.setCreateDepartmentRequest(request);
        try {
            processingCommandChain.execute(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        context.setCreateDepartmentRequest(request);
        return ResponseEntity.ok(context.getBaseItemResponse());
    }


    @Override
    public ResponseEntity<?> updateDepartment(UpdateDepartmentRequest request) {
        Department department = findDepartmentById(request.getId());

        if (StringUtils.hasText(request.getCode())) {
            if (checkExitsByCode(request.getCode())) {
                return ResponseEntity.ok().body(new ErrorResponse(500, "department code is existed ! ", null));
            }
            department.setCode(request.getCode());
        }
        if (StringUtils.hasText(request.getName())) {
            department.setName(request.getName());
        }
        if (request.getSubjectRequests() != null && !request.getSubjectRequests().isEmpty()) {
            request.getSubjectRequests().forEach(subjectInterface::updateSubject);
        }
        departmentRepository.save(department);
        BaseItemResponse response = new BaseItemResponse();
        response.successData(department);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> deleteDepartment(String id) {
        Department department = findDepartmentById(id) ;
        department.getListSubject().clear();
        departmentRepository.delete(department);
        BaseItemResponse response = new BaseItemResponse();
        response.successData(true);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        BaseListResponse baseListResponse = new BaseListResponse();
        baseListResponse.setResults(departments ,departments.size());
        return ResponseEntity.ok(baseListResponse);
    }

    public Department findDepartmentById(String id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Department not found"));
    }

    public boolean checkExitsByCode(String code) {
        return departmentRepository.existsByCode(code);
    }
}
