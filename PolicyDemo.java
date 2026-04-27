import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PolicyDemo 
{   
   public static void main(String[] args) throws IOException
   {
      File file = new File("PolicyInformation.txt");
      Scanner inputFile = new Scanner(file);

      ArrayList<Policy> policies = new ArrayList<>();

      int smokerCount = 0;
      int nonSmokerCount = 0;

      while (inputFile.hasNext())
      {
         String policyNumber = inputFile.nextLine();
         String providerName = inputFile.nextLine();
         String firstName = inputFile.nextLine();
         String lastName = inputFile.nextLine();

         int age = inputFile.nextInt();
         inputFile.nextLine();

         String smokingStatus = inputFile.nextLine();

         double height = inputFile.nextDouble();
         double weight = inputFile.nextDouble();

         if (inputFile.hasNextLine())
            inputFile.nextLine();

         PolicyHolder holder = new PolicyHolder(firstName, lastName, age,
                                                smokingStatus, height, weight);

         Policy policy = new Policy(policyNumber, providerName, holder);

         policies.add(policy);

         if (smokingStatus.equalsIgnoreCase("smoker"))
            smokerCount++;
         else
            nonSmokerCount++;
      }

      inputFile.close();

      // implicit toString
      for (Policy policy : policies)
      {
         System.out.println(policy);
      }

      // final totals
      System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
      System.out.println("The number of policies with a smoker is: " + smokerCount);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
   }
}
