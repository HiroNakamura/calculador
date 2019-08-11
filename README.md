# Calculador: Serie de ejercicios en Spring Boot (ahora es un proyecto REST y Batch)


![Spring Boot con Maven](https://2.bp.blogspot.com/-7HqbqD5PNx8/XKLczkxqeDI/AAAAAAAAAE8/PadnAcp-SbIev5575wG002ELrN18qvrHACLcBGAs/s1600/laptop-1209008_960_720.jpg)




## Es necesario contar con Maven instalado


**Instalar**

```
$ mvn clean install
```


**Ejecutar**

```
$ mvn spring-boot:run
```


### REST


**Abrir navegador en:**

http://localhost:8090/curso/index


### Front-end Javascript

**Abrir navegador en:**

Usando http-server 

```
$ http-server front-end/
```

http://localhost:8080


### Correr el batch

```
$ mvn spring-boot:run
```

**Ir a**

http://localhost:8090/batch/empleados


**Consultas**

Consultas SQL.


```
 INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Juan','Lopez Lopez',1,23000.0);

INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Mariana','Alcantara Villegas',2,25000.0);

INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Ana Lilia','Torres Velardes',3,20000.0);

INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Hugo','Alvirdes Corona',3,24000.0);

INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Karla','Cortes Velez',1,16000.0);

INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Yuridiana','Lopez Valdez',1,23000.0);

INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Jacinto','Gutierrez Delarde',3,24000.0);

INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Adriana','Matamoros Mori',4,23000.0);

SELECT autor.id, CONCAT(autor.nombre,' ',autor.apellido) as escritor, libro.titulo FROM public.autores AS autor INNER JOIN public.libros AS libro ON autor.id=libro.autor_id ;


select notas.titulo, notas.nombre as autor,notas.contenido, now() as fecha  from public.notas as notas order by notas.nombre;

select notas.titulo, notas.nombre as autor,notas.contenido, now() as fecha  from public.notas as notas;

```