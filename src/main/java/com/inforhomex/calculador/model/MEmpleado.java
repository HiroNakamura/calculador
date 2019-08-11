package com.inforhomex.calculador.model;

import java.io.Serializable;
import java.util.Comparator;
import com.inforhomex.calculador.entity.Empleado;


public class MEmpleado implements Serializable,Comparator<MEmpleado>,Comparable<MEmpleado>{

    private static final long serialVersionUID = 7L;

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer departamento;
    private Double salario;

    public MEmpleado(Empleado empleado){
        this.id = empleado.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public int compareTo(MEmpleado emp) {
        return this.nombre.compareTo(emp.nombre);
    }

    @Override
    public int compare(MEmpleado emp1, MEmpleado emp2) {
        return emp1.getId() - emp2.getId();
    }

    @Override
    public String toString(){
        return "MEmpleado{ id:"+id+",nombre:"+nombre+ ",apellido: "+apellido+",departamento: "+departamento+",salario: "+salario+"}";
    }

}