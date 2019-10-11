package chapter4.model;

public class Account {
    private Long id;
    private String name;
    private Double balance;

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public Account setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account[id=" + id +
                ", name=" +
                name +
                ", balance=" +
                balance + "]";
    }
}