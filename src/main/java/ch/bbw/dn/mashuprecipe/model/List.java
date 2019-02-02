package ch.bbw.dn.mashuprecipe.model;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 02.02.2019
 */
public class List {

    private int id;
    private String ingredient;
    private String measure;

    public List() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

}
