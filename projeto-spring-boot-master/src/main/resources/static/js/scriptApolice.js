function salvarApolices() {
	
	var id =               $("#id").val();
	var numero_apolice =   $("#numero_apolice").val();
	var inicio_vigencia =  $("#inicio_vigencia").val();
	var fim_vigencia =     $("#fim_vigencia").val();
	var placa_veiculo =    $("#placa_veiculo").val();
	var valor_apolice =    $("#valor_apolice").val();
	
	if (inicio_vigencia == null || inicio_vigencia != null && inicio_vigencia.trim() == '') {
	    alert('Informe o Inicio de sua Vigencia');
	    return;
	}
	
	if (fim_vigencia == null || fim_vigencia != null && fim_vigencia.trim() == '') {
	    alert('Informe o Fim de sua Vigencia');
	    return;
	}
	
	if (placa_veiculo == null || placa_veiculo != null && placa_veiculo.trim() == '') {
	    alert('Informe uma Placa de Veiculo valida');
	    return;
	}
	
	if (valor_apolice == null || valor_apolice != null && valor_apolice.trim() == '') {
	    alert('Informe o Valor da apolice por favor');
	    return;
	}

	$.ajax({
		method: "POST",
		url : "salvarApo",
		data : JSON.stringify({
			id : id, 
			numero_apolice : numero_apolice,
			inicio_vigencia : inicio_vigencia,
			fim_vigencia : fim_vigencia,
			placa_veiculo : placa_veiculo,
			valor_apolice : valor_apolice	
		}),
		contentType: "application/json; charset-utf-8",

		success: function (response) {

			$("#id").val(response.id);
			alert ("Apolice Salvo com sucesso!!!");
			
			}
	
	}).fail(function (xhr, status, errorThrown) {
		    alert("Erro ao salvar Apolice");
    });
}

function botaoDeletar() {

        var id = $('#id').val();
        
        if (id != null && id.trim() != '') {
            deleteUser(id);
            document.getElementById ('formCadApolices').reset();
        }
      }
      
function deleteUser(id) {

        if (confirm('Deseja Realmente Deletar essa Apolice?')) {

    	$.ajax({
    		method: "DELETE",
    		url: "deleteApo",
    		data : "iduser=" + id ,
    		success: function (response) {

        		$('#'+ id).remove();
        		
        		alert(response);
    		}
    	
    	}).fail(function (xhr, status, errorThrown) {
    		    alert("Erro ao deletar essa Apolice por ID");
        });
       }
      }

function pesquisaApolice() {

        var numero_apolice = $('#apoliceBusca').val();

        if (numero_apolice != null && numero_apolice.trim() != '') {

        	$.ajax({
        		method: "GET",
        		url : "buscarPorApo",
        		data : "name=" + numero_apolice ,
        		success: function (response) {
            		$('#tabelaresultados > tbody > tr').remove();

            		for (var i = 0; i < response.length; i++) {
                		$('#tabelaresultados > tbody').append('<tr id="'+response[i].id+'"><td>'+response[i].id+'</td> <td>'+response[i].numero_apolice+'</td> <td><button type="button" onclick="colocarEmEdicao('+response[i].id+')" class="btn btn-primary"> Ver Apolice </button></td> <td><button type="button" class="btn btn-danger" onclick="deleteUser('+response[i].id+')"> Deletar Apolice </button></td> </tr>');     
                	}
        		}
        	
        	}).fail(function (xhr, status, errorThrown) {
        		    alert("Erro ao buscar essa Apolice: " + xhr.responseText);
            });
          }
        }

function colocarEmEdicao(id) {

            var numero_apolice = $('#apoliceBusca').val();

            if (numero_apolice != null && numero_apolice.trim() != '') {

            	$.ajax({
            		method: "GET",
            		url : "buscaruseridApo",
            		data : "iduser=" + id ,
            		success: function (response) {

            			$("#id").val(response.id);
            			$("#numero_apolice").val(response.numero_apolice);
            			$("#inicio_vigencia").val(response.inicio_vigencia);
            			$("#fim_vigencia").val(response.fim_vigencia);
            			$("#placa_veiculo").val(response.placa_veiculo);
            			$("#valor_apolice").val(response.valor_apolice);

            			$('#modalPesquisa').modal('hide');
            		}
            	
            	}).fail(function (xhr, status, errorThrown) {
            		    alert("Erro ao buscar essa Apolice por ID");
                });
              }    
    }

/* função para gerar os numeros aleatorios da apolice */
function numero_apolice(len){
  return Math.floor(Math.random() * Math.pow(10, len));
}

function setRand(){
   document.getElementById('numero_apolice').value = numero_apolice(9); 
}