
package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));        
        //FXMLDocumentController controller = fxml.getController();                        
        Parent root = (Parent)fxml.load();
        Scene scene = new Scene(root);
        stage.setMaximized(false);
        stage.setResizable(false);                        
        stage.setTitle("Tarea #4 Lenguajes de Programacion IV");
        stage.setScene(scene);
        stage.centerOnScreen();                
        stage.show();                
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
