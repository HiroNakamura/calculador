package com.inforhomex.calculador.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.inforhomex.calculador.tutorial.processor.PersonaItemProcessor;
import com.inforhomex.calculador.tutorial.model.Persona;


@Component
public class JobListener extends JobExecutionListenerSupport {

	private static final Logger LOG = LoggerFactory.getLogger(PersonaItemProcessor.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobListener(JdbcTemplate jdbcTemplate){
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution){
		if(jobExecution.getStatus() == BatchStatus.COMPLETED){
			LOG.info("FINALIZO EL JOB!!! Verifica los resultados");

			jdbcTemplate.query("SELECT nombre, apellido, telefono FROM persona", 
				(rs,row) -> new Persona(rs.getString(1),rs.getString(2),rs.getString(3)))
			.forEach(persona -> {
				LOG.info("Registro<"+persona+">");
			}
			);

		}
	}

}
