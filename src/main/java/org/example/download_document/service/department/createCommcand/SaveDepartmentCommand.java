package org.example.download_document.service.department.createCommcand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.download_document.dto.response.BaseItemResponse;
import org.example.download_document.repository.DepartmentRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class SaveDepartmentCommand extends BaseCustomCommand{
    private final DepartmentRepository departmentRepository ;
    @Override
    protected void executeBusinessLogic(CreateDepartmentContext context)  {
//        context.getDepartment().setId(UUID.randomUUID().toString());
        departmentRepository.save(context.getDepartment());
        BaseItemResponse response = new BaseItemResponse();
        response.successData(context.getDepartment());
        context.setBaseItemResponse(response);
        log.info("Save info department : {} " , context.getDepartment());

    }
}
