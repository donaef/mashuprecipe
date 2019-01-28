package ch.bbw.dn.mashuprecipe.data;

import ch.bbw.dn.mashuprecipe.model.List;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDatabase {

    public MySQLDatabase() {}

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
                tempList.setIncredient(entries.getString("incredient"));
                tempList.setMeasure(entries.getString("measure"));
                list.add(tempList);
            }

            // alle verwendeten Objekte schliessen
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

    public void addList(ArrayList<String> incredients, ArrayList<String> measures) {

        for (int i = 0; i < 20; i++) {
            if (!incredients.get(i).equals("")){

                try {

                    String myUrl = "jdbc:mysql://localhost/mashuprecipe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                    Connection conn = DriverManager.getConnection(myUrl, "root", "");

                    String query = "INSERT INTO List (incredient, measure)" + " values (?, ?)";

                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, incredients.get(i));
                    preparedStmt.setString(2, measures.get(i));

                    preparedStmt.execute();
                    conn.close();

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

            }
        }




    }

}
