package org.example.download_document.controller;

import lombok.RequiredArgsConstructor;
import org.example.download_document.dto.request.CreateSubjectRequest;
import org.example.download_document.dto.request.UpdateSubjectRequest;
import org.example.download_document.model.Subject;
import org.example.download_document.service.subjects.SubjectInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@RequestMapping("/")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectInterface subjectInterface ;
    @PostMapping
    public ResponseEntity<?> createSubject(@RequestBody CreateSubjectRequest request) {
        Subject subject = subjectInterface.createSubject(request);
        return ResponseEntity.ok(subject);
    }
    @PutMapping
    public ResponseEntity<?> updateSubject(@RequestBody UpdateSubjectRequest request){
        Subject subject = subjectInterface.updateSubject(request);
        return ResponseEntity.ok(subject);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailSubject(@PathVariable String id){
        Subject subject = subjectInterface.getDetailSubject(id);
        return ResponseEntity.ok(subject);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllSubject(){
        return ResponseEntity.ok(subjectInterface.getSubjects());
    }

}
