import accessory.*;
import arena.*;
import clothes.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    /** Creates a player, enters its name, chooses style
     *
     * @param mode writing to a file or console
     * @return created player(outfit)
     */
    public Outfit creationStep1(String mode){
        Scanner scan = new Scanner(System.in);
        String name;
        if (mode.equals("team"))
            name = "";
        else {
            System.out.print("Enter name for the player: ");
            name = scan.nextLine();
        }
        System.out.println("""
                            \tChoose style:
                            \t1 - casual
                            \t2 - romantic
                            \t3 - preppy""");
        return switch (Integer.parseInt(scan.nextLine())) {
            case 1 -> new Outfit(name, "Casual");
            case 2 -> new Outfit(name,"Romantic");
            case 3 -> new Outfit(name,"Preppy");
            default -> null;
        };
    }

    /**
     * Adds accessory to an outfit, adjusts it
     * @param mode writing to a file or console
     * @return changed outfit
     */
    public Outfit Create_droid(String mode){
        Outfit droid = this.creationStep1(mode);
        System.out.println(droid);
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to add an accessory? 1 - yes, 0 - no: ");
        if (Integer.parseInt(scan.nextLine())==0){
            this.Make_changes(droid);
            return droid;}
        System.out.println("""
                 Choose accessory:
                 1 - purse
                 2 - cap
                 3 - watch
                 4 - glasses
                 0 - no accessory""");
        switch (Integer.parseInt(scan.nextLine())){
            case 1 -> droid.setAccessory(new Purse());
            case 2 -> droid.setAccessory(new Cap());
            case 3 -> droid.setAccessory(new Watch());
            case 4 -> droid.setAccessory(new Glasses());
        }
        this.Make_changes(droid);
        return droid;
    }

    /**
     * Makes changes to an outfit
     * @param droid outfit we wanna change
     */
    public void Make_changes(Outfit droid){
        Scanner scan = new Scanner(System.in);
        System.out.print("If you want to change either an item - press 1, or the color of an item - press 2, otherwise - press 0: ");
        int opt=0;
        switch (Integer.parseInt(scan.nextLine())){
            case 1:
                System.out.println("""
                What item you want to change? Press:
                1 - top
                2 - bottom
                3 - shoes""");
                opt = Integer.parseInt(scan.nextLine());
                switch (opt){
                    case 1 -> droid.changeTop(droid.getStyle());
                    case 2 -> droid.changeBottom(droid.getStyle());
                    case 3 -> droid.changeShoes(droid.getStyle());
                }
                System.out.print("Your item is changed, wanna change its colour as well? 1 - yes, 0 - no: ");
                if (Integer.parseInt(scan.nextLine())==0)
                    break;
            case 2:
                if (opt ==0 ){
                    System.out.println("""
                    Colour of what item you want to change? Press:
                    1 - top
                    2 - bottom
                    3 - shoes""");
                    opt = Integer.parseInt(scan.nextLine());
                }
                Colour col = new Colour();
                System.out.print("Available colours: "+ col.getAllColours() + "\nYour choice: ");
                String colour = scan.nextLine();
                switch (opt){
                    case 1 -> droid.getTop().setColour(colour);
                    case 2 -> droid.getBottom().setColour(colour);
                    case 3 -> droid.getShoes().setColour(colour);
                }
                break;
            default: return;
        }
    }

    /**
     * Print list of players
     * @param players an array of creadet players
     */
    public void Players_list(ArrayList<Outfit> players){
        System.out.println("Available players:");
        if (players.isEmpty()){
            System.out.print("Sorry, no players added.\nCreate new? 1 - yes, 0 - no: ");
            Scanner scan = new Scanner(System.in);
            if (Integer.parseInt(scan.nextLine())==1)
                players.add(this.Create_droid("single"));
            return;
        }
        for (int i = 0; i <players.size(); i++){
            System.out.printf("%-29s", i + 1+". "+ players.get(i).getName()+":");
        }
        System.out.println();
        for (Outfit p: players){
            if (p.getAccessory()==null ||p.getAccessory().getItem().equals("watch") ||p.getAccessory().getItem().equals("purse") )
                 System.out.printf("%30s","|");
            else if (p.getAccessory().getItem().equals("cap") ||p.getAccessory().getItem().equals("glasses"))
                System.out.printf("%-29s|",p.getAccessory().getItem());
        }
        System.out.println();
        for (Outfit p: players) {
            if (p.getAccessory()==null || p.getAccessory().getItem().equals("cap") ||p.getAccessory().getItem().equals("glasses"))
                System.out.printf("%-7s%-22s|",p.getTop().getColour(), p.getTop().getItem());
            else if(p.getAccessory().getItem().equals("purse") || p.getAccessory().getItem().equals("watch"))
                System.out.printf("%-7s%-13s %-7s |", p.getTop().getColour(),p.getTop().getItem(),p.getAccessory().getItem());

        }
        System.out.println();
        for (Outfit p: players)
            System.out.printf("%-7s%-21s |",p.getBottom().getColour(),p.getBottom().getItem());
        System.out.println();
        for (Outfit p: players)
            System.out.printf("%-7s%-21s |",p.getShoes().getColour(),p.getShoes().getItem());
        System.out.println();
    }

    /**
     * Randomly chooses the arena for a round
     * @param usage array of booleans to mark arena's usage
     * @return chosen arena
     */
    public Arena Set_arena(boolean[] usage) {
        int opt = new Random().nextInt(4);
        while (usage[opt]){
            opt = new Random().nextInt(4);
        }
        switch (opt) {
            case 0:
                usage[0] = true;
                return new University();
            case 1:
                usage[1] = true;
                return new Theatre();
            case 2:
                usage[2] = true;
                return new Park();
            case 3:
                usage[3] = true;
               return new Cafe();
            default: return null;
        }
    }

    /**
     * Leads a round of a battle for 1 to 1 game
     * @param writer for file input
     * @param droid1 player 1
     * @param droid2 player 2
     * @param usage array of booleans to mark arena's usage for Set_arena method
     * @param n number of round
     * @param mode writing to a file or console
     * @throws IOException exception for file writing
     */
    public void Round_1v1(BufferedWriter writer, Outfit droid1, Outfit droid2, boolean[] usage, int n, String mode) throws IOException {
        if (mode.equals("console"))
            System.out.println("\n\t\t\t\tRound "+n);
        else writer.write("\n\n\t\t\tRound "+n+"\n");
        Arena arena =  this.Set_arena(usage);
        int d1_points;
        int d2_points;
        if (mode.equals("console")) {
            System.out.print(arena);
            d1_points = droid1.Round_points(null,arena, droid2,mode);
            d2_points = droid2.Round_points(null,arena, droid1,mode);
            System.out.println("\n"+droid1.getName() +"'s round points:" + d1_points+
                    "\n" + droid2.getName()+"'s round points:" +d2_points);
        }
        else {
            writer.write(String.valueOf(arena));
            d1_points = droid1.Round_points(writer,arena, droid2,mode);
            d2_points = droid2.Round_points(writer,arena, droid1,mode);
            writer.write("\n"+droid1.getName() +"'s round points:" + d1_points+
                    "\n" + droid2.getName()+"'s round points:" +d2_points);
        };

        droid1.setOutfit_points(d1_points);
        droid2.setOutfit_points(d2_points);
    }

    /**
     * Leads a round of a battle for team game
     * @param writer for file input
     * @param team1 team 1
     * @param team2 team 2
     * @param usage array of booleans to mark arena's usage for Set_arena method
     * @param n number of round
     * @param mode writing to a file or console
     * @throws IOException exception for file writing
     */
    public void Round_teams(BufferedWriter writer, Team team1, Team team2, boolean[] usage, int n, String mode) throws IOException {
        if (mode.equals("console"))
            System.out.println("\n\t\t\t\tRound "+n);
        else writer.write("\n\n\t\t\tRound "+n+"\n");
        Arena arena =  this.Set_arena(usage);
        int t1_points;
        int t2_points;
        if (mode.equals("console")) {
            System.out.print(arena);
            t1_points = team1.Round_points(null,arena, team2,mode)/team1.getTeam().size();
            t2_points = team2.Round_points(null,arena, team1,mode)/team2.getTeam().size();
            System.out.println("\n"+team1.getName() +"'s round points:" + t1_points+
                    "\n" + team2.getName()+"'s round points:" +t2_points);
        }
        else {
            writer.write(String.valueOf(arena));
            t1_points = team1.Round_points(writer,arena, team2,mode)/team1.getTeam().size();
            t2_points = team2.Round_points(writer,arena, team1,mode)/team2.getTeam().size();
            writer.write("\n"+team1.getName() +"'s round points:" + t1_points+
                    "\n" + team2.getName()+"'s round points:" +t2_points);
        };
        team1.setTeam_points(t1_points);
        team2.setTeam_points(t2_points);

    }

    /**
     * Leads a full battle for a 1 to 1 game
     * @param players array of available players
     * @throws IOException exception for file writing
     */
    public void Battle_1v1(ArrayList<Outfit> players) throws IOException {
        boolean[] Arena_usage = new boolean[4];
        Scanner scan = new Scanner(System.in);
        Outfit droid1, droid2;
        System.out.print("Player 1:\n1 - choose player from a list, 2 - create new player: ");
        if (Integer.parseInt(scan.nextLine())==1){
            this.Players_list(players);
            System.out.print("Enter player's number: ");
            droid1 = players.get(Integer.parseInt(scan.nextLine())-1);
        }
        else droid1 = Create_droid("single");
        System.out.print("Player 2:\n1 - choose player from a list, 2 - create new player: ");
        if (Integer.parseInt(scan.nextLine())==1){
            System.out.print("Enter player's number: ");
            droid2= players.get(Integer.parseInt(scan.nextLine())-1);
        }
        else {
            droid2 = Create_droid("single");
            System.out.println(droid2);
        }
        System.out.print("1 - write battle to a console, 2 - to a file: ");
        if (Integer.parseInt(scan.nextLine())==2){
            System.out.print("Enter file name: ");
            String filename  = scan.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write(droid1.getName()+" VS "+droid2.getName()+" BATTLE\n\n");
                writer.write("Player 1:\n"+ droid1);
                writer.write("Player 2:\n"+ droid1);
                int i=1;
                while (Single_winner(droid1,droid2)==null) {
                    this.Round_1v1(writer,droid1, droid2, Arena_usage,i++,"f");
                    writer.write("\n\nTotal points:\n"+droid1.getName()+ " - " + droid1.getOutfit_points() + "\n"+droid2.getName() +" - " + droid2.getOutfit_points());
                }
                if (Single_winner(droid1,droid2).getOutfit_points()!=0)
                    writer.write("\nThe winner is: "+ Single_winner(droid1,droid2).getName());
                else
                    writer.write("\nBoth are winners!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Battle is in your file!");

        }
        else {
            int i = 1;
            while (Single_winner(droid1, droid2) == null) {
                this.Round_1v1(null, droid1, droid2, Arena_usage, i++, "c");
                System.out.println("\nTotal points:\n" + droid1.getName() + " - " + droid1.getOutfit_points() + "\n" + droid2.getName() + " - " + droid2.getOutfit_points());
            }
            if (Single_winner(droid1, droid2).getOutfit_points() != 0)
                System.out.println("The winner is: " + Single_winner(droid1, droid2).getName());
            else
                System.out.println("Both are winners!");
        }
    }

    /**
     *  Leads a full battle for a team game
     * @param players array of available players
     * @throws IOException exception for file writing
     */
    public void Battle_commands (ArrayList<Outfit> players) throws IOException {
        boolean[] Arena_usage = new boolean[4];
        System.out.print("Enter number of players for commands: ");
        Scanner scan = new Scanner(System.in);
        int players_number = Integer.parseInt(scan.nextLine());
        System.out.print("Enter name for command 1: ");
        Team team1 = new Team(this,players,players_number,scan.nextLine());
        System.out.print("Enter name for command 2: ");
        Team team2 = new Team(this,players,players_number,scan.nextLine());
        System.out.print("1 - write battle to a console, 2 - to a file: ");
        if (Integer.parseInt(scan.nextLine())==2){
            System.out.print("Enter file name: ");
            String filename  = scan.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write(team1.getName()+" VS "+team2.getName()+" BATTLE\n\n");
                writer.write("\n"+ team1.getName()+":");
                team1.Team_to_file(writer);
                writer.write("\n"+ team2.getName()+":");
                team1.Team_to_file(writer);
                int i=1;
                while (Team_winner(team1,team2)==null) {
                    this.Round_teams(writer,team1, team2, Arena_usage,i++,"file");
                    writer.write("\n\nTotal points:\n"+team1.getName()+ " - " + team1.getTeam_points() + "\n"+team2.getName() +" - " + team2.getTeam_points());
                }
                if (Team_winner(team1,team2).getTeam_points()!=0)
                    writer.write("\nThe winner is: "+ Team_winner(team1,team2).getName());
                else
                    writer.write("\nBoth are winners!");
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Battle is in your file!");

        }
        else {
            System.out.println("Team "+team1.getName() +":\n");
            this.Players_list(team1.getTeam());
            System.out.println("Team "+team2.getName() +":\n");
            this.Players_list(team2.getTeam());
            int i = 1;
            while (Team_winner(team1,team2)==null) {
                this.Round_teams(null,team1, team2, Arena_usage,i++,"console");
                System.out.println("\nTotal points:\n" + team1.getName() + " - " + team1.getTeam_points() + "\n" + team2.getName() + " - " + team2.getTeam_points());
            }
            if (Team_winner(team1,team2).getTeam_points() != 0)
                System.out.println("The winner is: " + Team_winner(team1,team2).getName());
            else
                System.out.println("\nBoth are winners!");
        }

    }

    /**
     * Shows battle from a certain file
     * @param filename name of file
     */
    public void Battle_from_file(String filename){
        System.out.println();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Defines winner in 1 to 1 game
     * @param droid1 player 1
     * @param droid2 player 2
     * @return player who won, null if nobody, new player obj if both
     */
    public Outfit Single_winner(Outfit droid1, Outfit droid2){
        if (droid1.isWinner() && droid2.isWinner())
            return new Outfit();
        else if (droid1.isWinner())
            return droid1;
        else if (droid2.isWinner())
            return droid2;
        else return null;
    }

    /**
     * Defines winner in team game
     * @param team1 team 1
     * @param team2 team 2
     * @return team who won, null if nobody, new team obj if both
     */
    public Team Team_winner(Team team1, Team team2){
        if (team1.isWinner() && team2.isWinner())
            return new Team();
        else if (team1.isWinner())
            return team1;
        else if (team2.isWinner())
            return team2;
        else return null;
    }




}
