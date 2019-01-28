package ch.bbw.dn.mashuprecipe.model;

import javax.print.DocFlavor;
import java.util.ArrayList;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 19.01.2019
 */
public class Drink {

    private String idDrink;
    private String strDrink;
    private String strDrinkES;
    private String strDrinkDE;
    private String strDrinkFR;
    private String strDrinkZH_HANS;
    private String strDrinkZH_HANT;
    private String strVideo;
    private String strCategory;
    private String strIBA;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;
    private String strInstructionsES;
    private String strInstructionsDE;
    private String strInstructionsFR;
    private String strInstructionsZH_HANS;
    private String strInstructionsZH_HANT;
    private String strDrinkThumb;
    private ArrayList<String> integredients = new ArrayList<String>();
    private ArrayList<String> measures = new ArrayList<String>();
    private String dateModified;

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

    public String getStrDrinkES() {
        return strDrinkES;
    }

    public void setStrDrinkES(String strDrinkES) {
        this.strDrinkES = strDrinkES;
    }

    public String getStrDrinkDE() {
        return strDrinkDE;
    }

    public void setStrDrinkDE(String strDrinkDE) {
        this.strDrinkDE = strDrinkDE;
    }

    public String getStrDrinkFR() {
        return strDrinkFR;
    }

    public void setStrDrinkFR(String strDrinkFR) {
        this.strDrinkFR = strDrinkFR;
    }

    public String getStrDrinkZH_HANS() {
        return strDrinkZH_HANS;
    }

    public void setStrDrinkZH_HANS(String strDrinkZH_HANS) {
        this.strDrinkZH_HANS = strDrinkZH_HANS;
    }

    public String getStrDrinkZH_HANT() {
        return strDrinkZH_HANT;
    }

    public void setStrDrinkZH_HANT(String strDrinkZH_HANT) {
        this.strDrinkZH_HANT = strDrinkZH_HANT;
    }

    public String getStrVideo() {
        return strVideo;
    }

    public void setStrVideo(String strVideo) {
        this.strVideo = strVideo;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrIBA() {
        return strIBA;
    }

    public void setStrIBA(String strIBA) {
        this.strIBA = strIBA;
    }

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public void setStrAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public void setStrGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrInstructionsES() {
        return strInstructionsES;
    }

    public void setStrInstructionsES(String strInstructionsES) {
        this.strInstructionsES = strInstructionsES;
    }

    public String getStrInstructionsDE() {
        return strInstructionsDE;
    }

    public void setStrInstructionsDE(String strInstructionsDE) {
        this.strInstructionsDE = strInstructionsDE;
    }

    public String getStrInstructionsFR() {
        return strInstructionsFR;
    }

    public void setStrInstructionsFR(String strInstructionsFR) {
        this.strInstructionsFR = strInstructionsFR;
    }

    public String getStrInstructionsZH_HANS() {
        return strInstructionsZH_HANS;
    }

    public void setStrInstructionsZH_HANS(String strInstructionsZH_HANS) {
        this.strInstructionsZH_HANS = strInstructionsZH_HANS;
    }

    public String getStrInstructionsZH_HANT() {
        return strInstructionsZH_HANT;
    }

    public void setStrInstructionsZH_HANT(String strInstructionsZH_HANT) {
        this.strInstructionsZH_HANT = strInstructionsZH_HANT;
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

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

}
