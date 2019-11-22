package pkg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;
import java.util.*;

public class TestMain extends Application {
  // PreparedStatement for executing queries
  //private PreparedStatement preparedStatement;
  private TextField tfStore = new TextField();
  private Label lblStatus = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Initialize database connection
	StoreDao store = new StoreDao();
	store.initializeJdbc();

    Button bt = new Button("Show Items");
    HBox hBox = new HBox(5);
    hBox.getChildren().addAll(new Label("Store name"), tfStore, (bt));

    VBox vBox = new VBox(10);
    vBox.getChildren().addAll(hBox, lblStatus);
    
    bt.setOnAction(e -> showItems());
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 420, 80);
    primaryStage.setTitle("TestMain"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage   
  }

  private void initializeDB() {
    try {
      // Establish a connection
      Connection connection = DriverManager.getConnection
        ("jdbc:mysql://localhost/javabook?useSSL=false", "scott", "tiger");
      System.out.println("Database connected");

      String queryString = "select firstName, mi, " +
        "lastName, title, grade from Student, Enrollment, Course " +
        "where Student.ssn = ? and Enrollment.courseId = ? " +
        "and Enrollment.courseId = Course.courseId";

      // Create a statement
      //preparedStatement = connection.prepareStatement(queryString);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void showItems() {
    String store = tfStore.getText().toLowerCase();
    //String courseId = tfCourseId.getText();
    
	List<StoreProduct> items = StoreDao.getAllProductsFromTable(store);
	lblStatus.setText("");
	for(StoreProduct item : items) {
		lblStatus.setText(lblStatus.getText() + "\n" + item.getName());
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
