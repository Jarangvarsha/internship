import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    String name;
    int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Doctor {
    String name;
    String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Specialization: " + specialization;
    }
}

class Appointment {
    Doctor doctor;
    Patient patient;
    String date;

    public Appointment(Doctor doctor, Patient patient, String date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Doctor: " + doctor.name + ", Patient: " + patient.name + ", Date: " + date;
    }
}

public class MedicalManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMedical Management System Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Make Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    addDoctor(scanner);
                    break;
                case 3:
                    makeAppointment(scanner);
                    break;
                case 4:
                    viewAppointments();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }

    static void addPatient(Scanner scanner) {
        System.out.print("Enter patient name: ");
        String name = scanner.next();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        patients.add(new Patient(name, age));
        System.out.println("Patient added successfully!");
    }

    static void addDoctor(Scanner scanner) {
        System.out.print("Enter doctor name: ");
        String name = scanner.next();
        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.next();
        doctors.add(new Doctor(name, specialization));
        System.out.println("Doctor added successfully!");
    }

    static void makeAppointment(Scanner scanner) {
        if (doctors.isEmpty() || patients.isEmpty()) {
            System.out.println("There are no doctors or patients available to make appointments.");
            return;
        }
        System.out.println("Available doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i));
        }
        System.out.print("Select doctor (enter number): ");
        int doctorIndex = scanner.nextInt() - 1;

        System.out.println("Available patients:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i));
}
  System.out.print("Select patient (enter number): ");
        int patientIndex = scanner.nextInt() - 1;

        System.out.print("Enter appointment date: ");
        String date = scanner.next();

        appointments.add(new Appointment(doctors.get(doctorIndex), patients.get(patientIndex), date));
        System.out.println("Appointment made successfully!");
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("Scheduled Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
}