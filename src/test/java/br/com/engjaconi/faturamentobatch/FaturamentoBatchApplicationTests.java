package br.com.engjaconi.faturamentobatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@SpringBatchTest
@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class FaturamentoBatchApplicationTests {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	private JobRepositoryTestUtils jobRepositoryTestUtils;

	@Test
	void testJobExecution(CapturedOutput output) throws Exception {
		// given
		JobParameters jobParameters = this.jobLauncherTestUtils.getUniqueJobParametersBuilder()
				.addString("input.file", "/some/input/file")
				.toJobParameters();

		/*
		// Recebendo o formato do arquivo como parametro
			JobParameters jobParameters = new JobParametersBuilder()
                                  .addString("input.file", "/some/input/file")
                                  .addString("file.format", "csv", false)
                                  .toJobParameters();
		*/

		// when
		JobExecution jobExecution = this.jobLauncherTestUtils.launchJob(jobParameters);

		// then
		Assertions.assertTrue(output.getOut().contains("processando faturamento do arquivo /some/input/file"));
		Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}
}
