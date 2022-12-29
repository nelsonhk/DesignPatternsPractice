public class ChristmasFactory implements Factory {

    @Override
    public DecorationPlacer.TableclothPatternProvider getTablecloth() {
        return new ChristmasTableclothPatternProvider();
    }

    @Override
    public DecorationPlacer.WallHangingProvider getWallHanging() {
        return new ChristmasWallHangingProvider();
    }

    @Override
    public DecorationPlacer.YardOrnamentProvider getYardOrnament() {
        return new ChristmasYardOrnamentProvider();
    }

}
