package br.com.springboot.curso_jdev.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.springboot.curso_jdev.model.Clientes;
import br.com.springboot.curso_jdev.repository.ClientesRepository;

@Controller
public class ClientesController {
	

	@Autowired // *IC/CD OU CDI - Injeção de Dependencia
	private ClientesRepository clientesRepository;
	
	// ------------------------------------------------ //
	
    @PostMapping (value = "salvar")                                              //mapeia a url
    @ResponseBody                                                                    //descrição da resposta
    public ResponseEntity<Clientes> salvar (@RequestBody Clientes clientes){    //recebe os dados para salvar
    	
    	Clientes user = clientesRepository.save(clientes);
    	
    	return new ResponseEntity<Clientes>(user, HttpStatus.CREATED);
    }
    
    // ------------------------------------------------ //
    
    @GetMapping (value = "listatodos")                                     //Primeira API ( LIST )
    @ResponseBody                                                          //retorna os dados para o corpo da responta (JSON)
    public ResponseEntity<List<Clientes>> listaClientes() {
    	
    	List<Clientes> clientes = clientesRepository.findAll();                //executa a consulta no bando de dados
    	
    	return new ResponseEntity<List<Clientes>> (clientes, HttpStatus.OK);    //retorna a lista em JSON
    }
    
    // ------------------------------------------------ //
    
    @DeleteMapping (value = "delete")     //mapeia a url
    @ResponseBody                     //descrição da resposta
    public ResponseEntity<String> delete (@RequestParam Long iduser){    
    	
    	clientesRepository.deleteById (iduser);
    	
    	return new ResponseEntity<String>("Cliente deletado com sucesso", HttpStatus.OK);
    }
   
    // ----------------------------------------------------------------------- //
    
    @GetMapping (value = "buscaruserid")     //mapeia a url
    @ResponseBody                           //descrição da resposta
    public ResponseEntity<Clientes> buscaruserid (@RequestParam (name = "iduser") Long iduser){    
    	
    	Clientes clientes = clientesRepository.findById(iduser).get();
    	
    	return new ResponseEntity<Clientes> (clientes, HttpStatus.OK);
    }
    
    // ----------------------------------------------------------------------- //
    
    @PutMapping (value = "atualizar")     //mapeia a url
    @ResponseBody                     //descrição da resposta
    public ResponseEntity<?> atualizar (@RequestBody Clientes clientes){    //recebe os dados para salvar
    	
    	if (clientes.getId() == null) {   //se o ID for igual a nulo(nao existe) exibir essa mensagem
    		return new ResponseEntity<String> ("Id nao foi encontrado para atualização.", HttpStatus.OK);
    	}
    	
    	Clientes user = clientesRepository.saveAndFlush(clientes);
    	
    	return new ResponseEntity<Clientes>(user, HttpStatus.OK);
    }

    // ----------------------------------------------------------------------- //
    
    @GetMapping (value = "buscarPorNome")
    @ResponseBody ResponseEntity<List<Clientes>> buscarPorNome (@RequestParam (name = "name") String nome){     //retorna uma lista de usuarios, e passa o paramentro "name" para fazer a busca por nomes
    	
    	List<Clientes> clientes = clientesRepository.buscarPorNomeList(nome.trim().toUpperCase() );               // "trim" serve para tirar os espaços na hora de pesquisar                                                   
    	                                                                                                        // "toUpperCase" serve para ignorar se o caracter é maiusculo ou minusculo 
    	return new ResponseEntity<List<Clientes>> (clientes, HttpStatus.OK);
    }
}