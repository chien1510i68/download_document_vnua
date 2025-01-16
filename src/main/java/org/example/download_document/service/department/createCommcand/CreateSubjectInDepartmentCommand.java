package org.example.download_document.service.department.createCommcand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.download_document.dto.request.CreateDepartmentRequest;
import org.example.download_document.dto.request.CreateDocumentRequest;
import org.example.download_document.dto.request.CreateSubjectRequest;
import org.example.download_document.model.Department;
import org.example.download_document.model.Document;
import org.example.download_document.model.Subject;
import org.example.download_document.repository.SubjectRepository;
import org.example.download_document.service.documents.DocumentInterface;
import org.example.download_document.service.subjects.SubjectInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateSubjectInDepartmentCommand extends BaseCustomCommand {
    private final SubjectInterface subjectInterface;
    private final SubjectRepository subjectRepository;
    private final DocumentInterface documentInterface;

    @Override
    protected void executeBusinessLogic(CreateDepartmentContext context) throws Exception {
        CreateDepartmentRequest request = context.getCreateDepartmentRequest();
        List<Subject> subjects = new ArrayList<>();
        if (request.getSubjectRequests() != null && !request.getSubjectRequests().isEmpty()) {
            request.getSubjectRequests().forEach(subject -> {
                processingExistSubject(subject, subjects, context.getDepartment());
                processingNotExistSubject(subject, subjects, context.getDepartment());
            });
        }
        context.getDepartment().setListSubject(subjects);
        log.info("Create info subject in department ");
    }


    private void processingExistSubject(CreateSubjectRequest request, List<Subject> subjects, Department department) {
        if (subjectRepository.existsByCode(request.getCode())) {
            Subject subjectExisted = subjectRepository.findByCode(request.getCode());
            List<Department> departments = subjectExisted.getDepartments();
            departments.add(department);
            subjectExisted.setDocuments(createDocumentsBySubjectRequest(request.getDocumentRequests()));
            subjectExisted.setDepartments(departments);
            subjects.add(subjectExisted);
        }
    }

    private void processingNotExistSubject(CreateSubjectRequest request, List<Subject> subjects, Department department) {
        List<Department> departments = new ArrayList<>();
        departments.add(department);
        if (!subjectRepository.existsByCode(request.getCode())) {
            Subject newSubject = subjectInterface.createSubject(request);
            subjects.add(newSubject);
            newSubject.setDepartments(departments);

        }
    }

    private List<Document> createDocumentsBySubjectRequest(List<CreateDocumentRequest>  documentRequests) {
        List<Document> documents = new ArrayList<>();
        documentRequests.forEach(i -> documents.add(documentInterface.createDocument(i)));
        return documents;
    }
}
