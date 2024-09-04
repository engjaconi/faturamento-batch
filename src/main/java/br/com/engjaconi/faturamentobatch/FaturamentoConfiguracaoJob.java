package br.com.engjaconi.faturamentobatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FaturamentoConfiguracaoJob {
    @Bean
    public Job job(JobRepository jobRepository) {
        return new FaturamentoJob(jobRepository);
    }
}