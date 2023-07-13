class Pawn implements Figure {
    private FigureColor color;
    private Coord coord, maxCoord, minCoord;

    public Pawn(FigureColor color, Coord coord, Coord maxCoord, Coord minCoord) {
        this.color = color;
        this.coord = coord;
        this.maxCoord = maxCoord;
        this.minCoord = minCoord;
    }

    public boolean isCanMove(Coord newCoord, Figure[] figures) {
        return checkMove(newCoord);
    }

    private int getCoff() {
        if (color.equals(FigureColor.WHITE)) {
            return 1;
        }

        return -1;
    }

    private boolean checkMove(Coord newCoord) {
        return checkDefaultMove(newCoord) || checkDoubleMove(newCoord);
    }

    private boolean checkDoubleMove(Coord newCoord) {
        if (coord.getYCoord() == newCoord.getYCoord() - 2 * getCoff() && coord.getXCoord() == newCoord.getXCoord()
                && coord.getYCoord() == 4.5 - 2.5 * getCoff())
            return true;

        return false;
    }

    private boolean checkDefaultMove(Coord newCoord) {
        if (coord.getYCoord() == newCoord.getYCoord() - getCoff() && coord.getXCoord() == newCoord.getXCoord()) {
            return true;
        }

        return false;
    }

    public boolean isCanTake(Figure figure, Figure[] figures) {
        return checkTake(figure.getPosition()) && !color.equals(figure.getColor());
    }

    private boolean checkDefaultTake(Coord newCoord) {
        return coord.getYCoord() == newCoord.getYCoord() - getCoff()
                && (coord.getXCoord() == newCoord.getXCoord() - 1 || coord.getXCoord() == newCoord.getXCoord() + 1);
    }

    private boolean checkTake(Coord newCoord) {
        return checkDefaultTake(newCoord);
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