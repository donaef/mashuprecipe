package ch.bbw.dn.mashuprecipe.data;

import ch.bbw.dn.mashuprecipe.model.Drink;
import ch.bbw.dn.mashuprecipe.model.Meal;
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
 * @version 02.02.2019
 */
public class TheCocktailDBAPI {

    public TheCocktailDBAPI() {}

    //---------------------------------------------
    //                 getDrink
    //---------------------------------------------

    public ArrayList<Drink> getRandomDrink(){

        ArrayList<Drink> returnList = new ArrayList<Drink>();

        try {

            URL url = new URL("https://www.thecocktaildb.com/api/json/v1/1/random.php");
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
            JSONArray drinks = mainJSONObject.getJSONArray("drinks");
            for (int i = 0; i < drinks.length(); i++) {

                JSONObject jsonMealsInstance = drinks.getJSONObject(i);

                Drink drinkTemp = new Drink();
                drinkTemp.setStrDrink(jsonMealsInstance.getString("strDrink"));
                drinkTemp.setStrDrinkThumb(jsonMealsInstance.getString("strDrinkThumb"));
                drinkTemp.setStrInstructions(jsonMealsInstance.getString("strInstructions"));

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
                ingredients.add("");
                ingredients.add("");
                ingredients.add("");
                ingredients.add("");
                ingredients.add("");

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
                measures.add("");
                measures.add("");
                measures.add("");
                measures.add("");
                measures.add("");

                drinkTemp.setIntegredients(ingredients);
                drinkTemp.setMeasures(measures);

                returnList.add(drinkTemp);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnList;

    }

}
