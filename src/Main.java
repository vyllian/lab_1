import clothes.Outfit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Battle battle = new Battle();
       ArrayList<Outfit> players = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean cont= true;
        while(cont){
            System.out.print("""
                   Menu:
                   1 - add new player
                   2 - player's list
                   3 - start a 1vs1 game
                   4 - start a command game
                   5 - take battle from a file
                   0 - exit
                   Choose action:""");
            switch (Integer.parseInt(scan.nextLine())) {
                case 1 -> players.add(battle.Create_droid("single"));
                case 2 -> battle.Players_list(players);
                case 3 -> battle.Battle_1v1(players);
                case 4 -> battle.Battle_commands(players);
                case 5 -> {
                    System.out.print("Enter filename: ");
                    battle.Battle_from_file(scan.nextLine());
                }
                default -> cont = false;
            }
        }
    }
}