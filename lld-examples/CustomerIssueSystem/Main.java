// Customer Issue System Application
// Functional Requirements:
// 1. Customer can create an issue
// 2. Customer can view their issues
// 3. Agents can view the issue history
// 4. Agents can update the issue status
// 5. Agents can assign an issue to a technician
// 6. Agents can view all technicians
// 7. Agents can update a technician
// 8. Agents can delete a technician

// Non-Functional Requirements:
// 1. Scalable
// 2. Extensible
// 3. Maintainable


//Core Entities:
// IssueStatus -> enum -> OPEN, IN_PROGRESS, CLOSED, RESOLVED
// IssuePriority -> enum -> LOW, MEDIUM, HIGH
// abstract User -> user id, user name, user email
// Customer -> extends User -> customer id, customer name, customer email,
// Agent -> extends User -> agent id, agent name, agent email, +viewIssueHistory(Issue), List<Issue> assignedIssues, +updateIssueStatus(Issue), +assignIssueToTechnician(Issue), +viewAllTechnicians()
// Technician -> extends User -> technician id, technician name, technician email, list<Issue> assignedIssues, +viewIssueHistory(Issue), +updateIssueStatus(Issue), 
//
// TehnicianRepo -> addTechnician(Technician), removeTechnician(Technician), getTechnician(TechnicianId), getAllTechnicians(), List<Technician> technicians
// Issue -> id, title, description, status, createdAt, updatedAt, customerId, agentId, technicianId, IssueHistory,priority,status,
// IssueHistory -> id, message, createdAt, updatedAt, technicianId
// IssueRepo -> addIssue(Issue), removeIssue(Issue), getIssue(IssueId), getAllIssues(), List<Issue> issues

// CustomerRepo -> addCustomer(Customer), removeCustomer(Customer), getCustomer(CustomerId), getAllCustomers(), List<Customer> customers
// AgentRepo -> addAgent(Agent), removeAgent(Agent), getAgent(AgentId), getAllAgents(), List<Agent> agents

// AssignmentIssue inteface -> assignIssueToTechnician(Issue)
// RoundRobinAssignmentStrategy -> assignIssueToTechnician(Issue)
// LeastBusyTechnicianStrategy -> assignIssueToTechnician(Issue)
// PriorityAssignmentStrategy -> assignIssueToTechnician(Issue) -> based on the priority of the issue




import java.util.*;
public class Main {

    enum IssueStatus {
        OPEN,
        IN_PROGRESS,
        CLOSED,
        RESOLVED
    }
    enum IssuePriority {
        LOW(1),MEDIUM(2),HIGH(3);
        private final int priority;
        IssuePriority(int priority) {
            this.priority = priority;
        }
        public int getPriority() {
            return priority;
        }
    }
    static class Issue {
        private final String id;
        private final String title;
        private final String description;
        private  IssueStatus status;
        private  IssuePriority priority;
        private final Customer customer;
        private final Agent agent;
        private Technician technician;
        private IssueHistory issueHistory;
        private Issue(Builder builder) {
            this.id = builder.id;
            this.title = builder.title;
            this.description = builder.description;
            this.status = builder.status;
            this.priority = builder.priority;
            this.customer = builder.customer;
            this.agent = builder.agent;
            this.technician =null;
        }
        public static class Builder {
            private String id;
            private String title;
            private String description;
            private IssueStatus status;
            private IssuePriority priority;
            private String customerId;
            private Agent agent;
            private Customer customer;
            public Builder() {
                this.id = UUID.randomUUID().toString();
            }
            public Builder title(String title) {
                this.title = title;
                return this;
            }
            public Builder description(String description) {
                this.description = description;
                return this;
            }
            public Builder status(IssueStatus status) {
                this.status = status;
                return this;
            }
            public Builder priority(IssuePriority priority) {
                this.priority = priority;
                return this;
            }
            public Builder customer(Customer customer) {
                this.customer = customer;
                return this;
            }
            public Builder agent(Agent agent) {
                this.agent = agent;
                return this;
            }
            public Issue build() {
                return new Issue(this);
            }
        }
        public String getId() {
            return id;
        }
        public String getTitle() {
            return title;
        }
        public String getDescription() {
            return description;
        }
        public IssueStatus getStatus() {
            return status;
        }
        public IssuePriority getPriority() {
            return priority;
        }
        public Customer getCustomer() {
            return customer;
        }
        public Agent getAgent() {
            return agent;
        }
        public Technician getTechnician() {
            return technician;
        }
        public void setTechnician(Technician technician) {
            this.technician = technician;
        }
        public void setStatus(IssueStatus status) {
            this.status = status;
        }
        public void setPriority(IssuePriority priority) {
            this.priority = priority;
        }
        public void addIssueHistory(String message) {
            issueHistory.addMessage(message);
        }
        public IssueHistory getIssueHistory() {
            return issueHistory;
        }
    }

    abstract static class User {
        private final String id;
        private final String name;
        private final String email;
        public User(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
        public String getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
    }

