package ch.bbw.dn.mashuprecipe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

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

    public ArrayList<Meal> filterByCategory(String categoryChoosen) {

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












    public ArrayList<Meal> showMeal(String mealChoosen) {

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

}
