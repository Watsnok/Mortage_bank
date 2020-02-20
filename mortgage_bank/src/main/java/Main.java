import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){



        Main mort = new Main();

        ArrayList<Prospect> list = new ArrayList<Prospect>();
        
        String address = "prospects.txt";
        String alllines = mort.readFile(address);

        list = mort.addCustomers(list, alllines);

        mort.showAllProspects(list);


    }

    public void showAllProspects(ArrayList<Prospect> list) {
        for(Prospect p : list){
            System.out.println(p.getName()+" wants to borrow "+p.getTotal()+" Euros for a period of "+p.getYears()+" years paying "+p.getMonthlypay()+" euros a month");
        }
    }

    public ArrayList<Prospect> addCustomers(ArrayList<Prospect> list, String alllines) {
        String[] everyLine = alllines.split(";");

        for(String p : everyLine){
            String[] temp = p.split(",");
            if(temp[0] == " ") {break;}

            //If the prospect is of normal length being 4.
            if(temp.length == 4){
                list.add(new Prospect(
                        temp[0],
                        Double.parseDouble(temp[1]),
                        Float.parseFloat(temp[2]),
                        Float.parseFloat(temp[3])));
            }
            //If the prospects length is longer or shorter than four it will need to be cleaned.
            else if (temp.length > 4){
                list.add(new Prospect(
                        temp[0].substring(1)+" "+temp[1].substring(0,temp[1].length()-1),
                        Double.parseDouble(temp[2]),
                        Float.parseFloat(temp[3]),
                        Float.parseFloat((temp[4]))
                ));
            }
        }

        return list;
    }

    public String readFile(String address) {
        String totaltext = "";
        String s = null;
        File file = new File(address);

        try {
            BufferedReader bfreader = new BufferedReader(new FileReader(file));
            try {
                if(bfreader.ready()){
                    bfreader.readLine();
                    while((s=bfreader.readLine())!=null)
                    {
                        if(s==" "){

                        }else{
                            totaltext += s + ";";
                        }

                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return totaltext;
    }
}
