package vu.mif.services;

import vu.mif.entities.AuditEntry;
import vu.mif.interfaces.Logger;
import vu.mif.persistence.AuditDAO;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.Date;

@Alternative
@SessionScoped
@Named
public class DatabaseLogger implements Logger, Serializable {

    @Inject
    private AuditDAO auditDAO;

    public void makeAuditLog(InvocationContext ctx) {

        AuditEntry entry = new AuditEntry();
        entry.setMethod(ctx.getMethod().getName());
        entry.setTimestamp(new Date());
        auditDAO.save(entry);
    }
}
