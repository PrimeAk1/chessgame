package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {


    public Rook(Position position, String color) {
        super(position, color);
    }

    @Override
    public List<Position> pieceDirections(Position from) {
        List<Position> directions = new ArrayList<>();
        for (int row = -7; row <= 7; row++) {
            for (int col = -7; col <= 7; col++) {
                if (row != 0 && col == 0 || row == 0 && col != 0) {
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
        }

        return path;
    }
}
