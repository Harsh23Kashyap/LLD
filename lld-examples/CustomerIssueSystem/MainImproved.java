import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class MainImproved {

    enum IssueStatus {
        OPEN,
        IN_PROGRESS,
        RESOLVED,
        CLOSED
    }

    enum IssuePriority {
        LOW,
        MEDIUM,
        HIGH
    }

    static class IssueHistory {
        // Important fix: history is per issue (not static/global).
        private final List<String> messages = new ArrayList<>();

        void addMessage(String message) {
            messages.add(message);
        }

        List<String> getMessages() {
            return Collections.unmodifiableList(messages);
        }
    }

    static abstract class User {
        private final String id;
        private final String name;
        private final String email;

        User(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        String getId() {
            return id;
        }

        String getName() {
            return name;
        }

        String getEmail() {
            return email;
        }
    }

    static class Customer extends User {
        Customer(String id, String name, String email) {
            super(id, name, email);
        }
    }

    static class Agent extends User {
        private final List<Issue> assignedIssues = new ArrayList<>();

        Agent(String id, String name, String email) {
            super(id, name, email);
        }

        void assignIssue(Issue issue) {
            assignedIssues.add(issue);
        }

        void unassignIssue(Issue issue) {
            assignedIssues.remove(issue);
        }
    }

    static class Technician extends User {
        private final List<Issue> assignedIssues = new ArrayList<>();

        Technician(String id, String name, String email) {
            super(id, name, email);
        }

        void assignIssue(Issue issue) {
            assignedIssues.add(issue);
        }

        void unassignIssue(Issue issue) {
            assignedIssues.remove(issue);
        }

        int getAssignedIssueCount() {
            return assignedIssues.size();
        }
    }

    static class Issue {
        private final String id;
        private final String title;
        private final String description;
        private IssueStatus status;
        private IssuePriority priority;
        private final Customer customer;
        private final Agent agent;
        private Technician technician;
        private final IssueHistory history;

        private Issue(Builder builder) {
            this.id = builder.id;
            this.title = builder.title;
            this.description = builder.description;
            this.status = builder.status;
            this.priority = builder.priority;
            this.customer = builder.customer;
            this.agent = builder.agent;
            this.technician = null;
            this.history = new IssueHistory();
            this.history.addMessage("Issue created");
        }

        // Important fix: static builder with validation/defaults.
        static class Builder {
            private final String id = UUID.randomUUID().toString();
            private String title;
            private String description;
            private IssueStatus status = IssueStatus.OPEN;
            private IssuePriority priority = IssuePriority.MEDIUM;
            private Customer customer;
            private Agent agent;

            Builder title(String title) {
                this.title = title;
                return this;
            }

            Builder description(String description) {
                this.description = description;
                return this;
            }

            Builder status(IssueStatus status) {
                this.status = status;
                return this;
            }

            Builder priority(IssuePriority priority) {
                this.priority = priority;
                return this;
            }

            Builder customer(Customer customer) {
                this.customer = customer;
                return this;
            }

            Builder agent(Agent agent) {
                this.agent = agent;
                return this;
            }

            Issue build() {
                if (title == null || title.isBlank()) {
                    throw new IllegalStateException("title is required");
                }
                if (description == null || description.isBlank()) {
                    throw new IllegalStateException("description is required");
                }
                if (customer == null) {
                    throw new IllegalStateException("customer is required");
                }
                if (agent == null) {
                    throw new IllegalStateException("agent is required");
                }
                return new Issue(this);
            }
        }

        String getId() {
            return id;
        }

        String getTitle() {
            return title;
        }

        IssueStatus getStatus() {
            return status;
        }

        IssuePriority getPriority() {
            return priority;
        }

        Agent getAgent() {
            return agent;
        }

        Technician getTechnician() {
            return technician;
        }

        IssueHistory getHistory() {
            return history;
        }

        void setTechnician(Technician technician) {
            this.technician = technician;
            history.addMessage("Assigned technician: " + technician.getName());
        }

        void setStatus(IssueStatus status) {
            this.status = status;
            history.addMessage("Status changed to: " + status);
        }
    }

    interface AssignmentStrategy {
        Technician chooseTechnician(Issue issue, List<Technician> technicians);
    }

    static class RoundRobinAssignmentStrategy implements AssignmentStrategy {
        private int index = 0;

        @Override
        public Technician chooseTechnician(Issue issue, List<Technician> technicians) {
            if (technicians.isEmpty()) {
                throw new IllegalStateException("No technicians available");
            }
            Technician selected = technicians.get(index % technicians.size());
            index++;
            return selected;
        }
    }

    static class LeastBusyAssignmentStrategy implements AssignmentStrategy {
        @Override
        public Technician chooseTechnician(Issue issue, List<Technician> technicians) {
            if (technicians.isEmpty()) {
                throw new IllegalStateException("No technicians available");
            }
            Technician best = technicians.get(0);
            for (Technician t : technicians) {
                if (t.getAssignedIssueCount() < best.getAssignedIssueCount()) {
                    best = t;
                }
            }
            return best;
        }
    }

    static class PriorityAwareAssignmentStrategy implements AssignmentStrategy {
        @Override
        public Technician chooseTechnician(Issue issue, List<Technician> technicians) {
            // Important fix: deterministic priority handling (not random index by enum ordinal).
            return new LeastBusyAssignmentStrategy().chooseTechnician(issue, technicians);
        }
    }

    // Important fix: instance repositories (no static global state).
    static class IssueRepository {
        private final List<Issue> issues = new ArrayList<>();

        void add(Issue issue) {
            issues.add(issue);
        }

        List<Issue> getAll() {
            return Collections.unmodifiableList(issues);
        }
    }

    static class TechnicianRepository {
        private final List<Technician> technicians = new ArrayList<>();

        void add(Technician technician) {
            technicians.add(technician);
        }

        List<Technician> getAll() {
            return Collections.unmodifiableList(technicians);
        }
    }

    static class AgentRepository {
        private final List<Agent> agents = new ArrayList<>();

        void add(Agent agent) {
            agents.add(agent);
        }
    }

    static class CustomerRepository {
        private final List<Customer> customers = new ArrayList<>();

        void add(Customer customer) {
            customers.add(customer);
        }
    }

    static class IssueService {
        private final IssueRepository issueRepository;

        IssueService(IssueRepository issueRepository) {
            this.issueRepository = issueRepository;
        }

        Issue createIssue(String title, String description, IssuePriority priority, Customer customer, Agent agent) {
            Issue issue = new Issue.Builder()
                .title(title)
                .description(description)
                .priority(priority)
                .customer(customer)
                .agent(agent)
                .build();
            issueRepository.add(issue);
            return issue;
        }

        void resolveIssue(Issue issue) {
            if (issue.getStatus() == IssueStatus.RESOLVED) {
                throw new IllegalStateException("Issue already resolved");
            }
            issue.setStatus(IssueStatus.RESOLVED);

            Agent agent = issue.getAgent();
            if (agent != null) {
                agent.unassignIssue(issue);
            }
            Technician technician = issue.getTechnician();
            if (technician != null) {
                technician.unassignIssue(issue);
            }
        }
    }

    static class AssignmentService {
        private final TechnicianRepository technicianRepository;
        private AssignmentStrategy strategy;

        AssignmentService(TechnicianRepository technicianRepository, AssignmentStrategy strategy) {
            this.technicianRepository = technicianRepository;
            this.strategy = strategy;
        }

        void setStrategy(AssignmentStrategy strategy) {
            this.strategy = strategy;
        }

        void assign(Issue issue) {
            Technician technician = strategy.chooseTechnician(issue, technicianRepository.getAll());
            technician.assignIssue(issue);
            issue.setTechnician(technician); // Important fix: Issue owns assignment state.
            issue.getAgent().assignIssue(issue);
        }
    }

    public static void main(String[] args) {
        IssueRepository issueRepo = new IssueRepository();
        TechnicianRepository technicianRepo = new TechnicianRepository();
        AgentRepository agentRepo = new AgentRepository();
        CustomerRepository customerRepo = new CustomerRepository();

        IssueService issueService = new IssueService(issueRepo);
        AssignmentService assignmentService =
            new AssignmentService(technicianRepo, new RoundRobinAssignmentStrategy());

        Agent agent = new Agent("A-1", "John", "john@example.com");
        Customer customer = new Customer("C-1", "Sam", "sam@example.com");
        agentRepo.add(agent);
        customerRepo.add(customer);

        technicianRepo.add(new Technician("T-1", "Alice", "alice@example.com"));
        technicianRepo.add(new Technician("T-2", "Bob", "bob@example.com"));

        Issue issue = issueService.createIssue(
            "Login Failure",
            "User cannot log in with valid credentials",
            IssuePriority.HIGH,
            customer,
            agent
        );

        assignmentService.assign(issue);
        issueService.resolveIssue(issue);

        System.out.println("Issue ID: " + issue.getId());
        System.out.println("Title: " + issue.getTitle());
        System.out.println("Status: " + issue.getStatus());
        System.out.println("Assigned Technician: " +
            (issue.getTechnician() == null ? "None" : issue.getTechnician().getName()));
        System.out.println("History:");
        for (String msg : issue.getHistory().getMessages()) {
            System.out.println("- " + msg);
        }
    }
}
