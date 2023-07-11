package WenlongLab01;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Supplier;

public class Main {

    /**
     * this is a test class for this lab assignment
     */
    public static void main(String[] args) {
//        Person person = new Person("jack", "ma");
//        System.out.println(person.sureName);

        /**
         * Step 1: create 3 nurse instances and assign different shift to each
         */
        Nurse nurse_0 = new Nurse("ChildrenCare", "Martha", "McGee");
        nurse_0.setShift(Nurse.SHIFT_A);
        Nurse nurse_1 = new Nurse("PhysicalCure", "Alice", "Lee");
        nurse_1.setShift(Nurse.SHIFT_B);
        Nurse nurse_2 = new Nurse("Emergency", "Donald", "Kim");
        nurse_2.setShift(Nurse.SHIFT_C);
        /**
         * create a new array to store these 3 nurse instance
         */
        System.out.println("==============Step1:==============");
        Nurse[] nurse = new Nurse[3];
        nurse[0] = nurse_0;
        nurse[1] = nurse_1;
        nurse[2] = nurse_2;
        System.out.println(nurse_0.toString());
        System.out.println(nurse_1.toString());
        System.out.println(nurse_2.toString());
        /**
         * Step 2: create 3 doctor instance
         */
        System.out.println("==============Step2:==============");
        Doctor doctor_0 = new Doctor("ChildrenCare", "Neurology", "Brenda", "Freeman");
        Doctor doctor_1 = new Doctor("PhysicalCure", "Podiatry", "Jones", "Doe");
        Doctor doctor_2 = new Doctor("Emergency", "Surgury", "Mike", "Wilson");
        /**
         * create a new array to store these 3 doctor instance
         */
        Doctor doctor[] = new Doctor[3];
        doctor[0] = doctor_0;
        doctor[1] = doctor_1;
        doctor[2] = doctor_2;

        System.out.println(doctor_0.toString());
        System.out.println(doctor_1.toString());
        System.out.println(doctor_2.toString());
        /**
         * Step 3: Create 3 patients manually ,assign doctor instance
         */
        System.out.println("==============Step3:==============");
        Patient patient0 = new Patient("Spencer", "Kelly", doctor_0);
        Patient patient1 = new Patient("Taylor", "Clark", doctor_1);
        Patient patient2 = new Patient("Kendall", "Roy", doctor_2);
// given  array of givenNames and surNames
        String[] givenNames = {
            "Avery", "Riley", "Jordan", "Angel", "Peyton",
            "Quinn", "Hayden", "Taylor", "Alexis", "Rowan",
            "Charlie", "Emerson", "Finley", "River", "Emery",
            "Morgan", "Elliot", "London", "Eden", "Elliott",
            "Karter", "Dakota", "Reese", "Remington", "Payton",
            "Amari", "Phoenix", "Kendall", "Harley", "Rylan",
            "Marley", "Dallas", "Skyler", "Spencer", "Sage",
            "Kyrie", "Ellis", "Rory", "Remi", "Justice",
            "Ali", "Haven", "Tatum", "Arden", "Linden",
            "Devon", "Rebel", "Rio", "Ripley", "Frankie"
        };
        // change surnames to surNames for convenience
        String[] surNames = {
            "Smith", "Brown", "Tremblay", "Martin", "Roy",
            "Wilson", "Macdonald", "Gagnon", "Johnson", "Taylor",
            "Cote", "Campbell", "Anderson", "Leblanc", "Lee",
            "Jones", "White", "Williams", "Miller", "Thompson",
            "Gauthier", "Young", "Van", "Morin", "Bouchard",
            "Scott", "Stewart", "Belanger", "Reid", "Pelletier",
            "Moore", "Lavoie", "King", "Robinson", "Levesque",
            "Murphy", "Fortin", "Gagne", "Wong", "Clark",
            "Johnston", "Clarke", "Ross", "Walker", "Thomas",
            "Boucher", "Landry", "Kelly", "Bergeron", "Davis"
        };
        /**
         * Step 4: generate 20 patients automatically int TOTAL_NUM_OF_PATIENTS
         * is the total number of 23 patients in this lab work 3 patients:
         * created manually 20 patients: created with random names from 2 arrays
         * (givenNames[],surNames[]) and 1 array of doctor[]
         */
        System.out.println("==============Step4:==============");
        final int TOTAL_NUM_OF_PATIENTS = 20 + 3;
        Patient[] patient = new Patient[TOTAL_NUM_OF_PATIENTS];
        patient[0] = patient0;
        patient[1] = patient1;
        patient[2] = patient2;

        Random random = new Random();
        for (int i = 3; i < TOTAL_NUM_OF_PATIENTS; i++) {
            // generate integer between 0 to 2 (there are 3 doctors instances in total)
            int randomIndex = random.nextInt(3);
            patient[i] = new Patient(givenNames[i], surNames[i], doctor[randomIndex]);
        }
        /**
         * Step 5:Prints the toString() values for all employees. create a new
         * Person [] [] array to store all instances that have been created
         * above
         */
        System.out.println("==============Step5:==============");
        Person[][] persons = new Person[3][];
        persons[0] = nurse;
        persons[1] = doctor;
        persons[2] = patient;
        //System.out.println(Arrays.stream(persons).toList());
        /**
         * use for loops to print all employee instances' toString values nurse
         * and doctor are the first 2 array in person[][]
         */
        for (int y = 0; y < persons.length - 1; y++) {
            for (int y1 = 0; y1 < persons[y].length; y1++) {
                System.out.println(persons[y][y1].toString());
            }
        }
        /**
         * Step 6:Prints the toString() value and physician ID for each patient.
         */
        System.out.println("==============Step6:==============");
        for (int j = 0; j < TOTAL_NUM_OF_PATIENTS; j++) {
            System.out.println(" patient[" + j + "]" + patient[j].toString() + "'doctor's ID is  " + patient[j].physician.ID);
        }
        /**
         * Step 7:calculate and print total annual cost of all nurse[3] and
         * doctor[3]
         */
        System.out.println("==============Step7:==============");
        int totalAnnualSalary = 0;
        int maxNumOfEmp = 0;
        for (int y = 0; y < persons.length - 1; y++) {
            if (persons[y].length >= maxNumOfEmp) {
                maxNumOfEmp = persons[y].length;
            }
            Employee[][] employee = new Employee[2][maxNumOfEmp];
            for (int y1 = 0; y1 < persons[y].length; y1++) {
                employee[y][y1] = (Employee) persons[y][y1];
                totalAnnualSalary += employee[y][y1].getAnnualSalary();
            }
        }
        System.out.println("employees' totalAnnualSalary is " + totalAnnualSalary);
        /**
         * Step 8:Calculates and prints the number of patients assigned to each
         * doctor There are 23 patients in total
         */
        System.out.println("==============Step8:==============");
        int[] totalNumOfPatients = new int[doctor.length];
        for (int d1 = 0; d1 < doctor.length; d1++) {
            for (int d2 = 0; d2 < patient.length; d2++) {
                if (doctor[d1].ID == patient[d2].physician.ID) {
                    totalNumOfPatients[d1]++;
                }
            }
            System.out.println("Doctor[" + doctor[d1].givenName + "] Number of patients(totalNum is 23) is: " + totalNumOfPatients[d1]);
        }

    }
}
