package book;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class NewBook {
    private String name;
    private String author;
    private String size;

    public NewBook(String name, String author, String size) {
        this.name = name;
        this.author = author;
        this.size = size;
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

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
}

class Book {
    private int id;
    private String name;
    private String author;
    private String size;

    public Book(int id, String name, String author, String size) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.size = size;
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

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

}

@Component
class BookStorage {
    private Map<Integer, Book> map;
    private int key = 1;

    public BookStorage() {
        map = new HashMap<Integer, Book>();
    }

    public boolean isEmpty() {
        if (map.isEmpty()) {
            return true;
        }
        return false;
    }

    public void add(String name, String author, String size) {
        map.put(key, new Book(key, name, author, size));
        key = key + 1;
    }

    public ArrayList<Book> get() {
        return new ArrayList<>(map.values());
    }

    public void removeByName(int id) {
            map.remove(id);
    }
}