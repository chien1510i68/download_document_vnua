package org.example.download_document.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Department {
    @Id
    private String id ;
    private String name;
    private String code ;
    private Timestamp createdAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "department_subject",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> listSubject;
}
