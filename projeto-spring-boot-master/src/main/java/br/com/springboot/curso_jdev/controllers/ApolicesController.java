package br.com.springboot.curso_jdev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev.model.Apolices;
import br.com.springboot.curso_jdev.repository.ApolicesRepository;

@RestController
public class ApolicesController {
	
	@Autowired // *IC/CD OU CDI - Injeção de Dependencia
	private ApolicesRepository apolicesRepository;
	
	// ------------------------------------------------ //
	
    @PostMapping (value = "salvarApo")                                                 //mapeia a url
    @ResponseBody                                                                     //descrição da resposta
    public ResponseEntity<Apolices> salvarApo (@RequestBody Apolices apolices){        //recebe os dados para salvar
    	
    	Apolices user = apolicesRepository.save(apolices);
    	
    	return new ResponseEntity<Apolices>(user, HttpStatus.CREATED);
    }
    
    // ------------------------------------------------ //
    
    @GetMapping (value = "listatodosApo")                                     //Primeira API ( LIST )
    @ResponseBody                                                          //retorna os dados para o corpo da responta (JSON)
    public ResponseEntity<List<Apolices>> listaApolices() {
    	
    	List<Apolices> apolices = apolicesRepository.findAll();                //executa a consulta no bando de dados
    	
    	return new ResponseEntity<List<Apolices>> (apolices, HttpStatus.OK);    //retorna a lista em JSON
    }
    
    // ------------------------------------------------ //
    
    @DeleteMapping (value = "deleteApo")     //mapeia a url
    @ResponseBody                     //descrição da resposta
    public ResponseEntity<String> deleteApo (@RequestParam Long iduser){    
    	
    	apolicesRepository.deleteById (iduser);
    	
    	return new ResponseEntity<String>("Apolice deletado com sucesso", HttpStatus.OK);
    }
   
    // ----------------------------------------------------------------------- //
    
    @GetMapping (value = "buscaruseridApo")     
    @ResponseBody                          
    public ResponseEntity<Apolices> buscaruseridApo (@RequestParam (name = "iduser") Long iduser){    
    	
    	Apolices apolices = apolicesRepository.findById(iduser).get();
    	
    	return new ResponseEntity<Apolices> (apolices, HttpStatus.OK);
    }
    
    // ----------------------------------------------------------------------- //
    
    @PutMapping (value = "atualizarApo")     
    @ResponseBody                     
    public ResponseEntity<?> atualizar (@RequestBody Apolices apolices){    
    	
    	if (apolices.getId() == null) {   
    		return new ResponseEntity<String> ("Id nao foi encontrado para atualização.", HttpStatus.OK);
    	}
    	
    	Apolices user = apolicesRepository.saveAndFlush(apolices);
    	
    	return new ResponseEntity<Apolices>(user, HttpStatus.OK);
    }

    // ----------------------------------------------------------------------- //
    
    @GetMapping (value = "buscarPorApo")
    @ResponseBody ResponseEntity<List<Apolices>> buscarPorApo (@RequestParam (name = "name") String numero_apolice){     
    	
    	List<Apolices> apolices = apolicesRepository.buscarPorApolicesList(numero_apolice.trim().toUpperCase() );               
    	                                                                                                        
    	return new ResponseEntity<List<Apolices>> (apolices, HttpStatus.OK);
    }
}