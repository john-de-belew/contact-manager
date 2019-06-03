import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DeleteContact {
    public static void deleteContact(){
        @SuppressWarnings("duplicate")
        Scanner input = new Scanner(System.in);
        String directory = "data";
        String file = "contact.txt";
        List<String> contactList;


        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, file);

        System.out.println("Please enter a contact you want to delete");
        String nameDelete= input.nextLine().toLowerCase();
        try {
            contactList = Files.readAllLines(dataFile);
            List<String> newContactList= new ArrayList<>();
            for (String line: contactList){

                if (line.toLowerCase().contains(nameDelete)){
                    System.out.println(line);
                    System.out.println("Is this the contact you want to delete?");
                    String response = input.nextLine();
                    if (response.equalsIgnoreCase("yes")||response.equalsIgnoreCase("y") ||
                            response.equalsIgnoreCase("yea")|| response.equalsIgnoreCase("sure")
                    || response.equalsIgnoreCase("yeah") || response.equalsIgnoreCase(
                            "affirmative")|| response.equalsIgnoreCase("correct")|| response.equalsIgnoreCase("ok")){
                        System.out.println("removing "+ line);

                        continue;
                    }

                }
                newContactList.add(line);
            }




                Files.write(dataFile,newContactList);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
