package com.inforhomex.calculador.entity;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name = "Empleado")
@Table(name="empleados")
public class Empleado implements Serializable,Comparator<Empleado>,Comparable<Empleado>{

    private static final long serialVersionUID = 22L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    private String nombre;
    private String apellido;
    
    private Integer departamento;

    private Double salario;

    public Empleado(){}

    public Empleado(Integer id, String nombre, String apellido, Integer departamento,Double salario){
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
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
    public int compareTo(Empleado emp) {
        return this.nombre.compareTo(emp.nombre);
    }

    @Override
    public int compare(Empleado emp1, Empleado emp2) {
        return emp1.getId() - emp2.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleado emp = (Empleado) o;

        return id != null ? id.equals(emp.id) : emp.id == null;
    }

    

    @Override
    public String toString(){
        return "Empleado{ id:"+id+",nombre:"+nombre+ ",apellido: "+apellido+",departamento: "+departamento+",salario: "+salario+"}";
    }

} 
