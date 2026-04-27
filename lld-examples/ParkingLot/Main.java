//Parking Lot Application
// Functional Requirements:
// 1. Parking Lot should have multiple floors
// 2. Each floor should have multiple parking spots
// 3. Each parking spot should be able to park a vehicle
// 4. Each parking spot should be able to unpark a vehicle
// 5. Each parking spot should be able to check if it is available
// 6. Each parking spot should be able to check if it is occupied
// 7. Each parking spot should be able to check if it is full
// 8. Each parking spot should be able to check if it is empty
// 9. Generate invoice and calculate the parking fee

// Non-Functional Requirements:
// Scalable
// Extensible

// Core Entities:
// Parking Spot -> spot id, spotType, isAvailable, park, unpark
// Vehicle -> vehicle id, vehicleType, licenseNumber
// ParkingStrategy-> interface for different parking strategies
// FirstFitStrategy, BestFitStrategy
// Ticket -> ticket id, parkingSpotId, vehicleId, entryTime, exitTime, feePaid
// PaymentType -> interface for different payment types
// Cash, CreditCard, UPI 
// Floor -> floor id, parkingSpots
// ParkingLot -> parkingLot id, floors
// ParkingLotManager -> manage the parking lot

import java.time.LocalDateTime;
import java.util.*;
import java.time.Duration;

public class Main {

    //lets implemet the enums first
    static enum vehicleType {
        CAR(10),
        BIKE(5),
        TRUCK(20),
        VAN(15);

        private final int size;

