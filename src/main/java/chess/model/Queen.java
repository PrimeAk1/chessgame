package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen(Position position, String color) {
        super(position, color);
    }

    @Override
    public List<Position> pieceDirections(Position from) {
        List<Position> directions = new ArrayList<>();
        for (int row = -7; row <= 7; row++) {
            for (int col = -7; col <= 7; col++) {
                if (Math.abs(row) == Math.abs(col) || (row != 0 && col == 0 || row == 0 && col != 0)) {
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
        List<Position> path = new ArrayList<>();

        if (from.row() == to.row()) {
            int direction = (to.col() - from.col()) > 0 ? 1 : -1;
            for (int col = from.col() + direction; col != to.col(); col += direction) {
                path.add(new Position(from.row(), col));
            }
        } else if (from.col() == to.col()) {
            int direction = (to.row() - from.row()) > 0 ? 1 : -1;
            for (int row = from.row() + direction; row != to.row(); row += direction) {
                path.add(new Position(row, from.col()));
            }
        } else {
            int rowDirection = (to.row() - from.row()) > 0 ? 1 : -1;
            int colDirection = (to.col() - from.col()) > 0 ? 1 : -1;
            int steps = Math.abs(to.row() - from.row());

            for (int i = 1; i < steps; i++) {
                path.add(new Position(from.row() + i * rowDirection, from.col() + i * colDirection));
            }
        }

        return path;
    }

}

