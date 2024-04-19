public class Gameboard {
    //Variables de clase (Array 3x3 de caracteres representando la partida y tamaño de la diagonal de la matriz)
    private char[][] gameboard;
    private final int SIZE = 3;

    //Constructor de clase, se inicializa el array a ' '
    public Gameboard(){
        this.gameboard = new char[SIZE][SIZE];
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                gameboard[i][j] = ' ';
            }
        }
    }

    //Escribir sobre una celda

    public void TurnByUser(int i, int j){
            gameboard[i][j] = 'x';
    }

    public void TurnByMachine(int i, int j){
            gameboard[i][j] = 'o';
    }


    //Esta funcion booleana comprueba si una celda está vacía, evitando así la sobreescritura
    public boolean EmtyCell(int i, int j){
        return gameboard[i][j] == ' ';
    }


    //Esta funcion booleana comprueba si se ha ganado la partida
        //Esta funcion booleana "CheckCell" compara el valor de una celda con una x o una o
    public boolean CheckCell(char x, int i, int j){
        return gameboard[i][j] == x;
    }
        //Esta funcion comprueba las tres filas, las tres columnas y las dos diagonales
    public boolean EndGame(char x){
        boolean FoundRow = false;
        boolean BreakCycle = false;
        while(FoundRow==false && BreakCycle==false){
            //Comprobar tres filas
            for(int fila = 0; fila<SIZE; fila++){
                if(!FoundRow) {
                    FoundRow = CheckCell(x, fila, 0) && CheckCell(x, fila, 1) && CheckCell(x, fila, 2);
                }
            }
            //Comprobar tres columnas
            for(int columna = 0; columna<SIZE; columna++){
                if(!FoundRow) {
                    FoundRow = CheckCell(x, 0, columna) && CheckCell(x, 1, columna) && CheckCell(x, 2, columna);
                    }
            }
            //Comprobar diagonal principal
                if(!FoundRow) {
                    FoundRow = CheckCell(x, 0, 0) && CheckCell(x, 1, 1) && CheckCell(x, 2, 2);
                }
            //Comprobar diagonal secundaria
                if(!FoundRow) {
                    FoundRow = CheckCell(x, 0, 2) && CheckCell(x, 1, 1) && CheckCell(x, 2, 0);
                }
            //Cortamos el ciclo
            BreakCycle = true;
        }
        return FoundRow;
    }

    //Imprimimos la partida por pantalla

    public void PrintGame(){
        for(int i = 0; i<SIZE; i++){
            for(int j = 0; j<SIZE; j++){
                System.out.print("["+gameboard[i][j]+"]");
            }
            System.out.println(" ");
        }
    }
}
