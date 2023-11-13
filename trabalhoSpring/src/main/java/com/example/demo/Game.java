package com.example.demo;

public class Game {
    private char[][] board;
    private char currentPlayer;
    private int playerXWins;
    private int playerOWins;

    public Game() {
        board = new char[3][3];
        currentPlayer = 'X';
        playerXWins = 0;
        playerOWins = 0;
        initializeBoard();
    }

    public char[][] getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public int getPlayerXWins() {
        return playerXWins;
    }

    public int getPlayerOWins() {
        return playerOWins;
    }

    public void makeMove(int row, int col) {
        if (board[row][col] == 0) {
            board[row][col] = currentPlayer;
            if (checkWinner(row, col)) {
                if (currentPlayer == 'X') {
                    playerXWins++;
                } else {
                    playerOWins++;
                }
                System.out.println("Player " + currentPlayer + " wins!");
                initializeBoard();
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                initializeBoard();
            } else {
                switchPlayer();
            }
        }
    }

    public void resetScore() {
        playerXWins = 0;
        playerOWins = 0;
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWinner(int row, int col) {
    	  // Verifica horizontal
        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
            return true;
        }
        
        // Verifica vertical
        if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
            return true;
        }
        
        // Verifica diagonal principal
        if (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }

        // Verifica diagonal secundária
        if (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false; // Ainda existem espaços vazios
                }
            }
        }
        return true; // Todos os espaços estão preenchidos, mas não há um vencedor
    }
}
