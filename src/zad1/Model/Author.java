package zad1.Model;

import java.util.List;

public class Author {
    private static String tableName = "AUTOR";
    private int id;
    private String name;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }

    public static String getTableName() {
        return tableName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String[] createInsert(List<Author> authors){
        String[] valuesString = new String[authors.size()];

        for(Author a : authors){
            valuesString[authors.indexOf(a)] = "(" + a.id + ",'" + a.getName() + "')";
        }
        return valuesString;
    }
}
