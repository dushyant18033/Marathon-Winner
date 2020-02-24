public class Runner
{
    public static int HALF_MARATHON;
    public static int OPEN_10K_RUN;
    public static int GREAT_DELHI_RUN;

    private String name;
    private int time;
    private int category;

    Runner(String n, int t, int c)
    {
        name=n;
        time=t;
        category=c;
        HALF_MARATHON=0;
        OPEN_10K_RUN=1;
        GREAT_DELHI_RUN=2;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getCategory() {
        return category;
    }
}
