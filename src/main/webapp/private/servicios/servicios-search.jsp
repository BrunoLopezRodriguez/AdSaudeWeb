<%@include file="/common/header.jsp" %>
<script>
function buscarTipoServicioPadreAjax() {
          var url = '/ADSaudeWeb/asistido';
              $.ajax({           	
                 type: "GET",
                 url: url,
             data: "action=servicioSearch",
             success: function(data) {
              for (i = 0; i<data.length; i++) {
               $('#tipoServicioPadre').append('<label><input type="checkbox" id="cbox"'+i+' value="'+data[i].id+'"> '+data[i].nombre+'</label>');
              }
            }
          });
      }
function buscarTipoServicioHijasAjax() {
    var url = '/ADSaudeWeb/asistido';
        $.ajax({           	
           type: "GET",
           url: url,
       data: "action=servicioHijaSearch",
       success: function(data) {
        for (i = 0; i<data.length; i++) {
        	<!-- Pensar en algo que pueda tener un valor para luego clicar y que me lleve a ver mas detalles -->
         $('#tipoServicioHijas').append('<tr><td>'+data[i].nombre+'<td><td>'+data[i].tiempoEstimado+'<td><td><a href="/ADSaudeWeb/asistido?action=hijaByPadre&id-hija='+data[i].id+'">Ver Mas</a><td></tr>');
        }
      }
    });
}

</script>

	<section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb">
			<div class="overlay"></div>
    	<div class="container">
    		<div class="row d-md-flex justify-content-center">
    			<div class="col-md-12">
	    			<div class="wrap-appointment d-md-flex">
		    			<div class="col-md-12 bg-primary p-5 heading-section heading-section-white">
		    				<span class="subheading">Servicios</span>
		    					<div class="row justify-content-center">
		    					
		    					
										<div class="col-md-12">
											<div class="form-group" id="tipoServicioPadre">											
					             
					            </div>
										</div>
											<div class="col-md-12">
											<div class="form-group" >											
					             			<table id="tipoServicioHijas">
					             				<tr>
					             					<td>Nombre</td>			     
					             					<td>Tiempo Estimado </td>
					             					<td></td>
					             				</tr>
					             				
					             			</table>
					            </div>
										</div>
								
														
		    					</div>			        
		    			</div>		    		
		    		</div>
		    	</div>
    		</div>
    	</div>
    </section>


<script> 
$(document).ready(buscarTipoServicioPadreAjax());
</script>
<script>
$(document).ready(buscarTipoServicioHijasAjax());
</script>

<%@include file="/common/footer.jsp" %>