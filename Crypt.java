import java.util.*;
import java.io.*;
public class Crypt
{
   public static void main(String[] args)
   {
        char sel, type;
        int displace;
        String ifilename = "", ofilename = "";
        do
        {
                intro();
                displace = getPassword();

                ifilename = getFileName("Source File  ==> ");

                type = getType();  // get Crypt Type

                ofilename = getFileName("Output File  ==> ");

                crypt (ifilename, ofilename, displace, type);
                sel = rerunPrompt ();
                System.out.println();
        } while (sel != 'N');

        System.out.println("\t\t\10" + "   !!! Exiting Security System !!!\7");
   }

   private static void intro()
   {    // Prints the welcome message


   }

   private static int getPassword()
   {    // Inputs the password

        // Prompt user to enter password

        // Add the ascii values of the characters and calculate the displacement value


   }

   private static String getFileName(String prompt)
   {    // Prompt the user for the filename using the parameter as the prompt message


   }

   private static char getType()
   {    // Prompt user to enter either E to encrypt or D to decrypt


   }

   private static void crypt(String ifilename, String ofilename, int displace, char type)
   {    // Encrypts the file in ifilename and outputs it to ofilename

        try {
           // Create input and output file objects to work with
           Scanner in = new Scanner(new File(ifilename));
           PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ofilename)));

           int coef = (type == 'E') ? 1 : -1;

           // Loop until end of file...read a line, encrypt it character by character, and
           // write the line to the output file
           String line;
           char ch;
           int linesProcessed = 0, charsCrypted = 0;
           while(in.hasNext())
           {
                line = in.nextLine();

                // Encrypt the line
                for (int i = 0; i < line.length(); i++)
                {
                   if (line.charAt(i) != '\t')
                   {
                        int ascii = (int) line.charAt(i) + (displace * coef);

                        // Keep printable characters
                        if (coef == 1)
                        {
                           if (ascii > 126)
                                ch = (char) (ascii - 126 + 31);
                           else
                                ch = (char) (ascii);
                        }
                        else
                           if (ascii < 32)
                                ch = (char) (127 - (32 - ascii));
                           else
                                ch = (char) (ascii);

                        line = line.substring(0, i) + ch + line.substring(i + 1);
                        charsCrypted++;
                   }
                }

                // Write the line to the output file
                out.println(line);
                linesProcessed++;
           }

           in.close();
           out.close();
           System.out.println("\t\t\t   Lines processed :  " + linesProcessed +
                            "\n\t\t\tCharacters crypted :  " + charsCrypted);

        }
        catch (IOException e)
        {
           System.err.println(e.getMessage());
        }
   }


   private static char rerunPrompt()
   {    // Prompt the user to enter Y to go again or N to stop





   }
