package clothes.shoes;

import arena.Arena;
import clothes.Colour;


public abstract class Shoes {

    private  String style;
    private  String item;
    private  String colour;
    private int  points_grow ;
// constructor
    public Shoes(){};
// setters and getters
    public void setStyle(String style){
        this.style = style;
    }
    public String getStyle(){
        return this.style;
    }
    public void setItem(String item){
        this.item = item;
    };
    public String getItem() {
        return item;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public void setPoints_grow(int points_grow) {
        this.points_grow = points_grow;
    }

    /**
     * Chooses an item
     * @return name of that item
     */
    public abstract String chooseItem ();

    /**
     * Adds points for shoes of outfit
     * @param arena arena name of round arena
     * @param colour colour name of item colour
     * @return number of points
     */
    public int Shoes_points(Arena arena, String colour){
        Colour col = new Colour();
        if (col.isAppropriateColour(colour, arena.getPreferable_style()))
            return (int)(arena.coeff(this.style)*points_grow)+5;
        else
            return (int)(arena.coeff(this.style)*points_grow);
    }

    public String toString() {
        return colour+" " + item;
    }
}
