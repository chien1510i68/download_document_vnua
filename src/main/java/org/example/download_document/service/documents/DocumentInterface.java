package org.example.download_document.service.documents;

import org.example.download_document.dto.DocumentDto;
import org.example.download_document.dto.request.CreateDocumentRequest;
import org.example.download_document.dto.request.UpdateDocumentRequest;
import org.example.download_document.model.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DocumentInterface {
    List<DocumentDto> getDocuments();
    Document getDetailDocument(String id );
    Document createDocument(CreateDocumentRequest createDocumentRequest);
    Document updateDocument(UpdateDocumentRequest createDocumentRequest);
    Boolean deleteDocument(String id);

}
