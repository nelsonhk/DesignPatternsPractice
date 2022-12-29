public class DecorationPlacer {

    public interface TableclothPatternProvider {
        String getTablecloth();
    }

    public interface WallHangingProvider {
        String getHanging();
    }

    public interface YardOrnamentProvider {
        String getOrnament();
    }

    private TableclothPatternProvider tableclothPattern;
    private WallHangingProvider wallHanging;
    private YardOrnamentProvider yardOrnament;

    public DecorationPlacer(Factory factory) {

        this.tableclothPattern = factory.getTablecloth();
        this.wallHanging = factory.getWallHanging();
        this.yardOrnament = factory.getYardOrnament();

    }

    public String placeDecorations() {
        return "Everything was ready for the party. The " + yardOrnament.getOrnament()
                + " was in front of the house, the " + wallHanging.getHanging()
                + " was hanging on the wall, and the tablecloth with " + tableclothPattern.getTablecloth()
                + " was spread over the table.";
    }
}
