package org.example.download_document.service.department.createCommcand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.download_document.dto.request.CreateDepartmentRequest;
import org.example.download_document.repository.DepartmentRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class CheckExitsDepartmentCommand extends BaseCustomCommand{
    private final DepartmentRepository departmentRepository ;
    @Override
    protected void executeBusinessLogic(CreateDepartmentContext context) throws Exception {
        CreateDepartmentRequest request = context.getCreateDepartmentRequest();
        if (departmentRepository.existsByCode(request.getCode())){
            throw new IllegalArgumentException("Department already exists");
        }
        log.info("Checked info request department code");

    }
}
