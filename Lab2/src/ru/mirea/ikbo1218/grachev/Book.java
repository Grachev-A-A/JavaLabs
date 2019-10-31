package ru.mirea.ikbo1218.grachev;

public class Book {
    private String name, author, publisher;
    private int edition, publishYear;

    public Book(String name, String author, String publisher, int edition, int publishYear) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        setEdition(edition);
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        setEdition(0);
    }

    public Book() {
        this.name = "default";
        this.author = "default";
        setEdition(0);
    }

    @Override
    public String toString() {
        String res = "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'';
        if(edition > 0)
            res += ", publisher='" + publisher + '\'' +
                    ", edition=" + edition  +
                    ", publishYear=" + publishYear+
                    '}';
        else res += ", had not been published yet!}";
        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return edition > 0 ? publisher:"None";
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getEdition() {
        return edition;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPublishYear() {
        return edition > 0 ? publishYear : -1;
    }

    public void setEdition(int edition) {
        if(edition < 0) throw new IllegalArgumentException("Тираж не может быть меньше 0!");
        this.edition = edition;
    }
}
