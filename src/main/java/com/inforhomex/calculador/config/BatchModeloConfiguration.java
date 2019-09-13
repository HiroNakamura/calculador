package com.inforhomex.calculador.config;

import javax.sql.DataSource;

import com.inforhomex.calculador.model.Modelo;
import com.inforhomex.calculador.processor.ModeloItemProcessor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@EnableBatchProcessing
public class BatchModeloConfiguration{
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;


    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/curso_udemy");
        dataSource.setUsername("postgres");
        dataSource.setPassword("5432");
        return dataSource;
    }
    
    @Bean
    public FlatFileItemReader<Modelo> reader(){
        FlatFileItemReader<Modelo> reader = new FlatFileItemReader<Modelo>();
        reader.setResource(new ClassPathResource("modelos.csv"));
        reader.setLineMapper(new DefaultLineMapper<Modelo>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "nombre" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Modelo>() {{
                setTargetType(Modelo.class);
            }});
        }});
        return reader;
    }
    
    @Bean
    public ModeloItemProcessor processor(){
        return new ModeloItemProcessor();
    }
    
    @Bean
    public JdbcBatchItemWriter<Modelo> writer(){
        JdbcBatchItemWriter<Modelo> writer = new JdbcBatchItemWriter<Modelo>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Modelo>());
        writer.setSql("INSERT INTO public.modelos(nombre) VALUES (:nombre)");
        writer.setDataSource(dataSource);
        return writer;
    }
    
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Modelo, Modelo> chunk(3)
        .reader(reader())
        .processor(processor())
        .writer(writer())
        .build();
    }
    
    @Bean
    public Job importModeloJob() {
        return jobBuilderFactory.get("importModeloJob")
        .incrementer(new RunIdIncrementer())
        .flow(step1())
        .end()
        .build();
    }
}