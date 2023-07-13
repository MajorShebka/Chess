class main{
static Figure[] figures = new Figure[1];
public static void main(String[] args){
/*Bishop bishop = new Bishop(FigureColor.WHITE, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));
Figure[] figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(4, 4), new Coord(8, 8), new Coord(1, 1))};

System.out.println(bishop.checkFigureOnTheWay(figures, new Coord(7, 7)));*/

testPawn();
testBishop();
testTower();
testQueen();
//testKing();
//testHorse();
}

public static void testPawn(){
testPawnMove();
testPawnTake();
}

public static void testBishop(){
testBishopMove();
testBishopTake();
}

public static void testTower(){
testTowerMove();
testTowerTake();
}

public static void testQueen(){
testQueenMove();
testQueenTake();
}

public static void testKing(){
testKingMove();
testKingTake();
}

public static void testHorse(){
testHorseMove();
testHorseTake();
}

public static void testHorseTake(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST HORSE TAKE");
int n = 0;

Figure horse = new Horse(FigureColor.BLACK, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testTake(horse, new Pawn(FigureColor.WHITE, new Coord(4, 3), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(horse, new Pawn(FigureColor.WHITE, new Coord(4, 7), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(horse, new Pawn(FigureColor.WHITE, new Coord(6, 7), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(horse, new Pawn(FigureColor.WHITE, new Coord(6, 3), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(horse, new Pawn(FigureColor.WHITE, new Coord(7, 6), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(horse, new Pawn(FigureColor.WHITE, new Coord(7, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(horse, new Pawn(FigureColor.WHITE, new Coord(3, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(horse, new Pawn(FigureColor.WHITE, new Coord(3, 6), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(horse, new Pawn(FigureColor.WHITE, new Coord(4, 4), new Coord(8, 8), new Coord(1, 1))), ++n);

System.out.println("END TEST HORSE TAKE");
System.out.println("- - - - - - - - - - - -");
}

public static void testHorseMove(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST HORSE MOVE");
int n = 0;

Figure horse = new Horse(FigureColor.BLACK, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testMove(horse, new Coord(4, 3)), ++n);
assertResults(true, testMove(horse, new Coord(4, 7)), ++n);
assertResults(true, testMove(horse, new Coord(6, 7)), ++n);
assertResults(true, testMove(horse, new Coord(6, 3)), ++n);
assertResults(true, testMove(horse, new Coord(7, 6)), ++n);
assertResults(true, testMove(horse, new Coord(7, 4)), ++n);
assertResults(true, testMove(horse, new Coord(3, 4)), ++n);
assertResults(true, testMove(horse, new Coord(3, 6)), ++n);
assertResults(false, testMove(horse, new Coord(4, 4)), ++n);

assertResults(false, testMove(horse, new Coord(2, 4)), ++n);

System.out.println("END TEST HORSE MOVE");
System.out.println("- - - - - - - - - - - -");
}

public static void testKingTake(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST KING TAKE");
int n = 0;

Figure king = new King(FigureColor.BLACK, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testTake(king, new Pawn(FigureColor.WHITE, new Coord(5, 6), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(king, new Pawn(FigureColor.WHITE, new Coord(6, 6), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(king, new Pawn(FigureColor.WHITE, new Coord(6, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(king, new Pawn(FigureColor.WHITE, new Coord(6, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(king, new Pawn(FigureColor.WHITE, new Coord(5, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(king, new Pawn(FigureColor.WHITE, new Coord(4, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(king, new Pawn(FigureColor.WHITE, new Coord(4, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(king, new Pawn(FigureColor.WHITE, new Coord(4, 6), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(king, new Pawn(FigureColor.WHITE, new Coord(5, 7), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(king, new Pawn(FigureColor.BLACK, new Coord(5, 6), new Coord(8, 8), new Coord(1, 1))), ++n);

System.out.println("END TEST KING TAKE");
System.out.println("- - - - - - - - - - - -");
}

public static void testKingMove(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST KING MOVE");
int n = 0;

Figure king = new King(FigureColor.BLACK, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testMove(king, new Coord(5, 6)), ++n);
assertResults(true, testMove(king, new Coord(6, 6)), ++n);
assertResults(true, testMove(king, new Coord(6, 5)), ++n);
assertResults(true, testMove(king, new Coord(6, 4)), ++n);
assertResults(true, testMove(king, new Coord(5, 4)), ++n);
assertResults(true, testMove(king, new Coord(4, 4)), ++n);
assertResults(true, testMove(king, new Coord(4, 5)), ++n);
assertResults(true, testMove(king, new Coord(4, 6)), ++n);
assertResults(false, testMove(king, new Coord(5, 7)), ++n);
assertResults(false, testMove(king, new Coord(7, 5)), ++n);
assertResults(false, testMove(king, new Coord(7, 7)), ++n);
assertResults(false, testMove(king, new Coord(7, 3)), ++n);
assertResults(false, testMove(king, new Coord(5, 3)), ++n);
assertResults(false, testMove(king, new Coord(3, 3)), ++n);
assertResults(false, testMove(king, new Coord(3, 5)), ++n);
assertResults(false, testMove(king, new Coord(3, 7)), ++n);
assertResults(false, testMove(king, new Coord(2, 4)), ++n);

System.out.println("END TEST KING MOVE");
System.out.println("- - - - - - - - - - - -");
}

public static void testQueenTake(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST QUEEN TAKE");
int n = 0;

Figure queen = new Queen(FigureColor.BLACK, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(8, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(5, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(5, 1), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(2, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(8, 2), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(1, 1), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(8, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(2, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(queen, new Pawn(FigureColor.BLACK, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1))), ++n);

figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 5), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(6, 5), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(8, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(5, 7), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(5, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(5, 3), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(5, 1), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 7), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(2, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(6, 4), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(8, 2), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 3), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(1, 1), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(6, 6), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(queen, new Pawn(FigureColor.WHITE, new Coord(8, 8), new Coord(8, 8), new Coord(1, 1))), ++n);

figures = new Figure[1];

System.out.println("END TEST QUEEN TAKE");
System.out.println("- - - - - - - - - - - -");
}

public static void testQueenMove(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST QUEEN MOVE");
int n = 0;

Figure queen = new Queen(FigureColor.BLACK, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testMove(queen, new Coord(1, 5)), ++n);
assertResults(true, testMove(queen, new Coord(8, 5)), ++n);
assertResults(true, testMove(queen, new Coord(5, 8)), ++n);
assertResults(true, testMove(queen, new Coord(5, 1)), ++n);
assertResults(true, testMove(queen, new Coord(2, 8)), ++n);
assertResults(true, testMove(queen, new Coord(8, 2)), ++n);
assertResults(true, testMove(queen, new Coord(1, 1)), ++n);
assertResults(true, testMove(queen, new Coord(8, 8)), ++n);
assertResults(false, testMove(queen, new Coord(4, 3)), ++n);

figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 5), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(queen, new Coord(1, 5)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(6, 5), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(queen, new Coord(8, 5)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(5, 7), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(queen, new Coord(5, 8)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(5, 3), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(queen, new Coord(5, 1)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 7), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(queen, new Coord(2, 8)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(6, 4), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(queen, new Coord(8, 2)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 3), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(queen, new Coord(1, 1)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(6, 6), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(queen, new Coord(8, 8)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(2, 2), new Coord(8, 8), new Coord(1, 1))};
assertResults(true, testMove(queen, new Coord(8, 8)), ++n);

figures = new Figure[1];

System.out.println("END TEST QUEEN MOVE");
System.out.println("- - - - - - - - - - - -");
}

public static void testTowerTake(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST TOWER TAKE");
int n = 0;

Figure tower = new Tower(FigureColor.BLACK, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(8, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(5, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(5, 1), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(2, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(8, 2), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(1, 1), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(8, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(tower, new Pawn(FigureColor.BLACK, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1))), ++n);

figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 5), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(6, 5), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(8, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(5, 6), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(5, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(5, 3), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(tower, new Pawn(FigureColor.WHITE, new Coord(5, 1), new Coord(8, 8), new Coord(1, 1))), ++n);

figures = new Figure[1];

System.out.println("END TEST TOWER TAKE");
System.out.println("- - - - - - - - - - - -");
}

public static void testTowerMove(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST TOWER MOVE");
int n = 0;

Figure tower = new Tower(FigureColor.BLACK, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testMove(tower, new Coord(1, 5)), ++n);
assertResults(true, testMove(tower, new Coord(8, 5)), ++n);
assertResults(true, testMove(tower, new Coord(5, 8)), ++n);
assertResults(true, testMove(tower, new Coord(5, 1)), ++n);
assertResults(false, testMove(tower, new Coord(2, 8)), ++n);
assertResults(false, testMove(tower, new Coord(8, 2)), ++n);
assertResults(false, testMove(tower, new Coord(1, 1)), ++n);
assertResults(false, testMove(tower, new Coord(8, 8)), ++n);

figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 5), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(tower, new Coord(1, 5)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(6, 5), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(tower, new Coord(8, 5)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(5, 6), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(tower, new Coord(5, 8)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(5, 3), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(tower, new Coord(5, 1)), ++n);

figures = new Figure[1];

System.out.println("END TEST TOWER MOVE");
System.out.println("- - - - - - - - - - - -");
}

public static void testBishopTake(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST BISHOP TAKE");
int n = 0;

Figure bishop = new Bishop(FigureColor.BLACK, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(1, 1), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(8, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(2, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(8, 2), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(8, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(5, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(2, 6), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(bishop, new Pawn(FigureColor.BLACK, new Coord(1, 1), new Coord(8, 8), new Coord(1, 1))), ++n);

figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(2, 2), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(1, 1), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(7, 7), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(8, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 7), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(2, 8), new Coord(8, 8), new Coord(1, 1))), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(7, 3), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testTake(bishop, new Pawn(FigureColor.WHITE, new Coord(8, 2), new Coord(8, 8), new Coord(1, 1))), ++n);

figures = new Figure[1];

System.out.println("END TEST BISHOP TAKE");
System.out.println("- - - - - - - - - - - -");
}

public static void testBishopMove(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST BISHOP MOVE");
int n = 0;

Figure bishop = new Bishop(FigureColor.WHITE, new Coord(5, 5), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testMove(bishop, new Coord(1, 1)), ++n);
assertResults(true, testMove(bishop, new Coord(8, 8)), ++n);
assertResults(true, testMove(bishop, new Coord(2, 8)), ++n);
assertResults(true, testMove(bishop, new Coord(8, 2)), ++n);
assertResults(false, testMove(bishop, new Coord(1, 5)), ++n);
assertResults(false, testMove(bishop, new Coord(8, 5)), ++n);
assertResults(false, testMove(bishop, new Coord(5, 8)), ++n);
assertResults(false, testMove(bishop, new Coord(2, 6)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(2, 2), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(bishop, new Coord(1, 1)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(7, 7), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(bishop, new Coord(8, 8)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(3, 7), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(bishop, new Coord(2, 8)), ++n);
figures = new Figure[]{new Bishop(FigureColor.WHITE, new Coord(7, 3), new Coord(8, 8), new Coord(1, 1))};
assertResults(false, testMove(bishop, new Coord(8, 2)), ++n);

figures = new Figure[1];

System.out.println("END TEST BISHOP MOVE");
System.out.println("- - - - - - - - - - - -");
}

public static void testPawnTake(){
testDefaultPawnTake();
}

public static void testPawnMove(){
testDefaultPawnMove();
testDoublePawnMove();
}

public static void testDefaultPawnTake(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST DEFAULT PAWN TAKE");
int n = 0;

Figure pawn = new Pawn(FigureColor.WHITE, new Coord(2, 3), new Coord(8, 8), new Coord(1, 1));

assertResults(false, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(2, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(3, 3), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(1, 3), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(3, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(1, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(3, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(1, 4), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(1, 2), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(3, 2), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(1, 2), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(3, 2), new Coord(8, 8), new Coord(1, 1))), ++n);

pawn = new Pawn(FigureColor.BLACK, new Coord(2, 6), new Coord(8, 8), new Coord(1, 1));

assertResults(false, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(2, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(3, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(true, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(1, 6), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(3, 6), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(3, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(1, 7), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.WHITE, new Coord(3, 7), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(1, 7), new Coord(8, 8), new Coord(1, 1))), ++n);
assertResults(false, testTake(pawn, new Pawn(FigureColor.BLACK, new Coord(3, 7), new Coord(8, 8), new Coord(1, 1))), ++n);

System.out.println("END TEST DEFAULT PAWN TAKE");
System.out.println("- - - - - - - - - - - -");
}

public static void testDoublePawnMove(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST DOUBLE PAWN MOVE");
int n = 0;

Figure pawn = new Pawn(FigureColor.WHITE, new Coord(2, 2), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testMove(pawn, new Coord(2, 4)), ++n);
assertResults(false, testMove(pawn, new Coord(1, 4)), ++n);
assertResults(false, testMove(pawn, new Coord(3, 4)), ++n);

pawn = new Pawn(FigureColor.BLACK, new Coord(2, 7), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testMove(pawn, new Coord(2, 5)), ++n);
assertResults(false, testMove(pawn, new Coord(1, 5)), ++n);
assertResults(false, testMove(pawn, new Coord(3, 5)), ++n);

pawn = new Pawn(FigureColor.WHITE, new Coord(2, 3), new Coord(8, 8), new Coord(1, 1));

assertResults(false, testMove(pawn, new Coord(2, 5)), ++n);

pawn = new Pawn(FigureColor.BLACK, new Coord(2, 6), new Coord(8, 8), new Coord(1, 1));

assertResults(false, testMove(pawn, new Coord(2, 4)), ++n);

System.out.println("END TEST DOUBLE PAWN MOVE");
System.out.println("- - - - - - - - - - - -");
}

public static void testDefaultPawnMove(){
System.out.println("- - - - - - - - - - - -");
System.out.println("START TEST DEFAULT PAWN MOVE");
int n = 0;

Figure pawn = new Pawn(FigureColor.WHITE, new Coord(2, 3), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testMove(pawn, new Coord(2, 4)), ++n);
assertResults(false, testMove(pawn, new Coord(3, 4)), ++n);
assertResults(false, testMove(pawn, new Coord(1, 4)), ++n);

pawn = new Pawn(FigureColor.BLACK, new Coord(2, 6), new Coord(8, 8), new Coord(1, 1));

assertResults(true, testMove(pawn, new Coord(2, 5)), ++n);
assertResults(false, testMove(pawn, new Coord(1, 5)), ++n);
assertResults(false, testMove(pawn, new Coord(3, 5)), ++n);

System.out.println("END TEST DEFAULT PAWN MOVE");
System.out.println("- - - - - - - - - - - -");
}

public static boolean testMove(Figure figure, Coord newCoord){
return figure.isCanMove(newCoord, figures);
}

public static boolean testTake(Figure figure, Figure takeFigure){
return figure.isCanTake(takeFigure, figures);
}

public static void assertResults(boolean expected, boolean actual, int number){

if(expected == actual){
System.out.println("TEST - " + number + ": PASSED");
}
else
System.out.println("TEST - " + number + ": FAILED");
}

public static void assertResults(boolean expected, boolean actual){

if(expected == actual){
System.out.println("TEST: PASSED");
}
else
System.out.println("TEST: FAILED");
}

}