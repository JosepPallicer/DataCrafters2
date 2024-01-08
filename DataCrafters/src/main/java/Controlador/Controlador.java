
package Controlador;
import Modelo.TipoclientesEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import Modelo.ClientesEntity;
import Modelo.PedidosEntity;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Modelo.ArticulosEntity;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Controlador.Utilidades.sessionFactory;

public class Controlador implements AutoCloseable {

    public void agregarArticulo(String nombre, String descripcion, double precio, int tiempoPreparacion, double gastosEnvio) {
        // Crear una instancia de Articulo
        ArticulosEntity articulo = new ArticulosEntity();
        articulo.setNombre(nombre);
        articulo.setDescripcion(descripcion);
        articulo.setPrecio(BigDecimal.valueOf(precio));
        articulo.setTiempoPreparacion(tiempoPreparacion);
        articulo.setGastosEnvio(BigDecimal.valueOf(gastosEnvio));

        // Uso de la sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            session.beginTransaction();

            // Guardar el artículo
            session.persist(articulo);

            // Comprometer la transacción
            session.getTransaction().commit();

            System.out.println("Artículo creado satisfactoriamente");
        } catch (Exception e) {
            System.err.println("Error al agregar el artículo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarArticulo(int idCodigo) {
        // Uso de la sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            session.beginTransaction();

            // Buscar el artículo a eliminar
            ArticulosEntity articulo = session.get(ArticulosEntity.class, idCodigo);

            if (articulo != null) {
                // Eliminar el artículo
                session.remove(articulo);

                // Comprometer la transacción
                session.getTransaction().commit();
                System.out.println("Articulo eliminado satisfactoriamente");
            } else {
                System.out.println("Artículo no encontrado con el ID: " + idCodigo);
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar el artículo: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public List<ArticulosEntity> mostrarArticulos() {
        List<ArticulosEntity> articulos = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM ArticulosEntity";
            articulos = session.createQuery(hql, ArticulosEntity.class).list();
        } catch (Exception e) {
            System.err.println("Error al mostrar los artículos: " + e.getMessage());
            e.printStackTrace();
            return null; // O manejar la excepción de alguna otra manera
        }
        return articulos;
    }


    public ArticulosEntity buscarArticulo(String nombre) {
        try (Session session = sessionFactory.openSession()) {
            // Crear una consulta HQL para buscar el artículo por nombre
            String hql = "FROM ArticulosEntity WHERE nombre = :nombre";
            Query query = session.createQuery(hql, ArticulosEntity.class);
            query.setParameter("nombre", nombre);

            // Obtener el resultado
            ArticulosEntity articulo = (ArticulosEntity) query.uniqueResult();

            if (articulo != null) {
                System.out.println("Artículo encontrado:");
                System.out.println("Nombre: " + articulo.getNombre());
                System.out.println("Descripción: " + articulo.getDescripcion());
                System.out.println("Precio: " + articulo.getPrecio());
                System.out.println("Tiempo de Preparación: " + articulo.getTiempoPreparacion());
                System.out.println("Gastos de Envío: " + articulo.getGastosEnvio());
                return articulo; // Devuelve el artículo encontrado
            } else {
                System.out.println("Artículo no encontrado, asegúrate de poner correctamente el nombre.");
                return null; // Devuelve null si no se encuentra el artículo
            }
        } catch (Exception e) {
            System.err.println("Error al buscar el artículo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String agregarCliente(String p_nif, String p_email, String p_nombre, String p_apellido1, String p_apellido2, String p_domicilio, String p_tipo) {
        // Crear una instancia de Cliente
        ClientesEntity cliente = new ClientesEntity();
        cliente.setNif(p_nif);
        cliente.setEmail(p_email);
        cliente.setNombre(p_nombre);
        cliente.setApellido1(p_apellido1);
        cliente.setApellido2(p_apellido2);
        cliente.setDomicilio(p_domicilio);
        cliente.setTipo(p_tipo);

        // Uso de la sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            session.beginTransaction();

            TipoclientesEntity tipoCliente = buscarTipoClientePorTipo(session); // Utiliza la sesión de Hibernate
            cliente.setTipoCliente(tipoCliente); // Asignar el tipo al cliente

            // Guardar el cliente
            session.persist(cliente);

            // Comprometer la transacción
            session.getTransaction().commit();

            System.out.println("Cliente agregado satisfactoriamente");
            return "Cliente agregado satisfactoriamente";
        } catch (Exception e) {
            System.err.println("Error al agregar el cliente: " + e.getMessage());
            e.printStackTrace();
            return "Error al agregar el cliente: " + e.getMessage();
        }
    }

    private TipoclientesEntity buscarTipoClientePorTipo(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TipoclientesEntity> criteria = builder.createQuery(TipoclientesEntity.class);
        Root<TipoclientesEntity> root = criteria.from(TipoclientesEntity.class);
        criteria.select(root).where(builder.equal(root.get("tipo"), "premium"));

        try {
            TipoclientesEntity tipoCliente = session.createQuery(criteria).uniqueResult();
            return tipoCliente; // Puede ser null si no se encuentra el tipo de cliente
        } catch (Exception e) {
            System.err.println("Error al buscar tipo de cliente por tipo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    public List<ClientesEntity> mostrarClientes() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM ClientesEntity";
            return session.createQuery(hql, ClientesEntity.class).list();
        } catch (Exception e) {
            System.err.println("Error al mostrar clientes: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public String eliminarCliente(String nif) {
        String mensaje;
        // Uso de la sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            session.beginTransaction();

            // Buscar el cliente por NIF
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ClientesEntity> criteria = builder.createQuery(ClientesEntity.class);
            Root<ClientesEntity> root = criteria.from(ClientesEntity.class);
            criteria.select(root).where(builder.equal(root.get("nif"), nif));
            ClientesEntity cliente = session.createQuery(criteria).uniqueResult();

            // Si el cliente existe, eliminarlo
            if (cliente != null) {
                session.remove(cliente);
                mensaje = "Cliente eliminado satisfactoriamente";
                System.out.println(mensaje);
            } else {
                mensaje = "Cliente no encontrado con el NIF: " + nif;
                System.out.println(mensaje);
            }

            // Comprometer la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
            e.printStackTrace();
            mensaje = "Error al eliminar el cliente: " + e.getMessage();
        }

        return mensaje;
    }

    public ClientesEntity buscarCliente(String nif) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ClientesEntity> query = builder.createQuery(ClientesEntity.class);
            Root<ClientesEntity> root = query.from(ClientesEntity.class);
            query.select(root).where(builder.equal(root.get("nif"), nif));

            return session.createQuery(query).uniqueResult();
        } catch (Exception e) {
            System.err.println("Error al buscar el cliente: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    public List<PedidosEntity> mostrarPedidos() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM PedidosEntity";
            return session.createQuery(hql, PedidosEntity.class).list();
        } catch (Exception e) {
            System.err.println("Error al mostrar los pedidos: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    public PedidosEntity buscarPedido(int numeroPedido) {
        PedidosEntity pedido = null;
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM PedidosEntity WHERE idNumeroPedido = :numeroPedido";
            Query<PedidosEntity> query = session.createQuery(hql, PedidosEntity.class);
            query.setParameter("numeroPedido", numeroPedido);
            pedido = query.uniqueResult();

            // Inicializar las entidades asociadas (si son perezosas) mientras la sesión esté abierta
            if (pedido != null && pedido.getIdClientes() != null) {
                Hibernate.initialize(pedido.getIdClientes());
            }
        } catch (Exception e) {
            System.err.println("Error al buscar el pedido: " + e.getMessage());
            e.printStackTrace();
        }
        return pedido;
    }


    public void eliminarPedido(int numeroPedido) {
        // Uso de la sesión de Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            session.beginTransaction();

            // Buscar el pedido por número de pedido
            PedidosEntity pedido = session.get(PedidosEntity.class, numeroPedido);
            if (pedido != null) {
                // Eliminar el pedido
                session.remove(pedido);
                System.out.println("Pedido eliminado satisfactoriamente.");

                // Comprometer la transacción
                session.getTransaction().commit();
            } else {
                System.out.println("No se encontró ningún pedido con ese número para eliminar.");
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar el pedido: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public List<PedidosEntity> mostrarPedidosEnviados() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM PedidosEntity WHERE enviado != 0";
            return session.createQuery(hql, PedidosEntity.class).list();
        } catch (Exception e) {
            System.err.println("Error al mostrar los pedidos enviados: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    public List<PedidosEntity> mostrarPedidosPendientes() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM PedidosEntity WHERE enviado = 0";
            return session.createQuery(hql, PedidosEntity.class).list();
        } catch (Exception e) {
            System.err.println("Error al mostrar pedidos pendientes: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    public void agregarPedido(String nifCliente, String nombreArticulo, int cantidad, boolean enviado) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            // Buscar cliente y artículo por sus identificadores.
            ClientesEntity cliente = buscarClientePorNif(nifCliente, session);
            ArticulosEntity articulo = buscarArticuloPorNombre(nombreArticulo, session);

            if (cliente != null && articulo != null) {
                // Crear una instancia de Pedido
                PedidosEntity pedido = new PedidosEntity();

                // Configurar el pedido con la información proporcionada y las entidades relacionadas
                pedido.setIdCliente(cliente.getIdCliente());
                pedido.setIdArticulo(articulo.getIdCodigo());
                pedido.setCantidad(cantidad);
                pedido.setFechaHora(new Timestamp(System.currentTimeMillis()));
                pedido.setEnviado((byte) (enviado ? 1 : 0));

                pedido.setPagado((byte) 0);

                // Guardar el pedido
                session.persist(pedido);

                // Comprometer la transacción
                tx.commit();
                System.out.println("Pedido creado satisfactoriamente.");
            } else {
                System.out.println("Error: El cliente o el artículo no existe");
                if (tx != null) tx.rollback();
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error al agregar el pedido: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private ClientesEntity buscarClientePorNif(String nif, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ClientesEntity> criteria = builder.createQuery(ClientesEntity.class);
        Root<ClientesEntity> root = criteria.from(ClientesEntity.class);
        criteria.select(root).where(builder.equal(root.get("nif"), nif));
        try {
            ClientesEntity cliente = session.createQuery(criteria).uniqueResult();
            return cliente; // Puede ser null si no se encuentra el cliente
        } catch (Exception e) {
            System.err.println("Error al buscar cliente por NIF: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    private ArticulosEntity buscarArticuloPorNombre(String nombre, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ArticulosEntity> criteria = builder.createQuery(ArticulosEntity.class);
        Root<ArticulosEntity> root = criteria.from(ArticulosEntity.class);
        criteria.select(root).where(builder.equal(root.get("nombre"), nombre));
        try {
            ArticulosEntity articulo = session.createQuery(criteria).uniqueResult();
            return articulo; // Puede ser null si no se encuentra el artículo
        } catch (Exception e) {
            System.err.println("Error al buscar artículo por nombre: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void close() throws Exception {

    }
}
