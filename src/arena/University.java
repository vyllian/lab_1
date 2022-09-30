package arena;

public class University extends Arena {
    // constructor
    public University(){
        this.setName("University");
        this.setPreferable_style("Preppy");

    }
    @Override
    public double coeff(String style) {
        return switch (style) {
            case "Casual" -> 0.5;
            case "Preppy", "Basic" -> 1.0;
            default -> -0.5;
        };
    }


}
