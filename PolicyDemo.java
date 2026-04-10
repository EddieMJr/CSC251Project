import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PolicyDemo 
{   
   public static void main(String[] args) throws IOException
   {
      // Open file
      File file = new File("PolicyInformation.txt");
      Scanner inputFile = new Scanner(file);

      // Store multiple policies
      ArrayList<Policy> policies = new ArrayList<>();

      int smokerCount = 0;
      int nonSmokerCount = 0;

      // Read from file
      while (inputFile.hasNext())
      {
         String policyNumber = inputFile.nextLine();
         String providerName = inputFile.nextLine();
         String firstName = inputFile.nextLine();
         String lastName = inputFile.nextLine();

         int age = inputFile.nextInt();
         inputFile.nextLine(); // IMPORTANT

         String smokingStatus = inputFile.nextLine();

         double height = inputFile.nextDouble();
         double weight = inputFile.nextDouble();

         if (inputFile.hasNextLine())
            inputFile.nextLine();

         // Create Policy object
         Policy policy = new Policy(policyNumber, providerName, firstName,
                                    lastName, age, smokingStatus, height, weight);

         // Add to list
         policies.add(policy);

         // Count smokers
         if (smokingStatus.equalsIgnoreCase("smoker"))
            smokerCount++;
         else
            nonSmokerCount++;
      }

      inputFile.close();

      // Display all policies
      for (Policy policy : policies)
      {
         System.out.println("Policy Number: " + policy.getPolicyNumber());
         System.out.println("Provider Name: " + policy.getProviderName());
         System.out.println("Policyholder's First Name: " + policy.getFirstName());
         System.out.println("Policyholder's Last Name: " + policy.getLastName());
         System.out.println("Policyholder's Age: " + policy.getAge());
         System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
         System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
         System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");

         System.out.printf("Policyholder's BMI: %.2f\n", policy.getBMI());
         System.out.printf("Policy Price: $%.2f\n\n", policy.getPrice());
      }

      // Display totals
      System.out.println("The number of policies with a smoker is: " + smokerCount);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
   }
}
