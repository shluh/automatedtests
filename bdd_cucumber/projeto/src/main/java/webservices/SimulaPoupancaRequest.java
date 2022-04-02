package webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimulaPoupancaRequest {
	public String GETRequest(String url) throws IOException{
		URL uri = new URL(url);
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) uri.openConnection();

		conection.setRequestMethod("GET");
		int responseCode = conection.getResponseCode();
		
		StringBuffer response = null;

		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			response = new StringBuffer();
			while ((readLine = buffer.readLine()) != null) {
				response.append(readLine);
			}
			buffer.close();
		
		} else {

			System.out.println("Request inv�lido");
		}

		return response.toString();
	}
	
	public static final String jsonBase ="{\"id\":1,\"meses\":[\"112\",\"124\",\"136\",\"148\"],\"valor\":[\"2.802\",\"3.174\",\"3.564\",\"3.971\"]}";

}
