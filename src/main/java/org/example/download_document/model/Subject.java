package org.example.download_document.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
    @Id
    private String id;
    private String name;
    private String code ;
    private Timestamp createdAt;
    @OneToMany(mappedBy = "subject" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Document> documents;

    @ManyToMany(mappedBy = "listSubject", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Department> departments;

}
