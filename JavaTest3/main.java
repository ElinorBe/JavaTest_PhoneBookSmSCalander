package JavaTest3;

import java.io.IOException;
import java.util.Scanner;


public class main {

    static void printMainMenu() {
        System.out.println("Menu - Type the operation number you would like to run:");
        System.out.println("[1] Phonebook menu");
        System.out.println("[2] Chat menu");
        System.out.println("[3] Calendar menu");
        System.out.println("[4] Exit program");
    }

    /**
     * 'printMenu()' method is printing the menu to the user.
     */
    static void printContactMenu() {
        System.out.println("\n");
        System.out.println("PhoneBook Menu - Type the operation number you would like to run:");
        System.out.println("[1] Add contact");
        System.out.println("[2] Delete contact");
        System.out.println("[3] Print all contacts");
        System.out.println("[4] Search contact (by name)");
        System.out.println("[5] Sort contacts (by name - ASC");
        System.out.println("[6] Sort contacts (by name - Desc");
        System.out.println("[7] Organize arrayList by revers order");
        System.out.println("[8] Print all deleted duplicate contacts");
        System.out.println("[9] Save phonebook as .txt file");
        System.out.println("[10] Load phonebook from txt file");
        System.out.println("[11] Exit");
    }

    static void PrintChatMenu() {
        System.out.println("\n");
        System.out.println("Chats menu - Type the operation number you would like to run:");
        System.out.println("[1] Add chat");
        System.out.println("[2] Delete chat");
        System.out.println("[3] Print chat");
        System.out.println("[4] Print contact name which have the relevant sentence");
        System.out.println("[5] Print all chats");
        System.out.println("[6] Exit - go back to main menu");
    }

    public void printCalendarMenu() {
        System.out.println("[1] Add new event");
        System.out.println("[2] Delete event");
        System.out.println("[3] Print events by date");
        System.out.println("[4] Print events by contact name, order by date");
        System.out.println("[5] Check if there are events at same time (delete the last)");
        System.out.println("[6] Print all events order by days");
        System.out.println("[7] Exit - go back to main menu");
    }

    static void GoToPhonebook() {
        int count = 0;
        int phonebookIndex = 0;
        PhoneBook phoneBook = new PhoneBook();
        do {
            printContactMenu();
            Scanner s = new Scanner(System.in);
            /** This try catch is checking if the user clicked illegal character (letters & signs).
             * if any illegal character was clicked it prints an error message and count the mistakes.
             * the user gets 3 chances to make a mistake, between the count arrive to 3 the program is closed. */
            try {
                phonebookIndex = s.nextInt();
            } catch (Exception e) {
                System.out.println("illegal choice! you have " + (3 - count) + " more chances left before the program will be close.\nplease choose an operation between 1 to 11");
                count++;
                continue;
            }

            /** In this switch case the user choice is transferred.
             * Depend on the number he clicked the relevant case start to run. */
            switch (phonebookIndex) {
                case 1: /** The user insert the details of the contact he wants to add, and then the contact is being transferred to the function at PhoneBook class. */
                    s.nextLine(); /** Catch the "linebreak" witch clicked after choosing case.*/
                    Contact c = new Contact();

                    System.out.println("Enter first name");
                    c.setFirstName(s.nextLine());

                    System.out.println("Enter middle name (optional)");
                    c.setMiddleName(s.nextLine());

                    System.out.println("Enter last name");
                    c.setLastName(s.nextLine());

                    System.out.println("Enter phone number");
                    c.setContactPhoneNumber(s.nextLine());

                    System.out.println("Enter company name number");
                    c.setContactCompanyName(s.nextLine());

                    phoneBook.AddContact(c);
                    count = 0; /** The count resets so that correct choices of the user will not count. (Repeated at all cases) */
                    break;
                case 2: /** The user insert the name of the contact he wants to delete, and then the name is being transferred to the function at PhoneBook class. */
                    System.out.println("Type the contact full name you want to delete (if there is 'middle name' type it also):");
                    s.nextLine(); /** Catch the "linebreak" witch clicked after insert name and phone */
                    phoneBook.DeleteContactByName(s.nextLine());
                    count = 0;
                    break;
                case 3: /** PhoneBook will be printed */
                    phoneBook.PrintPhoneBook();
                    count = 0;
                    break;
                case 4: /** user send to the function name of contact, the function prints all contacts with that name */
                    System.out.println("Type the contact full name you want to find:");
                    s.nextLine();
                    String findName = s.nextLine();
                    phoneBook.SearchContactByName(findName);
                    count = 0;
                    break;
                case 5: /** PhoneBook will be sorted in ascending order, by name - from small to large */
                    phoneBook.SortPhonebookAscending();
                    count = 0;
                    break;
                case 6: /** PhoneBook will be sorted in descending order, by name - from large to small */
                    phoneBook.SortPhonebookDescending();
                    count = 0;
                    break;
                case 7: /** PhoneBook organized reverse */
                    phoneBook.organizeReverse();
                    count = 0;
                    break;
                case 8: /** If there are duplicates contacts - they will be deleted and prints */
                    phoneBook.DeleteDuplicateContact();
                    count = 0;
                    break;
                case 9: /** PhoneBook will be saved as txt file*/
                    phoneBook.saveToTxtFile();
                    count = 0;
                    break;
                case 10: /** Contacts from txt file will be loaded to the phonebook */
                    phoneBook.LoadFileToPhoneBook("C:\\Users\\יעקב\\Desktop\\קורס JAVA\\MyJavaProject\\PhoneBook2.txt");
                    count = 0;
                    break;
                case 11: /** Program will close */
                    System.out.println("You chose to exit phonebook.");
                    break;
                default: /** If the user choice is not one of the cases (its mean a mistake choice),
                 the count will increase by 1 and a condition will run -
                 if the count is equal to 3, the program will close.
                 If the count smaller than 3, error message will be shown.*/
                    count++;
                    if (count != 3)
                        System.out.println("illegal choice! you have " + (3 - count) + " more chances left before the program will be close.\nplease choose an operation between 1 to 11");
                    else System.out.println("Program end");
            }
        } while (phonebookIndex != 11 && count != 3);
    }

