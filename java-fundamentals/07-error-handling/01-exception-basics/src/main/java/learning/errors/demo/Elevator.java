package learning.errors.demo;
// 🏢 Elevator System — LLD Breakdown
// 🔹 Core Requirements
// Functional
// Multiple elevators
// Handle external requests (Up/Down button on floors)
// Handle internal requests (floor selection inside elevator)
// Efficient scheduling (nearest elevator, direction-aware)
// Non-Functional
// Scalable (N elevators, M floors)
// Extensible (VIP priority, maintenance mode, etc.)
// Thread-safe (real systems are concurrent)

// CORE ENTITIES
// Elevator
// ElevatorController
// Request
// Button
import java.util.List;
import java.util.ArrayList;
enum CurrentDirection {
    UP,
    DOWN,
    IDLE
}
enum RequestType {
    UP,
    DOWN, 
    DESTINATION
}
interface Request {
    RequestType getRequestType();
    int getFloor();
}
class ExternalRequest implements Request {
    private int floor;
    private RequestType requestType;

    ExternalRequest(int floor, RequestType requestType) {
        this.floor = floor;
        this.requestType = requestType;
    }
    @Override
    public RequestType getRequestType() {
        return requestType;
    }
    @Override
    public int getFloor() {
        return floor;
    }
}

class InternalRequest implements Request {
    private int floor;
    private RequestType requestType;

    InternalRequest(int floor, RequestType requestType) {
        this.floor = floor;
        this.requestType = requestType;
    }
    @Override
    public RequestType getRequestType() {
        return requestType;
    }
    @Override
    public int getFloor() {
        return floor;
    }
}
class Elevator {
    private int currentFloor;
    private CurrentDirection currentDirection;
    private List<Request> requests;

    Elevator(int currentFloor, CurrentDirection currentDirection) {
        this.currentFloor = 0;
        this.currentDirection = CurrentDirection.IDLE;
        this.requests = new ArrayList<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void addRequest(Request request) {
        requests.add(request);
    }
    public CurrentDirection getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(CurrentDirection currentDirection) {
        this.currentDirection = currentDirection;
    }
    public void move() {
       while(!requests.isEmpty()) {
        Request request = requests.remove(0); 
        int requestFloor = request.getFloor();
        RequestType requestDirection = request.getRequestType();
        if(requestDirection == RequestType.UP) {
            currentDirection = CurrentDirection.UP;
        }
        else if(requestDirection == RequestType.DOWN){
            currentDirection = CurrentDirection.DOWN;
        }
    }
}
}

class ElevatorController {
   private List<Elevator> elevators;

   ElevatorController(int numberOfElevators) {
    for(int i = 0; i < numberOfElevators; i++) {
        elevators.add(new Elevator(0, CurrentDirection.IDLE));
    }
   }

   public void scheduleRequest(Request request) {
   
    //if any elevator idle, we assign that
    for(Elevator elevator : elevators) {
        if(elevator.getCurrentDirection() == CurrentDirection.IDLE) {
            elevator.addRequest(request);
            return;
        }
    }
    //if no elevator idle, we assign the request to the nearest elevator
    Elevator nearestElevator = null;
    int nearestDistance = Integer.MAX_VALUE;
    for(Elevator elevator : elevators) {
        int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
        if(distance < nearestDistance) {
            nearestDistance = distance;
            nearestElevator = elevator;
        }
    }
    if(nearestElevator != null) {
        nearestElevator.addRequest(request);

    }
    else {
        System.out.println("No elevator available");
    }
   }
}

class ElevatorSystem {
    public static void main(String[] args) {
        ElevatorController elevatorController = new ElevatorController(3);
        elevatorController.scheduleRequest(new ExternalRequest(5, RequestType.UP));
        elevatorController.scheduleRequest(new ExternalRequest(3, RequestType.DOWN));
        elevatorController.scheduleRequest(new ExternalRequest(1, RequestType.UP));
        elevatorController.scheduleRequest(new ExternalRequest(2, RequestType.DOWN));
        elevatorController.scheduleRequest(new ExternalRequest(4, RequestType.UP));
        elevatorController.scheduleRequest(new ExternalRequest(6, RequestType.DOWN));
        elevatorController.scheduleRequest(new ExternalRequest(7, RequestType.UP));
        elevatorController.scheduleRequest(new ExternalRequest(8, RequestType.DOWN));
        elevatorController.scheduleRequest(new InternalRequest(5, RequestType.UP));
        elevatorController.scheduleRequest(new InternalRequest(3, RequestType.DOWN));
        elevatorController.scheduleRequest(new InternalRequest(1, RequestType.UP));
        elevatorController.scheduleRequest(new InternalRequest(2, RequestType.DOWN));
        elevatorController.scheduleRequest(new InternalRequest(4, RequestType.UP));
        elevatorController.scheduleRequest(new InternalRequest(6, RequestType.DOWN));
        elevatorController.scheduleRequest(new InternalRequest(7, RequestType.UP));
        elevatorController.scheduleRequest(new InternalRequest(8, RequestType.DOWN));
        
    }
}
