
class ChessBoard {

    private ChessPiece[][] board;

    public ChessBoard() {
        board = new ChessPiece[8][8];
    }

    public void removePiece(int i, int j, ChessPiece piece) {
        if(i < 0 || i > 7 || j < 0 || j > 7) throw new IllegalArgumentException();

        if(board[i][j] == null) throw new IllegalArgumentException();

        board[i][j] = null;
    }

    public void insertPiece(int i, int j, ChessPiece piece) {

        if(i < 0 || i > 7 || j < 0 || j > 7) throw new IllegalArgumentException();

        if(board[i][j] != null) throw new IllegalArgumentException();

        board[i][j] = piece;

    }

    public void movePiece(int i, int j, int x, int y, ChessPiece piece) throws IllegalArgumentException {
        removePiece(i,j,piece);
        insertPiece(x,y,piece);
    }

    public ChessPiece getPieceAt(int i, int j) {

        if(i < 0 || i > 7 || j < 0 || j > 7) throw new IllegalArgumentException();

        return board[i][j];

    }

}