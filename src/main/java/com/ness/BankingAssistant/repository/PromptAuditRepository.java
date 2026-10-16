package com.ness.BankingAssistant.repository;

import com.ness.BankingAssistant.dto.PromptAudit;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class PromptAuditRepository {

    private final List<PromptAudit> history =
            new CopyOnWriteArrayList<>();

    public void save(PromptAudit audit) {
        history.add(audit);
    }

    public List<PromptAudit> findAll() {
        return history;
    }
}
