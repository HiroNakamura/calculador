package com.inforhomex.calculador.config


import com.inforhomex.calculador.entity.Empleado;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FlatFileFormatException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;


@Configuration
@EnableBatchProcessing
public class SpringBatchConfig{

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, 
    StepBuilderFactory stepBuilderFactory,
    ItemReader<Empleado> itemReader,
    ItemProcessor<Empleado,Empleado> itemProcessor,
    ItemWriter<Empleado> itemWriter){

        Step step = stepBuilderFactory.get("ETL-file-load")
        .<Empleado, Empleado>chunk(100)
        .reader(itemReader)
        .processor(itemProcessor)
        .writer(itemWriter)
        .build();


        return jobBuilderFactory.get("ETL-Load")
        .incrementer(new RunIdIncrementer())
        .start(step)
        .build();
    }


    @Bean
    public FlatFileItemReader<Empleado> itemReader(@Value("${input}") Resource resource) {

        FlatFileItemReader<Empleado> flatFileItemReader = new FlatFileItemReader<>();
        try{
            flatFileItemReader.setResource(resource);
            flatFileItemReader.setName("CSV-Reader");
            flatFileItemReader.setLinesToSkip(1);
            flatFileItemReader.setLineMapper(lineMapper());
        }catch(FlatFileFormatException exFormat){
            System.err.println("Ha ocurrido un error de formato:\n"+exFormat.toString());
        }catch(FlatFileParseException exParse){
            System.err.println("Ha ocurrido un error de parseo:\n"+exParse.toString());
        }catch(Exception ex){
            System.err.println("Ha ocurrido una excepcion al tratar el archivo plano: "+ex.toString());
        }

        return flatFileItemReader;
    }

    @Bean
    public LineMapper<Empleado> lineMapper() {

        DefaultLineMapper<Empleado> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        try{
            lineTokenizer.setDelimiter(",");
            lineTokenizer.setStrict(false);
            lineTokenizer.setNames(new String[]{"nombre","apellido", "departamento", "salario"});
        }
        catch(Exception ex){
            System.err.println("Ha ocurrido una excepcion en el lineTokenizer:\n"+ex.toString());
        }
        

        BeanWrapperFieldSetMapper<Empleado> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Empleado.class);
        
        try{
            defaultLineMapper.setLineTokenizer(lineTokenizer);
            defaultLineMapper.setFieldSetMapper(fieldSetMapper);
        }catch(Exception ex){
            System.err.println("Ha ocurrido una excepcion en el lineMapper:\n"+ex.toString());
        }
        

        return defaultLineMapper;
    }
   
}
