package conversor.api;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConversor {
		
		public void genJSON() {
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
}
