package org.example.download_document.repository;

import org.example.download_document.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject , String> {
    boolean existsByCode(String code);
    Subject findByCode(String code);
}
