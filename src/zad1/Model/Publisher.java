package zad1.Model;

import java.util.List;

public class Publisher {
    private static String tableName = "WYDAWCA";
    private int id;
    private String name;

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Publisher(String name) {
        this.name = name;
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

    public static String[] createInsert(List<Publisher> publishers){
        String[] valuesString = new String[publishers.size()];

        for(Publisher p : publishers){
            valuesString[publishers.indexOf(p)] = "(" + p.id  + ",'" + p.getName() + "')";
        }
        return valuesString;
    }

    public static String getTableName() {
        return tableName;
    }
}
