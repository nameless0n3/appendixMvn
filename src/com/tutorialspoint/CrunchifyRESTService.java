package com.tutorialspoint;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
 

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/CrunchifyRESTService")
public class CrunchifyRESTService {
	
	private static final Map<String, String> words = new HashMap<String, String>();
	/*static {
		words.put("I", "\"III\"");
		words.put("use", "\"useuse\"");
		words.put("this", "\"thisthis\"");
		words.put("method", "\"methodmethod\"");
		words.put("wrapper", "\"wrapperwrapper\"");
		words.put("that", "\"thatthat\"");	
		words.put("can", "\"cancan\"");
		words.put("send", "\"sendsend\"");
		words.put("parameters", "\"parametersparameters\"");	
		
	};*/
	
	static {
		words.put("I", "<img src='2.jpg'/>");
		words.put("equation2", "<img src='lenz-law.gif'/>");
		words.put("equation1", "<img src='faradays-law.gif'/>");
		words.put("B", "<img src='magnetic-flux-definition.gif'/>");
		words.put("EMF", "<img src='lenz-law.gif'/><a class='link ui-link' href='#d' data-rel='popup'>equation1</a>");		
		words.put("this", "thisthis");
		words.put("method", "methodmethod");
		words.put("wrapper", "wrapperwrapper");
		words.put("that", "thatthat");	
		words.put("can", "cancan");
		words.put("send", "sendsend");
		words.put("parameters", "parametersparameters");	
		
	};	
	
	

	@GET
	@Path("/crunchifyService")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces("text/html")
	@Produces({"text/html", "application/json"})
	public String crunchifyREST(@QueryParam("word") String word) {	

		String returnStr;
		System.out.println("-------------word:" +word);		
		
		if(words.containsKey(word)){
			returnStr = words.get(word);
		}else{
			returnStr ="none";
		}
		// return HTTP response 200 in case of success
		//return Response.status(200).entity(returnStr).build();
		return returnStr;
	}
 
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "CrunchifyRESTService Successfully started..";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
 
}
