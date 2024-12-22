public class TableroAjedrez {
    private char[][] tableroAjedrez;

    //constructor

    public TableroAjedrez(int N) {
        tableroAjedrez = new char[N][N];
        for (int i = 0; i < tableroAjedrez.length; i++) {
            for (int j = 0; j < tableroAjedrez[i].length; j++) {
                tableroAjedrez[i][j] = '\s';
            }
        }
    }

    // metodos

    public void mostrar() {
        for (int i = 0; i < tableroAjedrez.length; i++) {
            System.out.println();
            for (int j = 0; j < tableroAjedrez[i].length; j++) {
                if (j == 0) {
                    System.out.print("|" + tableroAjedrez[i][j] + "|");
                } else {
                    System.out.print(tableroAjedrez[i][j] + "|");
                }
            }
        }
        System.out.println();
    }

    public boolean ponerPieza(int fila, int columna, char pieza) {
        if (fila >= 0 && fila < tableroAjedrez.length && columna >= 0 && columna < tableroAjedrez[fila].length) {
            tableroAjedrez[fila][columna] = pieza;
            return true;
        } else {
            return false;
        }
    }

    public boolean posicionSeguraTorre(int filaSegura, int columnaSegura, int filaTorre, int columnaTorre) {
        boolean encontrado = false;
        if (filaSegura == filaTorre || columnaSegura == columnaTorre) {
            if (filaSegura == filaTorre && columnaSegura > columnaTorre) {
                int j = columnaTorre + 1;
                while (j < columnaSegura && !encontrado) {
                    if (tableroAjedrez[filaTorre][j] != '\s') {
                        encontrado = true;
                    } else {
                        j++;
                    }
                }
            } else if (filaSegura == filaTorre && columnaSegura < columnaTorre) {
                int j = columnaTorre - 1;
                while (j > columnaSegura && !encontrado) {
                    if (tableroAjedrez[filaTorre][j] != '\s') {
                        encontrado = true;
                    } else {
                        j--;
                    }
                }
            } else if (filaSegura > filaTorre && columnaSegura == columnaTorre) {
                int i = filaTorre + 1;
                while (i < filaSegura && !encontrado) {
                    if (tableroAjedrez[i][columnaTorre] != '\s') {
                        encontrado = true;
                    } else {
                        i++;
                    }
                }
            } else if (filaSegura < filaTorre && columnaSegura == columnaTorre) {
                int i = filaTorre - 1;
                while (i > filaSegura && !encontrado) {
                    if (tableroAjedrez[i][columnaTorre] != '\s') {
                        encontrado = true;
                    } else {
                        i--;
                    }
                }
            }
            if (!encontrado) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean posicionSeguraPeon(int filaSegura, int columnaSegura, int filaPeon, int columnaPeon){
        if (filaSegura == filaPeon + 1 && (columnaSegura == columnaPeon + 1 || columnaSegura == columnaPeon - 1)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean posicionSeguraAlfil(int filaSegura, int columnaSegura, int filaAlfil, int columnaAlfil) {
        int diagonalDirecta = filaAlfil + columnaAlfil;
        int diagonalIndirecta = filaAlfil - columnaAlfil;
        boolean encontrado = false;

        if (filaSegura + columnaSegura == diagonalDirecta || filaSegura - columnaSegura == diagonalIndirecta) {
            if (filaSegura > filaAlfil && columnaSegura > columnaAlfil) {
                int i = filaAlfil + 1, j = columnaAlfil + 1;
                while (i < filaSegura && j < columnaSegura && !encontrado) {
                    if (tableroAjedrez[i][j] != '\s') {
                        encontrado = true;
                    } else {
                        i++;
                        j++;
                    }
                }
            } else if (filaSegura > filaAlfil && columnaSegura < columnaAlfil) {
                int i = filaAlfil + 1, j = columnaAlfil - 1;
                while (i < filaSegura && j > columnaSegura && !encontrado) {
                    if (tableroAjedrez[i][j] != '\s') {
                        encontrado = true;
                    } else {
                        i++;
                        j--;
                    }
                }
            } else if (filaSegura < filaAlfil && columnaSegura > columnaAlfil) {
                int i = filaAlfil - 1, j = columnaAlfil + 1;
                while (i > filaSegura && j < columnaSegura && !encontrado) {
                    if (tableroAjedrez[i][j] != '\s') {
                        encontrado = true;
                    } else {
                        i--;
                        j++;
                    }
                }
            } else if (filaSegura < filaAlfil && columnaSegura < columnaAlfil) {
                int i = filaAlfil - 1, j = columnaAlfil - 1;
                while (i > filaSegura && j > columnaSegura && !encontrado) {
                    if (tableroAjedrez[i][j] != '\s') {
                        encontrado = true;
                    } else {
                        i--;
                        j--;
                    }
                }
            }
            if (!encontrado) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean posicionSeguraRey(int filaSegura, int columnaSegura, int filaRey, int columnaRey) {
        if (filaSegura == filaRey + 1 && (columnaSegura == columnaRey || columnaSegura == columnaRey - 1 || columnaSegura == columnaRey + 1) ||
                filaSegura == filaRey - 1 && (columnaSegura == columnaRey || columnaSegura == columnaRey - 1 || columnaSegura == columnaRey + 1) ||
                filaSegura == filaRey && (columnaSegura == columnaRey + 1 || columnaSegura == columnaRey - 1)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean posicionSeguraCaballo(int filaSegura, int columnaSegura, int filaCaballo, int columnaCaballo) {
        if (filaSegura == filaCaballo - 1) {
            if (columnaSegura == columnaCaballo - 2) {
                return false;
            } else if (columnaSegura == columnaCaballo + 2) {
                return false;
            } else {
                return true;
            }
        } else if (filaSegura == filaCaballo + 1) {
            if (columnaSegura == columnaCaballo - 2) {
                return false;
            } else if (columnaSegura == columnaCaballo + 2) {
                return false;
            } else {

                return true;
            }
        } else if (filaSegura == filaCaballo + 2) {
            if (columnaSegura == columnaCaballo - 1) {
                return false;
            } else if (columnaSegura == columnaCaballo + 1) {
                return false;
            } else {
                return true;
            }
        } else if (filaSegura == filaCaballo - 2) {
            if (columnaSegura == columnaCaballo - 1) {
                return false;
            } else if (columnaSegura == columnaCaballo + 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean posicionSeguraDama(int filaSegura, int columnaSegura, int filaDama, int columnaDama) {
        if (!this.posicionSeguraAlfil(filaSegura, columnaSegura, filaDama, columnaDama) || !this.posicionSeguraTorre(filaSegura, columnaSegura, filaDama, columnaDama)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean posicionSegura(int filaSegura, int columnaSegura){
        int i = 0;
        boolean seguro = true;
        while(i < tableroAjedrez.length && seguro) {
            int j = 0;
            while(j < tableroAjedrez[i].length && seguro) {
                if (tableroAjedrez[i][j] != '\s'){
                    if (tableroAjedrez[i][j] == 't'){
                        seguro = this.posicionSeguraTorre(filaSegura, columnaSegura, i, j);
                    } else if (tableroAjedrez[i][j] == 'a') {
                        seguro = this.posicionSeguraAlfil(filaSegura, columnaSegura, i, j);
                    } else if (tableroAjedrez[i][j] == 'r') {
                        seguro = this.posicionSeguraRey(filaSegura, columnaSegura, i, j);
                    } else if (tableroAjedrez[i][j] == 'd') {
                        seguro = this.posicionSeguraDama(filaSegura, columnaSegura, i, j);
                    } else if (tableroAjedrez[i][j] == 'p') {
                        seguro = this.posicionSeguraPeon(filaSegura, columnaSegura, i, j);
                    } else if (tableroAjedrez[i][j] == 'c') {
                        seguro = this.posicionSeguraCaballo(filaSegura, columnaSegura, i, j);
                    }
                }
                j++;
            }
            i++;
        }
        return seguro;
    }

    public static void main(String[] args) {
        int posicionY = 1;
        int posicionX = 6;

        TableroAjedrez tablero = new TableroAjedrez(8);
        tablero.ponerPieza(2,6,'c');
        tablero.ponerPieza(4,6,'d');
        tablero.ponerPieza(0,0,'t');
        tablero.ponerPieza(6,2,'a');
        tablero.mostrar();
        System.out.println("La posicion [" + posicionY + "," + posicionX + "] es una posiion segura? --> " + tablero.posicionSegura(posicionY, posicionX));

    }
}
