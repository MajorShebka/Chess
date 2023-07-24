package org.chess.serviceTest.takeServiceTest;

public class ClassicChessTakeServiceTest {
//    @Test
//    public void makeMoveByQueenTest() throws IncorrectTakeException {
//        HashSet<FigureDTO> figures = new HashSet<>();
//        FigureManagerFactory factory = new ClassicalChessFigureManagerFactory();
//
//        figures.addAll(Arrays.asList(
//                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(4, 4)),
//                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(3, 6))
//        ));
//
//        Board board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.WHITE);
//
//        ClassicChessTakeService takeService = new ClassicChessTakeService(board, factory);
//
//        takeService.take(new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(4, 4)),
//                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(3, 6)));
//
//        FigureDTO figure = board.getFiguresOnTheBoard().stream().filter(figure1 -> figure1.getType().equals(FigureType.HORSE)).findFirst().get();
//
//        Assertions.assertEquals(new CoordDTO(3, 6), figure.getFigureCoord());
//
//
//        figures = new HashSet<>();
//        figures.addAll(Arrays.asList(
//                new FigureDTO(FigureColor.BLACK, FigureType.HORSE, new CoordDTO(4, 4)),
//                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(2, 2))
//        ));
//
//        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.WHITE);
//
//        takeService = new ClassicChessTakeService(board, factory);
//
//        try {
//            takeService.take(new FigureDTO(FigureColor.BLACK, FigureType.HORSE, new CoordDTO(4, 4))
//                    , new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(2, 2)));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        figure = board.getFiguresOnTheBoard()
//                .stream().filter(figure1 -> figure1.getType().equals(FigureType.HORSE)).findFirst().get();
//
//        Assertions.assertEquals(new CoordDTO(4, 4), figure.getFigureCoord());
//    }
}
