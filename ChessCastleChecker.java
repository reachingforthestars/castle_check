
class ChessCastleChecker {

    public static void main(String[] args) {

        ChessBoard board = new ChessBoard();
        ChessPiece blackKing = new ChessPiece("king","black");
        ChessPiece blackRook1 = new ChessPiece("rook","black");
        ChessPiece blackRook2 = new ChessPiece("rook","black");
        ChessPiece whiteKing = new ChessPiece("king","white");
        ChessPiece whiteRook1 = new ChessPiece("rook","white");
        ChessPiece whiteRook2 = new ChessPiece("rook","white");
        board.insertPiece(0,0,blackRook1);
        board.insertPiece(0,7,blackRook2);
        board.insertPiece(0,4,blackKing);
        board.insertPiece(7,0,whiteRook1);
        board.insertPiece(7,7,whiteRook2);
        board.insertPiece(7,4,whiteKing);

        if(checkIfCastlePossibleForColor("black", board)) {
            System.out.println("Black can castle!");
        }

        if(checkIfCastlePossibleForColor("white", board)) {
            System.out.println("White can castle!");
        }

    }

    public static boolean checkIfCastlePossibleForColor(String color, ChessBoard board) {

        int offset = 0;

        if(color.equals("white")) {
            offset = 7;
        }

        ChessPiece rook1 = board.getPieceAt(offset,0);
        ChessPiece  rook2 = board.getPieceAt(offset,7);
        ChessPiece  king = board.getPieceAt(offset,4);

        if(!checkIfRightTypeAndColor(king, "king", color)) return false;

        if(!checkIfRightTypeAndColor(rook1, "rook", color) && !checkIfRightTypeAndColor(rook2, "rook", color)) {
            return false;
        }

        return true;

    }

    private static boolean checkIfRightTypeAndColor(ChessPiece piece, String type, String color) {

        if(piece == null) return false;

        if(!piece.getType().equals(type)) return false;

        if(!piece.getColor().equals(color)) return false;

        return true;

    }
}