package com.example.bayar.rxgetstarted;

public class Task {
    private String name;
    private int importance;

    public Task(String name, int importance) {
        this.name = name;
        this.importance = importance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
