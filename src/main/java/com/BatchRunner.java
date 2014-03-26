package com;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;
import org.springframework.beans.factory.annotation.Autowired;

public class BatchRunner
{

  @Autowired
  private JobLauncher launcher;

  @Autowired
  private Job job;
  private JobParameters jobParameters = new JobParameters();

  @Autowired
  private static JobLauncher jobLauncher;

  public static void main(String[] args) {
    try {
      CommandLineJobRunner.main(new String[] { "classpath:Students-config.xml", "Student" });
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}


