package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField input;
    @FXML
    private Label output;

    public void initialize() {
        Model model = new Model();
        input.textProperty().addListener((obs, oldText, newText) -> {
            output.setText(model.processString(newText));
        });
        input.setText("This is a demo");
    }

}
