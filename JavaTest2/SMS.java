package JavaTest2;

import java.io.*;
import java.util.*;

public class SMS {
    HashMap<String, ArrayList<String>> sms;

    SMS() {
        this.sms = new HashMap<String, ArrayList<String>>();
    }

    public void addMessage(String fullName, String msg) {
        if (!sms.containsKey(fullName)) {
            sms.put(fullName, new ArrayList<>());
        }
        sms.get(fullName).add(msg);
    }

    public void DeleteChat(String fullName) {
        for (int i = 0; i < sms.size(); i++) {
            if (sms.containsKey(fullName)) {
                for (Map.Entry<String, ArrayList<String>> entry : sms.entrySet()) {
                    for (String message : entry.getValue()) {
                        entry.getValue().remove(message);
                    }
                }
            }
        }
    }

    public void PrintContactChats(String fullName) {
        for (int i = 0; i < sms.size(); i++) {
            if (sms.containsKey(fullName)) {
                for (Map.Entry<String, ArrayList<String>> entry : sms.entrySet()) {
                    System.out.println(entry.getValue());
                }
            } else {
                System.out.println("Contact doesn't exist!");
            }
        }
    }

    public void PrintNames(String searchStr) {
                for (Map.Entry<String, ArrayList<String>> entry : sms.entrySet())
                    if(entry.getValue().contains(searchStr))
                        System.out.println(entry.getKey());
    }


    public void PrintAllChats(){
        for (Map.Entry<String, ArrayList<String>> entry : sms.entrySet())
                System.out.println(entry.getKey() + ": " + entry.getValue());
    }


    /*SMS(String fullName) {
        this.sms = new HashMap<>();
        loadSMS(fullName);
    }

    public void loadSMS(String fullName) {
        try(BufferedReader br = new BufferedReader(new FileReader(fullName + ".txt"))){
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                // addmessage(parts[0],parts[1]);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void saveSMS(String fullName) {
        File messages = new File(fullName + ".txt"); /*New file named "PhoneBook.txt" */
/*        try {
            if (messages.createNewFile()) System.out.println("File created: " + messages.getName());
            else System.out.println("File already exists. Data will add to the existing file.");
            FileWriter wr = new FileWriter(fullName + ".txt");
            for (Map.Entry<String, List<String>> entry : sms.entrySet()) {
                for(String msg : entry.getValue())
                    wr.write(entry.getKey() + "\t" + msg + "\n");
            }
            System.out.println("Data added successfully");
            wr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }    }
*/
    }



