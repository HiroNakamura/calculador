

INSERT INTO public.notas(nombre,titulo,contenido) VALUES ('Umberto Eco','Sobre la esquizofrenia natural','Blah blah y blah');
INSERT INTO public.notas(nombre,titulo,contenido) VALUES ('Inmanuel Kant','Tratado de logica distopica','En muchas palabras...');
INSERT INTO public.notas(nombre,titulo,contenido) VALUES ('Hortencia Alcantara','Hablando de los sentimientos humanos','Creo que no escribire de esto');
INSERT INTO public.notas(nombre,titulo,contenido) VALUES ('Tirsio Gomora','Informe sobre ciegos','Y exponiendo el asunto tenemos que las gallinas ponen muchos huevos');


-- INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Juan','Lopez Lopez',1,23000.0);
-- INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Mariana','Alcantara Villegas',2,25000.0);
-- INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Ana Lilia','Torres Velardes',3,20000.0);
-- INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Hugo','Alvirdes Corona',3,24000.0);
-- INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Karla','Cortes Velez',1,16000.0);
-- INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Yuridiana','Lopez Valdez',1,23000.0);
-- INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Jacinto','Gutierrez Delarde',3,24000.0);
-- INSERT INTO public.empleados(nombre, apellido,depto, salario) VALUES('Adriana','Matamoros Mori',4,23000.0);


-- select notas.titulo, notas.nombre as autor,notas.contenido, now() as fecha  from public.notas as notas order by notas.nombre;
-- select notas.titulo, notas.nombre as autor,notas.contenido, now() as fecha  from public.notas as notas;