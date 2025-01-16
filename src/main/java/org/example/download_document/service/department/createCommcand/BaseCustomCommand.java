package org.example.download_document.service.department.createCommcand;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.stereotype.Component;

@Component

public abstract class BaseCustomCommand implements Command {
    protected abstract void executeBusinessLogic(CreateDepartmentContext context) throws Exception;

    @Override
    public boolean execute(Context context) throws Exception {
        CreateDepartmentContext customerContext = (CreateDepartmentContext) context;
        executeBusinessLogic(customerContext);
        return false;
    }
}
