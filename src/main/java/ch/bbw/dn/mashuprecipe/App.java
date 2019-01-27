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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 19.01.2019
 */
public class App extends Application {

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

        sceneHome = new Scene(root, 800, 900);

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

        sceneCategories = new Scene(rootCategories, 800, 900);
        window.setScene(sceneCategories);
    }

    public void showMeal() {

        //---------------------------------------------
        //                  Categories
        //---------------------------------------------

        StackPane rootMeal = new StackPane();
        rootMeal.setAlignment(Pos.TOP_CENTER);

        API api = new API();
        final ArrayList<Meal> resultsCategory = api.showMeal(mealChoosen);

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

        Button btnYouTube = new Button();
        btnYouTube.setText("YouTube");
        btnYouTube.setTranslateX(200);
        btnYouTube.setPrefWidth(100);
        btnYouTube.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                Stage windowYouTube = new Stage();
                WebView webView = new WebView();
                webView.getEngine().load(resultsCategory.get(0).getStrYoutTube());
                webView.setPrefSize(640, 390);
                windowYouTube.setScene(new Scene(webView));
                windowYouTube.show();

            }

        });
        rootMeal.getChildren().add(btnYouTube);

        Button btnList = new Button();
        btnList.setText("Incredients");
        btnList.setTranslateX(200);
        btnList.setTranslateY(35);
        btnList.setPrefWidth(100);
        btnList.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                Stage windowIncredients = new Stage();
                StackPane rootList = new StackPane();
                rootList.setAlignment(Pos.TOP_CENTER);

                ArrayList<String> incredients = resultsCategory.get(0).getIntegredients();
                ArrayList<String> measures = resultsCategory.get(0).getMeasures();

                int cordinateIncredient = 10;
                int cordinateMeasure = 10;
                for (String incredient : incredients) {
                    Label incredient1 = new Label();
                    incredient1.setAlignment(Pos.CENTER);
                    incredient1.setText(incredient);
                    incredient1.setTranslateY(cordinateIncredient);
                    incredient1.setTranslateX(-50);
                    incredient1.setPrefWidth(150);
                    incredient1.wrapTextProperty().setValue(true);
                    cordinateIncredient += 20;
                    rootList.getChildren().add(incredient1);
                }

                for (String measure : measures) {
                    Label measure1 = new Label();
                    measure1.setAlignment(Pos.CENTER);
                    measure1.setText(measure);
                    measure1.setTranslateY(cordinateMeasure);
                    measure1.setTranslateX(50);
                    measure1.setPrefWidth(150);
                    measure1.wrapTextProperty().setValue(true);
                    cordinateMeasure += 20;
                    rootList.getChildren().add(measure1);
                }

                windowIncredients.setScene(new Scene(rootList, 400, 500));
                windowIncredients.show();

            }

        });
        rootMeal.getChildren().add(btnList);

        int cordinateXCategory = 0;
        int cordinateYCategory = 40;

        Image img = new Image(resultsCategory.get(0).getStrMealThumb());
        ImageView imgView = new ImageView(img);
        imgView.setTranslateX(-250);
        imgView.setTranslateY(cordinateYCategory-5);
        imgView.setFitHeight(50);
        imgView.setFitWidth(50);

        Label title = new Label();
        title.setText(resultsCategory.get(0).getStrMeal());
        title.setAlignment(Pos.CENTER);
        title.setTranslateY(cordinateYCategory);
        cordinateYCategory += 50;

        Label introductions = new Label();
        introductions.setText(resultsCategory.get(0).getStrInstructions());
        introductions.setAlignment(Pos.CENTER);
        introductions.setTranslateY(cordinateYCategory);
        introductions.setPrefWidth(700);
        introductions.wrapTextProperty().setValue(true);

        rootMeal.getChildren().addAll(title, introductions, imgView);

        sceneMeal = new Scene(rootMeal, 800, 900);
        window.setScene(sceneMeal);

    }

}