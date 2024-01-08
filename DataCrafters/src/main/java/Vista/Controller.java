package Vista;

import Controlador.Controlador;
import Modelo.ArticulosEntity;
import Modelo.ClientesEntity;
import Modelo.PedidosEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Controller {
    private final Controlador controlador = new Controlador();
    @FXML
    public TextField idCodigoArticulo;

    @FXML
    private TextField nombreArticulo;
    @FXML
    private TextField descripcionArticulo;
    @FXML
    private TextField precioArticulo;
    @FXML
    private TextField horasPreparacionArticulo;
    @FXML
    private TextField gastosEnvioArticulo;
    @FXML
    public TextField nombreBuscarArticulo;
    @FXML
    public Label resultadoBusquedaArticulo;

    @FXML
    private TextField nifCliente;
    @FXML
    private TextField emailCliente;
    @FXML
    private TextField nombreCliente;
    @FXML
    private TextField apellido1Cliente;
    @FXML
    private TextField apellido2Cliente;
    @FXML
    private TextField domicilioCliente;
    @FXML
    private TextField tipoCliente;
    @FXML
    public TextField nifBuscarCliente;
    @FXML
    public Label resultadoBusquedaCliente;

    @FXML
    public TextField nifClientePedido;
    @FXML
    public TextField nombreArticuloPedido;
    @FXML
    public TextField cantidadPedido;
    @FXML
    public CheckBox enviadoConfirmacion;
    @FXML
    public TextField numeroPedido;
    @FXML
    public TextField numeroBuscarPedido;
    @FXML
    public Label resultadoBusquedaPedido;



    @FXML
    private TableView<ArticulosEntity> tablaArticulos;
    @FXML
    public TableColumn<ArticulosEntity, String> idCodigoArticuloLista;
    @FXML
    private TableColumn<ArticulosEntity, String> nombreArticuloLista;
    @FXML
    private TableColumn<ArticulosEntity, String> descripcionArticuloLista;
    @FXML
    private TableColumn<ArticulosEntity, Double> precioArticuloLista;
    @FXML
    private TableColumn<ArticulosEntity, Integer> horasPreparacionArticuloLista;
    @FXML
    private TableColumn<ArticulosEntity, Double> gastosEnvioArticuloLista;

    private final ObservableList<ArticulosEntity> listaArticulos = FXCollections.observableArrayList();

    @FXML
    private TableView<ClientesEntity> tablaClientes;
    @FXML
    public TableColumn<ClientesEntity, String> idClienteLista;
    @FXML
    public TableColumn<ClientesEntity, String> nifClienteLista;
    @FXML
    public TableColumn<ClientesEntity, String> emailClienteLista;
    @FXML
    public TableColumn<ClientesEntity, String> nombreClienteLista;
    @FXML
    public TableColumn<ClientesEntity, String> apellido1ClienteLista;
    @FXML
    public TableColumn<ClientesEntity, String> apellido2ClienteLista;
    @FXML
    public TableColumn<ClientesEntity, String> domicilioClienteLista;
    @FXML
    public TableColumn<ClientesEntity, String> tipoClienteLista;

    private final ObservableList<ClientesEntity> listaClientes = FXCollections.observableArrayList();

    @FXML
    private TableView<PedidosEntity> tablaPedidos;
    @FXML
    public TableView <PedidosEntity> tablaPedidosEnviados;
    @FXML
    public TableView <PedidosEntity> tablaPedidosPendientes;
    @FXML
    public TableColumn<PedidosEntity, String> numeroPedidosLista;
    @FXML
    public TableColumn<PedidosEntity, String> idClientePedidosLista;
    @FXML
    public TableColumn<PedidosEntity, String> fechaHoraPedidosLista;
    @FXML
    public TableColumn<PedidosEntity, String> enviadoPedidosLista;
    @FXML
    public TableColumn<PedidosEntity, String> pagadoPedidosLista;

    private final ObservableList<PedidosEntity> listaPedidos = FXCollections.observableArrayList();
    private final ObservableList<PedidosEntity> listaPedidosEnviados = FXCollections.observableArrayList();
    private final ObservableList<PedidosEntity> listaPedidosPendientes = FXCollections.observableArrayList();


    @FXML
    public void abrirOnlineStore(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stageActual = (Stage) source.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/menu-principal.fxml"));
            Parent root = fxmlLoader.load();
            Stage nuevoStage = new Stage();
            nuevoStage.setScene(new Scene(root));
            nuevoStage.show();

            stageActual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirGestionArticulos(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/gestion-articulos.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirGestionClientes(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/gestion-clientes.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirGestionPedidos(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/gestion-pedidos.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirAnadirArticulo(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/anadir-articulo.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirMostrarArticulos(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/lista-articulos.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirBuscarArticulo(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/buscar-articulo.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirEliminarArticulo(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/eliminar-articulo.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirAnadirCliente(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/anadir-cliente.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirMostrarClientes(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/lista-clientes.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirEliminarCliente(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/eliminar-cliente.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirBuscarClienteNIF(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/buscar-cliente.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirAnadirPedido(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/anadir-pedido.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirMostrarPedidos(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/lista-pedidos.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirBuscarPedido(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/buscar-pedido.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirEliminarPedido(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/eliminar-pedido.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirMostrarPedidosEnviados(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/lista-pedidosEnviados.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void abrirMostrarPedidosPendientes(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Pantallas/lista-pedidosPendientes.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void botonAnadirArticulo(ActionEvent event) {

        try{
            String nombre = nombreArticulo.getText();
            String descripcion = descripcionArticulo.getText();
            double precio = Double.parseDouble(precioArticulo.getText());
            int horasPreparacion = Integer.parseInt(horasPreparacionArticulo.getText());
            double gastosEnvio = Double.parseDouble(gastosEnvioArticulo.getText());

            controlador.agregarArticulo(nombre, descripcion, precio, horasPreparacion, gastosEnvio);

            // Mensaje de confirmación
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Artículo Añadido");
            alert.setHeaderText(null);
            alert.setContentText("El artículo ha sido añadido con éxito.");
            alert.showAndWait();

            //Mensaje de error
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Formato");
            alert.setHeaderText(null);
            alert.setContentText("Error al introducir el artículo.");
            alert.showAndWait();
        }

        // Limpiar los campos después de agregar el artículo
        nombreArticulo.clear();
        descripcionArticulo.clear();
        precioArticulo.clear();
        horasPreparacionArticulo.clear();
        gastosEnvioArticulo.clear();
    }

    @FXML
    private void botonActualizarArticulos(ActionEvent event) {
        mapeoColumnasArticulos();
        List<ArticulosEntity> articulos = controlador.mostrarArticulos();
        if (articulos != null) {
            listaArticulos.clear();
            listaArticulos.addAll(articulos);
            tablaArticulos.setItems(listaArticulos);
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pueden actualizar los artículos");
            alert.setContentText("Ocurrió un error al intentar actualizar los artículos de la base de datos.");

            alert.showAndWait();
        }
    }

    private void mapeoColumnasArticulos() {
        idCodigoArticuloLista.setCellValueFactory(new PropertyValueFactory<>("idCodigo"));
        nombreArticuloLista.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descripcionArticuloLista.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        precioArticuloLista.setCellValueFactory(new PropertyValueFactory<>("precio"));
        horasPreparacionArticuloLista.setCellValueFactory(new PropertyValueFactory<>("tiempoPreparacion"));
        gastosEnvioArticuloLista.setCellValueFactory(new PropertyValueFactory<>("gastosEnvio"));
    }

    @FXML
    private void botonActualizarClientes(ActionEvent event){
        mapeoColumnasClientes();
        List<ClientesEntity> clientes = controlador.mostrarClientes();
        if (clientes != null) {
            listaClientes.clear();
            listaClientes.addAll(clientes);
            tablaClientes.setItems(listaClientes);
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pueden actualizar los clientes");
            alert.setContentText("Ocurrió un error al intentar actualizar los clientes de la base de datos.");

            alert.showAndWait();
        }
    }

    private void mapeoColumnasClientes() {
        idClienteLista.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        nifClienteLista.setCellValueFactory(new PropertyValueFactory<>("nif"));
        emailClienteLista.setCellValueFactory(new PropertyValueFactory<>("email"));
        nombreClienteLista.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellido1ClienteLista.setCellValueFactory(new PropertyValueFactory<>("apellido1"));
        apellido2ClienteLista.setCellValueFactory(new PropertyValueFactory<>("apellido2"));
        domicilioClienteLista.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        tipoClienteLista.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    }

    @FXML
    private void botonActualizarPedidos(ActionEvent event){
        mapeoColumnasPedidos();
        List<PedidosEntity> pedidos = controlador.mostrarPedidos();
        if (pedidos != null) {
            listaPedidos.clear();
            listaPedidos.addAll(pedidos);
            tablaPedidos.setItems(listaPedidos);
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pueden actualizar los pedidos");
            alert.setContentText("Ocurrió un error al intentar actualizar los pedidos de la base de datos.");

            alert.showAndWait();
        }
    }

    @FXML
    private void botonActualizarPedidosEnviados(ActionEvent event){
        mapeoColumnasPedidos();
        List<PedidosEntity> pedidosEnviados = controlador.mostrarPedidosEnviados();
        if (pedidosEnviados != null) {
            listaPedidosEnviados.clear();
            listaPedidosEnviados.addAll(pedidosEnviados);
            tablaPedidosEnviados.setItems(listaPedidosEnviados);
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pueden actualizar los pedidos enviados");
            alert.setContentText("Ocurrió un error al intentar actualizar los pedidos enviados de la base de datos.");

            alert.showAndWait();
        }
    }

    @FXML
    private void botonActualizarPedidosPendientes(ActionEvent event){
        mapeoColumnasPedidos();
        List<PedidosEntity> pedidosPendientes = controlador.mostrarPedidosPendientes();
        if (pedidosPendientes != null) {
            listaPedidosPendientes.clear();
            listaPedidosPendientes.addAll(pedidosPendientes);
            tablaPedidosPendientes.setItems(listaPedidosPendientes);
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pueden actualizar los pedidos pendientes");
            alert.setContentText("Ocurrió un error al intentar actualizar los pedidos pendientes de la base de datos.");

            alert.showAndWait();
        }
    }

    private void mapeoColumnasPedidos() {
        numeroPedidosLista.setCellValueFactory(new PropertyValueFactory<>("idNumeroPedido"));
        idClientePedidosLista.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        fechaHoraPedidosLista.setCellValueFactory(new PropertyValueFactory<>("fechaHora"));
        enviadoPedidosLista.setCellValueFactory(new PropertyValueFactory<>("enviado"));
        pagadoPedidosLista.setCellValueFactory(new PropertyValueFactory<>("pagado"));
    }

    @FXML
    private void botonEliminarArticulo(ActionEvent event) {
        try {
            int idCodigo = Integer.parseInt(idCodigoArticulo.getText());
            controlador.eliminarArticulo(idCodigo);

            // Mensaje de confirmación
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Artículo Eliminado");
            alert.setHeaderText(null);
            alert.setContentText("El artículo ha sido eliminado con éxito.");
            alert.showAndWait();

            //Mensaje de error
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Formato");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, introduce un ID de artículo válido.");
            alert.showAndWait();
        }

        // Limpia el campo de texto
        idCodigoArticulo.clear();

    }

    @FXML
    private void botonBuscarArticulo(ActionEvent event) {
        String nombre = nombreBuscarArticulo.getText();
        ArticulosEntity articulo = controlador.buscarArticulo(nombre);

        if (articulo != null) {
            // Mostrar los detalles del artículo
            resultadoBusquedaArticulo.setText(
                    "Nombre: " + articulo.getNombre() + "\n" +
                    "Descripción: " + articulo.getDescripcion() + "\n" +
                    "Precio: " + articulo.getPrecio() + "\n" +
                    "Tiempo de Preparación: " + articulo.getTiempoPreparacion() + "\n" +
                    "Gastos de Envío: " + articulo.getGastosEnvio());
        } else {
            // Mostrar mensaje de que no se encontró el artículo
            resultadoBusquedaArticulo.setText("Artículo no encontrado, asegúrate de poner correctamente el nombre.");
        }

        // Limpia el campo de texto
        nombreBuscarArticulo.clear();
    }

    @FXML
    private void botonAnadirCliente(ActionEvent event) {
        String nif = nifCliente.getText();
        String email = emailCliente.getText();
        String nombre = nombreCliente.getText();
        String apellido1 = apellido1Cliente.getText();
        String apellido2 = apellido2Cliente.getText();
        String domicilio = domicilioCliente.getText();
        String tipo = tipoCliente.getText();

        String resultado = controlador.agregarCliente(nif, email, nombre, apellido1, apellido2, domicilio, tipo);

        Alert alert;
        if (resultado.contains("satisfactoriamente")) {
            // Muestra un mensaje de éxito
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cliente registrado");
            alert.setHeaderText(null);
        } else {
            // Muestra un mensaje de error
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al registrar el cliente");
            alert.setHeaderText(null);
        }
        alert.setContentText(resultado);
        alert.showAndWait();

        // Limpiar los campos después de agregar el cliente
        nifCliente.clear();
        emailCliente.clear();
        nombreCliente.clear();
        apellido1Cliente.clear();
        apellido2Cliente.clear();
        domicilioCliente.clear();
        tipoCliente.clear();
    }

    @FXML
    private void botonEliminarCliente(ActionEvent event) {
        String nif = nifCliente.getText();
        String resultado = controlador.eliminarCliente(nif);

        Alert alert;
        if (resultado.contains("satisfactoriamente")) {
            // Muestra un mensaje de éxito
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cliente Eliminado");
        } else {
            // Muestra un mensaje de error
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al Eliminar");
        }
        alert.setHeaderText(null);
        alert.setContentText(resultado);
        alert.showAndWait();

        // Limpia el campo de texto
        nifCliente.clear();
    }

    @FXML
    private void botonBuscarCliente(ActionEvent event) {
        String nif = nifBuscarCliente.getText();
        ClientesEntity cliente = controlador.buscarCliente(nif);

        if (cliente != null) {
            resultadoBusquedaCliente.setText(
                    "NIF: " + cliente.getNif() + "\n" +
                            "Email: " + cliente.getEmail() + "\n" +
                            "Nombre: " + cliente.getNombre() + "\n" +
                            "Apellido1: " + cliente.getApellido1() + "\n" +
                            "Apellido2: " + cliente.getApellido2() + "\n" +
                            "Domicilio: " + cliente.getDomicilio() + "\n" +
                            "Tipo: " + cliente.getTipo()
            );
        } else {
            resultadoBusquedaCliente.setText("No se encontró ningún cliente con ese NIF.");
        }

        // Limpia el campo de texto
        nifBuscarCliente.clear();

    }

    @FXML
    private void botonAnadirPedido(ActionEvent event) {
        try {
            String nifCliente = nifClientePedido.getText();
            String nombreArticulo = nombreArticuloPedido.getText();
            int cantidad = Integer.parseInt(cantidadPedido.getText());
            boolean enviado = enviadoConfirmacion.isSelected();

            controlador.agregarPedido(nifCliente, nombreArticulo, cantidad, enviado);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pedido Agregado");
            alert.setHeaderText(null);
            alert.setContentText("Pedido creado satisfactoriamente.");
            alert.showAndWait();

            // Limpia los campos después de agregar el pedido
            nifClientePedido.clear();
            nombreArticuloPedido.clear();
            cantidadPedido.clear();
            enviadoConfirmacion.setSelected(false);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Formato");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, introduce una cantidad válida.");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al agregar el pedido: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void botonEliminarPedido(ActionEvent event) {
        try {
            int numeroDePedido = Integer.parseInt(numeroPedido.getText());
            controlador.eliminarPedido(numeroDePedido);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pedido Eliminado");
            alert.setHeaderText(null);
            alert.setContentText("Pedido eliminado satisfactoriamente.");
            alert.showAndWait();

            // Limpia el campo de texto
            numeroPedido.clear();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Formato");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, introduce un número de pedido válido.");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al eliminar el pedido: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void botonBuscarPedido(ActionEvent event) {
        try {
            int numeroPedido = Integer.parseInt(numeroBuscarPedido.getText());
            PedidosEntity pedido = controlador.buscarPedido(numeroPedido);

            if (pedido != null) {
                String resultado = "Número de Pedido: " + pedido.getIdNumeroPedido() + "\n";
                resultado += "Cliente: " + (pedido.getIdClientes() != null ? pedido.getIdClientes().getNombre() : "No disponible") + "\n";
                resultado += "Fecha y Hora: " + pedido.getFechaHora() + "\n";
                resultado += "Enviado: " + (pedido.getEnviado() != 0) + "\n";
                resultado += "Pagado: " + (pedido.getPagado() != 0);
                resultadoBusquedaPedido.setText(resultado);
            } else {
                resultadoBusquedaPedido.setText("No se encontró ningún pedido con ese número.");
            }
        } catch (NumberFormatException e) {
            resultadoBusquedaPedido.setText("Por favor, introduce un número de pedido válido.");
        } catch (Exception e) {
            resultadoBusquedaPedido.setText("Error al buscar el pedido: " + e.getMessage());
        }
    }






}