package org.credium.uploadservice.event;

import org.credium.uploadservice.model.Action;
import org.credium.uploadservice.model.Loan;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DbEvent implements Serializable {

	private Date timestamp;
	private String partnerId;
	private Long userId;
	private String applicationId;
	private String actionType;
	private String txHash;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(final Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(final String partnerId) {
		this.partnerId = partnerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(final String applicationId) {
		this.applicationId = applicationId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(final String actionType) {
		this.actionType = actionType;
	}

	public String getTxHash() {
		return txHash;
	}

	public void setTxHash(final String txHash) {
		this.txHash = txHash;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final DbEvent dbEvent = (DbEvent) o;
		return Objects.equals(timestamp, dbEvent.timestamp) &&
						Objects.equals(partnerId, dbEvent.partnerId) &&
						Objects.equals(userId, dbEvent.userId) &&
						Objects.equals(applicationId, dbEvent.applicationId) &&
						Objects.equals(actionType, dbEvent.actionType) &&
						Objects.equals(txHash, dbEvent.txHash);
	}

	@Override
	public int hashCode() {
		return Objects.hash(timestamp, partnerId, userId, applicationId, actionType, txHash);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DbEvent{");
		sb.append("timestamp=").append(timestamp);
		sb.append(", partnerId='").append(partnerId).append('\'');
		sb.append(", userId=").append(userId);
		sb.append(", applicationId='").append(applicationId).append('\'');
		sb.append(", actionType='").append(actionType).append('\'');
		sb.append(", txHash='").append(txHash).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public static DbEvent createDbEvent(final String transactionHash, final Action action, final Loan loan, final String source) {
		final DbEvent dbEvent = new DbEvent();
		dbEvent.setActionType(action.name());
		dbEvent.setApplicationId(String.valueOf(loan.getApplicationNumber()));
		dbEvent.setPartnerId(source.toUpperCase());
		dbEvent.setTimestamp(new Date());
		dbEvent.setTxHash(transactionHash);
		dbEvent.setUserId(loan.getUserId());
		return dbEvent;
	}
}
