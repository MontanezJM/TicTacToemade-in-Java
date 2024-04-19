import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        //Tablero, Scanner y Randomizador
        Gameboard gameboard = new Gameboard();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Variables de juego
        boolean MyTurn = true;
        char Winner = ' ';
        int inputX = 0;
        int inputY = 0;
        int NumberOfTurns = 0;

        welcoming(gameboard);

        //Transcurso de la partida
        while(Winner == ' ' && NumberOfTurns < 9){
            if(MyTurn){
                System.out.println("Te toca");
                do {
                    System.out.println("En que fila escribiras tu 'x'?");
                    do {
                        inputX = scanner.nextInt();
                    } while (inputX < 1 || inputX > 3);
                    System.out.println("En que columna escribirás tu 'x'?");
                    do {
                        inputY = scanner.nextInt();
                    } while (inputY < 1 || inputY > 3);
                    if(!gameboard.EmtyCell(inputX-1,inputY-1)){
                        System.out.println("Como vas a sobreescribir una celda papanatas?");
                    }
                }while(!gameboard.EmtyCell(inputX-1,inputY-1));
                gameboard.TurnByUser(inputX-1,inputY-1);
                gameboard.PrintGame();
                if(gameboard.EndGame('x')){
                    Winner = 'x';
                }else{
                    MyTurn = !MyTurn;
                    NumberOfTurns++;
                }
            }else{
                System.out.println("Me toca, calculando posible jugada PARA NADA ALEATORIA...");
                do {
                    do {
                        inputX = random.nextInt(0,3);
                    } while (inputX < 0 || inputX > 2);
                    do {
                        inputY = random.nextInt(0,3);
                    } while (inputY < 0 || inputY > 2);
                }while(!gameboard.EmtyCell(inputX,inputY));
                gameboard.TurnByMachine(inputX,inputY);
                gameboard.PrintGame();
                if(gameboard.EndGame('o')){
                    Winner = 'o';
                }else{
                    MyTurn = !MyTurn;
                    NumberOfTurns++;
                }
            }
        }
        switch(Winner){
            case 'x' ->
                System.out.println("Ganaste de puta potra hermano");
            case 'o' ->
                System.out.println("Ya me jodería ser tan subnormal como pa perder contra un programa hecho por alguien de la ETSII");
            case ' ' ->
                System.out.println("Empate (Sigues siendo gilipollas)");
        }
    }
    //Mensaje de bienvenida
    public static void welcoming(Gameboard gameboard){
        System.out.println("Hola, soy un puto programa que juega contra retrasaos mentales al tres en raya");
        System.out.println("CÓMO SE JUEGA: Cuando sea tu turno, dame un número del 1 al 3 indicando en que fila escribirás tu 'x' y luego un número del 1 al 3 indicando en qué columna la colocarás.");
        gameboard.PrintGame();
    }
}
