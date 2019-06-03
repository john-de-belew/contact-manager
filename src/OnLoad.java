import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

            for (int i = 0; i < 7; i++) {

                String name = NameGenerator.nameGenerator();
                long number = (long) (Math.random()*10000000000L);
                String nConcat = String.format("%-28s |%-28s", name, number);
                contacts.add(nConcat);
            }

//            System.out.println(contacts);
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
                System.out.printf("%-27s  |%-28s %n","Name", "Phone Number");
                System.out.println("----------------------------------------");
                try {
                    List<String> contactList = Files.readAllLines(dataFile);
                    for (String contact : contactList) {
                        System.out.println(contact);
                    }

                }catch (Exception e){
                    System.out.println("this isnt working");
                    e.fillInStackTrace();
                }
                OnLoad.onLoad();
                break;
            case 2 :
                    AddContact.addContacts();
                OnLoad.onLoad();
                break;
            case 3 :
                SearchContacts.searchContacts();
                OnLoad.onLoad();
                break;
            case 4 :
                DeleteContact.deleteContact();
                OnLoad.onLoad();
                break;
            case 5 :
                System.out.println("                 ___====-_  _-====___\n" +
                        "           _--^^^#####//      \\\\#####^^^--_\n" +
                        "        _-^##########// (    ) \\\\##########^-_\n" +
                        "       -############//  |\\^^/|  \\\\############-\n" +
                        "     _/############//   (@::@)   \\\\############\\_\n" +
                        "    /#############((     \\\\//     ))#############\\\n" +
                        "   -###############\\\\    (oo)    //###############-\n" +
                        "  -#################\\\\  / VV \\  //#################-\n" +
                        " -###################\\\\/      \\//###################-\n" +
                        "_#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" +
                        "|/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" +
                        "`  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" +
                        "   `   `  `      `   / | |  | | \\   '      '  '   '\n" +
                        "                    (  | |  | |  )\n" +
                        "                   __\\ | |  | | /__\n" +
                        "                  (vvv(VVV)(VVV)vvv)");
                System.out.println("Bye.");
                break;
                default:
                    System.out.println("Something went terribly wrong.");
        }

    }


}
