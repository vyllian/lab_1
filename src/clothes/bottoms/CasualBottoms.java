package clothes.bottoms;

import clothes.Colour;

import java.util.Random;

    public class CasualBottoms extends Bottom {
        // constructor
        public CasualBottoms(String colour){
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
            return new Random().nextBoolean() ? "sweatpants" : "shorts";
        }


    }
