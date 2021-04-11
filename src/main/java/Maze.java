import java.util.Random;

public class Maze {
    private static final int DEUX = 2; // ????
    public static final int TROIS = 3; //
    public static final int UN = 1;
    public static final int GOTO_START = 270;
    public static final int FIRST_ROW = 0;
    public static final int FIRST_LINE = 0;

    private final int horizontalSize;
    private final int verticalSize;

    Random random;

    int[][] matrixChemin;
    CellType[][] matrix;
    int target = 0;      // where GOTO goes
    int q = 0;      // continue ? / start a new iteration ?  // 0 or 1
    int z = 0;      // mis une seule fois à 1, testé plusieurs fois. quand on arrive à la dernière ligne ?
    int roll;       // variable temp pour les choix aléatoires. soit 1/2, soit 1/2/3. soit n'importe où dans la 1ere ligne pour démarrer.
    int nbOfIterations = 1; // nb of iterations, and also used to flag cells where the path is.
    int row;
    int line;
    
    StringBuffer result = new StringBuffer();

    public Maze(int horizontalSize, int verticalSize, Random random) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        this.random = random;

        this.matrixChemin = new int[horizontalSize + 1][verticalSize + 1];
        for (int i = 0; i <= horizontalSize; i++) {
            matrixChemin[i] = new int[verticalSize + 1];
        }

