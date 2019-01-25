package ch.bbw.dn.mashuprecipe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 19.01.2019
 */
public class App extends Application
{

    Stage window;
    Scene sceneHome, sceneCategories, sceneMeal;
    String categoryChoosen, mealChoosen;

	public static void main(String[] args) {
        launch(args);
    }
    
    public void start(final Stage primaryStage) {

	    window = primaryStage;

        //---------------------------------------------
        //                  HOME
        //---------------------------------------------

        StackPane root = new StackPane();
        root.setAlignment(Pos.TOP_CENTER);

        Label lblTitleCategories = new Label();
        lblTitleCategories.setText("Categories");
        lblTitleCategories.setTranslateY(10);
        root.getChildren().add(lblTitleCategories);

        API api = new API();
        ArrayList<Category> results = api.getAllCategories();
        int cordinateX = 0;
        int cordinateY = 40;
        for (final Category category : results) {

            Button test = new Button();
            test.wrapTextProperty().setValue(true);
            test.setText(category.getStrCategory());

            test.setTranslateX(cordinateX);
            test.setTranslateY(cordinateY);
            test.setPrefWidth(400);

            Image img = new Image(category.getStrCategoryThumb());
            ImageView imgView = new ImageView(img);
            imgView.setTranslateX(-250);
            imgView.setTranslateY(cordinateY-5);
            imgView.setFitHeight(50);
            imgView.setFitWidth(50);

            test.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    categoryChoosen = category.getStrCategory();
                    showCategories();
                }
            });
            cordinateY += 50;
            root.getChildren().addAll(test, imgView);
        }

        sceneHome = new Scene(root, 800, 700);

        window.setTitle("MashUpRecipe - Dominik Näf");
        window.setScene(sceneHome);
        window.show();
        
	}

    public void showCategories() {

        //---------------------------------------------
        //                  Categories
        //---------------------------------------------

        StackPane rootCategories = new StackPane();
        rootCategories.setAlignment(Pos.TOP_CENTER);

        Label lblTitleCategories = new Label();
        lblTitleCategories.setText("Meals in Category");
        lblTitleCategories.setTranslateY(10);
        rootCategories.getChildren().add(lblTitleCategories);

        Button btnCategories = new Button();
        btnCategories.setText("<");
        btnCategories.setTranslateX(-250);
        btnCategories.setPrefWidth(50);
        btnCategories.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                window.setScene(sceneHome);

            }

        });
        rootCategories.getChildren().add(btnCategories);

        API api = new API();
        ArrayList<Meal> resultsCategory = api.filterByCategory(categoryChoosen);
        int cordinateXCategory = 0;
        int cordinateYCategory = 40;
        for (final Meal meal : resultsCategory) {

            Image img = new Image(meal.getStrMealThumb());
            ImageView imgView = new ImageView(img);
            imgView.setTranslateX(-250);
            imgView.setTranslateY(cordinateYCategory-5);
            imgView.setFitHeight(50);
            imgView.setFitWidth(50);

            Button test = new Button();
            test.wrapTextProperty().setValue(true);
            test.setText(meal.getStrMeal());
            //image
            test.setTranslateX(cordinateXCategory);
            test.setTranslateY(cordinateYCategory);
            test.setPrefWidth(400);
            test.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    mealChoosen = meal.getIdMeal();
                    showMeal();
                }
            });
            cordinateYCategory += 50;
            rootCategories.getChildren().addAll(test, imgView);
        }

        sceneCategories = new Scene(rootCategories, 800, 700);
        window.setScene(sceneCategories);
    }








    public void showMeal() {

        //---------------------------------------------
        //                  Categories
        //---------------------------------------------

        StackPane rootMeal = new StackPane();
        rootMeal.setAlignment(Pos.TOP_CENTER);

        Button btnCategories = new Button();
        btnCategories.setText("<");
        btnCategories.setTranslateX(-250);
        btnCategories.setPrefWidth(50);
        btnCategories.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                window.setScene(sceneCategories);

            }

        });
        rootMeal.getChildren().add(btnCategories);

        /*

        API api = new API();
        ArrayList<Meal> resultsCategory = api.filterByCategory(categoryChoosen);
        int cordinateXCategory = 0;
        int cordinateYCategory = 40;
        for (final Meal meal : resultsCategory) {

            Image img = new Image(meal.getStrMealThumb());
            ImageView imgView = new ImageView(img);
            imgView.setTranslateX(-250);
            imgView.setTranslateY(cordinateYCategory-5);
            imgView.setFitHeight(50);
            imgView.setFitWidth(50);

            Button test = new Button();
            test.wrapTextProperty().setValue(true);
            test.setText(meal.getStrMeal());
            //image
            test.setTranslateX(cordinateXCategory);
            test.setTranslateY(cordinateYCategory);
            test.setPrefWidth(400);
            test.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    mealChoosen = meal.getIdMeal();
                    showMeal();
                }
            });
            cordinateYCategory += 50;
            rootCategories.getChildren().addAll(test, imgView);
        }

    */

        sceneMeal = new Scene(rootMeal, 800, 700);
        window.setScene(sceneMeal);
    }

}