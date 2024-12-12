package chess.model;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {


    public Pawn(Position position, String color) {
        super(position, color);
    }

    @Override
    public List<Position> pieceDirections(Position from) {
        List<Position> directions = new ArrayList<>();

        int row = -1;
        int col = 0;

        if(color.equals("black")) {
            row = 1;
        }

        if((from.row() == 1 && color.equals("black")) || (from.row() == 6 && color.equals("white")) ) {
            directions.add(new Position(from.row() + (row * 2), from.col() + col));
        }
        else if((from.row() != 1 && color.equals("black")) || (from.row() != 6 && color.equals("white")) ) {
            directions.remove(new Position(from.row() + (row * 2), from.col() + col));
        }

        directions.add(new Position(from.row() + row, from.col() + col));
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
