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

   private String valor;
   private Nodo nodo;
   
   public Nodo(){}

   public Nodo(String valor, Nodo nodo){
      this.valor = valor;
      this.nodo = nodo;
   }
  
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Nodo getNodo() {
      return nodo;
   }

   public void setNodo(Nodo nodo) {
      this.nodo = nodo;
   }

   public String getValor() {
      return valor;
   }

   public void setValor(String valor) {
      this.valor = valor;
   }

   @Override 
   public String toString(){
      return "Nodo{valor = "+valor+", Nodo = "+nodo+"}";
   }
   
}
