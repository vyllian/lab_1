package clothes.bottoms;

import clothes.Colour;

import java.util.Random;


public class BasicBottoms extends Bottom {
    // constructor
    public BasicBottoms(String colour){
        this.setStyle("Basic");
        this.setItem(this.chooseItem());
        if (colour.isEmpty()){
            Colour col = new Colour();
            this.setColour(col.assignColour());
        }
        else this.setColour(colour);
        this.setPoints_grow(7);
    }
    // override method
    public String chooseItem (){
        return new Random().nextBoolean() ? "jeans" : "overall";
    }

}
