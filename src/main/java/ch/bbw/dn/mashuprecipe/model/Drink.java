package ch.bbw.dn.mashuprecipe.model;

import javax.print.DocFlavor;
import java.util.ArrayList;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 02.02.2019
 */
public class Drink {

    private String idDrink;
    private String strDrink;
    private String strInstructions;
    private String strDrinkThumb;
    private ArrayList<String> integredients = new ArrayList<String>();
    private ArrayList<String> measures = new ArrayList<String>();

    public Drink() {}

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
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
