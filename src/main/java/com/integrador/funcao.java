package com.integrador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONObject;

public class funcao {

	public static funcao INSTANCE = new funcao();

	public static funcao getInstance() {
		if (INSTANCE == null) {
			setInstance(new funcao());
		}

		return INSTANCE;
	}
	
	public static void setInstance(funcao instance) {
		INSTANCE = instance;
	}

	
	 public String getHttpGET(String urlToRead) {
	        StringBuilder result = new StringBuilder();

	        try {
	            URL url = new URL(urlToRead);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");

	            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = rd.readLine()) != null) {
	                result.append(line);
	            }
	            
	        } catch (MalformedURLException | ProtocolException ex) {
	            // verifica os Eventos
	            
	        } catch (IOException ex) {
	            // verifica os Eventos
	            
	        }
	        
	        return result.toString();
	 }

	 public JSONObject buscaCep (String cep) {
			
		if(cep.isEmpty() || cep == null) {
			return null;
		}
		
		String url = "http://viacep.com.br/ws/" + cep + "/json/";

		String retorno = funcao.getInstance().getHttpGET(url);
		
		if(!retorno.isEmpty() && retorno != null) {		
	        JSONObject jsonCep = new JSONObject(retorno);
	        
	        return jsonCep;
		}else {
			return null;
		}
		
	}

	
}
