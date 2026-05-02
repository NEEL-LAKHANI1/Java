package Assignment_3;

import java.time.*;

public class Assignment_3_Book {

    public String name;
    public String authorName;
    public String publisherName;
    public String genre;
    public String ISBN;

    public double price;

    public LocalDate dateOfPublishing;


    public Assignment_3_Book(){                          // Default Constructor
        price = 0;
        authorName = "Unknown";
        publisherName = "Unspecified";
        genre = "Uncategorized";
        ISBN = "0000000";
        dateOfPublishing = LocalDate.parse("2020-01-01");
    }

    public Assignment_3_Book(String n, String a, double p, String isbn){
        price = p;
        ISBN = isbn;
    }

    // The parameter order should be different for the constructor method as 2 methods with same order of parameter is not allowed
    // Here we are doing methodOverloading as same method name but different parameters ( order )

// Line 25 and 34 - Parameterized Constructor

    public Assignment_3_Book(String n, String a, String g, double p){

        name = n;
        authorName = a;
        genre = g;
        price = p;
    }

// Line 44 - Copy constructor

    public Assignment_3_Book(Assignment_3_Book b){

        name = b.name;
        authorName = b.authorName;
        price = b.price;
        publisherName = b.publisherName;
        genre = b.genre;
        ISBN = b.ISBN;
    }
}
