package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import application.LoginController;
import application.Producto;

public class AdminController
{
    @FXML
    private TableView<Producto> productTable;
    
    @FXML
    private TableColumn<Producto, String> firstNameColumn;
    
    @FXML
    private Label unidadesLb;
    
    @FXML
    private Label precioLb;
    
    @FXML
    private Label fechaLb;
    
    private LoginController login; //Login comunicacion

    @FXML
    private void initialize()
    {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());

        showProductDetails(null);

        productTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showProductDetails(newValue));
    }
    
    @FXML
    private void handleDeleteProduct()
    {
        int selectedIndex = productTable.getSelectionModel().getSelectedIndex();
        
        if(selectedIndex>=0)
        {
        	productTable.getItems().remove(selectedIndex);
        }
    }
    
    @FXML
    private void handleNewPerson()
    {
        Producto tempProduct = new Producto();
        boolean okClicked = login.showProductEditDialog(tempProduct);
        if(okClicked)
        {
            login.getProductData().add(tempProduct);
        }
    }

    @FXML
    private void handleEditPerson()
    {
    	Producto selectedProduct = productTable.getSelectionModel().getSelectedItem();
    	
        if(selectedProduct != null)
        {
            boolean okClicked = login.showProductEditDialog(selectedProduct);
            if (okClicked)
            {
                showProductDetails(selectedProduct);
            }

        }
    }
    
    private void showProductDetails(Producto producto)
    {
        if(producto != null)
        {
            unidadesLb.setText(Integer.toString(producto.getUnidades()));
            precioLb.setText(Double.toString(producto.getPrecio()));
            fechaLb.setText(DateUtil.format(producto.getFecha()));
        }
        else
        {
            unidadesLb.setText("");
            precioLb.setText("");
            fechaLb.setText("");
        }
    }

    //Comunicacion con login
    public void setLogin(LoginController login)
    {
        this.login = login;
        productTable.setItems(login.getProductData());
    }
}