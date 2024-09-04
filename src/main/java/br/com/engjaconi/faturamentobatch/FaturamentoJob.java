package br.com.engjaconi.faturamentobatch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.repository.JobRepository;

public class FaturamentoJob implements Job {

    private JobRepository jobRepository;

    public FaturamentoJob(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public String getName() {
        return "FaturamentoJob";
    }

    @Override
    public void execute(JobExecution execution) {
        System.out.println("processando faturamento");

        execution.setStatus(BatchStatus.COMPLETED);
        execution.setExitStatus(ExitStatus.COMPLETED);

        this.jobRepository.update(execution);

        /* // Exemplo de tratamento de erro do faturamento
        try {
            throw new Exception("Não foi possível realizar o faturamento");
        } catch (Exception exception) {
            execution.addFailureException(exception);
            execution.setStatus(BatchStatus.COMPLETED);
            execution.setExitStatus(ExitStatus.FAILED.addExitDescription(exception.getMessage()));
        } finally {
            this.jobRepository.update(execution);
        }
        */

    }
}