        this.matrix = new CellType[horizontalSize + 1][verticalSize + 1];
        for (int i = FIRST_ROW; i <= horizontalSize; i++) {
            matrix[i] = new CellType[verticalSize + 1];
            for (int j = FIRST_LINE; j <= verticalSize; j++) {
                matrix[i][j] = CellType.CLOSE_RIGHT_BOTTOM;
            }
        }
    }

    public void extracted() {
        print("Amazing - Copyright by Creative Computing, Morristown, NJ");
        println();

        if (horizontalSize == 1 || verticalSize == 1) return;
        this.roll = rand(horizontalSize);

        // crée la 1ere ligne ?
        for (int i = 1; i <= horizontalSize; i++) {
            if (i == roll)
                print(CellType.OPEN.bottom);
            else
                print(CellType.CLOSE_BOTTOM.bottom);
        }

        print(":");
        println();


        matrixChemin[roll][1] = nbOfIterations;
        nbOfIterations++;

        row = roll;
        line = 1;
        GOTO(210);

        while (isNotFinished()) {
            switch (target) {
                case 210:
                    int[] rowLine = searchNewCell(row, line);
                    row = rowLine[0];
                    line = rowLine[1];
                    GOTO(GOTO_START);
                    continue;
                case GOTO_START:
                    q = 0;
                    if (row - 1 == FIRST_ROW)
                        GOTO(600);
                    else {
                        if (isChemin(row - 1, line))
                            GOTO(600);
                        else {
                            if (line - 1 == FIRST_LINE || isChemin(row, line - 1)) {
                                if (row == horizontalSize || isChemin(row + 1, line)) {
                                    if (line != verticalSize && isChemin(row, line + 1) || line == verticalSize && z == 1) {
                                        GOTO(940); // potentiellement on a fini et on sort.
                                        // TODO : ici doit sûrement finir ?
                                    }

                                    if (line != verticalSize && !isChemin(row, line + 1)) {
                                        GOTO(570);
                                    } else if (line == verticalSize && z != 1) {
                                        q = 1;
                                        GOTO(570);
                                    }
                                } else {
                                    if (line != verticalSize) {
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
                                if (row == horizontalSize || isChemin(row + 1, line)) {
                                    if (line != verticalSize) {
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
                                        goto940();
                                    else if (roll == DEUX)
                                        goto980();
                                    else if (roll == TROIS)
                                        GOTO(1020);
                                }
                            }
                        }
                    }
                    continue;
                case 390:
                    roll = rand(3);
                    if (roll == UN)
                        goto940();
                    else if (roll == DEUX)
                        goto980();
                    else if (roll == TROIS)
                        goto1090();
                    continue;
                case 410:
                    if (isUneChanceSurDeux()) {
                        matrixChemin[row - 1][line] = nbOfIterations;
                        matrix[row - 1][line] = CellType.CLOSE_BOTTOM;
                        row--;
                    }
                    else {
                        matrixChemin[row][line - 1] = nbOfIterations;
                        matrix[row][line - 1] = CellType.CLOSE_RIGHT;
                        line--;
                    }
                    nbOfIterations++;
                    GOTO(GOTO_START);
                    continue;
                case 490:
                    roll = rand(3);
                    if (roll == UN)
                        goto940();
                    else if (roll == DEUX)
                        GOTO(1020);
                    else if (roll == TROIS)
                        goto1090();
                    continue;
                case 510:
                    if (isUneChanceSurDeux())
                        goto940();
                    else
                        GOTO(1020);
                    continue;
                case 570:
                    if (isUneChanceSurDeux())
                        goto940();
                    else
                        goto1090();
                    continue;
                case 600:
                    if (line - 1 == FIRST_LINE || isChemin(row, line - 1)) {
                        if (row == horizontalSize || isChemin(row + 1, line)) {
                            if (line != verticalSize) {
                                if (isChemin(row, line + 1))
                                    GOTO(210);
                                else
                                    goto1090();
                            } else {
                                if (z == 1)
                                    GOTO(210);
                                else {
                                    q = 1;
                                    goto1090();
                                }
                            }
                        }
                        else {
                            if (line != verticalSize) {
                                if (isChemin(row, line + 1))
                                    GOTO(1020);
                                else {
                                    if (isUneChanceSurDeux())
                                        GOTO(1020);
                                    else
                                        goto1090();
                                }
                            } else {
                                if (z == 1)
                                    GOTO(1020);
                                else {
                                    q = 1;
                                    nbOfIterations++;
                                    matrix[row][line - 1] = CellType.CLOSE_RIGHT;
                                    line--;
                                    GOTO(GOTO_START);
                                }
                            }
                        }
                    }
                    else {
                        if (row == horizontalSize || isChemin(row + 1, line)) {
                            if (line != verticalSize) {
                                if (isChemin(row, line + 1))
                                    goto980();
                                else if (isUneChanceSurDeux())
                                    goto980();
                                else
                                    goto1090();
                            } else {
                                if (z == 1)
                                    goto980();
                                else {
                                    q = 1;
                                    if (isUneChanceSurDeux())
                                        goto980();
                                    else
                                        goto1090();
                                }
                            }
                        } else {
                            if (line != verticalSize) {
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
                    continue;
                case 680:
                    roll = rand(3);
                    if (roll == UN)
                        goto980();
                    else if (roll == DEUX)
                        GOTO(1020);
                    else if (roll == TROIS)
                        goto1090();
                    continue;
                case 700:
                    if (isUneChanceSurDeux())
                        goto980();
                    else
                        GOTO(1020);
                    continue;
                case 940:
                    goto940();
                    continue;
                case 1020:
                    goto1020();
            }
        }

        for (int j = 1; j <= verticalSize; j++) {
            print("I");

            for (int i = 1; i <= horizontalSize; i++) {
                print(matrix[i][j].right);
            }

            print(" ");
            println();

            for (int i = 1; i <= horizontalSize; i++) {
                print(matrix[i][j].bottom);
            }

            print(":");
            println();
        }
    }

    private void goto1020() {
        matrixChemin[row + 1][line] = nbOfIterations;
        nbOfIterations++;
        if (matrix[row][line] == CellType.CLOSE_RIGHT_BOTTOM)
            matrix[row][line] = CellType.CLOSE_BOTTOM;
        else
            matrix[row][line] = CellType.OPEN;
        row++;
        GOTO(600);
    }

    private void goto940() {
        matrixChemin[row - 1][line] = nbOfIterations;
        nbOfIterations++;
        matrix[row - 1][line] = CellType.CLOSE_BOTTOM;
        row--;
        GOTO(GOTO_START);
    }

    private void goto980() {
        matrixChemin[row][line - 1] = nbOfIterations;
        nbOfIterations++;
        matrix[row][line - 1] = CellType.CLOSE_RIGHT;
        line--;
        GOTO(GOTO_START);
    }

    private void goto1090() {
        if (q == 1) {
            z = 1;      // only time when z is changed.
            if (matrix[row][line] == CellType.CLOSE_RIGHT_BOTTOM) {
                matrix[row][line] = CellType.CLOSE_RIGHT;
                row = 1;
                line = 1;
            } else {
                matrix[row][line] = CellType.OPEN;
            }
            GOTO(210);
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

    private int[] searchNewCell(int row, int line) {
        do {
            if (row != horizontalSize) {
                row++;
            } else {
                if (line != verticalSize) {
                    row = 1;
                    line++;
                } else {
                    row = 1;
                    line = 1;
                }
            }
        } while (!isChemin(row, line));
        return new int[]{row, line};
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
        return nbOfIterations != (horizontalSize * verticalSize) + 1;
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
