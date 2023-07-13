class Bishop implements Figure {
    private FigureColor color;
    private Coord coord, maxCoord, minCoord;

    public Bishop(FigureColor color, Coord coord, Coord maxCoord, Coord minCoord) {
        this.color = color;
        this.coord = coord;
        this.maxCoord = maxCoord;
        this.minCoord = minCoord;
    }

    private Coord getCoff(Coord newCoord) {
        int bX = coord.getXCoord() < newCoord.getXCoord() ? 1 : -1;
        int bY = coord.getYCoord() < newCoord.getYCoord() ? 1 : -1;

        return new Coord(bX, bY);
    }

    private Coord[] getCoords(Coord newCoord) {
        Coord[] coords = new Coord[10];
        int i = 0;
        Coord coff = getCoff(newCoord);

        Coord presentCoord = new Coord(coord.getXCoord() + coff.getXCoord(), coord.getYCoord() + coff.getYCoord());

        while (presentCoord.getXCoord() != newCoord.getXCoord() || presentCoord.getYCoord() != newCoord.getYCoord()) {
            coords[i++] = presentCoord;
            presentCoord = new Coord(presentCoord.getXCoord() + coff.getXCoord(), presentCoord.getYCoord() + coff.getYCoord());
        }

        return coords;
    }

    public boolean checkFigureOnTheWay(Figure[] figures, Coord newCoord) {
        Coord[] coords = getCoords(newCoord);

        for (int i = 0; i < figures.length; i++) {
            for (int j = 0; j < coords.length; j++) {
                if (coords[j] != null && figures[i] != null && coords[j].getXCoord() == figures[i].getPosition().getXCoord() && coords[j].getYCoord() == figures[i].getPosition().getYCoord()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCanMove(Coord newCoord, Figure[] figures) {
        return checkMove(newCoord) && !checkFigureOnTheWay(figures, newCoord);
    }

    private boolean checkMove(Coord newCoord) {
        return checkLeftDiagonal(newCoord) || checkRightDiagonal(newCoord);
    }

    private boolean checkRightDiagonal(Coord newCoord) {
        return newCoord.getXCoord() - coord.getXCoord()
                == coord.getYCoord() - newCoord.getYCoord();
    }

    private boolean checkLeftDiagonal(Coord newCoord) {
        return newCoord.getXCoord() - coord.getXCoord()
                == newCoord.getYCoord() - coord.getYCoord();
    }

    public boolean isCanTake(Figure figure, Figure[] figures) {
        return checkTake(figure.getPosition()) && !color.equals(figure.getColor()) && !checkFigureOnTheWay(figures, figure.getPosition());
    }

    private boolean checkTake(Coord newCoord) {
        return checkLeftDiagonal(newCoord) || checkRightDiagonal(newCoord);
    }

    public Figure move(Coord coord) {
//TODO: if last coord - give option to choose figure
        this.coord = coord;
        System.out.println("Move Pawn on: " + coord);
        return this;
    }

    public Figure take(Figure figure) {
        coord = figure.getPosition();
        return this;
    }

    public Coord getPosition() {
        return coord;
    }

    public FigureColor getColor() {
        return color;
    }
}