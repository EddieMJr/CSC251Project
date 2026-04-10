public class Policy
{  //fields
   private String policyNumber;
   private String providerName;
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   //constructors
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0;
      weight = 0;
   }

   /**
    * Constructor that initializes all fields.
    * 
    * @param pNumber The policy number
    * @param pName The provider name
    * @param fName The policyholder's first name
    * @param lName The policyholder's last name
    * @param a The policyholder's age
    * @param sStatus The smoking status (smoker/non-smoker)
    * @param h The height in inches
    * @param w The weight in pounds
    */
   public Policy(String pNumber, String pName, String fName, String lName,int a, String sStatus, double h, double w)
   {
      policyNumber = pNumber;
      providerName = pName;
      firstName = fName;
      lastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }
   
   //setters//
   /**
    * Sets the policy number.
    * @param pNumber The policy number
    */
   public void setPolicyNumber(String pNumber)
   {
      policyNumber = pNumber;
   }

   /**
    * Sets the provider name.
    * @param pName The provider name
    */
   public void setProviderName(String pName)
   {
      providerName = pName;
   }

   /**
    * Sets the first name.
    * @param fName The first name
    */
   public void setFirstName(String fName)
   {
      firstName = fName;
   }

   /**
    * Sets the last name.
    * @param lName The last name
    */
   public void setLastName(String lName)
   {
      lastName = lName;
   }

   /**
    * Sets the age.
    * @param a The age
    */
   public void setAge(int a)
   {
      age = a;
   }

   /**
    * Sets the smoking status.
    * @param sStatus The smoking status
    */
   public void setSmokingStatus(String sStatus)
   {
      smokingStatus = sStatus;
   }

   /**
    * Sets the height.
    * @param h The height in inches
    */
   public void setHeight(double h)
   {
      height = h;
   }

   /**
    * Sets the weight.
    * @param w The weight in pounds
    */
   public void setWeight(double w)
   {
      weight = w;
   }

   
   //getters//

   /**
    * Gets the policy number.
    * @return The policy number
    */
   public String getPolicyNumber()
   {
      return policyNumber;
   }

   /**
    * Gets the provider name.
    * @return The provider name
    */
   public String getProviderName()
   {
      return providerName;
   }

   /**
    * Gets the first name.
    * @return The first name
    */
   public String getFirstName()
   {
      return firstName;
   }

   /**
    * Gets the last name.
    * @return The last name
    */
   public String getLastName()
   {
      return lastName;
   }

   /**
    * Gets the age.
    * @return The age
    */
   public int getAge()
   {
      return age;
   }

   /**
    * Gets the smoking status.
    * @return The smoking status
    */
   public String getSmokingStatus()
   {
      return smokingStatus;
   }

   /**
    * Gets the height.
    * @return The height in inches
    */
   public double getHeight()
   {
      return height;
   }

   /**
    * Gets the weight.
    * @return The weight in pounds
    */
   public double getWeight()
   {
      return weight;
   }
   
      
   /**
    * Calculates the policyholder's BMI.
    * 
    * @return The BMI value
    */
   public double getBMI()
   {
      final double CONVFACTOR = 703;
      
      return (weight * CONVFACTOR) / (height * height);
   }
   
   /**
    * Calculates the policy price based on age, smoking status, and BMI.
    * 
    * @return The calculated policy price
    */
   public double getPrice()
   {
      final double BASE_PRICE = 600;
      final double ADDITIONAL_FEE_AGE = 75;
      final double ADDITIONAL_FEE_SMOKING = 100;
      final double ADDITIONAL_FEE_PER_BMI = 20;
      
      final int AGE_THRESHOLD = 50;
      final int BMI_THRESHOLD = 35;
      
      double price = BASE_PRICE;
      
      if(age > AGE_THRESHOLD) //over 50 years
         price += ADDITIONAL_FEE_AGE; //75
         
      if(smokingStatus.equalsIgnoreCase("smoker")) 
         price += ADDITIONAL_FEE_SMOKING; //100
            
      //call the getBMI method
      if(getBMI() > BMI_THRESHOLD) //BMI over 35
         price += ((getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI); //additional BMI fee - 20
         
      return price;
   }
   
   //Not included in the instructions but can be added...
   /*Displays information about the Policy
   public void displayInformation()
   {
      System.out.println("Policy Number: " + policyNumber);
      System.out.println("Provider Name: " + providerName);
      System.out.println("Policyholder's First Name: " + firstName);
      System.out.println("Policyholder's Last Name: " + lastName);
      System.out.println("Policyholder's Age: " + age);
      System.out.println("Policyholder's Smoking Status (Y/N): " + smokingStatus);
      System.out.println("Policyholder's Height: " + height + " inches");
      System.out.println("Policyholder's Weight: " + weight + " pounds");
      System.out.printf("Policyholder's BMI: %.2f\n", getBMI());
      System.out.printf("Policy Price: $%.2f\n", getPrice());
   }
   */
}
