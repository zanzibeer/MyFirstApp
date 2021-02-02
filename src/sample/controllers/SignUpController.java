package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.User;
import sample.conn.DatabaseHandler;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUpName;

    @FXML
    private TextField SignUpLastName;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private CheckBox SignUpCheckBoxMale;

    @FXML
    private CheckBox SignUpCheckBoxFemale;

    @FXML
    private TextField SignUpCountry;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {

        SignUpButton.setOnAction(event -> {
            signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = SignUpName.getText();
        String lastName = SignUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = SignUpCountry.getText();
        String gender = "";

        if (SignUpCheckBoxMale.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User(firstName, lastName, userName, password, location, gender);

        dbHandler.signUpUser(user);
    }
}
