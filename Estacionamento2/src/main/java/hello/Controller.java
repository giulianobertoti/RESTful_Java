package hello;

import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {
	
	private Model model;
	
	
	public Controller(Model model){
		this.model = model;
	}
	
	public void buscarCarro(){
		get("/carro/:modelo/:marca/:cor", (req, res) -> {
		
			Especificacao espec = new Especificacao(req.params(":modelo"), req.params(":marca"), req.params(":cor"));	
			List<Carro> carrosEncontrados = model.buscarEspecificacao(espec);	
			return new Gson().toJson(carrosEncontrados);
			
		});
	}
	
	
	public void buscarCarroPlaca(){
		get("/carro/:placa", (req, res) -> {
		
			
			Carro carrosEncontrado = model.buscarPlaca(req.params(":placa"));	
			return new Gson().toJson(carrosEncontrado);
			
		});
	}
	
	public void buscarCarroModelo(){
		get("/carro/modelo/:modelo", (req, res) -> {
		
			
			List<Carro> carrosEncontrado = model.buscarModelo(req.params(":modelo"));	
			return new Gson().toJson(carrosEncontrado);
			
		});
	}
	
	

}
