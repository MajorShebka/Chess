interface Figure{
boolean isCanMove(Coord coord, Figure[] figures);
boolean isCanTake(Figure figure, Figure[] figures);
Figure move(Coord coord);
Figure take(Figure figure);
Coord getPosition();
//Coord getCoords(Coord coord);
FigureColor getColor();
}