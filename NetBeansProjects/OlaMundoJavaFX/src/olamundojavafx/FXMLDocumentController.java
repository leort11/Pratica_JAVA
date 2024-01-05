/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package olamundojavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author leort
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lblMensagem;
    private Button btnClick;
    private boolean verifica = false;
    
    
    @FXML
    private void clicouBotao(ActionEvent event) {
        if (verifica == false) {
            verifica = true;
            lblMensagem.setText("Olá, mundo");
            
        } else if (verifica == true) {
            verifica = false;
            lblMensagem.setText("Aqui vai aparecer uma mensagem");
            
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
