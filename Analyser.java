import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Analyser {


    private static String testString1 = "hello, please reserve a table for two people on 19.3 at 20:00 thank you Klaus Muller";
    private static String testString2 = "Dear sir or Madam, we would like to come to the brunch on 9 April at 9:45 with six people, Kind regards Maria Meier";
    private static String testString3 = "good day, a table for 8 people on 1.5. 9 o'clock in the evening, regards Franz Schulze";

    /*
    private static String testString1 = "Hallo, bitte für zwei Personen einen Tisch am 19.3. um 20:00 Uhr, Vielen Dank Klaus Müller";
    private static String testString2 = "Sehr geehrte Damen Herren, wir würden gern am 9. April um 9:45 Uhr mit sechs Leuten zum Brunch kommen, Mit freundlichen Grüßen Maria Meier";
    private static String testString3 = "Guten Tag, einen Tisch für 8 Mann am 1.5. 9 Uhr abends, Gruß Franz Schulze ";
     */
    

    public static void main(String[] args) {
        String request = testString3;
        extractAndPrintInfo(request);
    }

    private static String getRequestString() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your reservation request: ");
        String req = reader.next();
        reader.close();
        return req;
    }

    private static void extractAndPrintInfo(String request) {
        List<String> words = Arrays.asList(request.replaceAll(",", "").split("\\s+"));

        String name = words.get(words.size() - 2) + " " + words.get(words.size() - 1);

        int peopleIndex = words.indexOf("people");
        String numPeople = words.get(peopleIndex - 1);

        int onIndex = words.indexOf("on");
        String date = words.get(onIndex + 1);

        int atIndex = words.indexOf("at");
        String time;
        if (atIndex != -1) {
            time = words.get(atIndex + 1);
        } else {
            time = words.get(words.indexOf("in") - 2);
        }

        System.out.printf("(%s,%s,%s,%s)%n", name, date ,time, numPeople);
    }
}
