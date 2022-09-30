package clothes.shoes;

import clothes.Colour;

import java.util.Random;

public class RomanticShoes extends Shoes {
    // constructor
    public RomanticShoes(String colour){
        this.setStyle("Romantic");
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
        return new Random().nextBoolean() ? "sandals" : "mules";
    }

}