        vehicleType(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

    static enum parkingSpotType {
        SMALL(10),
        MEDIUM(20),
        LARGE(30);

        private final int size;

        parkingSpotType(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

    //implement parking spot
    static class ParkingSpot {
        private final int spotId;
        private final parkingSpotType spotType;
        private boolean isAvailable;

        public ParkingSpot(int spotId, parkingSpotType spotType) {
            this.spotId = spotId;
            this.spotType = spotType;
            this.isAvailable = true;
        }

        public int getSpotId() {
            return spotId;
        }

        public parkingSpotType getSpotType() {
            return spotType;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void freeSpot(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }

        public void parkVehicle() {
            this.isAvailable = false;
        }
    }

    static class Vehicle {
        private final int vehicleId;
        private final vehicleType vehicleType;
        private final String licenseNumber;

        public Vehicle(int vehicleId, vehicleType vehicleType, String licenseNumber) {
            this.vehicleId = vehicleId;
            this.vehicleType = vehicleType;
            this.licenseNumber = licenseNumber;
        }

        public int getVehicleId() {
            return vehicleId;
        }

        public vehicleType getVehicleType() {
            return vehicleType;
        }

        public String getLicenseNumber() {
            return licenseNumber;
        }
    }

    static class Ticket {
        private final String ticketId;
        private final ParkingSpot parkingSpot;
        private final Vehicle vehicle;
        private final LocalDateTime entryTime;
        private LocalDateTime exitTime;
        private final ParkingFeeCalculator parkingStrategy;
        private PaymentProcessor paymentProcessor;
        
        private Double feePaid ;
        public Ticket(ParkingSpot parkingSpot, Vehicle vehicle, ParkingFeeCalculator parkingFeeCalculator) {
            this.ticketId = UUID.randomUUID().toString();
            this.parkingSpot = parkingSpot;
            this.vehicle = vehicle;
            this.entryTime = LocalDateTime.now();
            this.exitTime = null;
            this.feePaid = null;
            this.parkingStrategy = parkingFeeCalculator;
            this.paymentProcessor = null;
        }

        public String getTicketId() {
            return ticketId;
        }

        public ParkingSpot getParkingSpot() {
            return parkingSpot;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public void setExitTime() {
            if (this.exitTime == null) {
                this.exitTime = LocalDateTime.now();
            }
        }

        public Double setFeePaid(Double feePaid) {
            this.feePaid = feePaid;
            return feePaid;
        }

        public LocalDateTime getEntryTime() {
            return entryTime;
        }
        public LocalDateTime getExitTime() {
            return exitTime == null ? null : exitTime;
        }
        public Double getFeePaid() {
            return feePaid;
        }

        public ParkingFeeCalculator getParkingStrategy() {
            return parkingStrategy;
        }
        public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
            this.paymentProcessor = paymentProcessor;
        }
        public PaymentProcessor getPaymentProcessor() {
            return paymentProcessor;
        }
    }

    static class ParkingFloor {
        private final int floorId;
        private final List<ParkingSpot> parkingSpots;

        public ParkingFloor(int floorId) {
            this.floorId = floorId;
            this.parkingSpots = new ArrayList<>();
        }

        public int getFloorId() {
            return floorId;
        }

        public List<ParkingSpot> getParkingSpots() {
            return parkingSpots;
        }
        public void addParkingSpot(ParkingSpot parkingSpot) {
            this.parkingSpots.add(parkingSpot);
        }
        public void removeParkingSpot(ParkingSpot parkingSpot) {
            this.parkingSpots.remove(parkingSpot);
        }
    }

    static class ParkingLot {
        private final int parkingLotId;
        private final List<ParkingFloor> parkingFloors;

        public ParkingLot(int parkingLotId) {
            this.parkingLotId = parkingLotId;
            this.parkingFloors = new ArrayList<>();
        }

        public int getParkingLotId() {
            return parkingLotId;
        }

        public List<ParkingFloor> getParkingFloors() {
            return parkingFloors;
        }
        public void addParkingFloor(ParkingFloor parkingFloor) {
            this.parkingFloors.add(parkingFloor);
        }
        public void removeParkingFloor(ParkingFloor parkingFloor) {
            this.parkingFloors.remove(parkingFloor);
        }

    }
    
    interface ParkingFeeCalculator {
        Double calculateParkingFee(Ticket ticket);
    }

    static class smallVehicleParkingFeeCalculator implements ParkingFeeCalculator {
        @Override
        public Double calculateParkingFee(Ticket ticket) {
            long time = java.time.Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toMinutes();
       
            return ticket.getParkingSpot().getSpotType().getSize() *    10.0 * time;
        }
    }

    static class mediumVehicleParkingFeeCalculator implements ParkingFeeCalculator {
        @Override
        public Double calculateParkingFee(Ticket ticket) {
            long time = java.time.Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toMinutes();
            return ticket.getParkingSpot().getSpotType().getSize() *    20.0;
        }
    }

    static class largeVehicleParkingFeeCalculator implements ParkingFeeCalculator {
        @Override
        public Double calculateParkingFee(Ticket ticket) {
            long time = java.time.Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toMinutes();
            return ticket.getParkingSpot().getSpotType().getSize() *    30.0 * time;   
        }
    }

    interface ParkingStrategy {
        ParkingSpot findAvailableSpot(ParkingLot parkingLot, Vehicle vehicle);
    }

    static class FirstFitStrategy implements ParkingStrategy {
        @Override
        public ParkingSpot findAvailableSpot(ParkingLot parkingLot, Vehicle vehicle) {
            for (ParkingFloor floor : parkingLot.getParkingFloors()) {
                for (ParkingSpot spot : floor.getParkingSpots()) {
                    if (spot.isAvailable() && spot.getSpotType().getSize() >= vehicle.getVehicleType().getSize()) {
                        return spot;
                    }
                }
            }
            return null;
        }
    }
    interface PaymentProcessor {
        void processPayment(Ticket ticket);
    }
    static class CashPaymentProcessor implements PaymentProcessor {
        @Override
        public void processPayment(Ticket ticket) {
            System.out.println("Cash Payment processed successfully");
        }
    }
    static class CreditCardPaymentProcessor implements PaymentProcessor {
        @Override
        public void processPayment(Ticket ticket) {
            System.out.println("Credit Card Payment processed successfully");
        }
    }
    static class UPIPaymentProcessor implements PaymentProcessor {
        @Override
        public void processPayment(Ticket ticket) {
            System.out.println("UPI Payment processed successfully");
        }
    }
    static class BestFitStrategy implements ParkingStrategy {
        @Override
        public ParkingSpot findAvailableSpot(ParkingLot parkingLot, Vehicle vehicle) {
            ParkingSpot bestSpot = null;
            int bestSize = Integer.MAX_VALUE;
            for (ParkingFloor floor : parkingLot.getParkingFloors()) {
                for (ParkingSpot spot : floor.getParkingSpots()) {
                    if (spot.isAvailable() && spot.getSpotType().getSize() >= vehicle.getVehicleType().getSize()) {
                        if (spot.getSpotType().getSize() < bestSize) {
                            bestSize = spot.getSpotType().getSize();
                            bestSpot = spot;
                        }
                    }
                }
            }
            return bestSpot;
        }
    }

    static class ParkingLotManager {
        private final ParkingLot parkingLot;
        private final ParkingStrategy parkingStrategy;
        private final Map<String, Ticket> ticketsMap;
        public ParkingLotManager(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
            this.parkingLot = parkingLot;
            this.parkingStrategy = parkingStrategy;
            this.ticketsMap = new HashMap<>();
        }
        public Ticket parkVehicle(Vehicle vehicle) {
            ParkingSpot spot = parkingStrategy.findAvailableSpot(parkingLot, vehicle);
            if (spot != null) {
                spot.parkVehicle();
                Ticket ticket = new Ticket(spot, vehicle, getParkingFeeCalculator(spot.getSpotType()));
                ticketsMap.put(ticket.getTicketId(), ticket);
                System.out.println("Vehicle parked successfully");
                return ticket;
            } else {
                System.out.println("No available spot found for the given vehicle size");
                return null;
            }
        }

        private ParkingFeeCalculator getParkingFeeCalculator(parkingSpotType spotType) {
            if (spotType == parkingSpotType.SMALL) {
                return new smallVehicleParkingFeeCalculator();
            } else if (spotType == parkingSpotType.MEDIUM) {
                return new mediumVehicleParkingFeeCalculator();
            } else if (spotType == parkingSpotType.LARGE) {
                return new largeVehicleParkingFeeCalculator();
            } else {
                throw new IllegalArgumentException("Invalid parking spot type");
            }
        }

       static private void printTicket(Ticket ticket) {
           System.out.println("--------------------------------");
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("Parking Spot ID: " + ticket.getParkingSpot().getSpotId());
            System.out.println("Vehicle ID: " + ticket.getVehicle().getVehicleId());
            System.out.println("Entry Time: " + ticket.getEntryTime().toString());
            System.out.println("Exit Time: " + ticket.getExitTime().toString());
            System.out.println("Fee Paid: " + ticket.getFeePaid());
            System.out.println("Payment Type: " + ticket.getPaymentProcessor());
            System.out.println("--------------------------------");
        }
        static private void calculateParkingFee(Ticket ticket, PaymentProcessor paymentProcessor) { 
            ticket.setExitTime();
            ticket.setPaymentProcessor(paymentProcessor);
            paymentProcessor.processPayment(ticket);
            Double parkingFee = ticket.getParkingStrategy().calculateParkingFee(ticket);
            ticket.setFeePaid(parkingFee);
            printTicket(ticket);
        }

        public void unparkVehicle(Ticket ticket, PaymentProcessor paymentProcessor) {
            calculateParkingFee(ticket, paymentProcessor);
            ParkingSpot parkingSpot = ticket.getParkingSpot();
            ticketsMap.remove(ticket.getTicketId());
            parkingSpot.freeSpot(true);
            System.out.println("Vehicle unparked successfully");
        }
    }
    
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingFloor parkingFloor = new ParkingFloor(1);
        parkingFloor.addParkingSpot(new ParkingSpot(1, parkingSpotType.SMALL));
        parkingFloor.addParkingSpot(new ParkingSpot(2, parkingSpotType.SMALL));
        parkingFloor.addParkingSpot(new ParkingSpot(3, parkingSpotType.MEDIUM));
        parkingFloor.addParkingSpot(new ParkingSpot(4, parkingSpotType.MEDIUM));
        parkingFloor.addParkingSpot(new ParkingSpot(5, parkingSpotType.LARGE));
        parkingFloor.addParkingSpot(new ParkingSpot(6, parkingSpotType.LARGE));
        parkingLot.addParkingFloor(parkingFloor);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot, new FirstFitStrategy());
        // Add multiple spots to properly test parking behavior.
        Ticket ticket1 = parkingLotManager.parkVehicle(new Vehicle(1, vehicleType.CAR, "1234567890"));
        Ticket ticket2 = parkingLotManager.parkVehicle(new Vehicle(2, vehicleType.BIKE, "BIKE12345"));
        Ticket ticket3 = parkingLotManager.parkVehicle(new Vehicle(3, vehicleType.TRUCK, "TRUCK987654"));
        Ticket ticket4 = parkingLotManager.parkVehicle(new Vehicle(4, vehicleType.CAR, "CAR24680"));
        Ticket ticket5 = parkingLotManager.parkVehicle(new Vehicle(5, vehicleType.BIKE, "BIKE54321"));
        Ticket ticket6 = parkingLotManager.parkVehicle(new Vehicle(6, vehicleType.CAR, "CAR11223"));
        if (ticket1 != null) {
            parkingLotManager.unparkVehicle(ticket1, new CashPaymentProcessor());
        }
        if (ticket2 != null) {
            parkingLotManager.unparkVehicle(ticket2, new CreditCardPaymentProcessor());
        }
        if (ticket3 != null) {
        parkingLotManager.parkVehicle(new Vehicle(2, vehicleType.BIKE, "BIKE12345"));
            parkingLotManager.unparkVehicle(ticket3, new UPIPaymentProcessor());
        }
        if (ticket4 != null) {
            parkingLotManager.unparkVehicle(ticket4, new CashPaymentProcessor());
        }
        if (ticket5 != null) {
            parkingLotManager.unparkVehicle(ticket5, new CreditCardPaymentProcessor());
        }
        if (ticket6 != null) {
            parkingLotManager.unparkVehicle(ticket6, new UPIPaymentProcessor());
        }
    }
}
