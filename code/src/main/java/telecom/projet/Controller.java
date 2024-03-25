package telecom.projet;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML private Label label; // Label à mettre à jour

    @FXML private Label query;

    @FXML private CheckBox checkbox;

    @FXML private TextField symptoms;

    @FXML private ScrollPane results;

    private Data data; // Instance pour les données
    public Controller() {

    }

    @FXML
    public void search() {
        VBox vbox = new VBox();
        vbox.setStyle("-fx-alignment: center; -fx-spacing: 10;");

        if (symptoms.getText().isEmpty()){
            query.setText("Please enter a symptom");
        }else{
            //line_of_infos of the results
            query.setText("Symptoms: " + symptoms.getText());

            
            //data test
            ArrayList<String> treatments = new ArrayList<>();
            treatments.add("treatment1zzzzzzzzzzzzzzzzzzzzzzzzzzz");
            treatments.add("treatment2");
            treatments.add("treatment3");
            treatments.add("treatment4");
            treatments.add("treatment5");
            treatments.add("treatment6");
            treatments.add("treatment7");
            
            
            

            
            if (checkbox.isSelected()){ //if the symptom is a side effect
                Data data = new Data(symptoms.getText(), true);
                vbox.getChildren().add(line_of_infos("aspirin",treatments, true));
                vbox.getChildren().add(line_of_infos("ibuprofen",treatments, true));
                vbox.getChildren().add(line_of_infos("angine",treatments, false));
                vbox.getChildren().add(line_of_infos("grippe",treatments, false));

            }else{
                Data data = new Data(symptoms.getText(), false);
                vbox.getChildren().add(line_of_infos("angine",treatments, false));
                vbox.getChildren().add(line_of_infos("grippe",treatments, false));
            }

            //display
            

            results.setContent(vbox);
        }
    }

    public BorderPane line_of_infos(String disease, ArrayList<String> treatments, Boolean side_effect){
        //side_effect = true if it's a side effect, false if it's a disease

        //return a BorderPane composed of:
        //hboxLeft{ ImageView[image] | VBox[disease]} | ImageView[arrow]| hboxRight{ ImageView[image] | VBox[treatments]}

        BorderPane borderPane = new BorderPane();
        
        //-----------left
        HBox hboxLeft = new HBox();

        Image diseaseImage = new Image(getClass().getResource("images/disease.png").toExternalForm());
        
        if (side_effect){
            diseaseImage = new Image(getClass().getResource("images/meds.png").toExternalForm());
        }
        ImageView diseaseImageView = new ImageView(diseaseImage);
        diseaseImageView.setFitHeight(50);
        diseaseImageView.setFitWidth(50);
        diseaseImageView.setPreserveRatio(true);
        diseaseImageView.setStyle("-fx-padding: 10;");

        hboxLeft.getChildren().add(diseaseImageView);


        VBox diseaseBox = new VBox();
        if (!side_effect){
            diseaseBox.getChildren().add(new Label("Disease:"));
            hboxLeft.setStyle("-fx-background-color: #FFC0CB;-fx-background-radius: 20;");
        }else{
            diseaseBox.getChildren().add(new Label("Drug causing a side effect:"));
            hboxLeft.setStyle("-fx-background-color: #F1E2BE;-fx-background-radius: 20;");

        }
        diseaseBox.getChildren().add(new Label(disease));
        
        diseaseBox.getChildren().get(0).setStyle("-fx-text-fill: gray; -fx-font-weight: bold;");
        hboxLeft.getChildren().add(diseaseBox);
        

        borderPane.setLeft(hboxLeft);

        //-----------center
        Image arrowImage = new Image(getClass().getResource("images/arrow.png").toExternalForm());
        ImageView arrowImageView = new ImageView(arrowImage);
        arrowImageView.setFitHeight(50);
        arrowImageView.setFitWidth(50);
        arrowImageView.setPreserveRatio(true);
        arrowImageView.setStyle("-fx-padding: 10;");
        borderPane.setCenter(arrowImageView);

        
        //----------right
        VBox vbox = new VBox();

        HBox hboxRight = new HBox();
        //add image
        Image image = new Image(getClass().getResource("images/treatment.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        
        hboxRight.getChildren().add(imageView);

        for (String treatment : treatments){
            vbox.getChildren().add(new Label(treatment));
        }
        
        hboxRight.getChildren().add(vbox);
        
        //hbox.setStyle("-fx-background-color: #F0F8FF; -fx-border-radius: 30; -fx-padding: 10; -fx-spacing: 10;");
        hboxRight.setStyle("-fx-background-color: #C0EFA7;-fx-background-radius: 20;");
        borderPane.setRight(hboxRight);
        

        //fill the width of the scrollpane
        borderPane.prefWidthProperty().bind(results.widthProperty());
        //center it
        borderPane.setStyle("-fx-alignment: center;");
        
        
        hboxLeft.prefWidthProperty().bind(results.widthProperty().divide(2.5));//width of the left part
        hboxRight.prefWidthProperty().bind(results.widthProperty().divide(2.5));//width of the left part

        
        //space on the left and the right of the borderpane
        //borderPane.setStyle("-fx-padding: 0 50 0 50;");

        

        return borderPane;
    }

}
