package org.example.download_document.service.subjects;

import lombok.RequiredArgsConstructor;
import org.example.download_document.dto.request.CreateSubjectRequest;
import org.example.download_document.dto.request.UpdateSubjectRequest;
import org.example.download_document.exception.DataNotFoundException;
import org.example.download_document.model.Document;
import org.example.download_document.model.Subject;
import org.example.download_document.repository.SubjectRepository;
import org.example.download_document.service.documents.DocumentInterface;
import org.example.download_document.service.documents.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectService implements SubjectInterface {
    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;
    private final DocumentInterface documentInterface;
    private final DocumentService documentService;

    @Override
    public Subject getDetailSubject(String id) {

        return findSubjectById(id);
    }

    @Override
    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject createSubject(CreateSubjectRequest request) {
        List<Document> documents = new ArrayList<>();
        Subject subject = modelMapper.map(request, Subject.class);
        subject.setCreatedAt(new Timestamp(new Date().getTime()));
        subject.setId(UUID.randomUUID().toString());
        if (request.getDocumentRequests() != null && !request.getDocumentRequests().isEmpty()) {
            request.getDocumentRequests().forEach(i -> {
                Document document = documentInterface.createDocument(i);
                document.setSubject(subject);
                documents.add(document);
            });
        }
        subject.setDepartments(new ArrayList<>());
        subject.setDocuments(documents);
        subjectRepository.save(subject);
        return subject;
    }

    @Override
    public Subject updateSubject(UpdateSubjectRequest request) {
        Subject subject = findSubjectById(request.getId());
        if (StringUtils.hasText(request.getCode())) {
            subject.setCode(request.getCode());
        }
        if (StringUtils.hasText(request.getName())) {
            subject.setName(request.getName());
        }
        if (request.getDocumentRequests() != null && !request.getDocumentRequests().isEmpty()) {
            request.getDocumentRequests().forEach(documentInterface::updateDocument);
        }

        subjectRepository.save(subject);
        return subject;
    }

    @Override
    public Boolean deleteSubject(String id) {
        Subject subject = findSubjectById(id);
        documentService.deleteDocuments(subject.getDocuments());
        subjectRepository.delete(subject);
        return true;
    }

    public Subject findSubjectById(String id) {
        return subjectRepository.findById(id).orElseThrow(() -> new DataNotFoundException( "Subject not found"));
    }

}
