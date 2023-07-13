class Coord{
private int xCoord;
private int yCoord;

public Coord(int xCoord, int yCoord){
setXCoord(xCoord);
setYCoord(yCoord);
}

public void setXCoord(int xCoord){
this.xCoord = xCoord;
}

public void setYCoord(int yCoord){
this.yCoord = yCoord;
}

public int getXCoord(){
return xCoord;
}

public int getYCoord(){
return yCoord;
}

@Override
public String toString(){
return "[" + xCoord + ", " + yCoord + "]";
}
}