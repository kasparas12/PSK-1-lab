package vu.mif.usecases;

import vu.mif.interceptors.AuditedRequest;
import vu.mif.services.EmployeeSalaryGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class ProposeEmployeeSalary implements Serializable {

    @Inject
    private EmployeeSalaryGenerator salaryGenerator;

    private Future<Double> salaryProposalTask = null;

    @AuditedRequest
    public String generateNewSalaryProposal() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        salaryProposalTask = salaryGenerator.proposeSalary();
        return  "/employeeProjects.xhtml?faces-redirect=true&employeeId=" + requestParameters.get("employeeId");
    }

    public boolean isSalaryStillGenerating() {
        return salaryProposalTask != null && !salaryProposalTask.isDone();
    }

    public String getSalaryGenerationStatus() throws ExecutionException, InterruptedException {
        if (salaryProposalTask == null) {
            return null;
        } else if (isSalaryStillGenerating()) {
            return "Employee salary generation in progress";
        }
        return "Suggested salary " + salaryProposalTask.get();
    }
}
