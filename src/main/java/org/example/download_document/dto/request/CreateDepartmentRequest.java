package org.example.download_document.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateDepartmentRequest {
    @NotBlank(message = "Name department is not blank !")
    private String name;
    @NotBlank(message = "Code department is not blank !")
    private String code;
    private List<CreateSubjectRequest> subjectRequests;

}
