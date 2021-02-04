package HomeTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Controller {
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;

    @FXML
    private void clickBtnSend(ActionEvent actionEvent) {
        textArea.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();

    }

    public void pressEnterToSend(ActionEvent actionEvent) {
            textArea.appendText(textField.getText() + "\n");
            textField.clear();
            textField.requestFocus();
        }
    }
