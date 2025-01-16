package org.example.download_document.service.subjects;

import org.example.download_document.dto.request.CreateSubjectRequest;
import org.example.download_document.dto.request.UpdateSubjectRequest;
import org.example.download_document.model.Subject;

import java.util.List;

public interface SubjectInterface {
    Subject getDetailSubject(String id);
    Subject createSubject(CreateSubjectRequest request);
    Subject updateSubject(UpdateSubjectRequest request);
    Boolean deleteSubject(String id);
    List<Subject> getSubjects();
}
