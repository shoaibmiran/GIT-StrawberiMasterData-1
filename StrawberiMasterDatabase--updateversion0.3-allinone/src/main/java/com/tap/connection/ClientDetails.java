package com.tap.connection;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tap.model.Item2;

public class ClientDetails {
	Item2 item2=new Item2();
	Client client = ClientBuilder.newClient();
	WebTarget webTarget  = client.target("http://13.232.237.47:8000/api");
	WebTarget itemWebTarget = webTarget.path("resources/Item");
	Invocation.Builder invocationBuilder = itemWebTarget.request(MediaType.APPLICATION_JSON);
	Response response = invocationBuilder.post(Entity.entity(item2, MediaType.APPLICATION_JSON));
	
	
}
