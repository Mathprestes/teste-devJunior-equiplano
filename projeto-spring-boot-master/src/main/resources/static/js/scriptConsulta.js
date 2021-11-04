function pesquisaApolice1() {

        var numero_apolice = $('#apoliceBusca1').val();

        if (numero_apolice != null && numero_apolice.trim() != '') {

        	$.ajax({
        		method: "GET",
        		url : "buscarPorApo",
        		data : "name=" + numero_apolice ,
        		success: function (response) {
            		$('#tabelaresultados1 > tbody > tr').remove();

            		for (var i = 0; i < response.length; i++) {
                		$('#tabelaresultados1 > tbody').append('<tr id="'+response[i].id+'"><td>'+response[i].id+'</td><td>'+response[i].numero_apolice+'</td><td>'+response[i].valor_apolice+'</td><td>'+response[i].placa_veiculo+'</td></tr>');
                	}
        		}
        	
        	}).fail(function (xhr, status, errorThrown) {
        		    alert("Erro ao buscar essa Apolice: " + xhr.responseText);
            });
          }
        }
        
function pesquisaApolice2() {

        var numero_apolice = $('#apoliceBusca2').val();

        if (numero_apolice != null && numero_apolice.trim() != '') {

        	$.ajax({
        		method: "GET",
        		url : "buscarPorApo",
        		data : "name=" + numero_apolice ,
        		success: function (response) {
            		$('#tabelaresultados2 > tbody > tr').remove();

            		for (var i = 0; i < response.length; i++) {
                		$('#tabelaresultados2 > tbody').append('<tr id="'+response[i].id+'"><td>'+response[i].id+'</td><td>'+response[i].numero_apolice+'</td><td>'+response[i].inicio_vigencia+'</td><td>'+response[i].fim_vigencia+'</td></tr>');
                	}
        		}
        	
        	}).fail(function (xhr, status, errorThrown) {
        		    alert("Erro ao buscar essa Apolice: " + xhr.responseText);
            });
          }
        }