package org.example.download_document.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDocumentRequest {
    @NotBlank(message = "Title document is not blank !")
    private String title;
    @NotBlank(message = "Link document is not blank !")
    private String link;


}
