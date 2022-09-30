package clothes.tops;

import arena.Arena;
import clothes.Colour;


public abstract class Top {
    private  String style;
    private  String item;
    private  String colour;
    private int  points_grow;
// constructor
    public Top(){};
// getters and setters
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
     * Chooses item
     * @return name of that item
     */
    public abstract String chooseItem ();

    /**
     * Adds points for a top of outfit
     * @param arena name of round arena
     * @param colour name of item colour
     * @return number of points
     */
    public int Top_points(Arena arena, String colour){
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


