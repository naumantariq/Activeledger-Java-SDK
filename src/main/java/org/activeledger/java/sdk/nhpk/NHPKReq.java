package org.activeledger.java.sdk.nhpk;

import org.activeledger.java.sdk.connection.Connection;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
@Component("NHPKReq")
public class NHPKReq extends Connection {
	
	final static Logger logger = Logger.getLogger(NHPKReq.class);
	
	ObjectMapper mapper;

	public NHPKReq() {
		mapper = new ObjectMapper();
	}
	
	public String nhpkTransaction(NHPKTransaction nhpkTransaction)
	{
		 //System.out.println("JSON:"+transactionJson);;
		try {
        	
        	String contractUploadingJson = mapper.writeValueAsString(nhpkTransaction);
        	
        	HttpClient httpclient = HttpClients.createDefault();
        	HttpPost httppost = new HttpPost(getConnectionURL());
        	StringEntity entity=new StringEntity(contractUploadingJson);
        	entity.setContentType("application/json");
        	httppost.setEntity(entity);
        	HttpResponse response = httpclient.execute(httppost);

        	String responseAsString = EntityUtils.toString(response.getEntity());

        	return responseAsString;

        }
        catch(Exception e)
        {
        	logger.error("Exception occurred while sending transaction",e);
        	throw new IllegalArgumentException("Exception occurred while sending transaction"+e.getMessage());
        }
	}

	
	
}
