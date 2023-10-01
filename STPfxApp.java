import au.edu.uts.ap.javafx.*;
import javafx.stage.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import model.*;

public class STPfxApp extends Application {
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Session session = new Session();
        stage.getIcons().add(new Image("/view/book.png"));
        ViewLoader.showStage(session, "/view/session.fxml", "STPFX - Employer Mode", stage);//ViewLoader.showStage(model, view,title,stage)
    }
}