package br.com.engjaconi.faturamentobatch;

import org.springframework.batch.core.*;
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
        JobParameters jobParameters = execution.getJobParameters();
        String inputFile = jobParameters.getString("input.file");

        System.out.println("processando faturamento do arquivo " + inputFile);

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
