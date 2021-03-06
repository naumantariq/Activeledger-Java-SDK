package org.activeledger.java.sdk.nhpk;

import java.util.Map;

import org.activeledger.java.sdk.key.management.Encryption;

public class NHPKModel {

	private String namespace;
	private String contract;
	private String Identity;
	private String publicKey;
	private boolean selfSign;
	private Encryption encrp;
	private Map<String, String> signature;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getIdentity() {
		return Identity;
	}

	public void setIdentity(String identity) {
		Identity = identity;
	}

	public Encryption getEncrp() {
		return encrp;
	}

	public void setEncrp(Encryption encrp) {
		this.encrp = encrp;
	}

	public Map<String, String> getSignature() {
		return signature;
	}

	public void setSignature(Map<String, String> signature) {
		this.signature = signature;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public boolean isSelfSign() {
		return selfSign;
	}

	public void setSelfSign(boolean selfSign) {
		this.selfSign = selfSign;
	}

}