    static void GoToChat() {
        Scanner s = new Scanner(System.in);
        int chatIndex = 0;
        String fullName, msg;
        SMS chat = new SMS();
        do {
            PrintChatMenu();
            try {
                chatIndex = s.nextInt();
            } catch (Exception e) {
                System.out.println("illegal choice! Please try again.");
                continue;
            }
            switch (chatIndex) {
                case 1:
                    System.out.println("Enter contact name and the message (in 2 lines)");
                    s.nextLine();
                    fullName = s.nextLine();
                    msg = s.nextLine();
                    chat.addMessage(fullName, msg);
                    break;
                case 2:
                    System.out.println("Enter contact name which you would like to delete his chats.");
                    s.nextLine();
                    fullName = s.nextLine();
                    chat.DeleteChat(fullName);
                    break;
                case 3:
                    System.out.println("Enter contact name which you would like to print his chats.");
                    s.nextLine();
                    fullName = s.nextLine();
                    chat.PrintContactChats(fullName);
                    break;
                case 4:
                    System.out.println("Enter sentence");
                    s.nextLine();
                    String searchStr = s.nextLine();
                    chat.PrintNames(searchStr);
                    break;
                case 5:
                    chat.PrintAllChats();
                    break;
                case 6:
                    System.out.println("You chose to exit chat app.");
                    chat.saveSMS();
                    break;
            }
        } while (chatIndex != 6);
    }

    public static void main(String[] args) throws IOException {
        int menuIndex = 0;
        int count1 = 0;
        do {
            printMainMenu();
            Scanner s1 = new Scanner(System.in);
            /** This try catch is checking if the user clicked illegal character (letters & signs).
             * if any illegal character was clicked it prints an error message and count the mistakes.
             * the user gets 3 chances to make a mistake, between the count arrive to 3 the program is closed. */
            try {
                menuIndex = s1.nextInt();
            } catch (Exception e) {
                System.out.println("illegal choice! you have " + (3 - count1) + " more chances left before the program will be close.\nplease choose an operation between 1 to 11");
                count1++;
                continue;
            }
            switch (menuIndex) {
                case 1:
                    GoToPhonebook();
                    break;
                case 2:
                    GoToChat();
                    break;
                case 3:
                    //GoCalendar();
                    break;
                case 4: /** Program will close */
                    System.out.println("You chose to exit program.");
                    break;
                default: /** If the user choice is not one of the cases (its mean a mistake choice),
                 the count will increase by 1 and a condition will run -
                 if the count is equal to 3, the program will close.
                 If the count smaller than 3, error message will be shown.*/
                    count1++;
                    if (count1 != 3)
                        System.out.println("illegal choice! you have " + (3 - count1) + " more chances left before the program will be close.\nplease choose an operation between 1 to 11");
                    else System.out.println("Program end");
            }
        } while (menuIndex != 4 && count1 != 3);
    }
}

