package org.activeledger.java.sdk.generic.transaction;

import java.security.KeyPair;
import java.util.Map;

import org.activeledger.java.sdk.key.management.Encryption;

public class TransactionModel {

	private TxObjectModel txObject;
	private boolean selfSign;
	private Map<String, Object> signature;
	private KeyPair keyPair;
	private Encryption encrp;

	public TxObjectModel getTxObject() {
		return txObject;
	}

	public void setTxObject(TxObjectModel txObject) {
		this.txObject = txObject;
	}

	public boolean isSelfSign() {
		return selfSign;
	}

	public void setSelfSign(boolean selfSign) {
		this.selfSign = selfSign;
	}

	public Map<String, Object> getSignature() {
		return signature;
	}

	public void setSignature(Map<String, Object> signature) {
		this.signature = signature;
	}

	public KeyPair getKeyPair() {
		return keyPair;
	}

	public void setKeyPair(KeyPair keyPair) {
		this.keyPair = keyPair;
	}

	public Encryption getEncrp() {
		return encrp;
	}

	public void setEncrp(Encryption encrp) {
		this.encrp = encrp;
	}

}
