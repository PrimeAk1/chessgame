package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Position position, String color) {
        super(position, color);
    }

    @Override
    public List<Position> pieceDirections(Position from) {
        List<Position> directions = new ArrayList<>();
        for (int row = -2; row <= 2; row++) {
            for (int col = -2; col <= 2; col++) {
                if (Math.abs(row) != Math.abs(col) && (Math.abs(row) != 0 && Math.abs(col) != 0) ) {
                    directions.add(new Position(from.row() + row, from.col() + col));
                }
            }
        }
        return directions;
    }

    public Position getPosition() {
        return position;
    }

    public String getColor() {
        return color;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public List<Position> pathTo(Position from, Position to) {
        return null;
    }
}
