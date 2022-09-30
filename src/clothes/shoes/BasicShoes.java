package clothes.shoes;

import clothes.Colour;

import java.util.Random;

public class BasicShoes extends Shoes {
    // constructor
    public BasicShoes(String colour){
        this.setStyle("Basic");
        this.setItem(this.chooseItem());
        if (colour.isEmpty()) {
            Colour col = new Colour();
            this.setColour(col.assignColour());
        }
        else this.setColour(colour);
        this.setPoints_grow(7);
    }
    // override method
    public String chooseItem (){
        return new Random().nextBoolean() ? "converses" : "chelsea boots";
    }
}
