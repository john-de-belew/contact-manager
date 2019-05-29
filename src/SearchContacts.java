import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SearchContacts {
    static void searchContacts(){
        Scanner input = new Scanner(System.in);
        String directory = "data";
        String file = "contact.txt";
        List<String> contactList;

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, file);
        System.out.println("Please enter the contact you want to search for?");
        String nameSearch = input.nextLine().toLowerCase();

        try {
            contactList = Files.readAllLines(dataFile);
            for (String line: contactList) {
                if(line.toLowerCase().contains(nameSearch)){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

