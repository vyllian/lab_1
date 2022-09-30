
import arena.Arena;
import clothes.Outfit;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    private String name;
    private ArrayList<Outfit> team;
    private int team_points;
//constructors
    public Team(){};
    public Team(Battle battle, ArrayList<Outfit> players, int number, String name){
        this.name = name;
        Scanner scan = new Scanner(System.in);
        battle.Players_list(players);
        this.team = new ArrayList<>();
        for (int i=0;i<number;i++){
            System.out.println("\n1 - choose player from a list, 2 - create new player:");
            if (Integer.parseInt(scan.nextLine())==1){
                System.out.print("Enter player's number: ");
                this.team.add(players.get(Integer.parseInt(scan.nextLine())-1));
            }
            else this.team.add(battle.Create_droid("team"));

        }
    }
    public String getName() {
        return name;
    }
    public ArrayList<Outfit> getTeam() {
        return team;
    }
    public int getTeam_points() {
        return team_points;
    }
    public void setTeam_points(int team_points) {
        this.team_points += team_points;
    }

    /**
     * Adds points for a round
     * @param writer writer for file input
     * @param arena round arena
     * @param enemy opponent team
     * @param mode writing for a file or console
     * @return number of points
     */
    public int Round_points(BufferedWriter writer, Arena arena, Team enemy, String mode){
        int points = 0;
        for (Outfit d: this.team){
            points += d.Round_points(writer, arena, enemy.team.get(this.team.indexOf(d)), mode);
        }
        return points;
    }

    /**
     * Cheks if team won
     * @return true or false
     */
    public boolean isWinner(){
        return this.team_points>=100;
    }

    /**
     * Outputs team members into a file
     * @param writer for writing to a file
     */
    public void Team_to_file(BufferedWriter writer){
        int i=0;
        for (Outfit d: this.team){
            try {
                writer.write(i++ +"\n"+d);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
