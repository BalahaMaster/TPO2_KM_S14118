package zad1.Model;

public class Item {
    private String ISBN;
    private int authId;
    private String title;
    private int publisherId;
    private int year;
    private float price;

    public Item(String ISBN, int authId, String title, int publisherId, int year, float price) {
        this.ISBN = ISBN;
        this.authId = authId;
        this.title = title;
        this.publisherId = publisherId;
        this.year = year;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
