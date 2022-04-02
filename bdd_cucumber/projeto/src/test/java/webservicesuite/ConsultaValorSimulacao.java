package webservicesuite;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import webservices.SimulaPoupancaRequest;

public class ConsultaValorSimulacao {
	@Test
	public void ConsultaValorPoupanca() throws IOException{

		SimulaPoupancaRequest spr = new SimulaPoupancaRequest();
		assertTrue(spr.GETRequest(utils.Uri.SimulaOpcao).equals(SimulaPoupancaRequest.jsonBase));
		
	}
}
