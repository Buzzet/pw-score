package de.jannikreinefeld.cloudservice.passwordInspector;
public class PasswordInspector {
    public static int getPasswordScore(String pw){
        int amountChars = 0;
        if(matchesNumber(pw)){
            amountChars += 10;
        }
        if (matchesLetter(pw)){
            amountChars += 26;
        }
        if (matchesSymbol(pw)){
            amountChars += 22;
        }
        double possibilities = Math.pow(amountChars, pw.length());
        System.out.println(possibilities);
        double time = possibilities / 1000000 / 60;
        return (int) time;
    }

    public static boolean matchesNumber(String pw){
        return pw.matches(".*[0-9]+.*");
    }

    public static boolean matchesSymbol(String pw){
       return pw.matches(".*[$&+,:;=?@#|'<>.\\-^*()%!]+.*");
    }

    public static boolean matchesLetter(String pw){
        return pw.matches(".*[a-zA-Z]+.*");
    }
}
