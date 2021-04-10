import java.util.Random;

public class Maze {
    private static final int DEUX = 2; // ????
    public static final int TROIS = 3; //
    public static final int UN = 1;
    public static final int GOTO_START = 270;

    private final int horizontal;
    private final int vertical;

    int[][] matrixChemin;
    CellType[][] matrix;
    int target = 0;      // where GOTO goes
    int q = 0;      // continue ? / start a new iteration ?  // 0 or 1
    int z = 0;      // mis une seule fois à 1, testé plusieurs fois.
    int roll;       // variable temp pour les choix aléatoires.
    int nbOfIterations = 1; // nb of iterations, and also used to flag cells where the path is.
    Random random;


    StringBuffer result = new StringBuffer();


    public Maze(int horizontal, int vertical, Random random) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.random = random;

        this.matrixChemin = new int[horizontal + 1][vertical + 1];
        for (int i = 0; i <= horizontal; i++) {
            matrixChemin[i] = new int[vertical + 1];
        }

        this.matrix = new CellType[horizontal + 1][vertical + 1];
        for (int i = 0; i <= horizontal; i++) {
            matrix[i] = new CellType[vertical + 1];
            for (int j = 0; j <= vertical; j++) {
                matrix[i][j] = CellType.CLOSE_RIGHT_BOTTOM;
            }
        }
    }

    public void extracted() {
        print("Amazing - Copyright by Creative Computing, Morristown, NJ");
        println();

        if (horizontal == 1 || vertical == 1) return;
        this.roll = rand(horizontal);

        // crée la 1ere ligne ?
        for (int i = 1; i <= horizontal; i++) {
            if (i == roll)
                print(":  ");
            else
                print(":--");
        }

        print(":");
        println();


        matrixChemin[roll][1] = nbOfIterations;
        nbOfIterations++;

        int row = roll;
        int line = 1;
        GOTO(GOTO_START);

        while (isNotFinished()) {
            switch (target) {
                case 210:
                    if (row != horizontal) {
                        row++;
                    } else {
                        if (line != vertical) {
                            row = 1;
                            line++;
                        } else {
                            row = 1;
                            line = 1;
                        }
                    }
                    GOTO(260);
                    continue;
                case 260:
                    if (isNotChemin(row, line))
                        GOTO(210);
                    else
                        GOTO(GOTO_START);
                    continue;
                case GOTO_START: //start
                    q = 0;
                    if (row - 1 == 0)
                        GOTO(600);
                    else
                        GOTO(280);
                    continue;
                case 280:
                    if (isChemin(row - 1, line))
                        GOTO(600);
                    else {
                        if (line - 1 == 0 || isChemin(row, line - 1)) {
                            if (row == horizontal || isChemin(row + 1, line)) {
                                if (line != vertical) {
                                    if (isChemin(row, line + 1))
                                        GOTO(940);
                                    else
                                        GOTO(570);
                                } else {
                                    if (z == 1)
                                        GOTO(940);
                                    else {
                                        q = 1;
                                        GOTO(570);
                                    }
                                }
                            } else {
                                if (line != vertical) {
                                    if (isChemin(row, line + 1))
                                        GOTO(510);
                                    else
                                        GOTO(490);
                                } else {
                                    if (z == 1)
                                        GOTO(510);
                                    else {
                                        q = 1;
                                        GOTO(490);
                                    }
                                }
                            }
                        } else {
                            if (row == horizontal || isChemin(row + 1, line)) {
                                if (line != vertical) {
                                    if (isChemin(row, line + 1))
                                        GOTO(410);
                                    else
                                        GOTO(390);
                                } else {
                                    if (z == 1)
                                        GOTO(410);
                                    else {
                                        q = 1;
                                        GOTO(390);
                                    }
                                }
                            } else {
                                roll = rand(3);
                                if (roll == UN)
                                    GOTO(940);
                                else if (roll == DEUX)
                                    GOTO(980);
                                else if (roll == TROIS)
                                    GOTO(1020);
                            }
                        }
                    }
                    continue;
                case 390:
                    roll = rand(3);
                    if (roll == UN)
                        GOTO(940);
                    else if (roll == DEUX)
                        GOTO(980);
                    else if (roll == TROIS)
                        GOTO(1090);
                    continue;
                case 410:
                    if (isUneChanceSurDeux())
                        GOTO(940);
                    else
                        GOTO(980);
                    continue;
                case 490:
                    roll = rand(3);
                    if (roll == UN)
                        GOTO(940);
                    else if (roll == DEUX)
                        GOTO(1020);
                    else if (roll == TROIS)
                        GOTO(1090);
                    continue;
                case 510:
                    if (isUneChanceSurDeux())
                        GOTO(940);
                    else
                        GOTO(1020);
                    continue;
                case 570:
                    if (isUneChanceSurDeux())
                        GOTO(940);
                    else
                        GOTO(1090);
                    continue;
                case 600:
                    if (line - 1 == 0)
                        GOTO(790);
                    else {
                        if (isChemin(row, line - 1))
                            GOTO(790);
                        else {
                            if (row == horizontal || isChemin(row + 1, line)) {
                                if (line != vertical) {
                                    if (isChemin(row, line + 1))
                                        GOTO(980);
                                    else
                                        GOTO(760);
                                } else {
                                    if (z == 1)
                                        GOTO(980);
                                    else {
                                        q = 1;
                                        GOTO(760);
                                    }
                                }
                            } else {
                                if (line != vertical) {
                                    if (isChemin(row, line + 1))
                                        GOTO(700);
                                    else
                                        GOTO(680);
                                } else {
                                    if (z == 1)
                                        GOTO(700);
                                    else {
                                        q = 1;
                                        GOTO(680);
                                    }
                                }
                            }
                        }
                    }
                    continue;
                case 680:
                    roll = rand(3);
                    if (roll == UN)
                        GOTO(980);
                    else if (roll == DEUX)
                        GOTO(1020);
                    else if (roll == TROIS)
                        GOTO(1090);
                    continue;
                case 700:
                    if (isUneChanceSurDeux())
                        GOTO(980);
                    else
                        GOTO(1020);
                    continue;
                case 760:
                    if (isUneChanceSurDeux())
                        GOTO(980);
                    else
                        GOTO(1090);
                    continue;
                case 790:
                    if (row == horizontal)
                        GOTO(880);
                    else {
                        if (isChemin(row + 1, line))
                            GOTO(880);
                        else {
                            if (line != vertical) {
                                if (isChemin(row, line + 1))
                                    GOTO(1020);
                                else {
                                    if (isUneChanceSurDeux())
                                        GOTO(1020);
                                    else
                                        GOTO(1090);
                                }
                            } else {
                                if (z == 1)
                                    GOTO(1020);
                                else {
                                    q = 1;
                                    GOTO(990);
                                }
                            }
                        }
                    }
                    continue;
                case 880:
                    if (line != vertical) {
                        if (isChemin(row, line + 1))
                            GOTO(210);
                        else
                            GOTO(1090);
                    } else {
                        if (z == 1)
                            GOTO(210);
                        else {
                            q = 1;
                            GOTO(1090);
                        }
                    }
                    continue;
                case 940:
                    matrixChemin[row - 1][line] = nbOfIterations;
                    nbOfIterations++;
                    matrix[row - 1][line] = CellType.CLOSE_BOTTOM;
                    row--;
                    GOTO(GOTO_START);
                    continue;
                case 980:
                    matrixChemin[row][line - 1] = nbOfIterations;
                    GOTO(990);
                    continue;
                case 990:
                    nbOfIterations++;
                    matrix[row][line - 1] = CellType.CLOSE_RIGHT;
                    line--;
                    GOTO(GOTO_START);
                    continue;
                case 1020:
                    matrixChemin[row + 1][line] = nbOfIterations;
                    nbOfIterations++;
                    if (matrix[row][line] == CellType.CLOSE_RIGHT_BOTTOM)
                        matrix[row][line] = CellType.CLOSE_BOTTOM;
                    else
                        matrix[row][line] = CellType.OPEN;
                    row++;
                    GOTO(600);
                    continue;
                case 1090:
                    if (q == 1) {
                        z = 1;      // only time when z is changed.
                        if (matrix[row][line] == CellType.CLOSE_RIGHT_BOTTOM) {
                            matrix[row][line] = CellType.CLOSE_RIGHT;
                            q = 0;
                            row = 1;
                            line = 1;
                            GOTO(260);
                        } else {
                            matrix[row][line] = CellType.OPEN;
                            q = 0;
                            GOTO(210);
                        }
                    } else {
                        matrixChemin[row][line + 1] = nbOfIterations;
                        nbOfIterations++;
                        if (matrix[row][line] == CellType.CLOSE_RIGHT_BOTTOM) {
                            matrix[row][line] = CellType.CLOSE_RIGHT;
                        } else {
                            matrix[row][line] = CellType.OPEN;
                        }
                        line++;
                        GOTO(GOTO_START);
                    }
            }

        }

        for (
                int j = 1;
                j <= vertical; j++) {
            print("I");

            for (int i = 1; i <= horizontal; i++) {
                if (matrix[i][j] == CellType.CLOSE_RIGHT_BOTTOM || matrix[i][j] == CellType.CLOSE_RIGHT) {
                    print("  I");
                } else if (matrix[i][j] == CellType.CLOSE_BOTTOM || matrix[i][j] == CellType.OPEN) {
                    print("   ");
                }
            }

            print(" ");
            println();

            for (int i = 1; i <= horizontal; i++) {
                if (matrix[i][j] == CellType.CLOSE_RIGHT_BOTTOM)
                    print(":--");
                else if (matrix[i][j] == CellType.CLOSE_BOTTOM)
                    print(":--");
                else if (matrix[i][j] == CellType.CLOSE_RIGHT || matrix[i][j] == CellType.OPEN)
                    print(":  ");
            }

            print(":");
            println();
        }
    }

    public void GOTO(int lineno) {
        target = lineno;
    }

    public int rand(int count) {
        return (int) (count * random.nextFloat()) + 1;
    }

    private boolean isUneChanceSurDeux() {
        return rand(2) == UN;
    }

    private boolean isNotFinished() {
        return nbOfIterations != (horizontal * vertical) + 1;
    }

    private boolean isNotChemin(int row, int line) {
        return !isChemin(row, line);
    }

    private boolean isChemin(int row, int line) {
        return matrixChemin[row][line] != 0;
    }

    private void println() {
        result.append("\n");
    }

    public void print(String text) {
        result.append(text);
    }
}
