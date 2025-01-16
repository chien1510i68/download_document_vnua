package org.example.download_document.service.documents;

import lombok.RequiredArgsConstructor;
import org.example.download_document.dto.DocumentDto;
import org.example.download_document.dto.request.CreateDocumentRequest;
import org.example.download_document.dto.request.UpdateDocumentRequest;
import org.example.download_document.exception.DataNotFoundException;
import org.example.download_document.model.Document;
import org.example.download_document.repository.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentService implements DocumentInterface {
    private final DocumentRepository documentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DocumentDto> getDocuments() {
        return documentRepository.findAll()
                .stream().map(i -> modelMapper.map(i, DocumentDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public Document getDetailDocument(String id) {
        return findById(id);
    }

    @Override
    public Document createDocument(CreateDocumentRequest request) {
        Document document = modelMapper.map(request, Document.class);
        document.setId(UUID.randomUUID().toString());
        document.setCreatedAt(new Timestamp(new Date().getTime()));
        documentRepository.save(document);
        return document;
    }

    @Override
    public Document updateDocument(UpdateDocumentRequest request) {

        Document documentDto = findById(request.getId());


        if (StringUtils.hasText(request.getLink())) {
            documentDto.setLink(request.getLink());
        }
        if (StringUtils.hasText(request.getTitle())) {
            documentDto.setTitle(request.getTitle());
        }
        documentRepository.saveAndFlush(documentDto);
        return documentDto;
    }

    @Override
    public Boolean deleteDocument(String id) {
        Document document = findById(id);
        documentRepository.delete(document);
        return true;
    }

    protected Document findById(String id) {
        return documentRepository.findById(id).orElseThrow(() -> new DataNotFoundException( "Document not found"));
    }
    public void deleteDocuments(List<Document> documents) {
        documentRepository.deleteAll(documents);
    }
}
