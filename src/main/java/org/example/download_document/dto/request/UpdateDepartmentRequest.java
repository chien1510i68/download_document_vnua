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
public class UpdateDepartmentRequest {
    @NotBlank(message = "Field id  is required!")
    private String id;
    private String name;
    private String code;
    private List<UpdateSubjectRequest> subjectRequests ;

}
