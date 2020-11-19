import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    TextArea textArea; // нужно внимательно выбирать так как нужно выбрать для FX

    @FXML
    TextField textField;

    public void sendMessage() {
        textArea.appendText(textField.getText()+"\n");
        textField.clear();
        textField.requestFocus();
    }

}

