import java.util.Random;
import java.util.Scanner;

public class XOgame {
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static final Scanner sc = new Scanner(System.in);
    static final Random random = new Random();
    static char[][] map;

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWinImproved(DOT_X, DOTS_TO_WIN)) {
                System.out.println("Вы победили!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (checkWinImproved(DOT_O, DOTS_TO_WIN)) {
                System.out.println("Компьютер победил. Сейчас их даже в шахматы не выиграть...");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("input Y X");
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x;
        int y;



        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }

        return map[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkDiagonallyBeginning(char c, int dotsToWin) {
        int dots = 0;
        int beginning = 0;
        for (int i = 0; i < SIZE; i++) {
            if ((map[i][beginning] == c && i == 0) || (map[i][beginning] == c && dots == 0) || (map[i][beginning] == c && map[i-1][beginning-1] == c)) {
                dots++;
            } else {
                dots = 0;
            }
            beginning++;
            if (dots >= dotsToWin) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonallyEnd(char c, int dotsToWin) {
        int dots = 0;
        int end = SIZE - 1;
        for (int i = 0; i < SIZE; i++) {
            if ((map[i][end] == c && i == 0) || (map[i][end] == c && dots == 0) || (map[i][end] == c && map[i-1][end+1] == c)) {
                dots++;
            } else {
                dots = 0;
            }
            end--;
            if (dots >= dotsToWin) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkHorizontally(char c, int dotsToWin) {
        int dots;
        for (int i = 0; i < SIZE; i++) {
            dots = 0;
            for (int j = 0; j < SIZE; j++) {
                if ((map[i][j] == c && j == 0) || (map[i][j] == c && dots == 0) || (map[i][j] == c && map[i][j-1] == c)) {
                    dots++;
                } else {
                    dots = 0;
                }
                if (dots >= dotsToWin) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean checkVertically(char c, int dotsToWin) {
        int dots;
        for (int j = 0; j < SIZE; j++) {
            dots = 0;
            for (int i = 0; i < SIZE; i++) {
                if ((map[i][j] == c && i == 0)|| (map[i][j] == c && dots == 0) || (map[i][j] == c && map[i-1][j] == c)) {
                    dots++;
                } else {
                dots = 0;
                }
                if (dots >= dotsToWin) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean checkWinImproved(char c, int dotsToWin) {
        return (checkHorizontally(c, dotsToWin) || checkVertically(c, dotsToWin) || checkDiagonallyBeginning(c, dotsToWin) || checkDiagonallyEnd(c, dotsToWin));
    }

    public static boolean checkWin(char c) {
        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) {
            return true;
        }
        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) {
            return true;
        }
        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) {
            return true;
        }

        if (map[0][0] == c && map[1][0] == c && map[2][0] == c) {
            return true;
        }
        if (map[0][1] == c && map[1][1] == c && map[2][1] == c) {
            return true;
        }
        if (map[0][2] == c && map[1][2] == c && map[2][2] == c) {
            return true;
        }

        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }
        return map[0][2] == c && map[1][1] == c && map[2][0] == c;
    }

}
