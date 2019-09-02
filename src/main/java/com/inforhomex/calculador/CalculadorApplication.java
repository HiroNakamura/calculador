package com.inforhomex.calculador;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.inforhomex.calculador.controller.CursoController;
import com.inforhomex.calculador.service.AutorServiceImpl;
import com.inforhomex.calculador.service.IAutorService;
import com.inforhomex.calculador.service.ILibroService;
import com.inforhomex.calculador.service.LibroServiceImpl;

//import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class CalculadorApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(CalculadorApplication.class);
	public static void main(String[] args) {
		LOG.info("La aplicación CalculadorApplication esta ejecutandose...\n"+LocalDateTime.now());
		//SpringApplication.run(CalculadorApplication.class, args);
		ApplicationContext context = SpringApplication.run(CalculadorApplication.class, args);
		CursoController cursoController = (CursoController) context.getBean("cursoController");
		System.out.println(cursoController.aplicacion("Billy Mortell"));
		System.out.println(context.getBean(CursoController.class).aplicacion("John Callager"));
		LOG.info("La aplicación CalculadorApplication ha finalizado...\n"+LocalDateTime.now());
		

		IAutorService autorService = (AutorServiceImpl) context.getBean("autorService");
		autorService.createAutor("Doris", "Lessing");
		ILibroService libroService = (LibroServiceImpl) context.getBean("libroService");
		libroService.createLibro("Las Abuelas", "No disponible", 3L);


		String[] nombres={"La gata mas barata","El general Arteaga","La insoportable vacuidad del Señor Fantoche"};
		new  CalculadorApplication().run(nombres);
		
		//testA(args);
		//testB();
		//testC();
		//testD();
		//testE();
		//testF();
		//testG(args);
		//testH();
		//testI();
		//testJ();
		//testK();
		//testL();
		//testM();
		//testN();
		//testO();
		//testP();
		//testQ();
		//testR();
	}


	@Override
    public void run(String ... args){
		LOG.info("Esto servira para algo...");
		for(String arg : args){
			System.out.println(arg);
			LOG.info("#"+arg);
		}
	}

	public static void testR(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MensajesServicioImpl mensajesServicio = (MensajesServicioImpl) context.getBean("mensajesServicioBean");
		Mensajes mensaje = mensajesServicio.getMensaje("es_ES");
		System.out.println("Id: "+mensaje.getId());
		System.out.println("Idioma: "+mensaje.getIdioma());
		System.out.println("Mensaje: "+mensaje.getMensaje());
	}

	public static void testQ(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ContenedorCaja contenedorCaja= (ContenedorCaja) context.getBean("contenedorBean");
		contenedorCaja.setCaja(new CajaImpl());
		contenedorCaja.abrir();
		contenedorCaja.cerrar();
	}

	public static void testP(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Administrador a= (AdministradorImplA) context.getBean("adminABean");
		System.out.println(a.getFecha());
		Administrador b= (AdministradorImplB) context.getBean("adminBBean");
		System.out.println(b.getFecha());
	}

	public static void testO(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MensajesServicioImpl mensajesServicio = (MensajesServicioImpl) context.getBean("mensajesServicioBean");
		List<Mensajes> mensajes = mensajesServicio.getTodo();
		System.out.println("Mensajes:");
		mensajes.forEach(System.out::println);
		System.out.println("\nEspañol: "+mensajesServicio.getMensaje("es_ES").mensaje
		+"\nInglés: "+mensajesServicio.getMensaje("en_EN").mensaje);
		mensajesServicio.crearMensaje("pt_PT","Olá Mundo");
	}

	public static void testN(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ExpresionesServidor serv = (ExpresionesServidor) context.getBean("expresionesServidorBean");
		System.out.println(serv);
	}

	public static void testM(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Servidor serv = (Servidor) context.getBean("servidorBean");
		System.out.println(serv);
	}

	public static void testL(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
    	ExtractorServicio extractorServicio = (ExtractorServicio)context.getBean("extractorServicio");
		extractorServicio.extraer();
	}

	public static void testK(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
    	MensajeroServicio mensajeroServicio = (MensajeroServicio)context.getBean("mensajeroServicio");
    	System.out.println(mensajeroServicio);
	}


	public static void testJ(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Vehiculo camioneta = (Vehiculo) context.getBean("camionetaBean");
		camioneta.conducir();
		Vehiculo motocicleta = (Vehiculo) context.getBean("motocicletaBean");
		motocicleta.conducir();
		Vehiculo bicicleta = (Vehiculo) context.getBean("bicicletaBean");
		bicicleta.conducir();
	}

	public static void testI(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		Medidor medidor = (Medidor) context.getBean("medidorBean");
		System.out.println("Resultado: "+medidor.calculo());//22.8
	}

	public static void testH(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		Jugador jugador = (Jugador) context.getBean("jugadorBean");
		jugador.mostrar();//Bienvenido al club Chivas.
	}

	public static void testG(String[] args){
		ConfigurableApplicationContext contexto = SpringApplication.run(CalculadorApplication.class, args);
		MiServicio obj = contexto.getBean(MiServicio.class);
		obj.setMessage("El gato de Ribola");
		System.out.println(obj.getMessage());
	}

	public static void testF(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		AyudaImpresion ayudaImpresion = (AyudaImpresion) context.getBean("ayudaImpresionBean");
		ayudaImpresion.imprimir();//Imprimiendo documento .doc
	}

	public static void testE(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Punto obj = (Punto) context.getBean("puntoBean");
		obj.imprimir();
		obj.setX(new Double("32.1"));
		obj.setY(31.6);
		obj.imprimir();
	}

	public static void testD(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Punto obj = (Punto) context.getBean("puntoBean");
		obj.imprimir();
	}

	public static void testC(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Celsius obj = (Celsius) context.getBean("celsiusBean");
		obj.imprimirCelsius(new Double("123.5"));
	}

	public static void testB(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HolaMundo obj = (HolaMundo) context.getBean("holaBean");
		obj.imprimir();
	}

	public static void testA(String[] args){
		ConfigurableApplicationContext contexto = SpringApplication.run(CalculadorApplication.class, args);
		Objeto obj = contexto.getBean(Objeto.class);
		System.out.println("Fecha de hoy: "+LocalDate.now());
		obj.mostrar();
		obj.setId(2);
		obj.setNombre("Omega");
		obj.setValor("El Apocalipsis Now !!");
		obj.setModelo(new Modelo(2,"Tomahak"));
		obj.mostrar();
	} 

}
