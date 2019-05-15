package vu.mif.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
public class EmployeeSalaryGenerator implements Serializable {

    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Future<Double> proposeSalary() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        double generatedProposedSalary = new Random().nextInt(9000) + 1000;
        return new AsyncResult<>(generatedProposedSalary);
    }
}
