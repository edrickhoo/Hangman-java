public class DrawHangman {

    public static void draw(int lives) {
        if(lives == 7) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("________");
        } else if (lives == 6) {
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 5) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 4) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   o");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 3) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   o o");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 2) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   o o");
            System.out.println("|   _|_");
            System.out.println("|");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 1) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   o o");
            System.out.println("|   _|_");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("________");
        }
        else if (lives == 0) {
            System.out.println("_____");
            System.out.println("|    |");
            System.out.println("|   x x");
            System.out.println("|   _|_");
            System.out.println("|    |");
            System.out.println("|   / \\");
            System.out.println("________");
        }


    }
}
