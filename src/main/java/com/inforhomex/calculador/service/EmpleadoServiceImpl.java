package com.inforhomex.calculador.service;

import com.inforhomex.calculador.entity.Empleado;
import com.inforhomex.calculador.repository.EmpleadoRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("empleadoServiceImpl")
public class EmpleadoServiceImpl implements CrudService<Empleado,Integer>{

    @Autowired
    public EmpleadoRepository empleadoRepository;

    @Override
    @Transactional(readOnly = true)
    public Set<Empleado> findAll(){
        List<Empleado> listaEmpleados = empleadoRepository.findAll();
        Set<Empleado> emps = new HashSet<>();
        listaEmpleados.forEach(emp->{
            emps.add(emp);
        });
        return emps;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Empleado findById(Integer id){
        return empleadoRepository.getOne(id);
    }

   @Override 
   @Transactional
   public Empleado save(Empleado emp){
       return empleadoRepository.save(emp);
   }

   @Override
   @Transactional
   public void delete(Empleado emp){
       empleadoRepository.delete(emp);
   }

   @Override
   @Transactional
   public void deleteById(Integer id){
       empleadoRepository.deleteById(id);
   }

}