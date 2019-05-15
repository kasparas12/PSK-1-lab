package vu.mif.interfaces;

import javax.interceptor.InvocationContext;

public interface Logger {
    void makeAuditLog(InvocationContext ctx);
}
