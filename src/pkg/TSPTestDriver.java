package pkg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;

/*
 * This class is only temporary, and serves to test methods in the Algorithms class without a webpage or a server connection
 */
public class TSPTestDriver extends Application {
	private TextField tfList = new TextField();
	private Label lblBefore = new Label();
	private Label lblStatus = new Label();
	
	@Override // Override the start method in the Application class
  	public void start(Stage primaryStage) {
		// Dont need database connection
	    Button tsp = new Button("Submit List");
	    HBox hBox = new HBox(2);
	    hBox.getChildren().addAll(new Label("List 1 or 2?"), tfList, (tsp));

	    VBox vBox = new VBox(10);
	    vBox.getChildren().addAll(hBox, lblBefore, lblStatus);
	    
	    tsp.setOnAction(e -> shortestPath());
	    
	    // Create a scene and place it in the stage
	    Scene scene = new Scene(vBox, 800, 600);
	    primaryStage.setTitle("Test the TSP yall"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	}
	
	private void shortestPath() {
		ArrayList<StoreProduct> testList = new ArrayList<StoreProduct>();
		testList.add(new StoreProduct("Entrance", "", "", "", 0, 0));
		testList.add(new StoreProduct("Cargo Shorts", "Clothing", "8", "5", 11, 4));
		testList.add(new StoreProduct("Juice", "Beverages", "2", "2", 2, 12));
		testList.add(new StoreProduct("Milk", "Dairy", "1", "2", 0, 3));
		testList.add(new StoreProduct("Pepsi", "Beverages", "3", "5", 11, 12));
		
		ArrayList<StoreProduct> testList2 = new ArrayList<StoreProduct>();
		testList2.add(new StoreProduct("Entrance", "", "", "", 0, 0));
		testList2.add(new StoreProduct("Eggs", "Dairy", "8", "5", 0, 4));
		testList2.add(new StoreProduct("Juice", "Beverages", "2", "2", 2, 12));
		testList2.add(new StoreProduct("Milk", "Dairy", "1", "2", 0, 3));
		testList2.add(new StoreProduct("Pepsi", "Beverages", "3", "5", 11, 12));
		
		char toUse = tfList.getText().charAt(0);
		List<StoreProduct> useThis = new ArrayList<StoreProduct>();
		
		if(toUse == '1') {
			useThis = testList;
		}
		else if(toUse == '2') {
			useThis = testList2;
		}
		else return;
		
		lblBefore.setText("Shopping list:");
		for(int i = 0; i < useThis.size(); i++) {
			StoreProduct item = useThis.get(i);
			lblBefore.setText(lblBefore.getText() + "\n\t" + (i+1) + ": " + item.getName() + "\tat \t(" + item.getX() + ", " + item.getY() + ")");
		}
		
		List<StoreProduct> items = Algorithms.shortestPath(useThis);
		lblStatus.setText("Shortest path:");
		for(int i = 0; i < items.size(); i++) {
			StoreProduct item = items.get(i);
			lblStatus.setText(lblStatus.getText() + "\n\t" + (i+1) + ": " + item.getName() + "\tat \t(" + item.getX() + ", " + item.getY() + ")");
		}
	}

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
