package zad1.DAL;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class DbTable {
    private String tableName;
    private String[] columnNames;
    private DbConnection dbcon;

    public DbTable(DbConnection dbcon, String tableName) {
        this.tableName = tableName;
        this.dbcon = dbcon;
        setColumnNames();
    }

    public void setColumnNames(){
        try {
            dbcon.setUpConnection();
            DatabaseMetaData dbm = dbcon.getCon().getMetaData();
            ResultSet columns = dbm.getColumns(null, null, tableName, null);
            ArrayList<String> names = new ArrayList<>();
            while(columns.next()){
                names.add(columns.getString("COLUMN_NAME"));
            }
            columnNames = names.toArray(new String[names.size()]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            dbcon.close();
        }
    }

    public int getLastId(){
        String selectLastId = "SELECT Max(" + columnNames[0] + ") FROM " + tableName;
        ResultSet set = null;
        dbcon.setUpConnection();
        Statement querry = null;
        int id = -1;
        try {
            querry = dbcon.getCon().createStatement( );
            set = querry.executeQuery(selectLastId);
            id = set.getInt(1);
        } catch (SQLException e) {
            if(e.toString().contains("no current row"));
                return 0;
        }
        finally{
            dbcon.close();
        }
        return id;
    }

    public int insert(String[] values) throws Exception {
        StringBuilder columnNamesString = new StringBuilder();
        columnNamesString.append("(");
        columnNamesString.append(String.join(",", columnNames));
        columnNamesString.append(")");

        String query = "INSERT INTO " + tableName + " " + columnNamesString + " VALUES " + String.join(",", values);
        try {
            dbcon.setUpConnection();
            PreparedStatement statement = dbcon.getCon().prepareStatement(query);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbcon.close();
        }
        return -1;
    }

}
