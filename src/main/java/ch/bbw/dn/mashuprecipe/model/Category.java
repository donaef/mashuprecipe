package ch.bbw.dn.mashuprecipe.model;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 02.02.2019
 */
public class Category {

    private String idCategory;
    private String strCategory;
    private String strCategoryThumb;

    public Category() {};

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

}
