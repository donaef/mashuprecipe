package ch.bbw.dn.mashuprecipe.app;

import ch.bbw.dn.mashuprecipe.data.TheCocktailDBAPI;
import ch.bbw.dn.mashuprecipe.data.TheMealDBAPI;
import ch.bbw.dn.mashuprecipe.data.MySQLDatabase;
import ch.bbw.dn.mashuprecipe.model.Category;
import ch.bbw.dn.mashuprecipe.model.Drink;
import ch.bbw.dn.mashuprecipe.model.List;
import ch.bbw.dn.mashuprecipe.model.Meal;
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
    Scene sceneCategories, sceneCategoryResults, sceneMeal;
    String categoryChoosen, mealChoosen;
    TheMealDBAPI theMealDBAPI;

	public static void main(String[] args) {
        launch(args);
    }
    
    public void start(final Stage primaryStage) {

	    window = primaryStage;

        Button btnList = new Button();
        btnList.setText("Shoppinglist");
        btnList.setTranslateX(150);
        btnList.setTranslateY(10);
        btnList.setPrefWidth(100);
        btnList.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                Stage windowList = new Stage();
                StackPane rootList = new StackPane();
                rootList.setAlignment(Pos.TOP_CENTER);

                MySQLDatabase mySQLDatabase = new MySQLDatabase();
                ArrayList<List> incredients = mySQLDatabase.getList();

                int cordinateIncredient = 10;
                for (List incredient : incredients) {

                    Label incredient1 = new Label();
                    incredient1.setAlignment(Pos.CENTER);
                    incredient1.setText(incredient.getIncredient());
                    incredient1.setTranslateY(cordinateIncredient);
                    incredient1.setTranslateX(-50);
                    incredient1.setPrefWidth(150);
                    incredient1.wrapTextProperty().setValue(true);

                    Label measure1 = new Label();
                    measure1.setAlignment(Pos.CENTER);
                    measure1.setText(incredient.getMeasure());
                    measure1.setTranslateY(cordinateIncredient);
                    measure1.setTranslateX(50);
                    measure1.setPrefWidth(150);
                    measure1.wrapTextProperty().setValue(true);

                    rootList.getChildren().addAll(incredient1, measure1);
                    cordinateIncredient += 20;

                }

                windowList.setScene(new Scene(rootList, 400, 500));
                windowList.show();

            }

        });

        //---------------------------------------------
        //                  HOME
        //---------------------------------------------

        theMealDBAPI = new TheMealDBAPI();
        StackPane root = new StackPane();
        root.setAlignment(Pos.TOP_CENTER);

        Label lblTitleCategories = new Label();
        lblTitleCategories.setText("Categories");
        lblTitleCategories.setTranslateY(10);
        root.getChildren().addAll(lblTitleCategories, btnList);

        ArrayList<Category> results = theMealDBAPI.getAllCategories();
        int cordinateY = 40;
        for (final Category category : results) {

            Button btnCategory = new Button();
            btnCategory.setText(category.getStrCategory());
            btnCategory.setTranslateX(0);
            btnCategory.setTranslateY(cordinateY);
            btnCategory.setPrefWidth(400);
            btnCategory.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    categoryChoosen = category.getStrCategory();
                    showCategoryResults();
                }
            });

            Image imgCategory = new Image(category.getStrCategoryThumb());
            ImageView imgViewCategory = new ImageView(imgCategory);
            imgViewCategory.setTranslateX(-250);
            imgViewCategory.setTranslateY(cordinateY-5);
            imgViewCategory.setFitHeight(50);
            imgViewCategory.setFitWidth(50);

            root.getChildren().addAll(btnCategory, imgViewCategory);
            cordinateY += 50;

        }

        sceneCategories = new Scene(root, 800, 900);

        window.setTitle("MashUpRecipe - Dominik Näf");
        window.setScene(sceneCategories);
        window.show();
        
	}

    public void showCategoryResults() {

        //---------------------------------------------
        //          Category Results
        //---------------------------------------------

        StackPane rootCategoryResults = new StackPane();
        rootCategoryResults.setAlignment(Pos.TOP_CENTER);

        Label lblTitleCategories = new Label();
        lblTitleCategories.setText("Meals in Category");
        lblTitleCategories.setTranslateY(10);

        Button btnCategories = new Button();
        btnCategories.setText("<");
        btnCategories.setTranslateX(-250);
        btnCategories.setPrefWidth(50);
        btnCategories.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                window.setScene(sceneCategories);

            }

        });
        rootCategoryResults.getChildren().addAll(btnCategories, lblTitleCategories);

        ArrayList<Meal> resultsCategory = theMealDBAPI.getMealsFilteredByCategory(categoryChoosen);
        int cordinateYCategory = 40;
        for (final Meal meal : resultsCategory) {

            Image imgMeal = new Image(meal.getStrMealThumb());
            ImageView imgViewMeal = new ImageView(imgMeal);
            imgViewMeal.setTranslateX(-250);
            imgViewMeal.setTranslateY(cordinateYCategory-5);
            imgViewMeal.setFitHeight(50);
            imgViewMeal.setFitWidth(50);

            Button btnMeal = new Button();
            btnMeal.setText(meal.getStrMeal());
            btnMeal.setTranslateX(0);
            btnMeal.setTranslateY(cordinateYCategory);
            btnMeal.setPrefWidth(400);
            btnMeal.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    mealChoosen = meal.getIdMeal();
                    showMeal();
                }
            });
            cordinateYCategory += 50;
            rootCategoryResults.getChildren().addAll(btnMeal, imgViewMeal);
        }

        sceneCategoryResults = new Scene(rootCategoryResults, 800, 900);
        window.setScene(sceneCategoryResults);

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

                window.setScene(sceneCategoryResults);

            }

        });

        final ArrayList<Meal> resultsCategory = theMealDBAPI.getMeal(mealChoosen);

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

                final ArrayList<String> incredients = resultsCategory.get(0).getIntegredients();
                final ArrayList<String> measures = resultsCategory.get(0).getMeasures();

                Button btnShoppingList = new Button();
                btnShoppingList.setText("Add to Shoppinglist");
                btnShoppingList.setPrefWidth(150);
                btnShoppingList.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        MySQLDatabase mySQLDatabase = new MySQLDatabase();
                        mySQLDatabase.addList(incredients, measures);

                    }

                });
                rootList.getChildren().add(btnShoppingList);

                int cordinateIncredient = 40;
                int cordinateMeasure = 40;
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



        Button btnDrink = new Button();
        btnDrink.setText("Random Drink");
        btnDrink.setTranslateX(200);
        btnDrink.setTranslateY(70);
        btnDrink.setPrefWidth(100);
        btnDrink.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                Stage windowDrink = new Stage();
                StackPane rootDrink = new StackPane();
                rootDrink.setAlignment(Pos.TOP_CENTER);

                TheCocktailDBAPI drinkAPI = new TheCocktailDBAPI();
                ArrayList<Drink> resultsDrink = drinkAPI.getRandomDrink();

                Image img = new Image(resultsDrink.get(0).getStrDrinkThumb());
                ImageView imgView = new ImageView(img);
                imgView.setTranslateX(-100);
                imgView.setTranslateY(30);
                imgView.setFitHeight(50);
                imgView.setFitWidth(50);

                Label title = new Label();
                title.setText(resultsDrink.get(0).getStrDrink());
                title.setAlignment(Pos.CENTER);
                title.setTranslateY(50);

                Label introductions = new Label();
                introductions.setText(resultsDrink.get(0).getStrInstructions());
                introductions.setAlignment(Pos.CENTER);
                introductions.setTranslateY(100);
                introductions.setPrefWidth(300);
                introductions.wrapTextProperty().setValue(true);

                final ArrayList<String> incredients = resultsDrink.get(0).getIntegredients();
                final ArrayList<String> measures = resultsDrink.get(0).getMeasures();

                Button btnShoppingList = new Button();
                btnShoppingList.setText("Add to Shoppinglist");
                btnShoppingList.setPrefWidth(150);
                btnShoppingList.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        MySQLDatabase mySQLDatabase = new MySQLDatabase();
                        mySQLDatabase.addList(incredients, measures);

                    }

                });
                rootDrink.getChildren().addAll(btnShoppingList, imgView, title, introductions);

                int cordinateIncredient = 225;
                int cordinateMeasure = 225;
                for (String incredient : incredients) {
                    Label incredient1 = new Label();
                    incredient1.setAlignment(Pos.CENTER);
                    incredient1.setText(incredient);
                    incredient1.setTranslateY(cordinateIncredient);
                    incredient1.setTranslateX(-50);
                    incredient1.setPrefWidth(150);
                    incredient1.wrapTextProperty().setValue(true);
                    cordinateIncredient += 20;
                    rootDrink.getChildren().add(incredient1);
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
                    rootDrink.getChildren().add(measure1);
                }

                windowDrink.setScene(new Scene(rootDrink, 400, 500));
                windowDrink.show();

            }

        });

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
        cordinateYCategory += 100;

        Label introductions = new Label();
        introductions.setText(resultsCategory.get(0).getStrInstructions());
        introductions.setAlignment(Pos.CENTER);
        introductions.setTranslateY(cordinateYCategory);
        introductions.setPrefWidth(700);
        introductions.wrapTextProperty().setValue(true);

        rootMeal.getChildren().addAll(title, introductions, imgView, btnList, btnYouTube, btnCategories, btnDrink);

        sceneMeal = new Scene(rootMeal, 800, 900);
        window.setScene(sceneMeal);

    }

}