package chess.ui;

import chess.model.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameController {
    private Board board = new Board(); // Sakktábla
    @FXML
    private GridPane chessBoardPane; // Sakktábla megjelenítő
    private Position selectedPos;
    private Pane[][] chessFields = new Pane[8][8];

    private Map<Position, ImageView> pieceImageViews = new HashMap<>(); // Tárolja a bábuk képeit

    // Képek inicializálása
    private Image whiteKingPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/whiteking.png")));
    private Image whiteQueenPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/whitequeen.png")));
    private Image whiteRookPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/whiterook.png")));
    private Image whiteBishopPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/whitebishop.png")));
    private Image whiteKnightPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/whiteknight.png")));
    private Image whitePawnPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/whitepawn.png")));

    private Image blackKingPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/blackking.png")));
    private Image blackQueenPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/blackqueen.png")));
    private Image blackRookPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/blackrook.png")));
    private Image blackBishopPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/blackbishop.png")));
    private Image blackKnightPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/blackknight.png")));
    private Image blackPawnPNG = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/blackpawn.png")));

    @FXML
    public void startButtonClick() {
        initializeChessBoard();
        initializePieces();
    }

    private void initializeChessBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Pane chessField = new Pane();
                chessFields[row][col] = chessField;
                chessBoardPane.add(chessField, col, row);
                chessField.setStyle("-fx-background-color: " + ((row + col) % 2 == 0 ? "white" : "gray"));
                click(chessField, row, col);
            }
        }
    }

    private void click(Pane chessField, int row, int col) {
        chessField.setOnMouseClicked(event -> {
            Position clickedPosition = new Position(row, col);
            if (selectedPos == null) {
                selectedPos = clickedPosition;
            } else {
                board.movePiece(selectedPos, clickedPosition);
                selectedPos = null;
                updateBoardDisplay(); // Frissítjük a megjelenítést a lépés után
            }
        });
    }

    private void initializePieces() {
        // Fehér bábuk inicializálása
        board.placePiece(new King(new Position(7, 4), "white"), new Position(7, 4));
        board.placePiece(new Queen(new Position(7, 3), "white"), new Position(7, 3));
        board.placePiece(new Rook(new Position(7, 0), "white"), new Position(7, 0));
        board.placePiece(new Rook(new Position(7, 7), "white"), new Position(7, 7));
        board.placePiece(new Bishop(new Position(7, 2), "white"), new Position(7, 2));
        board.placePiece(new Bishop(new Position(7, 5), "white"), new Position(7, 5));
        board.placePiece(new Knight(new Position(7, 1), "white"), new Position(7, 1));
        board.placePiece(new Knight(new Position(7, 6), "white"), new Position(7, 6));
        board.placePiece(new Pawn(new Position(6, 0), "white"), new Position(6, 0));
        board.placePiece(new Pawn(new Position(6, 1), "white"), new Position(6, 1));
        board.placePiece(new Pawn(new Position(6, 2), "white"), new Position(6, 2));
        board.placePiece(new Pawn(new Position(6, 3), "white"), new Position(6, 3));
        board.placePiece(new Pawn(new Position(6, 4), "white"), new Position(6, 4));
        board.placePiece(new Pawn(new Position(6, 5), "white"), new Position(6, 5));
        board.placePiece(new Pawn(new Position(6, 6), "white"), new Position(6, 6));
        board.placePiece(new Pawn(new Position(6, 7), "white"), new Position(6, 7));

// Fekete bábuk inicializálása
        board.placePiece(new King(new Position(0, 4), "black"), new Position(0, 4));
        board.placePiece(new Queen(new Position(0, 3), "black"), new Position(0, 3));
        board.placePiece(new Rook(new Position(0, 0), "black"), new Position(0, 0));
        board.placePiece(new Rook(new Position(0, 7), "black"), new Position(0, 7));
        board.placePiece(new Bishop(new Position(0, 2), "black"), new Position(0, 2));
        board.placePiece(new Bishop(new Position(0, 5), "black"), new Position(0, 5));
        board.placePiece(new Knight(new Position(0, 1), "black"), new Position(0, 1));
        board.placePiece(new Knight(new Position(0, 6), "black"), new Position(0, 6));
        board.placePiece(new Pawn(new Position(1, 0), "black"), new Position(1, 0));
        board.placePiece(new Pawn(new Position(1, 1), "black"), new Position(1, 1));
        board.placePiece(new Pawn(new Position(1, 2), "black"), new Position(1, 2));
        board.placePiece(new Pawn(new Position(1, 3), "black"), new Position(1, 3));
        board.placePiece(new Pawn(new Position(1, 4), "black"), new Position(1, 4));
        board.placePiece(new Pawn(new Position(1, 5), "black"), new Position(1, 5));
        board.placePiece(new Pawn(new Position(1, 6), "black"), new Position(1, 6));
        board.placePiece(new Pawn(new Position(1, 7), "black"), new Position(1, 7));



        updateBoardDisplay(); // Frissítjük a megjelenítést az inicializálás után
    }

    private void updateBoardDisplay() {
        // Töröljük az összes képet a tábláról
        for (Pane[] row : chessFields) {
            for (Pane pane : row) {
                pane.getChildren().clear();
            }
        }

        // Tegyük vissza a bábukat a megfelelő helyre az új állapot alapján
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(new Position(row, col));
                if (piece != null) {
                    Image image = getImageForPiece(piece);
                    addPieceImageView(piece, image, row, col);
                }
            }
        }
    }

    private Image getImageForPiece(Piece piece) {
        String color = piece.getColor();
        switch (color) {
            case "white":
                switch (piece.getClass().getSimpleName()) {
                    case "King":
                        return whiteKingPNG;
                    case "Queen":
                        return whiteQueenPNG;
                    case "Rook":
                        return whiteRookPNG;
                    case "Bishop":
                        return whiteBishopPNG;
                    case "Knight":
                        return whiteKnightPNG;
                    case "Pawn":
                        return whitePawnPNG;
                    default:
                        break;
                }
                break;
            case "black":
                switch (piece.getClass().getSimpleName()) {
                    case "King":
                        return blackKingPNG;
                    case "Queen":
                        return blackQueenPNG;
                    case "Rook":
                        return blackRookPNG;
                    case "Bishop":
                        return blackBishopPNG;
                    case "Knight":
                        return blackKnightPNG;
                    case "Pawn":
                        return blackPawnPNG;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return null; // Ha nem található megfelelő kép
    }

    private void addPieceImageView(Piece piece, Image image, int row, int col) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50); // Kép méretezése
        imageView.setFitHeight(50);
        chessFields[row][col].getChildren().add(imageView);
        pieceImageViews.put(piece.getPosition(), imageView);
    }
}


