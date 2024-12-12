package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {



    public Bishop(Position position, String color) {
        super(position, color);
    }

    @Override
    public List<Position> pieceDirections(Position from) {
        List<Position> directions = new ArrayList<>();
        for (int row = -7; row <= 7; row++) {
            for (int col = -7; col <= 7; col++) {
                if (row != 0 && col != 0) {
                    if (Math.abs(row) == Math.abs(col)) {
                        directions.add(new Position(from.row() + row, from.col() + col));
                    }
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
        List<Position> path = new ArrayList<>();
        int rowDirection = (to.row() - from.row()) > 0 ? 1 : -1;
        int colDirection = (to.col() - from.col()) > 0 ? 1 : -1;
        int steps = Math.abs(to.row() - from.row());

        for (int i = 1; i < steps; i++) {
            path.add(new Position(from.row() + i * rowDirection, from.col() + i * colDirection));
        }

        return path;
    }
}
