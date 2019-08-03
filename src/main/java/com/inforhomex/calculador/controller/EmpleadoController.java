package com.inforhomex.calculador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/batch")
@RestController
public class EmpleadoController{

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    //http://localhost:8087/batch/empleados
    @GetMapping("/empleados")
    public BatchStatus empleados() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("Job ejecutandose ahora: " + jobExecution.getStatus());

        if("FAILED".equals(jobExecution.getStatus().toString())){
            System.out.println("El Job ha fallado: ");
        }

        System.out.println("El proceso por lotes (batch) esta corriendo...");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        return jobExecution.getStatus();
    }
}
