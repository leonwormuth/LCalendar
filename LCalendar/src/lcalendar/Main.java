package lcalendar;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lcalendar.controllers.LCalendarController;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
    private LCalendarController controller;
	
    @Override
    public void start(Stage primaryStage) {
        try {
            //set up FXML loader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/lcalendar/views/LCalendarFXML.fxml"));
            GridPane root = loader.load();
			
            //pass primaryStage to controller, ref https://stackoverflow.com/questions/10751271/accessing-fxml-controller-class
            controller = (LCalendarController)loader.getController();
            controller.setStage(primaryStage);
			
            Scene scene = new Scene(root, 700, 825);
            scene.getStylesheets().add(getClass().getResource("views/style.css").toExternalForm());
			
            scene.widthProperty().addListener(
                (observable, oldValue, newValue) -> {
                    root.setPrefSize((Double)newValue, (Double)newValue * 1.1);
                    System.out.println(root.getPrefWidth() + ", " + root.getPrefHeight());
                }
            );
            scene.heightProperty().addListener(
                (observable, oldValue, newValue) -> {
                    root.setPrefSize((Double)newValue / 1.1, (Double)newValue);
                    System.out.println(root.getPrefWidth() + ", " + root.getPrefHeight());
                }
            );
			
            Image icon = new Image(getClass().getResourceAsStream("/lcalendar/resources/icon.png"));
            primaryStage.getIcons().add(icon);
			
            primaryStage.setScene(scene);
            primaryStage.setTitle("LCalendar");
            primaryStage.initStyle(StageStyle.TRANSPARENT);
			
            //populate the calendar with days and values
            controller.initCalendar();
            controller.update();
			
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	
    public static void main(String[] args) {
        launch(args);
    }
}
