package com.hotelmanagement.service.approval;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApprovalWorkflowController {
    private final List<ICommand> commandHistory = new ArrayList<>();

    public void executeCommand(ICommand cmd) {
        cmd.execute();
        commandHistory.add(cmd);
    }

    public List<ICommand> getCommandHistory() {
        return commandHistory;
    }
}
