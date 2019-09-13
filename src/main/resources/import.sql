INSERT INTO public.notas(nombre,titulo,contenido) VALUES ('Umberto Eco','Sobre la esquizofrenia natural','Blah blah y blah');
INSERT INTO public.notas(nombre,titulo,contenido) VALUES ('Inmanuel Kant','Tratado de logica distopica','En muchas palabras...');
INSERT INTO public.notas(nombre,titulo,contenido) VALUES ('Hortencia Alcantara','Hablando de los sentimientos humanos','Creo que no escribire de esto');
INSERT INTO public.notas(nombre,titulo,contenido) VALUES ('Tirsio Gomora','Informe sobre ciegos','Y exponiendo el asunto tenemos que las gallinas ponen muchos huevos');

INSERT INTO public.autores(nombre,apellido) VALUES('José','Saramago');
INSERT INTO public.libros(titulo,isbn,autor_id) VALUES('Manual de pintura y caligrafia','',1);
INSERT INTO public.libros(titulo,isbn,autor_id) VALUES('Todos los nombres','',1);
INSERT INTO public.libros(titulo,isbn,autor_id) VALUES('La balsa de piedra','',1);
INSERT INTO public.libros(titulo,isbn,autor_id) VALUES('Cain','',1);

INSERT INTO public.autores(nombre,apellido) VALUES('Arturo','Perez Reverte');
INSERT INTO public.libros(titulo,isbn,autor_id) VALUES('El club Dumas','',2);
INSERT INTO public.libros(titulo,isbn,autor_id) VALUES('La Reina del Sur','',2);
INSERT INTO public.libros(titulo,isbn,autor_id) VALUES('La tabla de Flandes','',2);


INSERT INTO public.empleados(nombre,apellido,departamento,salario) VALUES('Hugo','Navarro',2,22000.0);
INSERT INTO public.empleados(nombre,apellido,departamento,salario) VALUES('Irene','Almodovar',1,26000.0);
INSERT INTO public.empleados(nombre,apellido,departamento,salario) VALUES('Xavier','Jimenez',4,15500.0);


CREATE TABLE public.modelos(id serial PRIMARY KEY, nombre varchar(150) not null);

