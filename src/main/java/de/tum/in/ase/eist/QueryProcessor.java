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

        } else { // TODO extend the programm here
            return "";
        }
    }
}
