package org.example.download_document.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSubjectRequest {
    @NotBlank(message = "name subject is not blank !")

    private String name;
    @NotBlank(message = "code subject is not blank !")
    private String code;
    private List<CreateDocumentRequest> documentRequests;


}
