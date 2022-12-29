public class HalloweenFactory implements Factory {

    public HalloweenFactory() {}

    @Override
    public DecorationPlacer.TableclothPatternProvider getTablecloth() {
        return new HalloweenTableclothPatternProvider();
    }

    @Override
    public DecorationPlacer.WallHangingProvider getWallHanging() {
        return new HalloweenWallHangingProvider();
    }

    @Override
    public DecorationPlacer.YardOrnamentProvider getYardOrnament() {
        return new HalloweenYardOrnamentProvider();
    }
}
