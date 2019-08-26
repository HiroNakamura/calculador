package com.inforhomex.calculador.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="Nodo")
@Table(name="nodos")
public class Nodo implements Serializable  {
   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   public Nodo(){}
   
}
