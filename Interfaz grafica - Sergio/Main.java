package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class Main extends Application
{
	//Hecho por Sergio Nebreda Andrés
    @Override
    public void start(Stage stage) throws Exception
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	AnchorPane root = (AnchorPane) loader.load();
    	Scene scene = new Scene(root);
    	stage.setTitle("Login");
    	stage.setScene(scene);
    	stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
