package com.example.village.model;

public class Rule {
    private int rule_id;
    private int name;

    public int getRule_id() {
        return rule_id;
    }

    public void setRule_id(int rule_id) {
        this.rule_id = rule_id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "rule_id=" + rule_id +
                ", name=" + name +
                '}';
    }
}
