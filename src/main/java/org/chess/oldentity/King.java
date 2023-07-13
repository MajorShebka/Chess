class King implements Figure{
private FigureColor color;
private Coord coord, maxCoord, minCoord;

public King(FigureColor color, Coord coord, Coord maxCoord, Coord minCoord){
this.color = color;
this.coord = coord;
this.maxCoord = maxCoord;
this.minCoord = minCoord;
}

public boolean isCanMove(Coord newCoord, Figure[] figures){
return checkMove(newCoord);
}

private boolean checkMove(Coord newCoord){
//TODO: Implement logic
return checkHorizontal(newCoord) || checkVertical(newCoord)
|| checkLeftDiagonal(newCoord) || checkRightDiagonal(newCoord);
}

private boolean checkHorizontal(Coord newCoord){
return newCoord.getYCoord() == coord.getYCoord();
}

private boolean checkVertical(Coord newCoord){
return newCoord.getXCoord() == coord.getXCoord();
}

private boolean checkRightDiagonal(Coord newCoord){
return newCoord.getXCoord() - coord.getXCoord()
== coord.getYCoord() - newCoord.getYCoord();
}

private boolean checkLeftDiagonal(Coord newCoord){
return newCoord.getXCoord() - coord.getXCoord() 
== newCoord.getYCoord() - coord.getYCoord();
}

public boolean isCanTake(Figure figure, Figure[] figures){
return checkTake(figure.getPosition()) && !color.equals(figure.getColor());
}

private boolean checkTake(Coord newCoord){
return checkHorizontal(newCoord) || checkVertical(newCoord)
|| checkLeftDiagonal(newCoord) || checkRightDiagonal(newCoord);
}

public Figure move(Coord coord){
//TODO: if last coord - give option to choose figure
this.coord = coord;
System.out.println("Move Pawn on: " + coord);
return this;
}
public Figure take(Figure figure){
coord = figure.getPosition();
return this;
}

public Coord getPosition(){
return coord;
}

public FigureColor getColor(){
return color;
}
}