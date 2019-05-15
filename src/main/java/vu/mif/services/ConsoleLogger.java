package vu.mif.services;

import vu.mif.interfaces.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.Date;

@Alternative
@SessionScoped
@Named
public class ConsoleLogger implements Logger, Serializable {

        public void makeAuditLog(InvocationContext ctx) {
            Date timestamp = new Date();
            System.out.println("Method invoked: " + ctx.getMethod().getName());
            System.out.println("Method invoked at: " + timestamp.toString());
        }
}
