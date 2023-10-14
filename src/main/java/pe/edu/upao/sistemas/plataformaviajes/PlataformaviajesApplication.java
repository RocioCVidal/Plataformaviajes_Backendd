package pe.edu.upao.sistemas.plataformaviajes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class PruebasTransaccionales {

	public static void main(String[] args) throws IOException {
		ArrayList<Experiencia> listaExperiencias = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		ArrayList<Recomendacion> listaRecomendaciones = new ArrayList<>();
		ArrayList<Itinerario> listaItinerarios = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n___________Menú Principal:___________");
			System.out.println("1. Crear perfil");
			System.out.println("2. Iniciar Sesión");
			System.out.println("3. Publicar experiencia");
			System.out.println("4. Publicar recomendaciones");
			System.out.println("5. Crear itinerario");
			System.out.println("6. Visualizar mi perfil");
			System.out.println("7. Visualizar experiencias");
			System.out.println("8. Visualizar recomendaciones");
			System.out.println("9. Editar perfil");
			System.out.println("10. Visualizar perfiles");
			System.out.println("11. Visualizar itinerario");
			System.out.println("0. Salir");
			System.out.print("Por favor, elija una opción: ");

			opcion = scanner.nextInt();

			switch (opcion) {
				case 1:

					System.out.println("Opción: Crear perfil");
					scanner.nextLine();
					System.out.print("Nombre: ");
					String nombre = scanner.nextLine();

					System.out.print("Apellido: ");
					String apellido = scanner.nextLine();

					System.out.print("correo: ");
					String correo = scanner.nextLine();

					System.out.print("Constraseña: ");
					String contrasena = scanner.nextLine();

					System.out.print("FEcha de nacimiento: ");
					String fechaNacimiento = scanner.nextLine();

					System.out.print("Sexo : ");
					String sexo = scanner.nextLine();

					System.out.print("Pais de origen: ");
					String paisOrigen = scanner.nextLine();

					System.out.print("Interes de viajes: ");
					String interesViaje = scanner.nextLine();

					System.out.print("Tipo de viajero: ");
					String tipoViajero = scanner.nextLine();

					System.out.print("Descripcion: ");
					String descripcion = scanner.nextLine();

					Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, contrasena, fechaNacimiento, sexo, paisOrigen, interesViaje, tipoViajero, descripcion);
					listaUsuarios.add(nuevoUsuario);
					System.out.println("EL perfil a sido creado Perfil creado exitosamente.");


					break;
				case 2:
					System.out.println("Opción: Iniciar Sesión");
					// Coloca aquí la lógica para iniciar sesión.
					break;
				case 3:
					System.out.println("Opción: Publicar experiencia");
					scanner.nextLine();
					System.out.print("Título de la experiencia: ");
					String tituloExperiencia = scanner.nextLine();

					System.out.print("Descripción de la experiencia: ");
					String descripcionExperiencia = scanner.nextLine();
					Experiencia nuevaExperiencia = new Experiencia(tituloExperiencia, descripcionExperiencia);
					listaExperiencias.add(nuevaExperiencia);
					System.out.println("Experiencia publicada exitosamente.");
					break;
				case 4:
					System.out.println("Opción: Publicar recomendaciones");
					System.out.println("Opción: Publicar recomendación");
					scanner.nextLine();
					System.out.print("Título de la recomendación: ");
					String tituloRecomendacion = scanner.nextLine();

					System.out.print("Descripción de la recomendación: ");
					String descripcionRecomendacion = scanner.nextLine();

					Recomendacion nuevaRecomendacion = new Recomendacion(tituloRecomendacion, descripcionRecomendacion);
					listaRecomendaciones.add(nuevaRecomendacion);
					System.out.println("Recomendación publicada exitosamente.");
					break;
				case 5:
					System.out.println("Opción: Crear itinerario");
					scanner.nextLine();
					System.out.print("Título del itinerario: ");
					String tituloItinerario = scanner.nextLine();

					System.out.print("Descripción del itinerario: ");
					String descripcionItinerario = scanner.nextLine();

					System.out.print("Fecha de inicio (DD/MM/YYYY): ");
					String fechaInicio = scanner.nextLine();

					System.out.print("Fecha de finalización (DD/MM/YYYY): ");
					String fechaFinalizacion = scanner.nextLine();

					Itinerario nuevoItinerario = new Itinerario(tituloItinerario, descripcionItinerario, fechaInicio, fechaFinalizacion);
					listaItinerarios.add(nuevoItinerario);
					System.out.println("Itinerario creado exitosamente.");
					break;
				case 6:
					System.out.println("Opción: Visualizar mi perfil");
					// Visualizar el perfil de un usuario (por ejemplo, el primero en la lista)
					System.out.println("Perfiles disponibles:");
					System.out.println("Perfiles disponibles:");

					for (Usuario usuario : listaUsuarios) {
						System.out.println("Nombre: " + usuario.getNombre());
						System.out.println("Apellido: " + usuario.getApellido());
						System.out.println("Correo: " + usuario.getCorreo());
						System.out.println("Fecha de Nacimiento: " + usuario.getFechaNacimiento());
						System.out.println("Sexo: " + usuario.getSexo());
						System.out.println("País de Origen: " + usuario.getPaisOrigen());
						System.out.println("Intereses de Viaje: " + usuario.getInteresesViaje());
						System.out.println("Tipo de Viajero: " + usuario.getTipoViajero());
						System.out.println("Descripción: " + usuario.getDescripcion());
						System.out.println("-----------------------------");
					}

					System.out.println("No se encontraron mas perfiles.");
					break;
				case 7:
					System.out.println("Opción: Visualizar experiencias");
					if (listaExperiencias.isEmpty()) {
						System.out.println("No se han publicado experiencias todavía.");
					} else {
						System.out.println("\nExperiencias publicadas:");
						for (Experiencia experiencia : listaExperiencias) {
							System.out.println("Título: " + experiencia.getTitulo());
							System.out.println("Descripción: " + experiencia.getDescripcion());
							System.out.println("-----------------------------");
						}
					}
					break;
				case 8:
					System.out.println("Opción: Visualizar recomendaciones");
					System.out.println("Opción: Visualizar recomendaciones");
					if (listaRecomendaciones.isEmpty()) {
						System.out.println("No se han publicado recomendaciones todavía.");
					} else {
						System.out.println("Recomendaciones publicadas:");
						for (Recomendacion recomendacion : listaRecomendaciones) {
							System.out.println("Título: " + recomendacion.getTitulo());
							System.out.println("Descripción: " + recomendacion.getDescripcion());
							System.out.println("-----------------------------");
						}
					}
					break;
				case 9:
					System.out.println("Opción: Editar perfil");
					// Coloca aquí la lógica para editar el perfil.
					break;
				case 10:
					System.out.println("Opción: Visualizar perfiles");
					// Coloca aquí la lógica para visualizar perfiles de otros usuarios.
					break;
				case 11:
					System.out.println("Opción: Visualizar itinerario");
					if (listaItinerarios.isEmpty()) {
						System.out.println("No se han creado itinerarios todavía.");
					} else {
						System.out.println("Itinerarios creados:");
						for (Itinerario itinerario : listaItinerarios) {
							System.out.println("Título: " + itinerario.getTitulo());
							System.out.println("Descripción: " + itinerario.getDescripcion());
							System.out.println("Fecha de inicio: " + itinerario.getFechaInicio());
							System.out.println("Fecha de finalización: " + itinerario.getFechaFinalizacion());
							System.out.println("-----------------------------");
						}
					}
					break;
				case 0:
					System.out.println("Saliendo del programa. ¡Hasta luego!");
					break;
				default:
					System.out.println("Opción no válida. Por favor, elija una opción válida.");
					break;
			}
		} while (opcion!=0);

}
}
