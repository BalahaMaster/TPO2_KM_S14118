package zad1;

import zad1.DAL.DbConnection;
import zad1.DAL.DbTable;
import zad1.Model.Author;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        DbConnection dbcon = new DbConnection("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:db/ksidb");

        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Jacek Dukaj"));
        authors.add(new Author("Andrzej Sapkowski"));
        authors.add(new Author("Terry Prachet"));

        DbTable authorDbTable = new DbTable(dbcon, Author.getTableName());
        String[][] authorsTable = new String[authors.size()][2];

        int lastId = authorDbTable.getLastId();
        if(lastId < 0) return;

        String[] valuesString = new String[authors.size()];

        for(Author a : authors){
            valuesString[authors.indexOf(a)] = "(" + ++lastId  + ",'" + a.getName() + "')";
        }
        try {
            authorDbTable.insert(valuesString);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
