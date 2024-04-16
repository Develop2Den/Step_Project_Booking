import utils.DateConverter;
import PackageMenu.AppMenu;

public class App 
{
    public static void main( String[] args ) {

        AppMenu.main(args);
      
        String testDateString = "14/04/2024";
        long testDateLong = 1713045600000L;
        System.out.println(DateConverter.stringToLong(testDateString));
        System.out.println(DateConverter.longToString(testDateLong));
    }
}
