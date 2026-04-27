public class PolicyHolder
{
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   public PolicyHolder()
   {
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0;
      weight = 0;
   }

   public PolicyHolder(String fName, String lName, int a, String sStatus, double h, double w)
   {
      firstName = fName;
      lastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }

   // COPY CONSTRUCTOR (security)
   public PolicyHolder(PolicyHolder other)
   {
      firstName = other.firstName;
      lastName = other.lastName;
      age = other.age;
      smokingStatus = other.smokingStatus;
      height = other.height;
      weight = other.weight;
   }

   // Getters
   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
   public int getAge() { return age; }
   public String getSmokingStatus() { return smokingStatus; }
   public double getHeight() { return height; }
   public double getWeight() { return weight; }

   // BMI
   public double getBMI()
   {
      final double CONVFACTOR = 703;
      return (weight * CONVFACTOR) / (height * height);
   }

   // toString method
   public String toString()
   {
      return "Policyholder's First Name: " + firstName + "\n" +
             "Policyholder's Last Name: " + lastName + "\n" +
             "Policyholder's Age: " + age + "\n" +
             "Policyholder's Smoking Status (smoker/non-smoker): " + smokingStatus + "\n" +
             "Policyholder's Height: " + height + " inches\n" +
             "Policyholder's Weight: " + weight + " pounds\n" +
             String.format("Policyholder's BMI: %.2f\n", getBMI());
   }
}
