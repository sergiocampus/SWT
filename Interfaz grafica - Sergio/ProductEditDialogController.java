package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import application.Producto;
import application.DateUtil;

public class ProductEditDialogController {

    @FXML
    private TextField nombreTxt;
    
    @FXML
    private TextField unidadesTxt;
    
    @FXML
    private TextField precioTxt;
    
    @FXML
    private TextField fechaTxt;


    private Stage dialogStage;
    private Producto producto;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage)
    {
        this.dialogStage = dialogStage;
    }

    public void setProduct(Producto producto)
    {
        this.producto = producto;

        nombreTxt.setText(producto.getNombre());
        unidadesTxt.setText(Integer.toString(producto.getUnidades()));
        precioTxt.setText(Double.toString(producto.getPrecio()));
        fechaTxt.setText(DateUtil.format(producto.getFecha()));
        fechaTxt.setPromptText("dd.mm.yyyy");
    }

    public boolean isOkClicked()
    {
        return okClicked;
    }

    @FXML
    private void handleOk()
    {
        if (isInputValid())
        {
        	producto.setNombre(nombreTxt.getText());
        	producto.setUnidades(Integer.parseInt(unidadesTxt.getText()));
        	producto.setPrecio(Double.parseDouble(precioTxt.getText()));
        	producto.setFecha(DateUtil.parse(fechaTxt.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel()
    {
        dialogStage.close();
    }

    private boolean isInputValid()
    {
        String errorMessage = "";

        if (nombreTxt.getText() == null || nombreTxt.getText().length() == 0) {
            errorMessage += "Nombre invalido!"; 
        }

        if (unidadesTxt.getText() == null || unidadesTxt.getText().length() == 0) {
            errorMessage += "Unidades invalidas"; 
        } else {
            try {
                Integer.parseInt(unidadesTxt.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Unidades invalidas. (Tiene que introducir un numero)"; 
            }
        }
        
        if (precioTxt.getText() == null || precioTxt.getText().length() == 0) {
            errorMessage += "Precio invalido"; 
        } else {
            try {
                Double.parseDouble(precioTxt.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Precio invalido. (Tiene que introducir un numero)"; 
            }
        }

        if (fechaTxt.getText() == null || fechaTxt.getText().length() == 0) {
            errorMessage += "Fecha invalida";
        } else {
            if (!DateUtil.validDate(fechaTxt.getText())) {
                errorMessage += "Fecha invalida. Usa el formato dd.mm.yyyy!";
            }
        }

        if (errorMessage.length() == 0)
        {
            return true;
        } 
        else 
        {
        	Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Información");
        	alert.setHeaderText(null);
        	alert.setContentText(errorMessage);
        	alert.showAndWait();
            return false;
        }
    }
}
