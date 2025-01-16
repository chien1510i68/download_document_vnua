package org.example.download_document.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateDocumentRequest {
    @NotBlank(message = "Field id  is required!")
    private String id ;
    private String title;
    private String link;


}
