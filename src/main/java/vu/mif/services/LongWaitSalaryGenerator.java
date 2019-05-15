package vu.mif.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import javax.transaction.Transactional;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
@Specializes
public class LongWaitSalaryGenerator extends EmployeeSalaryGenerator {

    @Override
    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Future<Double> proposeSalary() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        double generatedProposedSalary = new Random().nextInt(15000) + 1000;
        return new AsyncResult<>(generatedProposedSalary);
    }
}
