package ch.bbw.dn.mashuprecipe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 19.01.2019
 */
public class API {

    public API() {}

    public ArrayList<Category> getAllCategories() {

        ArrayList<Category> returnList = new ArrayList<Category>();

        try {

            URL url = new URL("https://www.themealdb.com/api/json/v1/1/categories.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine = "";

            while ((inputLine = in.readLine()) != null) {

                response.append(inputLine);

            }

            in.close();

            JSONObject mainJSONObject = new JSONObject(response.toString());
            JSONArray categories = mainJSONObject.getJSONArray("categories");
            for (int i = 0; i < categories.length(); i++) {
                JSONObject jsonCategoriesInstance = categories.getJSONObject(i);
                Category categoryTemp = new Category();
                categoryTemp.setIdCategory(jsonCategoriesInstance.getString("idCategory"));
                categoryTemp.setStrCategory(jsonCategoriesInstance.getString("strCategory"));
                categoryTemp.setStrCategoryThumb(jsonCategoriesInstance.getString("strCategoryThumb"));
                categoryTemp.setStrCategoryDescription(jsonCategoriesInstance.getString("strCategoryDescription"));
                returnList.add(categoryTemp);
            }


        } catch (Exception e) {
            // TODO: handle exception
        }

        return returnList;

    }

    public ArrayList<Meal> getMealsFilteredByCategory(String categoryChoosen) {

        ArrayList<Meal> returnList = new ArrayList<Meal>();

        try {

            URL url = new URL("https://www.themealdb.com/api/json/v1/1/filter.php?c="+categoryChoosen);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine = "";

            while ((inputLine = in.readLine()) != null) {

                response.append(inputLine);

            }

            in.close();

            JSONObject mainJSONObject = new JSONObject(response.toString());
            JSONArray meals = mainJSONObject.getJSONArray("meals");
            for (int i = 0; i < meals.length(); i++) {

                JSONObject jsonMealsInstance = meals.getJSONObject(i);
                Meal mealTemp = new Meal();
                mealTemp.setIdMeal(jsonMealsInstance.getString("idMeal"));
                mealTemp.setStrMeal(jsonMealsInstance.getString("strMeal"));
                mealTemp.setStrMealThumb(jsonMealsInstance.getString("strMealThumb"));
                returnList.add(mealTemp);

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return returnList;

    }

    public ArrayList<Meal> getMeal(String mealChoosen) {

        ArrayList<Meal> returnList = new ArrayList<Meal>();

        try {

            URL url = new URL("https://www.themealdb.com/api/json/v1/1/lookup.php?i="+mealChoosen);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine = "";

            while ((inputLine = in.readLine()) != null) {

                response.append(inputLine);

            }

            in.close();

            JSONObject mainJSONObject = new JSONObject(response.toString());
            JSONArray meals = mainJSONObject.getJSONArray("meals");
            for (int i = 0; i < meals.length(); i++) {

                JSONObject jsonMealsInstance = meals.getJSONObject(i);
                Meal mealTemp = new Meal();
                mealTemp.setStrMeal(jsonMealsInstance.getString("strMeal"));
                mealTemp.setStrMealThumb(jsonMealsInstance.getString("strMealThumb"));
                mealTemp.setStrInstructions(jsonMealsInstance.getString("strInstructions"));
                mealTemp.setStrYoutTube(jsonMealsInstance.getString("strYoutube"));

                ArrayList<String> ingredients = new ArrayList<String>();
                ArrayList<String> measures = new ArrayList<String>();

                ingredients.add(jsonMealsInstance.getString("strIngredient1"));
                ingredients.add(jsonMealsInstance.getString("strIngredient2"));
                ingredients.add(jsonMealsInstance.getString("strIngredient3"));
                ingredients.add(jsonMealsInstance.getString("strIngredient4"));
                ingredients.add(jsonMealsInstance.getString("strIngredient5"));
                ingredients.add(jsonMealsInstance.getString("strIngredient6"));
                ingredients.add(jsonMealsInstance.getString("strIngredient7"));
                ingredients.add(jsonMealsInstance.getString("strIngredient8"));
                ingredients.add(jsonMealsInstance.getString("strIngredient9"));
                ingredients.add(jsonMealsInstance.getString("strIngredient10"));
                ingredients.add(jsonMealsInstance.getString("strIngredient11"));
                ingredients.add(jsonMealsInstance.getString("strIngredient12"));
                ingredients.add(jsonMealsInstance.getString("strIngredient13"));
                ingredients.add(jsonMealsInstance.getString("strIngredient14"));
                ingredients.add(jsonMealsInstance.getString("strIngredient15"));
                ingredients.add(jsonMealsInstance.getString("strIngredient16"));
                ingredients.add(jsonMealsInstance.getString("strIngredient17"));
                ingredients.add(jsonMealsInstance.getString("strIngredient18"));
                ingredients.add(jsonMealsInstance.getString("strIngredient19"));
                ingredients.add(jsonMealsInstance.getString("strIngredient20"));

                measures.add(jsonMealsInstance.getString("strMeasure1"));
                measures.add(jsonMealsInstance.getString("strMeasure2"));
                measures.add(jsonMealsInstance.getString("strMeasure3"));
                measures.add(jsonMealsInstance.getString("strMeasure4"));
                measures.add(jsonMealsInstance.getString("strMeasure5"));
                measures.add(jsonMealsInstance.getString("strMeasure6"));
                measures.add(jsonMealsInstance.getString("strMeasure7"));
                measures.add(jsonMealsInstance.getString("strMeasure8"));
                measures.add(jsonMealsInstance.getString("strMeasure9"));
                measures.add(jsonMealsInstance.getString("strMeasure10"));
                measures.add(jsonMealsInstance.getString("strMeasure11"));
                measures.add(jsonMealsInstance.getString("strMeasure12"));
                measures.add(jsonMealsInstance.getString("strMeasure13"));
                measures.add(jsonMealsInstance.getString("strMeasure14"));
                measures.add(jsonMealsInstance.getString("strMeasure15"));
                measures.add(jsonMealsInstance.getString("strMeasure16"));
                measures.add(jsonMealsInstance.getString("strMeasure17"));
                measures.add(jsonMealsInstance.getString("strMeasure18"));
                measures.add(jsonMealsInstance.getString("strMeasure19"));
                measures.add(jsonMealsInstance.getString("strMeasure20"));

                mealTemp.setIntegredients(ingredients);
                mealTemp.setMeasures(measures);

                returnList.add(mealTemp);

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return returnList;

    }

}
