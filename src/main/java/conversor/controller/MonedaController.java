package conversor.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import conversor.api.APIConversor;


public class MonedaController {
	
	public List<String> listar(){
		APIConversor genJSON = new APIConversor();
		genJSON.getAPIJSON();
		
		List<String> list = new ArrayList<String>();
		try {
			String content = new String(Files.readAllBytes(Paths.get("conversiones.json")));
			JSONObject conversionesJSON = new JSONObject(content);
			JSONObject headers = conversionesJSON.getJSONObject("data");
			for (String key : headers.keySet()) {
				list.add(key);
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public double convertir(String moneda, String resultado, Double cantidad) {
		
		double totalConversion;
		
		
		try {
			String content = new String(Files.readAllBytes(Paths.get("conversiones.json")));
			JSONObject conversionesJSON = new JSONObject(content);
			Double valConOrigen = conversionesJSON.getJSONObject("data").getDouble(moneda);
			Double valConFin = conversionesJSON.getJSONObject("data").getDouble(resultado);
			
			totalConversion = cantidad/valConOrigen*valConFin;
			
			return totalConversion;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
