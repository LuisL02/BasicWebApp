package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
        query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("what is your name")) {
            return "Luis";
        } else if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("plus")) {
            int first = query.indexOf("what is ") + 9;
            int second = query.indexOf("plus ") + 5;

            String x = query.substring(query.indexOf("what is "), first);
            String y = query.substring(query.indexOf("plus "), second);


            return String.valueOf(Integer.parseInt(x) + Integer.parseInt(y));

        } else if (query.toLowerCase().contains("which of the following numbers is the largest:")) {
            String[] numbers = query.substring(query.indexOf("which of the following numbers is the largest:") + 46).split(",");
            for (String s : numbers) {
                s = s.replaceAll("\\s+", "");
            }

            int biggest = -1;
            for (String s : numbers) {
                if (Integer.parseInt(s) > biggest) {
                    biggest = Integer.parseInt(s);
                }
            }
            return String.valueOf(biggest);
        } else { // TODO extend the programm here
            return "";
        }
    }

    public static void main(String[] args) {
        QueryProcessor queryProcessor = new QueryProcessor();

        System.out.println(queryProcessor.process("which of the following numbers is the largest: 10,20"));
    }
}
