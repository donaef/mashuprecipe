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
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 02.02.2019
 */
public class App extends Application {

    Stage mainWindow;
    Scene sceneCategories;
    String categoryChoosen, mealChoosen;
    TheMealDBAPI theMealDBAPI;
    TheCocktailDBAPI theCocktailDBAPI;
    MySQLDatabase mySQLDatabase;

	public static void main(String[] args) {
        launch(args);
    }

    //---------------------------------------------
    //                  HOME
    //---------------------------------------------

    public void start(Stage primaryStage) {

        mainWindow = primaryStage;
        mainWindow.getIcons().add(new Image("https://www.themealdb.com/images/ingredients/Lime.png"));
        mainWindow.setTitle("MashUpRecipe - Dominik Näf");

        Button btnList = new Button();
        btnList.setText("Shoppinglist");
        btnList.setTranslateX(150);
        btnList.setTranslateY(10);
        btnList.setPrefWidth(100);
        btnList.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                    showList();
            }
        });

        StackPane paneHome = new StackPane();
        paneHome.setAlignment(Pos.TOP_CENTER);

        Label lblTitleCategories = new Label();
        lblTitleCategories.setText("Categories");
        lblTitleCategories.setTranslateY(10);

        theMealDBAPI = new TheMealDBAPI();
        ArrayList<Category> resultsCategories = theMealDBAPI.getAllCategories();
        int cordinateY = 50;
        for (final Category category : resultsCategories) {

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

            paneHome.getChildren().addAll(btnCategory, imgViewCategory);
            cordinateY += 50;

        }

        paneHome.getChildren().addAll(lblTitleCategories, btnList);

        sceneCategories = new Scene(paneHome, 800, 900);
        mainWindow.setScene(sceneCategories);
        mainWindow.show();
        
	}



    //---------------------------------------------
    //              Category Results
    //---------------------------------------------

    public void showCategoryResults() {

        StackPane paneCategoryResults = new StackPane();
        paneCategoryResults.setAlignment(Pos.TOP_CENTER);

        Label lblTitleCategories = new Label();
        lblTitleCategories.setText("Meals in Category");
        lblTitleCategories.setTranslateY(10);

        ArrayList<Meal> resultsCategory = theMealDBAPI.getMealsFilteredByCategory(categoryChoosen);
        int cordinateYCategory = 50;
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

            paneCategoryResults.getChildren().addAll(btnMeal, imgViewMeal);
            cordinateYCategory += 50;
        }

        paneCategoryResults.getChildren().addAll(btnBack(), lblTitleCategories);

        Scene scene = new Scene(paneCategoryResults, 800, 900);
        mainWindow.setScene(scene);

    }



    //---------------------------------------------
    //                    Meal
    //---------------------------------------------

    public void showMeal() {

        StackPane paneMeal = new StackPane();
        paneMeal.setAlignment(Pos.TOP_CENTER);

        final ArrayList<Meal> resultsCategory = theMealDBAPI.getMeal(mealChoosen);

        Button btnYouTube = new Button();
        btnYouTube.setText("YouTube");
        btnYouTube.setTranslateX(250);
        btnYouTube.setTranslateY(10);
        btnYouTube.setPrefWidth(100);
        btnYouTube.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                showVideo(resultsCategory);
            }
        });

        Button btnList = new Button();
        btnList.setText("Ingredients");
        btnList.setTranslateX(250);
        btnList.setTranslateY(45);
        btnList.setPrefWidth(100);
        btnList.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                showIngredients(resultsCategory, null);
            }
        });

        Button btnDrink = new Button();
        btnDrink.setText("Random Drink");
        btnDrink.setTranslateX(250);
        btnDrink.setTranslateY(80);
        btnDrink.setPrefWidth(100);
        btnDrink.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                showDrink();
            }
        });

        Image img = new Image(resultsCategory.get(0).getStrMealThumb());
        ImageView imgView = new ImageView(img);
        imgView.setTranslateX(-250);
        imgView.setTranslateY(40);
        imgView.setFitHeight(50);
        imgView.setFitWidth(50);

        Label lblTitle = new Label();
        lblTitle.setText(resultsCategory.get(0).getStrMeal());
        lblTitle.setAlignment(Pos.CENTER);
        lblTitle.setTranslateY(40);

        Label lblIntruction = new Label();
        lblIntruction.setText(resultsCategory.get(0).getStrInstructions());
        lblIntruction.setAlignment(Pos.CENTER);
        lblIntruction.setTranslateY(140);
        lblIntruction.setPrefWidth(700);
        lblIntruction.wrapTextProperty().setValue(true);

        paneMeal.getChildren().addAll(lblTitle, lblIntruction, imgView, btnList, btnYouTube, btnBack(), btnDrink);
        mainWindow.setScene(new Scene(paneMeal, 800, 900));

    }



    //---------------------------------------------
    //                    List
    //---------------------------------------------

    public void showList() {

        ScrollPane scrollPane = new ScrollPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        final Stage listStage = new Stage();
        listStage.getIcons().add(new Image("https://www.themealdb.com/images/ingredients/Lime.png"));

        mySQLDatabase = new MySQLDatabase();
        ArrayList<List> resultIngredients = mySQLDatabase.getList();

        Button btnDelete = new Button();
        btnDelete.setText("Delete");
        btnDelete.setPrefWidth(200);
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                mySQLDatabase.removeList();
                listStage.close();
            }
        });
        vbox.getChildren().add(btnDelete);

        for (final List ingredient : resultIngredients) {

            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER);

            Label lblIngredient = new Label();
            lblIngredient.setAlignment(Pos.CENTER_LEFT);
            lblIngredient.setText(ingredient.getIngredient() + " - ");
            lblIngredient.wrapTextProperty().setValue(true);

            Label lblMeasure = new Label();
            lblMeasure.setAlignment(Pos.CENTER_RIGHT);
            lblMeasure.setText(ingredient.getMeasure());
            lblMeasure.wrapTextProperty().setValue(true);

            hbox.getChildren().addAll(lblIngredient, lblMeasure);
            vbox.getChildren().add(hbox);

        }

        scrollPane.setContent(vbox);

        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        listStage.setScene(new Scene(scrollPane, 220, 500));
        listStage.show();

    }



    //---------------------------------------------
    //                    Drink
    //---------------------------------------------

    public void showDrink() {

        Stage drinkStage = new Stage();
        drinkStage.getIcons().add(new Image("https://www.themealdb.com/images/ingredients/Lime.png"));

        StackPane drinkPane = new StackPane();
        drinkPane.setAlignment(Pos.TOP_CENTER);

        theCocktailDBAPI = new TheCocktailDBAPI();
        final ArrayList<Drink> resultsDrink = theCocktailDBAPI.getRandomDrink();

        Image img = new Image(resultsDrink.get(0).getStrDrinkThumb());
        ImageView imgView = new ImageView(img);
        imgView.setTranslateX(-100);
        imgView.setTranslateY(45);
        imgView.setFitHeight(50);
        imgView.setFitWidth(50);

        Label lblTitle = new Label();
        lblTitle.setText(resultsDrink.get(0).getStrDrink());
        lblTitle.setAlignment(Pos.CENTER);
        lblTitle.setTranslateY(60);

        Label lblInstruction = new Label();
        lblInstruction.setText(resultsDrink.get(0).getStrInstructions());
        lblInstruction.setAlignment(Pos.CENTER);
        lblInstruction.setTranslateY(111);
        lblInstruction.setPrefWidth(300);
        lblInstruction.wrapTextProperty().setValue(true);

        Button btnIngredient = new Button();
        btnIngredient.setText("Ingredient");
        btnIngredient.setPrefWidth(250);
        btnIngredient.setTranslateY(10);
        btnIngredient.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                showIngredients(null, resultsDrink);
            }
        });

        drinkPane.getChildren().addAll(lblTitle, lblInstruction, imgView, btnIngredient);

        drinkStage.setScene(new Scene(drinkPane, 400, 500));
        drinkStage.show();

    }



    //---------------------------------------------
    //                    Video
    //---------------------------------------------

    public void showVideo(ArrayList<Meal> results) {

        Stage videoStage = new Stage();
        videoStage.getIcons().add(new Image("https://www.themealdb.com/images/ingredients/Lime.png"));

        WebView webView = new WebView();
        webView.getEngine().load(results.get(0).getStrYoutTube());
        webView.setPrefSize(640, 390);

        videoStage.setScene(new Scene(webView));
        videoStage.show();

    }



    //---------------------------------------------
    //                 Ingredients
    //---------------------------------------------

    public void showIngredients(ArrayList<Meal> resultsMeal, ArrayList<Drink> resultsDrink){

        final Stage windowIngredients = new Stage();
        windowIngredients.getIcons().add(new Image("https://www.themealdb.com/images/ingredients/Lime.png"));

        StackPane listPane = new StackPane();
        listPane.setAlignment(Pos.TOP_CENTER);

        final ArrayList<String> ingredients;
        final ArrayList<String> measures;
        if (resultsMeal == null) {
            ingredients = resultsDrink.get(0).getIntegredients();
            measures = resultsDrink.get(0).getMeasures();
        } else {
            ingredients = resultsMeal.get(0).getIntegredients();
            measures = resultsMeal.get(0).getMeasures();
        }

        Button btnShoppingList = new Button();
        btnShoppingList.setText("Add to Shoppinglist");
        btnShoppingList.setPrefWidth(200);
        btnShoppingList.setTranslateY(10);
        btnShoppingList.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                mySQLDatabase = new MySQLDatabase();
                mySQLDatabase.addList(ingredients, measures);
                windowIngredients.close();

            }
        });
        listPane.getChildren().add(btnShoppingList);

        int cordinateIngredient = 50;
        for (String ingredient : ingredients) {
            Label lblIngredient = new Label();
            lblIngredient.setAlignment(Pos.CENTER);
            lblIngredient.setText(ingredient);
            lblIngredient.setTranslateY(cordinateIngredient);
            lblIngredient.setTranslateX(-50);
            lblIngredient.setPrefWidth(150);
            lblIngredient.wrapTextProperty().setValue(true);

            listPane.getChildren().add(lblIngredient);
            cordinateIngredient += 20;
        }

        int cordinateMeasure = 50;
        for (String measure : measures) {
            Label measure1 = new Label();
            measure1.setAlignment(Pos.CENTER);
            measure1.setText(measure);
            measure1.setTranslateY(cordinateMeasure);
            measure1.setTranslateX(50);
            measure1.setPrefWidth(150);
            measure1.wrapTextProperty().setValue(true);

            listPane.getChildren().add(measure1);
            cordinateMeasure += 20;
        }

        windowIngredients.setScene(new Scene(listPane, 400, 500));
        windowIngredients.show();

    }



    //---------------------------------------------
    //                 Back
    //---------------------------------------------

    public Button btnBack(){

        Button btnBack = new Button();
        btnBack.setText("<");
        btnBack.setTranslateY(10);
        btnBack.setTranslateX(-250);
        btnBack.setPrefWidth(50);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                mainWindow.setScene(sceneCategories);
            }
        });

        return btnBack;

    }

}