 /*
 * Controlls start.fxml
 * when buttons are pressed different things happen
 */
package pages.startPage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vanessa
 */
public class StartPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    Button signin;
    @FXML
    Button create;
    //brings user to creating an account page
    public void register(ActionEvent event) throws SQLException, IOException {
            Parent aRoot = FXMLLoader.load(getClass().getResource("/pages/newAccount/ca.fxml"));
            Scene aScene = new Scene(aRoot);
            Stage secondaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            secondaryStage.setTitle("New Account");
            secondaryStage.setScene(aScene);
            secondaryStage.show();
    }
    //brings user to login page
    public void signIn(ActionEvent event) throws SQLException, IOException {
            Parent sRoot = FXMLLoader.load(getClass().getResource("/pages/plogin/plogin.fxml"));
            Scene sScene = new Scene(sRoot);
            Stage tertiaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            tertiaryStage.setTitle("Sign In");
            tertiaryStage.setScene(sScene);
            tertiaryStage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