    static class Customer extends User {
        public Customer(String id, String name, String email) {
            super(id, name, email);
        }
    }
    static class Agent extends User {
        private  List<Issue> assignedIssues;
        private  Map<Issue, Technician> assignedTechnicians;
        public Agent(String id, String name, String email) {
            super(id, name, email);
            this.assignedIssues = new ArrayList<>();
            this.assignedTechnicians = new HashMap<>();
        }

        public void assignIssueToTechnician(Issue issue,AssignmentIssue assignmentIssueStrategy) {
            Technician technician = assignmentIssueStrategy.assignIssueToTechnician(issue);
            assignedTechnicians.put(issue, technician);
            assignedIssues.add(issue);
        }
        public List<Issue> getAssignedIssues() {
            return assignedIssues;
        }
        public Map<Issue, Technician> getAssignedTechnicians() {
            return assignedTechnicians;
        }
    }
    static class Technician extends User {
        private  List<Issue> assignedIssues;
        public Technician(String id, String name, String email) {
            super(id, name, email);
            this.assignedIssues = new ArrayList<>();
        }
        public void assignIssue(Issue issue) {
            assignedIssues.add(issue);
        }
        public int getAssignedIssuesSize() {
            return assignedIssues.size();
        }
        public List<Issue> getAssignedIssues() {
            return assignedIssues;
        }
    }

    static class TechnicianRepo {
        private static final List<Technician> technicians = new ArrayList<>();

        public static void addTechnician(Technician technician) {
            technicians.add(technician);
        }

        public static Technician getTechnician(int index) {
            if (technicians.isEmpty()) {
                throw new IllegalStateException("No technicians available");
            }
            return technicians.get(index % technicians.size());
        }

        public static int getTechniciansSize() {
            return technicians.size();
        }

        public static Technician getLeastBusyTechnician() {
            if (technicians.isEmpty()) {
                throw new IllegalStateException("No technicians available");
            }
            Technician leastBusy = technicians.get(0);
            for (Technician technician : technicians) {
                if (technician.getAssignedIssuesSize() < leastBusy.getAssignedIssuesSize()) {
                    leastBusy = technician;
                }
            }
            return leastBusy;
        }
        public static List<Technician> getTechnicians() {
            return technicians;
        }
    }

    interface AssignmentIssue {
        public Technician assignIssueToTechnician(Issue issue);
    }

    static class RoundRobinAssignmentStrategy implements AssignmentIssue {
        private int currentIndex;
        public RoundRobinAssignmentStrategy() {
            this.currentIndex = 0;
        }

        public Technician assignIssueToTechnician(Issue issue) {
            // assign the issue to the next technician in the list
            Technician technician = TechnicianRepo.getTechnician(currentIndex%TechnicianRepo.getTechniciansSize());
            technician.assignIssue(issue);
            currentIndex++;
            return technician;
        }
    }
    static class LeastBusyTechnicianStrategy implements AssignmentIssue {
        

        public Technician assignIssueToTechnician(Issue issue) {
            // assign the issue to the least busy technician
            Technician leastBusyTechnician = TechnicianRepo.getLeastBusyTechnician();
            leastBusyTechnician.assignIssue(issue);
            return leastBusyTechnician;
        }
    }
    static class PriorityAssignmentStrategy implements AssignmentIssue { 
        public  Technician assignIssueToTechnician(Issue issue) {
            // assign the issue to the least busy technician
            Technician leastBusyTechnician = TechnicianRepo.getTechnician(issue.getPriority().getPriority());
            leastBusyTechnician.assignIssue(issue);
            return leastBusyTechnician;
        }
    }
    static class IssueRepo {
        private static final List<Issue> issues = new ArrayList<>();
        public static void addIssue(Issue issue) {
            issues.add(issue);
        }
        public static List<Issue> getIssues() {
            return issues;
        }
    }
    static class CustomerRepo {
        private static final List<Customer> customers = new ArrayList<>();
        public static void addCustomer(Customer customer) {
            customers.add(customer);
        }
        public static List<Customer> getCustomers() {
            return customers;
        }
    }
    static class AgentRepo {
        private static final List<Agent> agents = new ArrayList<>();
        public static void addAgent(Agent agent) {
            agents.add(agent);
        }
        public static List<Agent> getAgents() {
            return agents;
        }
    }
    static class IssueHistory {
        private static final List<String> messages = new ArrayList<>();
        public static void addMessage(String message) {
            messages.add(message);
        }
        public static List<String> getMessages() {
            return messages;
        }

    }   

    static class Orchestrator {
        AssignmentIssue assignmentIssueStrategy;
        IssueRepo issueRepo;
        CustomerRepo customerRepo;
        AgentRepo agentRepo;
        TechnicianRepo technicianRepo;
        public Orchestrator(AssignmentIssue assignmentIssueStrategy, IssueRepo issueRepo, CustomerRepo customerRepo, AgentRepo agentRepo, TechnicianRepo technicianRepo, IssueHistory issueHistory) {
            this.assignmentIssueStrategy = assignmentIssueStrategy;
            this.issueRepo = issueRepo;
            this.customerRepo = customerRepo;
            this.agentRepo = agentRepo;
            this.technicianRepo = technicianRepo;
        }

