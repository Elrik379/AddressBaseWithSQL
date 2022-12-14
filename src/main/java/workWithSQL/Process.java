package workWithSQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Process {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintStream printStream = new PrintStream(System.out);


    public String addingData() throws IOException {
        printStream.println("Введите адрес");
        String addressUser = bufferedReader.readLine();
        printStream.println("Введите фамилию");
        String firstName = bufferedReader.readLine();
        printStream.println("Введите имя");
        String lastName = bufferedReader.readLine();
        printStream.println("Введите возраст");
        String age = bufferedReader.readLine();
        int ages = Integer.parseInt(age);
        return String.format("('%s', '%s', '%s', '%d');", addressUser, firstName, lastName, ages);
    }


}