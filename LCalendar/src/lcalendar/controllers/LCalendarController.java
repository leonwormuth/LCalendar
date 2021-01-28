package lcalendar.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lcalendar.LCalendar;
import lcalendar.MonthArray;

public class LCalendarController {
	
    private static final double HOVER_BRIGHTNESS = 0.5;
    private static final double PRESS_BRIGHTNESS = 0.7;
	
	private double xOffset = 0;
    private double yOffset = 0;
    
    private Stage primaryStage;
    private LCalendar cal = new LCalendar();
    private MonthArray monthArray;
    
    @FXML protected HBox toolbar;
    @FXML protected HBox addBtn;
    @FXML protected HBox settingsBtn;
    @FXML protected HBox helpBtn;
    @FXML protected ImageView addBtnImage;
    @FXML protected ImageView settingsBtnImage;
    @FXML protected ImageView helpBtnImage;
    @FXML protected GridPane monthGrid;

    
    //allow stage to be passed to controller, ref https://stackoverflow.com/questions/10751271/accessing-fxml-controller-class
    public void setStage(Stage stage) {
    	this.primaryStage = stage;
    }
    
    public void initCalendar() {
    	monthArray = cal.now();
    }
    
    public void update() {
    	clearCalendar();
    	drawCalendar();
    }
    
    private void clearCalendar() {
    	monthGrid.getChildren().clear();
    	
    	String[] days = new String[] {"Mo","Tu","We","Th","Fr","Sa","Su"};
    	for (int i = 0; i < 7; i++) {
    		GridPane g = new GridPane();
        	g.getStyleClass().clear();
        	g.getStyleClass().add("day-heading");
        	g.setAlignment(Pos.CENTER);
        	GridPane.setConstraints(g, i, 0);
        	
        	Text t = new Text();
        	t.setText(days[i]);
        	t.getStyleClass().clear();
        	t.getStyleClass().add("text");
        	
        	monthGrid.getChildren().add(g);
        	g.getChildren().add(t);
    	}
    }
    
    private void drawCalendar() {
    	for (int i = 7; i < monthArray.getArray().length; i++) {
    		GridPane g = new GridPane();
    		g.getStyleClass().clear();
        	g.getStyleClass().add("day");
        	g.setAlignment(Pos.CENTER);
        	GridPane.setConstraints(g, i%7, i/7);
        	
        	Text t = new Text();
        	t.setText(Integer.toString(monthArray.getArray()[i]));
        	t.getStyleClass().clear();
        	
        	String textStyle;
        	if (i < monthArray.getFirst() || i > monthArray.getLast()) {
        		textStyle = "other-month";
        	} else {
        		textStyle = "text";
        	}
        	t.getStyleClass().add(textStyle);
        	
        	monthGrid.getChildren().add(g);
        	g.getChildren().add(t);
    	}
    	System.out.println(monthGrid.getRowConstraints());
    	System.out.println(monthGrid.getColumnConstraints());
    }

	@FXML
	protected void handleExitAction(MouseEvent event) {
		System.exit(0);
	}
	
	@FXML
	protected void handleToolbarPress(MouseEvent event) {
		xOffset = event.getSceneX();
        yOffset = event.getSceneY();
	}
	
	@FXML
	protected void handleToolbarDrag(MouseEvent event) {
		primaryStage.setX(event.getScreenX() - xOffset);
        primaryStage.setY(event.getScreenY() - yOffset);
	}
	
	@FXML
	protected void handleButtonEnter(MouseEvent event) {
		ColorAdjust hoverAdjust = new ColorAdjust();
		hoverAdjust.setBrightness(HOVER_BRIGHTNESS);

		HBox button = (HBox)event.getTarget();
	    ImageView imageView = (ImageView)button.getChildren().get(0);
	    imageView.setEffect(hoverAdjust);
	}
	
	@FXML
	protected void handleButtonExit(MouseEvent event) {
		ColorAdjust hoverAdjust = new ColorAdjust();
	    hoverAdjust.setBrightness(0);
	    
	    HBox button = (HBox)event.getTarget();
	    ImageView imageView = (ImageView)button.getChildren().get(0);
	    imageView.setEffect(hoverAdjust);
	}
	
	@FXML
	protected void handleButtonPress(MouseEvent event) {
		ColorAdjust pressAdjust = new ColorAdjust();
		pressAdjust.setBrightness(PRESS_BRIGHTNESS);
		
		ImageView imageView;
		
		if (event.getTarget() instanceof HBox) {
			HBox target = (HBox)event.getTarget();
			imageView = (ImageView)target.getChildren().get(0);
		} else {
			imageView = (ImageView)event.getTarget();
		}
	    imageView.setEffect(pressAdjust);
	}
	
	@FXML
	protected void handleButtonRelease(MouseEvent event) {
		ColorAdjust pressAdjust = new ColorAdjust();
		pressAdjust.setBrightness(HOVER_BRIGHTNESS);

		ImageView imageView;
		
		if (event.getTarget() instanceof HBox) {
			HBox target = (HBox)event.getTarget();
			imageView = (ImageView)target.getChildren().get(0);
		} else {
			imageView = (ImageView)event.getTarget();
		}
	    imageView.setEffect(pressAdjust);
	}
}