import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class OnLoad {

     static void onLoad() {
         ArrayList<String> contacts = new ArrayList<String>();
         String directory = "data";
         String file = "contact.txt";
         int response = 0;
         Scanner input = new Scanner(System.in);

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, file);

        if(Files.notExists(dataDirectory)){
            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(Files.notExists(dataFile)){
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 5; i++) {

                String name = NameGenerator.nameGenerator();
                long number = (long) (Math.random()*10000000000L);
                contacts.add(name+" | " + number);
            }

            System.out.println(contacts);
            try {
                Files.write(dataFile, contacts);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

         System.out.println("1. View contacts.\n" +
                 "2. Add a new contact.\n" +
                 "3. Search a contact by name.\n" +
                 "4. Delete an existing contact.\n" +
                 "5. Exit.\n" +
                 "Enter an option (1, 2, 3, 4 or 5):");
        try{
            response = input.nextInt();
        }catch (Exception e){
            System.out.println("Please enter a valid input");
            OnLoad.onLoad();
            return;
        }
        if(response<1 || response>5){
            System.out.println("Please enter a valid input");
            OnLoad.onLoad();
            return;
        }

        switch (response){
            case 1:
                System.out.println("You chose 1");
                break;
            case 2 :
                System.out.println("You chose 2");
                break;
            case 3 :
                System.out.println("You chose 3");
                break;
            case 4 :
                System.out.println("You chose 4");
                break;
            case 5 :
                System.out.println("You chose 5");
                break;
                default:
                    System.out.println("Something went terribly wrong.");
        }

    }


}
