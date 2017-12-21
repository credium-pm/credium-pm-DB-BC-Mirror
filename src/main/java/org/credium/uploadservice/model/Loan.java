package org.credium.uploadservice.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Loan {

	private Long userId;
	private Long applicationNumber;
	private String applicationDate;
	private String firstName;
	private String lastName;
	private String loanAmount;
	private Integer term;
	private String hasBaker;
	private String homeOwnerShip;
	private String annualIncome;
	private String loadPurpose;
	private String addressState;
	private String monthlyDebtObligation;
	private String debtToIncomeRatio;
	private Integer ficoScore;
	private Integer sixMonthIncome;
	private Integer publicRecords;
	private String revolvingBalance;
	private Integer totalAccounts;
	private BigDecimal employmentLength;
	private String revolvingAvailable;
	private String revolvingUtilization;
	private BigDecimal internalRiskScore;
	private String grade;
	private String interestRate;
	private String originationFee;
	private String apr;
	private String paymentAmount;
	private String dtiLoan;
	private String dateOfBirth;
	private BigDecimal age;
	private String loanStatus;
	private Integer periods;
	private String remainingPrincipal;
	private String asOfDate;
	private String latestTx;
	private String partnerId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public Long getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(final Long applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(final String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(final String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(final Integer term) {
		this.term = term;
	}

	public String getHasBaker() {
		return hasBaker;
	}

	public void setHasBaker(final String hasBaker) {
		this.hasBaker = hasBaker;
	}

	public String getHomeOwnerShip() {
		return homeOwnerShip;
	}

	public void setHomeOwnerShip(final String homeOwnerShip) {
		this.homeOwnerShip = homeOwnerShip;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(final String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getLoadPurpose() {
		return loadPurpose;
	}

	public void setLoadPurpose(final String loadPurpose) {
		this.loadPurpose = loadPurpose;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(final String addressState) {
		this.addressState = addressState;
	}

	public String getMonthlyDebtObligation() {
		return monthlyDebtObligation;
	}

	public void setMonthlyDebtObligation(final String monthlyDebtObligation) {
		this.monthlyDebtObligation = monthlyDebtObligation;
	}

	public String getDebtToIncomeRatio() {
		return debtToIncomeRatio;
	}

	public void setDebtToIncomeRatio(final String debtToIncomeRatio) {
		this.debtToIncomeRatio = debtToIncomeRatio;
	}

	public Integer getFicoScore() {
		return ficoScore;
	}

	public void setFicoScore(final Integer ficoScore) {
		this.ficoScore = ficoScore;
	}

	public Integer getSixMonthIncome() {
		return sixMonthIncome;
	}

	public void setSixMonthIncome(final Integer sixMonthIncome) {
		this.sixMonthIncome = sixMonthIncome;
	}

	public Integer getPublicRecords() {
		return publicRecords;
	}

	public void setPublicRecords(final Integer publicRecords) {
		this.publicRecords = publicRecords;
	}

	public String getRevolvingBalance() {
		return revolvingBalance;
	}

	public void setRevolvingBalance(final String revolvingBalance) {
		this.revolvingBalance = revolvingBalance;
	}

	public Integer getTotalAccounts() {
		return totalAccounts;
	}

	public void setTotalAccounts(final Integer totalAccounts) {
		this.totalAccounts = totalAccounts;
	}

	public BigDecimal getEmploymentLength() {
		return employmentLength;
	}

	public void setEmploymentLength(final BigDecimal employmentLength) {
		this.employmentLength = employmentLength;
	}

	public String getRevolvingAvailable() {
		return revolvingAvailable;
	}

	public void setRevolvingAvailable(final String revolvingAvailable) {
		this.revolvingAvailable = revolvingAvailable;
	}

	public String getRevolvingUtilization() {
		return revolvingUtilization;
	}

	public void setRevolvingUtilization(final String revolvingUtilization) {
		this.revolvingUtilization = revolvingUtilization;
	}

	public BigDecimal getInternalRiskScore() {
		return internalRiskScore;
	}

	public void setInternalRiskScore(final BigDecimal internalRiskScore) {
		this.internalRiskScore = internalRiskScore;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(final String grade) {
		this.grade = grade;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(final String interestRate) {
		this.interestRate = interestRate;
	}

	public String getOriginationFee() {
		return originationFee;
	}

	public void setOriginationFee(final String originationFee) {
		this.originationFee = originationFee;
	}

	public String getApr() {
		return apr;
	}

	public void setApr(final String apr) {
		this.apr = apr;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(final String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getDtiLoan() {
		return dtiLoan;
	}

	public void setDtiLoan(final String dtiLoan) {
		this.dtiLoan = dtiLoan;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(final String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BigDecimal getAge() {
		return age;
	}

	public void setAge(final BigDecimal age) {
		this.age = age;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(final String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public Integer getPeriods() {
		return periods;
	}

	public void setPeriods(final Integer periods) {
		this.periods = periods;
	}

	public String getRemainingPrincipal() {
		return remainingPrincipal;
	}

	public void setRemainingPrincipal(final String remainingPrincipal) {
		this.remainingPrincipal = remainingPrincipal;
	}

	public String getAsOfDate() {
		return asOfDate;
	}

	public void setAsOfDate(final String asOfDate) {
		this.asOfDate = asOfDate;
	}

	public String getLatestTx() {
		return latestTx;
	}

	public void setLatestTx(final String latestTx) {
		this.latestTx = latestTx;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(final String partnerId) {
		this.partnerId = partnerId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Loan loan = (Loan) o;
		return Objects.equals(userId, loan.userId) &&
						Objects.equals(applicationNumber, loan.applicationNumber) &&
						Objects.equals(applicationDate, loan.applicationDate) &&
						Objects.equals(firstName, loan.firstName) &&
						Objects.equals(lastName, loan.lastName) &&
						Objects.equals(loanAmount, loan.loanAmount) &&
						Objects.equals(term, loan.term) &&
						Objects.equals(hasBaker, loan.hasBaker) &&
						Objects.equals(homeOwnerShip, loan.homeOwnerShip) &&
						Objects.equals(annualIncome, loan.annualIncome) &&
						Objects.equals(loadPurpose, loan.loadPurpose) &&
						Objects.equals(addressState, loan.addressState) &&
						Objects.equals(monthlyDebtObligation, loan.monthlyDebtObligation) &&
						Objects.equals(debtToIncomeRatio, loan.debtToIncomeRatio) &&
						Objects.equals(ficoScore, loan.ficoScore) &&
						Objects.equals(sixMonthIncome, loan.sixMonthIncome) &&
						Objects.equals(publicRecords, loan.publicRecords) &&
						Objects.equals(revolvingBalance, loan.revolvingBalance) &&
						Objects.equals(totalAccounts, loan.totalAccounts) &&
						Objects.equals(employmentLength, loan.employmentLength) &&
						Objects.equals(revolvingAvailable, loan.revolvingAvailable) &&
						Objects.equals(revolvingUtilization, loan.revolvingUtilization) &&
						Objects.equals(internalRiskScore, loan.internalRiskScore) &&
						Objects.equals(grade, loan.grade) &&
						Objects.equals(interestRate, loan.interestRate) &&
						Objects.equals(originationFee, loan.originationFee) &&
						Objects.equals(apr, loan.apr) &&
						Objects.equals(paymentAmount, loan.paymentAmount) &&
						Objects.equals(dtiLoan, loan.dtiLoan) &&
						Objects.equals(dateOfBirth, loan.dateOfBirth) &&
						Objects.equals(age, loan.age) &&
						Objects.equals(loanStatus, loan.loanStatus) &&
						Objects.equals(periods, loan.periods) &&
						Objects.equals(remainingPrincipal, loan.remainingPrincipal) &&
						Objects.equals(asOfDate, loan.asOfDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, applicationNumber, applicationDate, firstName, lastName, loanAmount, term, hasBaker, homeOwnerShip, annualIncome, loadPurpose, addressState, monthlyDebtObligation, debtToIncomeRatio, ficoScore, sixMonthIncome, publicRecords, revolvingBalance, totalAccounts, employmentLength, revolvingAvailable, revolvingUtilization, internalRiskScore, grade, interestRate, originationFee, apr, paymentAmount, dtiLoan, dateOfBirth, age, loanStatus, periods, remainingPrincipal, asOfDate);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Loan{");
		sb.append("userId=").append(userId);
		sb.append(", applicationNumber=").append(applicationNumber);
		sb.append(", applicationDate='").append(applicationDate).append('\'');
		sb.append(", firstName='").append(firstName).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", loanAmount='").append(loanAmount).append('\'');
		sb.append(", term=").append(term);
		sb.append(", hasBaker='").append(hasBaker).append('\'');
		sb.append(", homeOwnerShip='").append(homeOwnerShip).append('\'');
		sb.append(", annualIncome='").append(annualIncome).append('\'');
		sb.append(", loadPurpose='").append(loadPurpose).append('\'');
		sb.append(", addressState='").append(addressState).append('\'');
		sb.append(", monthlyDebtObligation='").append(monthlyDebtObligation).append('\'');
		sb.append(", debtToIncomeRatio='").append(debtToIncomeRatio).append('\'');
		sb.append(", ficoScore=").append(ficoScore);
		sb.append(", sixMonthIncome=").append(sixMonthIncome);
		sb.append(", publicRecords=").append(publicRecords);
		sb.append(", revolvingBalance='").append(revolvingBalance).append('\'');
		sb.append(", totalAccounts=").append(totalAccounts);
		sb.append(", employmentLength=").append(employmentLength);
		sb.append(", revolvingAvailable='").append(revolvingAvailable).append('\'');
		sb.append(", revolvingUtilization='").append(revolvingUtilization).append('\'');
		sb.append(", internalRiskScore=").append(internalRiskScore);
		sb.append(", grade='").append(grade).append('\'');
		sb.append(", interestRate='").append(interestRate).append('\'');
		sb.append(", originationFee='").append(originationFee).append('\'');
		sb.append(", apr='").append(apr).append('\'');
		sb.append(", paymentAmount='").append(paymentAmount).append('\'');
		sb.append(", dtiLoan='").append(dtiLoan).append('\'');
		sb.append(", dateOfBirth='").append(dateOfBirth).append('\'');
		sb.append(", age=").append(age);
		sb.append(", loanStatus='").append(loanStatus).append('\'');
		sb.append(", periods=").append(periods);
		sb.append(", remainingPrincipal=").append(remainingPrincipal);
		sb.append(", asOfDate='").append(asOfDate).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
