/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newWindow;

import app.FXMLDocumentController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Master
 */
public class GenericWindowController implements Initializable {

    
    private FXMLDocumentController base;
    @FXML
    private Label lblMsg;
    @FXML
    public TextField txt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void update(){
        this.base.base.childClosed();
    }

    public FXMLDocumentController getBase() {
        return base;
    }

    public void setBase(FXMLDocumentController base) {
        this.base = base;
    }
    
    public void close(){
        Stage tmp = (Stage)this.lblMsg.getScene().getWindow();
        tmp.close();
    }
    
}
