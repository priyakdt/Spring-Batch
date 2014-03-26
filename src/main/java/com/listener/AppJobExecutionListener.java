package com.listener;


import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.stereotype.Component;

@Component("appJobExecutionListener")
public class AppJobExecutionListener
  implements JobExecutionListener
{
  private static final Log log = LogFactory.getLog(AppJobExecutionListener.class);
  private Date startDate = null;
  private Date endDate = null;
  private String fromDate = null;
  private String throughDate = null;

  private static final Logger logger = Logger.getLogger(AppJobExecutionListener.class);

  public void afterJob(JobExecution jobExecution) {
    System.out.println("Options batch process completed...");
    this.endDate = jobExecution.getEndTime();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

    log.info("Job execution finished at " + jobExecution.getEndTime());
    log.info("JOB Instance ID:" + jobExecution.getJobInstance().getId());

    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("SUCCESS: Job finished successfully.");

      log.info("Total time taken by Job execution :" + (
        this.endDate.getTime() - this.startDate.getTime()) + " milliseconds.");

      log.warn("Extract creation date:" + formatter.format(this.endDate));
      log.warn("Total Time Taken :  " + 
        (jobExecution.getEndTime().getTime() - 
        jobExecution.getStartTime().getTime()) / 1000L + 
        " sec " + 
        (jobExecution.getEndTime().getTime() - 
        jobExecution.getStartTime().getTime()) / 1000L / 60L + 
        " min");

      log.warn("==========================================================================");
    }
    else if (jobExecution.getStatus() == BatchStatus.FAILED)
    {
      log.info("FAILURE: Error during execution.");
      log.info("::" + jobExecution.getFailureExceptions().toString());

      log.info("**************************************************************************");
    }

    if (jobExecution.getStatus() == BatchStatus.COMPLETED)
      logger.info("Job completed: " + jobExecution.getJobId());
    else if (jobExecution.getStatus() == BatchStatus.FAILED)
      logger.info("Job failed: " + jobExecution.getJobId());
  }

  public void beforeJob(JobExecution jobExecution)
  {
    System.out.println("OptionsJobListener batch process started...");
    setStartDate(jobExecution.getCreateTime());
    log.info("Job execution started at " + jobExecution.getCreateTime());
    Map paramMap = jobExecution.getJobInstance()
      .getJobParameters().getParameters();
    Object throughDate = paramMap.get("throughDate");
    Object fromDate = paramMap.get("fromDate");
    if (throughDate != null) {
      setThroughDate(((JobParameter)paramMap.get("throughDate")).toString());
    }

    if (fromDate != null)
    {
      setFromDate(((JobParameter)paramMap.get("fromDate")).toString());
    }
  }

  public Date getStartDate() {
    return this.startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return this.endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getFromDate() {
    return this.fromDate;
  }

  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }

  public String getThroughDate() {
    return this.throughDate;
  }

  public void setThroughDate(String throughDate) {
    this.throughDate = throughDate;
  }
}