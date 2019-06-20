package com.inforhomex.calculador;

import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity(name="Visitante")
@Table(name="visitante")
public class Visitante implements Serializable{
	
	private static final long serialVersionUID = 8799656478674716638L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@Column(name="fecha")
	private LocalDate fecha;
	@Column(name="comentario")
    private String comentario;
    
    public long getId(){
        return id;
    }

    public LocalDate getFecha(){
        return fecha;
    } 

    public String getComentario(){
        return comentario;
    }

    @Override
    public String toString(){
        return String.format("%d , %s, %s", this.id, this.comentario, this.fecha);
    }
}