package Assignment_3;

import java.util.ArrayList;

public class ArrayList_Book {

    public static void main(String[] args){

        Assignment_3_Book b1 = new Assignment_3_Book();
        Assignment_3_Book b2 = new Assignment_3_Book("Eclipse", "Stephanie Mayer", "Fiction", 455.96);
        Assignment_3_Book b3 = new Assignment_3_Book("Atomic Habits", "James Clear", 899.99, "AH1724");
        Assignment_3_Book b4 = b2;

        b4.name = "Harry Potter and the Deathly Hallows";
        b4.authorName = "J.K.Rowling";

        Assignment_3_Book b5 = new Assignment_3_Book(b3);
        b5.name = "And Then There Were None";
        b5.authorName = "Agatha Cristie";

        ArrayList<Assignment_3_Book> bList = new ArrayList<Assignment_3_Book>();

        bList.add(b1);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);
        bList.add(b5);

        bList.forEach(b->{
            System.out.println(b.name);
            System.out.println(b.authorName);
            System.out.println(b.price);
            System.out.println(b.ISBN);
            System.out.println(b.genre);
            System.out.println(b.publisherName);
            System.out.println(b.dateOfPublishing);
        });

        // one more foreach statement to calc the avg of price
    }
}
