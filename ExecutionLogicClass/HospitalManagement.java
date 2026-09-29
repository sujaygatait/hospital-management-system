package ExecutionLogicClass;

import BusinessLogicClass.Appointment;
import BusinessLogicClass.Doctor;
import BusinessLogicClass.Patient;

import java.util.Scanner;
import java.util.ArrayList;

public class HospitalManagement {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println();
            
            switch(choice) {
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    addDoctor(sc);
                    break;
                case 3:
                    scheduleAppointment(sc);
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while(choice != 0);

        sc.close();
    }

    private static void addPatient(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Patient Gender: ");
        String gender = sc.next();

        Patient p = new Patient(name, age, gender);
        patients.add(p);
        System.out.println("Patient added successfully.");
        System.out.println();
    }
    
    private static void addDoctor(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Doctor Speciality: ");
        String speciality = sc.nextLine();
        Doctor d = new Doctor(name, speciality);
        doctors.add(d);
        System.out.println("Doctor added successfully.");
        System.out.println();
    }

    private static void scheduleAppointment(Scanner sc) {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        System.out.print("Enter doctor ID: ");
        int doctorId = sc.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = sc.next();

        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if(patient != null && doctor != null) {
            Appointment a = new Appointment(patient, doctor, date);
            appointments.add(a);
            System.out.println("Appointment scheduled successfully.");
        }
        else {
            System.out.println("Invalid patient ID or Doctor ID.");
        }
        System.out.println();
    }

    private static void viewPatients() {
        System.out.println("List of Patients:");
        for(Patient p : patients) {
            System.out.println(p);
        }
        System.out.println();
    }
    private static void viewDoctors() {
        System.out.println("List of Doctors:");
        for(Doctor d : doctors) {
            System.out.println(d);
        }
        System.out.println();
    }
    private static void viewAppointments() {
        System.out.println("List of Appointments:");
        for(Appointment a : appointments) {
            System.out.println(a);
        }
        System.out.println();
    }

    private static Patient findPatientById(int id) {
        for(Patient p : patients) {
            if(p.getId() == id) return p;
        }

        return null;
    }
    private static Doctor findDoctorById(int id) {
        for(Doctor d : doctors) {
            if(d.getId() == id) return d;
        }

        return null;
    }
}