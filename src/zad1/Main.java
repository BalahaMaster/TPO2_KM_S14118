package zad1;

import zad1.Controller.Welcome;
import zad1.DAL.DbConnection;
import zad1.DAL.DbTable;
import zad1.Model.Author;
import zad1.Model.Item;
import zad1.Model.Publisher;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        DbConnection dbcon = new DbConnection("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:db/ksidb");
        setUpDb(dbcon);


    }

    public static void setUpDb(DbConnection dbcon){
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author(1,"Jacek Dukaj"));
        authors.add(new Author(2,"Andrzej Sapkowski"));
        authors.add(new Author(3,"Terry Prachet"));

        ArrayList<Publisher> publishers = new ArrayList<>();
        publishers.add(new Publisher(1,"superNOVA"));
        publishers.add(new Publisher(2,"Prószyński i S-ka"));
        publishers.add(new Publisher(3,"Wydawnictwo Literackie"));

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("978-83-08-04-277-9", 1, "Perfekcyjna niedoskonałość", 3,2004,35.90f));
        items.add(new Item("978-83-08-04226-7", 1, "Inne pieśni", 3,2003,54.90f));
        items.add(new Item("978-83-08-045-37-4", 1, "Król Bólu", 3,2011,44.90f));
        items.add(new Item("978-83-7578-028-4", 2, "Ostatnie Życzenie", 1,2010,29.90f));
        items.add(new Item("978-83-7648-032-9", 3, "Czarodzicielstwo", 2,2005,29.90f));

        DbTable authorDbTable = new DbTable(dbcon, Author.getTableName());
        DbTable publisherDbTable = new DbTable(dbcon, Publisher.getTableName());
        DbTable itemDbTable = new DbTable(dbcon, Item.getTableName());

        try {
            authorDbTable.insert(Author.createInsert(authors));
            publisherDbTable.insert(Publisher.createInsert(publishers));
            itemDbTable.insert(Item.createInsert(items));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
