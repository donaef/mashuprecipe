package ch.bbw.dn.mashuprecipe;

import java.util.ArrayList;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 19.01.2019
 */
public class Meal {

    private String strMeal;
    private String strMealThumb;
    private String idMeal;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strTags;
    private String strYoutTube;
    private String strSource;
    private String dateModified;
    private ArrayList<String> integredients = new ArrayList<String>();
    private ArrayList<String> measures = new ArrayList<String>();

    public Meal() {};

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

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrYoutTube() {
        return strYoutTube;
    }

    public void setStrYoutTube(String strYoutTube) {
        this.strYoutTube = strYoutTube;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

}