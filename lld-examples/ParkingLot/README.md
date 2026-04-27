# Parking Lot LLD Example

This module implements a basic parking lot system using strategy patterns for:
- parking spot selection (`ParkingStrategy`)
- fee calculation (`ParkingFeeCalculator`)
- payment processing (`PaymentProcessor`)

All entities are currently implemented as `static` nested classes inside `Main`.

## UML Class Diagram

```mermaid
classDiagram
    class Main

    class ParkingLot {
      -int parkingLotId
      -List~ParkingFloor~ parkingFloors
      +addParkingFloor(ParkingFloor)
      +removeParkingFloor(ParkingFloor)
    }

    class ParkingFloor {
      -int floorId
      -List~ParkingSpot~ parkingSpots
      +addParkingSpot(ParkingSpot)
      +removeParkingSpot(ParkingSpot)
    }

    class ParkingSpot {
      -int spotId
      -parkingSpotType spotType
      -boolean isAvailable
      +parkVehicle()
      +freeSpot(boolean)
      +isAvailable() boolean
    }

    class Vehicle {
      -int vehicleId
      -vehicleType vehicleType
      -String licenseNumber
    }

    class Ticket {
      -String ticketId
      -ParkingSpot parkingSpot
      -Vehicle vehicle
      -LocalDateTime entryTime
      -LocalDateTime exitTime
      -Double feePaid
      -ParkingFeeCalculator parkingStrategy
      -PaymentProcessor paymentProcessor
      +setExitTime()
      +setFeePaid(Double)
      +setPaymentProcessor(PaymentProcessor)
    }

    class ParkingLotManager {
      -ParkingLot parkingLot
      -ParkingStrategy parkingStrategy
      -Map~String, Ticket~ ticketsMap
      +parkVehicle(Vehicle) Ticket
      +unparkVehicle(Ticket, PaymentProcessor)
    }

    class ParkingStrategy {
      <<interface>>
      +findAvailableSpot(ParkingLot, Vehicle) ParkingSpot
    }
    class FirstFitStrategy
    class BestFitStrategy

    class ParkingFeeCalculator {
      <<interface>>
      +calculateParkingFee(Ticket) Double
    }
    class smallVehicleParkingFeeCalculator
    class mediumVehicleParkingFeeCalculator
    class largeVehicleParkingFeeCalculator

    class PaymentProcessor {
      <<interface>>
      +processPayment(Ticket)
    }
    class CashPaymentProcessor
    class CreditCardPaymentProcessor
    class UPIPaymentProcessor

    class vehicleType {
      <<enum>>
      CAR
      BIKE
      TRUCK
      VAN
    }

    class parkingSpotType {
      <<enum>>
      SMALL
      MEDIUM
      LARGE
    }

    Main --> ParkingLotManager : creates
    Main --> ParkingLot : creates
    Main --> ParkingFloor : creates
    Main --> ParkingSpot : creates
    Main --> Vehicle : creates

    ParkingLot "1" o-- "*" ParkingFloor
    ParkingFloor "1" o-- "*" ParkingSpot
    ParkingLotManager --> ParkingLot
    ParkingLotManager --> ParkingStrategy
    ParkingLotManager --> Ticket : manages
    Ticket --> ParkingSpot
    Ticket --> Vehicle
    Ticket --> ParkingFeeCalculator
    Ticket --> PaymentProcessor

    ParkingStrategy <|.. FirstFitStrategy
    ParkingStrategy <|.. BestFitStrategy
    ParkingFeeCalculator <|.. smallVehicleParkingFeeCalculator
    ParkingFeeCalculator <|.. mediumVehicleParkingFeeCalculator
    ParkingFeeCalculator <|.. largeVehicleParkingFeeCalculator
    PaymentProcessor <|.. CashPaymentProcessor
    PaymentProcessor <|.. CreditCardPaymentProcessor
    PaymentProcessor <|.. UPIPaymentProcessor
```

## Entities and Responsibilities

- `ParkingLot`: top-level container for all parking floors.
- `ParkingFloor`: holds a collection of `ParkingSpot` objects.
- `ParkingSpot`: represents one physical spot with type and availability.
- `Vehicle`: holds vehicle identity and size category.
- `Ticket`: lifecycle object created on park; stores entry/exit timestamps, fee strategy, selected payment processor, and final fee.
- `ParkingLotManager`: orchestrates park/unpark operations and ticket map.

## Strategy Interfaces

- `ParkingStrategy`: decides which spot to allocate.
  - `FirstFitStrategy`: returns first matching available spot.
  - `BestFitStrategy`: returns smallest possible available spot that fits the vehicle.

- `ParkingFeeCalculator`: computes fee from ticket data.
  - `smallVehicleParkingFeeCalculator`
  - `mediumVehicleParkingFeeCalculator`
  - `largeVehicleParkingFeeCalculator`

- `PaymentProcessor`: processes payment before final unpark.
  - `CashPaymentProcessor`
  - `CreditCardPaymentProcessor`
  - `UPIPaymentProcessor`

## Enums

- `vehicleType`: includes size metadata used for spot fit checks.
- `parkingSpotType`: includes size metadata used for spot allocation and fee basis.

## Runtime Flow

1. `ParkingLotManager.parkVehicle(vehicle)`:
   - finds an available spot using `ParkingStrategy`
   - marks spot occupied
   - creates and stores a `Ticket` with the selected `ParkingFeeCalculator`

2. `ParkingLotManager.unparkVehicle(ticket, paymentProcessor)`:
   - sets ticket exit time
   - sets and executes payment processor
   - calculates and stores fee
   - prints ticket details
   - frees spot and removes ticket from active map

## How to Run

From this directory:

```bash
javac Main.java
java Main
```
