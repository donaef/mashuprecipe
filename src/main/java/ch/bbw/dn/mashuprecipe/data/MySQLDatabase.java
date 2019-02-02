package ch.bbw.dn.mashuprecipe.data;

import ch.bbw.dn.mashuprecipe.model.List;

import java.sql.*;
import java.util.ArrayList;

/**
 * MashUpRecipe
 * @author  Dominik Näf
 * @version 02.02.2019
 */
public class MySQLDatabase {

    public MySQLDatabase() {}

    //---------------------------------------------
    //                 getList
    //---------------------------------------------

    public ArrayList<List> getList() {

        ArrayList<List> list = new ArrayList<List>();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/mashuprecipe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "");
            Statement stmt = connection.createStatement();
            ResultSet entries = stmt.executeQuery("SELECT * FROM List");

            while (entries.next()) {
                List tempList = new List();
                tempList.setId(entries.getInt("id"));
                tempList.setIngredient(entries.getString("ingredient"));
                tempList.setMeasure(entries.getString("measure"));
                list.add(tempList);
            }

            entries.close();
            stmt.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }



    //---------------------------------------------
    //                 addList
    //---------------------------------------------

    public void addList(ArrayList<String> ingredients, ArrayList<String> measures) {

        for (int i = 0; i < 20; i++) {
            if (!ingredients.get(i).equals("")){

                try {

                    String myUrl = "jdbc:mysql://localhost/mashuprecipe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                    Connection conn = DriverManager.getConnection(myUrl, "root", "");

                    String query = "INSERT INTO List (ingredient, measure)" + " values (?, ?)";

                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, ingredients.get(i));
                    preparedStmt.setString(2, measures.get(i));

                    preparedStmt.execute();
                    conn.close();

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

            }
        }

        try {

            String myUrl = "jdbc:mysql://localhost/mashuprecipe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String query = "INSERT INTO List (ingredient, measure)" + " values (?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "");
            preparedStmt.setString(2, "");

            preparedStmt.execute();
            conn.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }



    //---------------------------------------------
    //                 removeList
    //---------------------------------------------

    public void removeList() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String myUrl = "jdbc:mysql://localhost/mashuprecipe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            PreparedStatement st = conn.prepareStatement("DELETE FROM list");
            st.executeUpdate();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

}
