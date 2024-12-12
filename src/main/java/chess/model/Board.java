package chess.model;

import java.util.List;

public class Board {
    private Piece[][] board;
    private boolean isWhitesTurn = true;

    public Board() {
        this.board = new Piece[8][8];
    }

    public Piece getPiece(Position position) {
        return board[position.row()][position.col()];
    }

    public void placePiece(Piece piece, Position position) {
        board[position.row()][position.col()] = piece;
        piece.setPosition(position);
    }

    public void movePiece(Position from, Position to) {
        Piece piece = getPiece(from);

        if (piece != null && isValidMove(piece, to) && isWhitesTurn && piece.getColor().equals("white")) {
            board[to.row()][to.col()] = piece;
            board[from.row()][from.col()] = null;
            piece.setPosition(to);
            isWhitesTurn = false;
        } else if (piece != null && isValidMove(piece, to) && !isWhitesTurn && piece.getColor().equals("black")) {
            board[to.row()][to.col()] = piece;
            board[from.row()][from.col()] = null;
            piece.setPosition(to);
            isWhitesTurn = true;
        }
    }

    public boolean isValidMove(Piece piece, Position to) {
        if (to.row() < 0 || to.row() >= 8 || to.col() < 0 || to.col() >= 8) {
            return false; // kívül a táblán
        }

        Piece targetPiece = getPiece(to);
        if (targetPiece != null && targetPiece.getColor().equals(piece.getColor())) {
            return false; // saját bábu a célhelyen
        }

        List<Position> possibleMoves = piece.pieceDirections(piece.position);

        if (piece instanceof Pawn) {
            int direction = piece.getColor().equals("white") ? -1 : 1;
            Position captureLeft = new Position(piece.position.row() + direction, piece.position.col() - 1);
            Position captureRight = new Position(piece.position.row() + direction, piece.position.col() + 1);

            if (targetPiece != null && !targetPiece.getColor().equals(piece.getColor()) && possibleMoves.contains(to)) {
                return false;
            } else if (targetPiece != null) {
                if (to.equals(captureLeft) || to.equals(captureRight)) {
                    possibleMoves.add(captureLeft);
                    possibleMoves.add(captureRight);
                }
            } else {
                possibleMoves.remove(captureLeft);
                possibleMoves.remove(captureRight);
            }
        }

        List<Position> path = piece.pathTo(piece.position, to);
        if (path != null && isPathObstructed(path)) {
            return false;
        }

        return possibleMoves.contains(to);

    }

    private boolean isPathObstructed(List<Position> path) {
        for (Position position : path) {
            if (getPiece(position) != null) {
                return true;
            }
        }
        return false;
    }

}