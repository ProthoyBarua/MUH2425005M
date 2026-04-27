import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


class Person {
    private String id;
    private String name;
    private String phone;
    private String address;

    public Person(String id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
     }
    public String getName() {
         return name;
         }
    public String getPhone() {
         return phone;
        }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}


class Doctor extends Person {
    private String specialization;

    public Doctor(String id, String name, String phone, String address, String specialization) {
        super(id, name, phone, address);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Dr. " + getName() + " - " + specialization;
    }
}


class Patient extends Person {
    private String bloodGroup;
    private String medicalHistory;

    public Patient(String id, String name, String phone, String address, String bloodGroup) {
        super(id, name, phone, address);
        this.bloodGroup = bloodGroup;
        this.medicalHistory = "No history recorded.";
    }

    public String getBloodGroup() { return bloodGroup; }
    public String getMedicalHistory() { return medicalHistory; }

    public void updateMedicalHistory(String history) {
        this.medicalHistory = history;
    }
}


class Nurse extends Person {
    private String shift;

    public Nurse(String id, String name, String phone, String address, String shift) {
        super(id, name, phone, address);
        this.shift = shift;
    }

    public String getShift() {
        return shift; }

    @Override
    public String toString() {
        return "Nurse: " + getName() + " (" + shift + " shift)";
    }
}


class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String reason;

    public Appointment(String appointmentId, Patient patient, Doctor doctor,
                       LocalDateTime startTime, LocalDateTime endTime, String reason) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return "Appointment ID: " + appointmentId +
                "\nPatient: " + patient.getName() +
                "\nDoctor: " + doctor.getName() +
                "\nTime: " + startTime.format(formatter) + " to " + endTime.format(formatter) +
                "\nReason: " + reason;
    }
}


class Medicine {
    private String name;
    private String dosage;
    private int quantity;
    private double price;

    public Medicine(String name, String dosage, int quantity, double price) {
        this.name = name;
        this.dosage = dosage;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return name + " (" + dosage + ") - Qty: " + quantity + " | Total: $" + getTotalPrice();
    }
}


class Bill {
    private String billId;
    private Patient patient;
    private double consultationFee;
    private ArrayList<Medicine> medicines;
    private double totalAmount;

    public Bill(String billId, Patient patient, double consultationFee) {
        this.billId = billId;
        this.patient = patient;
        this.consultationFee = consultationFee;
        this.medicines = new ArrayList<>();
        this.totalAmount = consultationFee;
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
        totalAmount += medicine.getTotalPrice();
    }

    @Override
    public String toString() {

        String result = "=== HOSPITAL BILL ===\n";

        result += "Bill ID: " + billId + "\n";
        result += "Patient: " + patient.getName() + "\n";
        result += "Consultation Fee: $" + consultationFee + "\n";

        result += "Medicines:\n";

        for (int i = 0; i < medicines.size(); i++) {
            result += " - " + medicines.get(i) + "\n";
        }

        result += "Total Amount Payable: $" + totalAmount;

        return result;
    }
}


public class HospitalManagementSystem {

    public static void main(String[] args) {

        Doctor doctor = new Doctor("D001", "Fateha Jahan", "123-456-7890", "Hospital", "General");
        Patient patient = new Patient("P001", "Rahul", "098-765-4321", "Home", "O+");

        System.out.println("=== Hospital System ===\n");

        LocalDateTime start1 = LocalDateTime.of(2026, 5, 5, 10, 0);
        LocalDateTime end1 = LocalDateTime.of(2026, 5, 5, 11, 0);

        Appointment app1 = new Appointment("APP001", patient, doctor, start1, end1, "Checkup");
        System.out.println("Appointment 1 Booked");

        LocalDateTime start2 = LocalDateTime.of(2026, 5, 5, 10, 30);
        LocalDateTime end2 = LocalDateTime.of(2026, 5, 5, 11, 30);

        try {
            if (!(end2.isBefore(start1) || start2.isAfter(end1))) {
                throw new Exception("Doctor is busy! Cannot book appointment.");
            }

            Appointment app2 = new Appointment("APP002", patient, doctor, start2, end2, "Follow-up");
            System.out.println("Appointment 2 Booked");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Medicine m1 = new Medicine("Aspirin", "100mg", 10, 8.0);
        Medicine m2 = new Medicine("Paracetamol", "500mg", 5, 4.0);

        System.out.println("\nMedicines:");
        System.out.println(m1);
        System.out.println(m2);

        Bill bill = new Bill("B001", patient, 600.0);
        bill.addMedicine(m1);
        bill.addMedicine(m2);

        System.out.println("\n" + bill);

        patient.updateMedicalHistory("Mild hypertension");
        System.out.println("\nMedical History: " + patient.getMedicalHistory());
    }
}