package org.chess.serviceTest.moveServiceTest;

public class ClassicChessMoveServiceTest {
//    @Test
//    public void makeMoveByQueenTest() throws IncorrectMoveException {
//        HashSet<FigureDTO> figures = new HashSet<>();
//        FigureManagerFactory factory = new ClassicalChessFigureManagerFactory();
//
//        figures.addAll(Arrays.asList(
//                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(4, 4)),
//                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(2, 2))
//        ));
//
//        Board board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.WHITE);
//
//        ClassicChessMoveService moveService = new ClassicChessMoveService(board, factory);
//
//        moveService.makeMove(new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(4, 4)), new CoordDTO(3, 6));
//
//        FigureDTO figure = board.getFiguresOnTheBoard().stream().filter(figure1 -> figure1.getType().equals(FigureType.HORSE)).findFirst().get();
//
//        Assertions.assertEquals(new CoordDTO(3, 6), figure.getFigureCoord());
//
//
//        figures = new HashSet<>();
//        figures.addAll(Arrays.asList(
//                new FigureDTO(FigureColor.BLACK, FigureType.HORSE, new CoordDTO(4, 4)),
//                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(2, 2))
//        ));
//
//        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.WHITE);
//
//        moveService = new ClassicChessMoveService(board, factory);
//
//        try {
//            moveService.makeMove(new FigureDTO(FigureColor.BLACK, FigureType.HORSE, new CoordDTO(4, 4)), new CoordDTO(3, 6));
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        figure = board.getFiguresOnTheBoard()
//                .stream().filter(figure1 -> figure1.getType().equals(FigureType.HORSE)).findFirst().get();
//
//        Assertions.assertEquals(new CoordDTO(4, 4), figure.getFigureCoord());
//
//
//        figures = new HashSet<>();
//        figures.addAll(Arrays.asList(
//                new FigureDTO(FigureColor.BLACK, FigureType.TOWER, new CoordDTO(4, 4)),
//                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(4, 2))
//        ));
//
//        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.WHITE);
//
//        moveService = new ClassicChessMoveService(board, factory);
//
//        try {
//            moveService.makeMove(new FigureDTO(FigureColor.BLACK, FigureType.TOWER, new CoordDTO(4, 4)), new CoordDTO(4, 1));
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        figure = board.getFiguresOnTheBoard()
//                .stream().filter(figure1 -> figure1.getType().equals(FigureType.TOWER)).findFirst().get();
//
//        Assertions.assertEquals(new CoordDTO(4, 4), figure.getFigureCoord());
//    }
}
