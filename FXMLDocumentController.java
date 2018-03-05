/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import code.windowBehavior;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javax.swing.ImageIcon;
/**
 *
 * @author Master
 */
public class FXMLDocumentController implements Initializable {
    
    public windowBehavior base = new windowBehavior(this);
    
    @FXML
    private Button btnCloseAll;    
        
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Label lbl1;
    @FXML
    public TextField txtactivas;
    @FXML
    public ImageView imagev;
    @FXML
    private AnchorPane form;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        final Image i = new Image("/resources/javafx.jpg");        
        this.imagev.setImage(i);
        
        form.setBackground(Background.EMPTY);
    }    

    @FXML
    private void btn1_click(MouseEvent event) {
        
        base.openFXML("/newWindow/genericWindow.fxml",true).setBase(this);         
    }

    @FXML
    private void btnclose_click(MouseEvent event) {
        this.base.closeAll();
    }
    
}
