/**
 * A program to carry on conversations with a human user.
 * This version: Final
 *<ul><li>
 * 		Uses advanced search for keywords 
 *</li><li>
 * 		Will transform statements as well as react to keywords
 *</li></ul>
 * @authors Shiroman Singh, Abigale Kim
 * @version December 2016
 * Domain: Sports chatbot which is expert on Golden State Warriors NBA team.
 */
public class Magpie4
{
    /**
     * Get a default greeting 	
     * @return a greeting
     */	
    public String getGreeting()
    {
        return "Input Variables";
    }

    public String getEnding()
    {
        return "Good Bye, have a nice day!";
    } //Unique method

    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = ""; 
        if (statement.length() == 0) //Null imput/random/probing response start
        {
            response = "Input Variables";
        }

        else if (findKeyword(statement, "hello") >= 0)
        {
            response = "Hello, how's your day?";
        }
        else if (findKeyword(statement, "How's your day?") >= 0)
        {
            response = "My day has been fine so far.";
        }
        else if (findKeyword(statement, "What is your name?") >= 0)
        {
            response = "My name is SportsAssist";
            //End Null input/random/probing response
        } //Begin context based responses
        else if (findKeyword(statement, "Where Warriors play") >= 0
        || findKeyword(statement, "Where") >= 0
        || findKeyword(statement, "Warriors play") >=0)
        {
            response = "The Golden State Warriors play at Oracle Arena in Oakland, California.";
        }
        //End context based responses 

        return response;
    }

   /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement)
    {
        // Start transposition responses
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "Would you like to " + restOfStatement + "?";
               
    }

    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
     
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }

        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
        //End transposition responses
    }

    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }

            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
            && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }

            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

        }

        return -1;
    }

    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 10;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        //Begin random responses
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Why?";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "Tell me more";
        }
        else if (whichResponse == 4)
        {
            response = "That sounds interesting!";
        }
        else if (whichResponse == 5)
        {
            response = "That's pretty good.";
        }
        else if (whichResponse == 6)
        {
            response = "Ask me another question";
        }
        else if (whichResponse == 7)
        {
            response = "Cool idea!";
        }
        else if (whichResponse == 8)
        {
            response = "Interesting point";
        }
        else if (whichResponse == 9)
        {
            response = "I do not understand; please clarify";
        }
        else if (whichResponse == 10)
        {
            response = "That's awesome";
        }
        //Finish random responses

        return response;

    }

}