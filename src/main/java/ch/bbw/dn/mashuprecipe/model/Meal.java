package ch.bbw.dn.mashuprecipe.model;

import java.util.ArrayList;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 02.02.2019
 */
public class Meal {

    private String idMeal;
    private String strMeal;
    private String strMealThumb;
    private String strInstructions;
    private String strYoutTube;
    private ArrayList<String> integredients = new ArrayList<String>();
    private ArrayList<String> measures = new ArrayList<String>();

    public Meal() {};

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrYoutTube() {
        return strYoutTube;
    }

    public void setStrYoutTube(String strYoutTube) {
        this.strYoutTube = strYoutTube;
    }

    public ArrayList<String> getIntegredients() {
        return integredients;
    }

    public void setIntegredients(ArrayList<String> integredients) {
        this.integredients = integredients;
    }

    public ArrayList<String> getMeasures() {
        return measures;
    }

    public void setMeasures(ArrayList<String> measures) {
        this.measures = measures;
    }

}