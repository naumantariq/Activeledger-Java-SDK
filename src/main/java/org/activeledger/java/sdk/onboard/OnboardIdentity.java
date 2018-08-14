package org.activeledger.java.sdk.onboard;

import java.security.KeyPair;

import org.activeledger.java.sdk.key.management.Encryption;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class OnboardIdentity {
	@Autowired
	private OnboardIdentityReq onboardIdentiy;
	ObjectMapper mapper;
	public OnboardIdentity()
	{
		mapper=new ObjectMapper();
	}
	
	public void onBoardIdentity(KeyPair keyPair,Encryption encrp)
    { 
    	OnboardTransaction	transaction =onboardIdentiy.onboard(keyPair,encrp);

		//Gson gson = new Gson();
		//String transactionJson = gson.toJson(transaction);
        //System.out.println("JSON:"+transactionJson);;
        try {
        	String transactionJson = mapper.writeValueAsString(transaction);
        	
        	HttpClient httpclient = HttpClients.createDefault();
        	HttpPost httppost = new HttpPost("http://testnet-eu.activeledger.io:5260");
        	//HttpPost httppost = new HttpPost("http://127.0.0.1:5260");
        	StringEntity entity=new StringEntity(transactionJson);
        	entity.setContentType("application/json");
        	httppost.setEntity(entity);
        	HttpResponse response = httpclient.execute(httppost);
        	HttpEntity resp = response.getEntity();

        	if (resp != null) {
        		String responseAsString = EntityUtils.toString(response.getEntity());
        	    System.out.println(responseAsString);
        	}

        }
        catch(Exception e)
        {
        	throw new IllegalArgumentException("Exception occurred while onboaring:"+e.getMessage());
        }
	
    }

}
