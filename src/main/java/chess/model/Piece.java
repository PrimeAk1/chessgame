package chess.model;

import java.util.List;

public abstract class Piece {
    protected Position position;
    protected String color;

    public Piece(Position position, String color) {
        this.position = position;
        this.color = color;
    }

    public abstract List<Position> pieceDirections(Position from);

    public Position getPosition() {
        return position;
    }

    public String getColor() {
        return color;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public abstract List<Position> pathTo(Position from, Position to);
}
