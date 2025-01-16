package org.example.download_document.service.department.createCommcand;

import lombok.Data;
import org.apache.commons.chain.impl.ContextBase;
import org.example.download_document.dto.request.CreateDepartmentRequest;
import org.example.download_document.dto.request.UpdateDocumentRequest;
import org.example.download_document.dto.response.BaseItemResponse;
import org.example.download_document.model.Department;

@Data
public class CreateDepartmentContext extends ContextBase {
    private UpdateDocumentRequest updateDocument;
    private CreateDepartmentRequest createDepartmentRequest;
    private boolean isExistCode;
    private Department department;
    private BaseItemResponse baseItemResponse;

}
