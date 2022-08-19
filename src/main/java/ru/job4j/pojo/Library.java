package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] arrayOfBooks = new Book[4];
        arrayOfBooks[0] = new Book("Faust. Eine Tragödie", 300);
        arrayOfBooks[1] = new Book("Flight of the Eisenstein", 600);
        arrayOfBooks[2] = new Book("Clean Code", 351);
        arrayOfBooks[3] = new Book("Necronomicon", 666);
        for (int index = 0; index < arrayOfBooks.length; index++) {
            System.out.println(arrayOfBooks[index].getName() + " " + arrayOfBooks[index].getCountOfPappers());
        }
        Book containerForBook = arrayOfBooks[0];
        arrayOfBooks[0] = arrayOfBooks[3];
        arrayOfBooks[3] = containerForBook;
        for (Book currentBook : arrayOfBooks) {
            System.out.println(currentBook.getName() + " " + currentBook.getCountOfPappers());
        }
        for (Book currentBook : arrayOfBooks) {
            if ("Clean Code".equals(currentBook.getName())) {
                System.out.println(currentBook.getName() + " " + currentBook.getCountOfPappers());
            }
        }

    }
}
