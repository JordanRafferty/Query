package jordanrafferty.com.query;

import java.util.Random;

/**
 * Created by Jordan on 4/21/15.
 */
public class Query {


    private String[] queryList;
    private Random randomGenerator;

    public Query(String[] queryList) {
        this.queryList = queryList;
        this.randomGenerator = new Random();
    }

    public String getQuestion() {

        String queryDisplay = "";

        //Randomly select a Question
        int randomNumber = randomGenerator.nextInt(queryList.length);

        queryDisplay = queryList[randomNumber];

        return queryDisplay;
    }
}

