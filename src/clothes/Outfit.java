package clothes;

import accessory.Accessory;
import arena.Arena;
import clothes.bottoms.*;
import clothes.shoes.*;
import clothes.tops.*;

import java.io.BufferedWriter;
import java.util.Random;

public class Outfit {
    private String name;
    private String style;
    private Top top;
    private Bottom bottom;
    private Shoes shoes;
    private Accessory accessory;
    private int outfit_points;
// constructors
    public Outfit(){

};
    public Outfit(String name,String style){
        this.name = name;
        this.style = style;
        if (style.equals("Casual")) {
            this.top = new Random().nextBoolean() ? new BasicTops("") : new CasualTops("");
            this.bottom = new Random().nextBoolean() ? new BasicBottoms("") : new CasualBottoms("");
            this.shoes = new Random().nextBoolean() ? new BasicShoes("") : new CasualShoes("");
        }
        else if (style.equals("Romantic")){
            this.top = new Random().nextBoolean() ? new BasicTops("") : new RomanticTops("");
            this.bottom = new Random().nextBoolean() ? new BasicBottoms("") : new RomanticBottoms("");
            this.shoes = new Random().nextBoolean() ? new BasicShoes("") : new RomanticShoes("");
        }
        else {
            this.top = new Random().nextBoolean() ? new BasicTops("") : new PreppyTops("");
            this.bottom = new Random().nextBoolean() ? new BasicBottoms("") : new PreppyBottoms("");
            this.shoes = new Random().nextBoolean() ? new BasicShoes("") : new PreppyShoes("");
        }
        this.accessory=null;
        this.outfit_points=0;

    }
// getters and setters
    public String getName() {
        return name;
    }
    public String getStyle() {
        return style;
    }
    public Top getTop() {
        return top;
    }
    public Bottom getBottom() {
        return bottom;
    }
    public Shoes getShoes() {
        return shoes;
    }
    public Accessory getAccessory(){return accessory;}
    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }
    public void setOutfit_points(int round_points) {
        this.outfit_points += round_points;
    }
    public int getOutfit_points() {
        return outfit_points;
    }

    /**
     * Changes top into another
     * @param style style of an outfit
     */
    public void changeTop(String style){
        Top temp = this.top;
        while (temp.equals(this.top)) {
            switch (style) {
                case "Casual" -> this.top = new Random().nextBoolean() ? new BasicTops(this.getTop().getColour()) : new CasualTops(this.getTop().getColour());
                case "Romantic" -> this.top = new Random().nextBoolean() ? new BasicTops(this.getTop().getColour()) : new RomanticTops(this.getTop().getColour());
                default -> this.top = new Random().nextBoolean() ? new BasicTops(this.getTop().getColour()) : new PreppyTops(this.getTop().getColour());
            }
        }
    }

    /**
     * Changes bottom into another
     * @param style style of an outfit
     */
    public void changeBottom(String style){
        Bottom temp = this.bottom;
        while (temp.equals(this.bottom)) {
            switch (style) {
                case "Casual" -> this.bottom = new Random().nextBoolean() ? new BasicBottoms(this.getBottom().getColour()) : new CasualBottoms(this.getBottom().getColour());
                case "Romantic" -> this.bottom = new Random().nextBoolean() ? new BasicBottoms(this.getBottom().getColour()) : new RomanticBottoms(this.getBottom().getColour());
                default -> this.bottom = new Random().nextBoolean() ? new BasicBottoms(this.getBottom().getColour()) : new PreppyBottoms(this.getBottom().getColour());
            }
        }
    }

    /**
     * Changes shoes into another
     * @param style style of an outfit
     */
    public void changeShoes(String style){
        Shoes temp = this.shoes;
        while (temp.equals(this.shoes)) {
            switch (style) {
                case "Casual" -> this.shoes = new Random().nextBoolean() ? new BasicShoes(this.getShoes().getColour()) : new CasualShoes(this.getShoes().getColour());
                case "Romantic" -> this.shoes = new Random().nextBoolean() ? new BasicShoes(this.getShoes().getColour()) : new RomanticShoes(this.getShoes().getColour());
                default -> this.shoes = new Random().nextBoolean() ? new BasicShoes(this.getShoes().getColour()) : new PreppyShoes(this.getShoes().getColour());
            }
        }
    }

    /**
     * Checks if player is a winner
     * @return true or false
     */
    public boolean isWinner(){
        return this.outfit_points>=100;
    }

    /**
     * Adds points for a round
     * @param writer for file input
     * @param arena round arena
     * @param enemy opponent
     * @param mode writing for a file or console
     * @return number of points
     */
    public int Round_points(BufferedWriter writer, Arena arena, Outfit enemy, String mode){
        if (this.accessory == null)
            return this.top.Top_points(arena,this.top.getColour()) + this.bottom.Bottom_points(arena,this.bottom.getColour())+
                this.shoes.Shoes_points(arena,this.shoes.getColour());
        return this.top.Top_points(arena,this.top.getColour()) + this.bottom.Bottom_points(arena,this.bottom.getColour())+
                this.shoes.Shoes_points(arena,this.shoes.getColour()) + this.accessory.Accessory_points(writer,arena,this, enemy,mode);

    }


    @Override
    public String toString() {
        if (this.accessory == null){
            if (this.name.equals(""))
                return top +"\n" + bottom + "\n" + shoes+"\n";
            return name+"'s outfit:\n"+ top +"\n" + bottom + "\n" + shoes+"\n";
        }
        if (this.accessory.getItem().equals("purse") || this.accessory.getItem().equals("watch")){
            if (this.name.equals(""))
                return top +" "+ accessory+"\n" + bottom + "\n" + shoes+"\n";
            return name+"'s outfit:\n"+ top +" "+ accessory+"\n" + bottom + "\n" + shoes+"\n";
        }
        if (this.name.equals(""))
            return accessory +"\n"+ top +"\n" + bottom + "\n" + shoes+"\n";
        return  name+"'s outfit:\n"+accessory +"\n"+ top +"\n" + bottom + "\n" + shoes+"\n";

    }


}