        public void createIssue(Customer customer, String title, String description, Agent agent) {
            Issue issue = new Issue.Builder()
                .title(title)
                .description(description)
                .customer(customer)
                .agent(agent)
                .build();
            issueRepo.addIssue(issue);
        } 
        public void assignIssueToAgent(Issue issue, Agent agent) {
            agent.assignIssueToTechnician(issue, assignmentIssueStrategy);
        }

        public void resolveIssue(Issue issue) {
            if (issue.getStatus() == IssueStatus.RESOLVED) {
                throw new IllegalStateException("Issue already resolved");
            }
            
            issue.setStatus(IssueStatus.RESOLVED);
            Agent agent = issue.getAgent();
            agent.getAssignedIssues().remove(issue);
            agent.getAssignedTechnicians().remove(issue);
            Technician technician = issue.getTechnician();
            if (technician != null) {
                technician.getAssignedIssues().remove(issue);
            }
            System.out.println("Issue resolved successfully");
            System.out.println("Issue title: " + issue.getTitle());
            System.out.println("Issue description: " + issue.getDescription());
            System.out.println("Issue status: " + issue.getStatus());
            System.out.println("Issue priority: " + issue.getPriority());
            System.out.println("Issue customer: " + issue.getCustomer().getName());
            System.out.println("Issue agent: " + issue.getAgent().getName());
            if (issue.getTechnician() != null) {
                System.out.println("Issue technician: " + issue.getTechnician().getName());
            } else {
                System.out.println("Issue technician: Not assigned");
            }
        }
        public void viewIssueHistory(Issue issue) {
            for (String issueHistory : issue.getIssueHistory().getMessages()) {
                System.out.println(issueHistory);
            }
        }
        public List<Issue> getIssues() {
            return issueRepo.getIssues();
        }

        public void viewAllIssues() {
            for (Issue issue : issueRepo.getIssues()) {
                System.out.println(issue.getTitle());
            }
        }
        public void viewAllAgents() {
            for (Agent agent : agentRepo.getAgents()) {
                System.out.println(agent.getName());
            }
        }
        public void viewAllTechnicians() {
            for (Technician technician : technicianRepo.getTechnicians()) {
                System.out.println(technician.getName());
            }
        }
        public void addAgent(Agent agent) {
            agentRepo.addAgent(agent);
        }
        public void addTechnician(Technician technician) {
            technicianRepo.addTechnician(technician);
        }
        public void addCustomer(Customer customer) {
            customerRepo.addCustomer(customer);
        }

    }

    public static void main(String[] args) {
        Orchestrator orchestrator = new Orchestrator(new RoundRobinAssignmentStrategy(), new IssueRepo(), new CustomerRepo(), new AgentRepo(), new TechnicianRepo(), new IssueHistory());
        orchestrator.addAgent(new Agent("1", "John Doe", "john.doe@example.com"));
        orchestrator.addTechnician(new Technician("2", "Alice Smith", "alice.smith@example.com"));
        orchestrator.addTechnician(new Technician("3", "Bob Johnson", "bob.johnson@example.com"));
        orchestrator.addTechnician(new Technician("4", "Charlie Brown", "charlie.brown@example.com"));
        orchestrator.addTechnician(new Technician("5", "Diana King", "diana.king@example.com"));
        orchestrator.addTechnician(new Technician("6", "Evan Lee", "evan.lee@example.com"));
        orchestrator.addTechnician(new Technician("7", "Fiona White", "fiona.white@example.com"));
        orchestrator.addTechnician(new Technician("8", "George Clark", "george.clark@example.com"));
        orchestrator.addTechnician(new Technician("9", "Helen Young", "helen.young@example.com"));
        orchestrator.addTechnician(new Technician("10", "Ivan Walker", "ivan.walker@example.com"));
        orchestrator.addCustomer(new Customer("2", "Sam Wilson", "sam.wilson@example.com"));
        orchestrator.createIssue(new Customer("2", "Sam Wilson", "sam.wilson@example.com"), "Login Failure", "User unable to login with valid credentials.", new Agent("1", "John Doe", "john.doe@example.com"));
   
        orchestrator.assignIssueToAgent(orchestrator.getIssues().get(0), new Agent("1", "John Doe", "john.doe@example.com"));
        
        orchestrator.resolveIssue(orchestrator.getIssues().get(0));
        orchestrator.viewIssueHistory(orchestrator.getIssues().get(0));
        orchestrator.viewAllIssues();
        orchestrator.viewAllAgents();
        orchestrator.viewAllTechnicians();
        orchestrator.viewIssueHistory(orchestrator.getIssues().get(0));
        orchestrator.viewAllIssues();
        orchestrator.viewAllAgents();
        orchestrator.viewAllTechnicians();
        orchestrator.viewIssueHistory(orchestrator.getIssues().get(0));
        orchestrator.viewAllIssues();
        orchestrator.viewAllAgents();
        orchestrator.viewAllTechnicians();
        orchestrator.viewIssueHistory(orchestrator.getIssues().get(0));
    }
}
