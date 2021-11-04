function salvarClientes() {
	
	var id =      $("#id").val();
	var nome =    $("#nome").val();
	var cpf =     $("#cpf").val();
	var cidade =  $("#cidade").val();
	var uf =      $("#uf").val();
	
	if (nome == null || nome != null && nome.trim() == '') {
	    alert('Informe seu Nome Completo por favor');
	    return;
	}
	
	if (cpf == null || cpf != null && cpf.trim() == '') {
	    alert('Informe um CPF valido');
	    return;
	}
	
	if (cidade == null || cidade != null && cidade.trim() == '') {
	    alert('Informe sua Cidade');
	    return;
	}

	$.ajax({
		method: "POST",
		url : "salvar",
		data : JSON.stringify({
			id : id, 
			nome : nome, 
			cpf : cpf,
			cidade : cidade,
			uf : uf
		}),
		contentType: "application/json; charset-utf-8",

		success: function (response) {

			$("#id").val(response.id);
			alert ("Cliente Salvo com sucesso!!!");
			
			}
	
	}).fail(function (xhr, status, errorThrown) {
		    alert("Erro ao salvar esse Cliente: ");
    });
}

function mascaraCPF(i,t){
   
   var v = i.value;
   
   if(isNaN(v[v.length-1])){
      i.value = v.substring(0, v.length-1);
      return;
   }

   if(t == "cpf"){
      i.setAttribute("maxlength", "14");
      if (v.length == 3 || v.length == 7) i.value += ".";
      if (v.length == 11) i.value += "-";
   }
}

function botaoDeletar() {

        var id = $('#id').val();
        
        if (id != null && id.trim() != '') {
            deleteUser(id);
            document.getElementById ('formCadCliente').reset();
        }
      }
      
      function deleteUser(id) {

        if (confirm('Deseja Realmente Deletar esse cliente?')) {

    	$.ajax({
    		method: "DELETE",
    		url: "delete",
    		data : "iduser=" + id ,
    		success: function (response) {

        		$('#'+ id).remove();
        		
        		alert(response);
    		}
    	
    	}).fail(function (xhr, status, errorThrown) {
    		    alert("Erro ao deletar Usuario por ID");
        });
       }
      }

function pesquisaUser() {

        var nome = $('#nameBusca').val();

        if (nome != null && nome.trim() != '') {

        	$.ajax({
        		method: "GET",
        		url : "buscarPorNome",
        		data : "name=" + nome ,
        		success: function (response) {
            		$('#tabelaresultados > tbody > tr').remove();

            		for (var i = 0; i < response.length; i++) {
                		$('#tabelaresultados > tbody').append('<tr id="'+response[i].id+'"><td>'+response[i].id+'</td> <td>'+response[i].nome+'</td> <td><button type="button" onclick="colocarEmEdicao('+response[i].id+')" class="btn btn-primary"> Ver Cliente </button></td> <td><button type="button" class="btn btn-danger" onclick="deleteUser('+response[i].id+')"> Deletar Cliente </button></td> </tr>');     
                	}
        		}
        	
        	}).fail(function (xhr, status, errorThrown) {
        		    alert("Erro ao buscar esse cliente: " + xhr.responseText);
            });
          }
        }

function colocarEmEdicao(id) {

            var nome = $('#nameBusca').val();

            if (nome != null && nome.trim() != '') {

            	$.ajax({
            		method: "GET",
            		url : "buscaruserid",
            		data : "iduser=" + id ,
            		success: function (response) {

            			$("#id").val(response.id);
            			$("#nome").val(response.nome);
            			$("#cpf").val(response.cpf);
            			$("#cidade").val(response.cidade);
            			$("#uf").val(response.uf);

            			$('#modalPesquisa').modal('hide');
            		}
            	
            	}).fail(function (xhr, status, errorThrown) {
            		    alert("Erro ao buscar esse Cliente por ID");
                });
              }    
    }