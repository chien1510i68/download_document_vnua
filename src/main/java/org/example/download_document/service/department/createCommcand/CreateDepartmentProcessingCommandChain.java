package org.example.download_document.service.department.createCommcand;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateDepartmentProcessingCommandChain {
    private final CheckExitsDepartmentCommand checkExitsDepartmentCommand ;
    private final CreateDepartmentCommand createDepartmentCommand ;
    private final CreateSubjectInDepartmentCommand  createSubjectInDepartmentCommand;
    private final SaveDepartmentCommand  saveDepartmentCommand ;
    public void execute(CreateDepartmentContext context) throws Exception {
        checkExitsDepartmentCommand.execute(context);
        createDepartmentCommand.execute(context);
        createSubjectInDepartmentCommand.execute(context);
        saveDepartmentCommand.execute(context);

    }
}
