package model.entities;

import model.exception.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	private static String regexUserName = "^[A-Za-z\\s]+$";

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		if (holder.matches(regexUserName) == false) {
			throw new DomainException("HOLDER: only letters are accepted...");
		}
		if (number < 0) {
			throw new DomainException("ACOUNT: Invalid account number...");
		}
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}

	public void withdraw(Double amount) {
		// o tratamento das excecoes de saque devem ser tratadas na classe Account
		if (amount > getWithdrawLimit()) {
			// instanciada uma nova DoimainException com a mensagem do erro
			throw new DomainException("WITHDRAW: The amount exceeds withdraw limit");
		}
		if (amount > getBalance()) {
			throw new DomainException("WITHDRAW: Not enough balance...");
		}
		// se nao houver excecoes o saque ocorrera normalmente
		this.balance -= amount;
	}
}