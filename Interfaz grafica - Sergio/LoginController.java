package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoginController
{
	private Stage stage;
	
	//Otro
	private ObservableList<Producto> productData = FXCollections.observableArrayList();
	
	public LoginController()
	{
		productData.add(new Producto("Mermelada", 5, 10.50, LocalDate.of(2019, 2, 21)));
		productData.add(new Producto("Chorizo", 2, 5.50, LocalDate.of(2019, 10, 20)));
    }
	
	public ObservableList<Producto> getProductData()
	{
        return productData;
    }
	
	//Controlador
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPass;
	
	@FXML
	public void login(ActionEvent event) throws IOException
	{
    	String email = "email@email.com";
    	String password = "1234";
    	
    	if(txtEmail.getText().equals(email) && txtPass.getText().equals(password))
    	{
    		nuevaVentana(event);
    	}
    	else 
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Información");
        	alert.setHeaderText(null);
        	alert.setContentText("Email y/o contraseña incorrectos");
        	alert.showAndWait();
    	}
	}
	
	private void nuevaVentana(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
		BorderPane admin = (BorderPane) loader.load();
		
    	Scene adminScene = new Scene(admin);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.setTitle("Panel de control");
    	stage.setScene(adminScene);
    	stage.show();
    	
    	AdminController adminCont = loader.getController();
    	adminCont.setLogin(this);
	}
	
	public boolean showProductEditDialog(Producto producto)
	{
	    try 
	    {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(stage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        ProductEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setProduct(producto);

	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	        return false;
	    }
	}
}