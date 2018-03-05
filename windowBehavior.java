
package code;

import app.FXMLDocumentController;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import newWindow.GenericWindowController;

/**
 *
 * @author Master
 */
public class windowBehavior {
    private int n = 0;
    private List<GenericWindowController> mylist = null;
    private TextField txtbox;
    private FXMLDocumentController Bcontroller;
    
    public windowBehavior(FXMLDocumentController Bcontroller){
        this.Bcontroller = Bcontroller;
        this.mylist = new ArrayList<GenericWindowController>();
    }
    
    public void childClosed(){
        this.n--;  
        this.txtUpdateText();
    }
    
    public void childOpened(){
        this.n++;        
        this.txtUpdateText();
    }
                
    private void txtUpdateText(){
        this.Bcontroller.txtactivas.setText(String.valueOf(this.n) + " FXML Activos.");        
    }
    
    public void closeAll(){
        
        this.mylist.stream().forEach((x) -> {
            x.close();
        });
    }
    
    public void openFXML(String path){
        
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = (Parent)loader.load();
            Stage scenario = new Stage();
            //scenario.initStyle(StageStyle.UNDECORATED);
            scenario.setTitle("Ventana Emergente");
            scenario.setMaximized(false);
            scenario.setResizable(false);
            scenario.setScene(new Scene(root));
                                                
            scenario.show();
        }
        catch(Exception ex){            
            JOptionPane.showMessageDialog(null, "Error", ex.getMessage(), JOptionPane.ERROR);        
            System.out.println(ex.getMessage());
        }
        
    }

    public GenericWindowController openFXML(String path, boolean x){

        GenericWindowController controller = null;

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = (Parent)loader.load();
            Stage scenario = new Stage();
            //scenario.initStyle(StageStyle.UNDECORATED);
            scenario.setTitle("Ventana Emergente");
            scenario.setMaximized(false);
            scenario.setResizable(false);
            scenario.setScene(new Scene(root));      
            
            final GenericWindowController innerController = loader.getController();
             
            controller = innerController;
            
            
            if(!(innerController == null)){
            
                scenario.setOnHidden(e -> {
                    innerController.update();
                });                                
                
               this.mylist.add(controller);   
                
               this.childOpened();
               
               innerController.txt.setText("My id is: #"+String.valueOf(this.n));
            }

            scenario.show();


            
        }
        catch(Exception ex){            
            JOptionPane.showMessageDialog(null, "Error", ex.getMessage(), JOptionPane.ERROR);        
            System.out.println(ex.getMessage());
        }

        return controller;        
}
    
        
    
}
