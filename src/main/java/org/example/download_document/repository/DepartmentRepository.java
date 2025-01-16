package org.example.download_document.repository;

import org.example.download_document.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department , String> {
    boolean existsByCode(String code);

}
