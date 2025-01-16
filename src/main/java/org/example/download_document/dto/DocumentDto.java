package org.example.download_document.dto;

import lombok.Data;
import org.example.download_document.model.Subject;

import java.util.List;

@Data
public class DocumentDto {
    private String id;
    private String title;
    private String link;
    private List<Subject> subjects;
}
