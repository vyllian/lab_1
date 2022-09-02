package lab2_book;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publication;
    private int pub_year;
    private int pages_num;
    private int price;

    /**
     * constructor
     */
    public Book(){}

    /**
     * getter for id field
     * @return id value
     */
    public int getId() {return id;}

    /**
     * getter for title field
     * @return book title
     */
    public String getTitle() {return title;}

    /**
     * getter for author field
     * @return book author
     */
    public String getAuthor() {return author;}

    /**
     * getter for publication field
     * @return book publication
     */
    public String getPublication() {return publication;}

    /**
     * getter for pub_year field
     * @return book year of publishing
     */
    public int getPub_year() {return pub_year;}

    /**
     * getter for pages_num field
     * @return book pages amount
     */
    public int getPages_num() {return pages_num;}  //!!!

    /**
     * getter for price field
     * @return book price
     */
    public int getPrice() {return price;}   //!!!

    /**
     *setter for id field
     * @param id book id
     */
    public void setId(int id) {this.id = id;}

    /**
     * setter for title field
     * @param title book title
     */
    public void setTitle(String title) {this.title = title;}

    /**
     * setter for author field
     * @param author book author
     */
    public void setAuthor(String author) {this.author = author;}

    /**
     * setter for publication field
     * @param publication book publication
     */
    public void setPublication(String publication) {this.publication = publication;}

    /**
     * setter fot pub_year field
     * @param pub_year book year of publishing
     */
    public void setPub_year(int pub_year) {this.pub_year = pub_year;}

    /**
     * setter for pages_num field
     * @param pages_num book amount of pages
     */
    public void setPages_num(int pages_num) {this.pages_num = pages_num;}

    /**
     * setter for price field
     * @param price book price
     */
    public void setPrice(int price) {this.price = price;}

    //??
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author +" ("+ pages_num+" p.) - "+ publication +" publication - " + price +" UAH";
    }
}
