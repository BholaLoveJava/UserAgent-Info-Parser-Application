package com.sapient.web.application.model;

public class UserAgentRequest {

	private String userAgent;

	public UserAgentRequest() {
		super();
	}

	public UserAgentRequest(String userAgent) {
		super();
		this.userAgent = userAgent;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userAgent == null) ? 0 : userAgent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAgentRequest other = (UserAgentRequest) obj;
		if (userAgent == null) {
			if (other.userAgent != null)
				return false;
		} else if (!userAgent.equals(other.userAgent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserAgentRequest [userAgent=" + userAgent + "]";
	}

}