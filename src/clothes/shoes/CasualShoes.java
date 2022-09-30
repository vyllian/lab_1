package clothes.shoes;

import clothes.Colour;

import java.util.Random;

public class CasualShoes extends Shoes {
    // constructor
    public CasualShoes(String colour){
        this.setStyle("Casual");
        this.setItem(this.chooseItem());
        if (colour.isEmpty()){
            Colour col = new Colour();
            this.setColour(col.assignColour());
        }
        else this.setColour(colour);
        this.setPoints_grow(16);
    }
    // override method
    public String chooseItem (){
        return new Random().nextBoolean() ? "sneakers" : "crocs";
    }

}
