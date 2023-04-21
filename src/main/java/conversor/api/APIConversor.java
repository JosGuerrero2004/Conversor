package conversor.api;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConversor {
		
		public void getAPIJSON() {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://api.freecurrencyapi.com/v1/latest?apikey=2TGEJXQfHJO84wB9bqkbfGUVp7e9cN1wOO1SCrUO"))
					.build();
			HttpResponse<String> response;
			
			try {
				FileWriter conversiones = new FileWriter("conversiones.json");
				response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
				conversiones.write(response.body());
				conversiones.close();
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		//TODO
		/*private void GenJSON(String monedas) {
			
			
			try {
				FileWriter conversiones = new FileWriter("conversiones.json");
				String datosJSON = removeLastChar(monedas);
				String ConversionTemperaturas = "";
				datosJSON += "";
				
				conversiones.write(datosJSON);
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
		
		public static String removeLastChar(String str) {
	        if (str == null || str.length() == 0) {
	            return str;
	        }
	        return str.substring(0, str.length() - 1);
	    }*/
}
