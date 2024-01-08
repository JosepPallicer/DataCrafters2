package Vista;

import Controlador.Controlador;
import Modelo.ArticulosEntity;
import Modelo.TipoclientesEntity;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.Scanner;

import static Controlador.Utilidades.getSessionFactory;

public class GestionOS {
    private final Controlador controlador;
    private final Scanner teclado;

    public GestionOS(Controlador controlador) {
        this.controlador = controlador;
        this.teclado = new Scanner(System.in);
    }


    public void inicio() {
        TipoclientesEntity tipoPremium = new TipoclientesEntity();
        tipoPremium.setTipo("premium");
        tipoPremium.setCuotaAnual(new BigDecimal("100.00")); // Ejemplo de cuota anual
        tipoPremium.setDescuentoEnvio(new BigDecimal("0.10")); // Ejemplo de descuento de envío

        TipoclientesEntity tipoEstandar = new TipoclientesEntity();
        tipoEstandar.setTipo("estandar");
        tipoEstandar.setCuotaAnual(new BigDecimal("50.00")); // Ejemplo de cuota anual
        tipoEstandar.setDescuentoEnvio(new BigDecimal("0.05")); // Ejemplo de descuento de envío

// Guardar en la base de datos utilizando Hibernate
        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(tipoPremium);
            session.saveOrUpdate(tipoEstandar);
            session.getTransaction().commit();
        }
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Gestión Articulo");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedido");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {

                case '1':
                    gestionArticulos();
                    break;

                case '2':
                    gestionClientes();
                    break;

                case '3':
                    gestionPedidos();
                    break;

                case '0':
                    salir = true;
            }
        } while (!salir);
    }


    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0):");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    public void gestionArticulos() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("Que desea hacer?");
            System.out.println("1. Añadir un artículo");
            System.out.println("2. Mostrar los artículos");
            System.out.println("3. Buscar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("0. Atrás");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    System.out.println("Introduce el nombre del artículo");
                    String nombre = teclado.nextLine();
                    System.out.println("Introduce la descripción del artículo");
                    String descripcion = teclado.nextLine();
                    System.out.println("Introduce el precio del artículo");
                    double precio = Double.parseDouble(teclado.nextLine());
                    System.out.println("Introduce las horas de preparación del artículo");
                    int tiempoPreparacion = Integer.parseInt(teclado.nextLine());
                    System.out.println("Introduce los gastos de envío del artículo");
                    double gastosEnvio = Double.parseDouble(teclado.nextLine());
                    controlador.agregarArticulo(nombre, descripcion, precio, tiempoPreparacion, gastosEnvio);
                    break;
                case '2':
                    controlador.mostrarArticulos();
                    break;
                case '3':
                    System.out.println("Introduce el nombre del artículo que quieres buscar:");
                    nombre = teclado.nextLine();
                    ArticulosEntity articuloEncontrado = controlador.buscarArticulo( nombre);
                    if (articuloEncontrado == null) {
                        System.out.println("El artículo con nombre: " + nombre + " no existe.");
                    } else {
                        System.out.println(articuloEncontrado);
                    }

                    break;
                case '4':
                    System.out.println("Introduce el ID del artículo que quieres eliminar:");
                    int idEliminar = Integer.parseInt(teclado.nextLine());
                    controlador.eliminarArticulo(idEliminar);
                    break;

                case '0':
                    salir = true;
                    break;

            }
        } while (!salir);
    }

    public void gestionClientes() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("¿Qué desea hacer con clientes?");
            System.out.println("1. Añadir un cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Eliminar un cliente");
            System.out.println("4. Buscar un cliente por NIF");
            System.out.println("0. Atrás");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    System.out.println("Introduce el NIF del cliente");
                    String nif = teclado.nextLine();
                    System.out.println("Introduce el email del cliente");
                    String email = teclado.nextLine();
                    System.out.println("Introduce el nombre del cliente");
                    String nombre = teclado.nextLine();
                    System.out.println("Introduce el primer apellido del cliente");
                    String apellido1 = teclado.nextLine();
                    System.out.println("Introduce el segundo apellido del cliente");
                    String apellido2 = teclado.nextLine();
                    System.out.println("Introduce el domicilio del cliente");
                    String domicilio = teclado.nextLine();
                    System.out.println("Introduce el tipo del cliente");
                    String tipo = teclado.nextLine();
                    controlador.agregarCliente(nif, email, nombre, apellido1, apellido2, domicilio, tipo);
                    break;
                case '2':
                    controlador.mostrarClientes();
                    break;
                case '3':
                    System.out.println("Introduce el NIF del cliente a eliminar");
                    nif = teclado.nextLine();
                    controlador.eliminarCliente(nif);
                    break;
                case '4':
                    System.out.println("Introduce el NIF del cliente a buscar");
                    nif = teclado.nextLine();
                    controlador.buscarCliente(nif);
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }

    private void gestionPedidos() {
        boolean salir = false;
        char opcion;

        do {
            System.out.println("¿Qué desea hacer con pedidos?");
            System.out.println("1. Crear un pedido");
            System.out.println("2. Mostrar todos los pedidos");
            System.out.println("3. Buscar un pedido por número");
            System.out.println("4. Eliminar un pedido");
            System.out.println("5. Mostrar pedidos enviados de un cliente");
            System.out.println("6. Mostrar pedidos pendientes de un cliente");
            System.out.println("0. Atrás");
            opcion = pedirOpcion();

            switch (opcion) {
                case '1':
                    crearPedido();
                    break;

                case '2':
                    controlador.mostrarPedidos();
                    break;

                case '3':
                    System.out.println("Introduce el número del pedido a buscar: ");
                    int numeroPedido = Integer.parseInt(teclado.nextLine());
                    controlador.buscarPedido(numeroPedido);
                    break;

                case '4':
                    System.out.println("Introduce el número del pedido a eliminar: ");
                    int numeroPedidoEliminar = Integer.parseInt(teclado.nextLine());
                    controlador.eliminarPedido(numeroPedidoEliminar);
                    break;

                case '5':
                    System.out.println(" Pedidos enviados: ");
                    controlador.mostrarPedidosEnviados();
                    break;

                case '6':
                    System.out.println("Pedidos pendientes:");
                    controlador.mostrarPedidosPendientes();
                    break;

                case '0':
                    salir = true;
            }
        } while (!salir);
    }

    private void crearPedido() {
        System.out.println("Introduce el NIF del cliente: ");
        String nifCliente = teclado.nextLine();

        System.out.println("Introduce el nombre del artículo: ");
        String nombreArticulo = teclado.nextLine();

        System.out.println("Introduce la cantidad: ");
        int cantidad = Integer.parseInt(teclado.nextLine());

        System.out.println("¿El pedido está enviado? (1 para SÍ/ 0 para NO): ");
        boolean enviado = Boolean.parseBoolean(teclado.nextLine());


        controlador.agregarPedido(nifCliente, nombreArticulo, cantidad, enviado);
    }

}