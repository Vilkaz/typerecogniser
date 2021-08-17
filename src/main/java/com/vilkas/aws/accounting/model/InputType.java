package com.vilkas.aws.accounting.model;

public enum InputType {
    CLIENTS("client_list"),
    PORTFOLIOS("portfolio_list"),
    ACCOUNTS("account_list"),
    TRANSACTIONS("transactions_list"),
    UNKNOWN("unknown_input_file_type");

    private String queueName;

    InputType(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueName() {
        return queueName;
    }
}
