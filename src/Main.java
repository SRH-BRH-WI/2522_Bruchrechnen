public class Main {

    public static void berechne(Bruch a, Bruch b, char operation) {
        System.out.print(a + " " + operation + " " + b + " = ");

        // Original Switch-Case Anweisung (break nicht vergessen!!!)
//        switch (operation) {
//            case '&':
//            case '+': System.out.println( a.add(b) );   break;
//            case '-': System.out.println( a.sub(b) );   break;
//            case '*': System.out.println( a.mult(b) );  break;
//            case ':':
//            case '/': System.out.println( a.div(b) );   break;
//            default:
//                System.out.println("unbekannte Operation");
//        }

        // Verbesserte (enhanced) Switch-Case Anweisung (mit Lambdas)
        switch (operation) {
            case '&', '+' -> System.out.println(a.add(b));
            case '-'      -> System.out.println(a.sub(b));
            case '*'      -> System.out.println(a.mult(b));
            case ':', '/' -> System.out.println(a.div(b));
            default       -> System.out.println("unbekannte Operation");
        }

/*
        if (operation == '+')      System.out.println( a.add(b) );
        else if (operation == '-') System.out.println( a.sub(b) );
        else if (operation == '*') System.out.println( a.mult(b) );
        else if (operation == '/') System.out.println( a.div(b) );
        else System.out.println("unbekannte Operation");
 */
    }

    public static void main(String[] args) {
        Bruch b1 = new Bruch(1, 2);
        Bruch b2 = new Bruch(2, 3);
        Bruch b3 = new Bruch(3, 4);

        berechne(b1, b2, '+');
        berechne(b1, b3, '-');
        berechne(b1, b2, '*');
        berechne(b1, b3, '/');
    }
}
