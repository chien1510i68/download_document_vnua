package org.example.download_document.service.department.createCommcand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.download_document.model.Department;
import org.example.download_document.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateDepartmentCommand extends BaseCustomCommand{
    private final ModelMapper modelMapper ;
    private final DepartmentRepository repository ;

    @Override
    protected void executeBusinessLogic(CreateDepartmentContext context) throws Exception {
        Department department = modelMapper.map(context.getCreateDepartmentRequest() , Department.class);
        department.setCreatedAt(new Timestamp(new Date().getTime()));
        department.setId(UUID.randomUUID().toString());
        context.setDepartment(department);
        repository.save(department);
        log.info("Created Department Object");



    }
}
