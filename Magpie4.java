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

        //End context based responses 

        return response;
    }

}
