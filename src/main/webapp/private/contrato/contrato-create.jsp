<%@include file="/common/header.jsp" %>


<script>

function buscarServiciosHijasAjax() {

          var url = '/ADSaudeWeb/asistido';

              $.ajax({

            	
                 type: "GET",

                 url: url,

             data: "action=servicioHijaSearch",

             success: function(data) {

              for (i = 0; i<data.length; i++) {

                            $('#servicioHija').append('<option value="'+data[i].id+'">'+data[i].nombre+'</option>');

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
		    				<span class="subheading">Contratacion</span>
		    				<h2 class="mb-4">Crea tu contrato</h2>
		    				 <form action="<%=ControllerPath.MAIN_CONTEXT%>asistido" method="post" class="appointment">
		    				<input type="hidden" name="<%=ParameterNames.ACTION%>" value="<%=ActionNames.CREATE_CONTRATO%>"/>
		    					<div class="row justify-content-center">
										<div class="col-md-6">
											<div class="form-group">
					              <input type="date" class="form-control" name="<%=ParameterNames.FECHA_INICIO%>">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="date" class="form-control" name="<%=ParameterNames.FECHA_FIN%>" >
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <select  class="form-control" id="servicioHija" name="<%=ParameterNames.SERVICIO_HIJA%>">
					              </select>
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <textarea name="<%=ParameterNames.DESCRPCION_CONTRATO%>" class="form-control" rows="10" cols="40" placeholder="Describenos que necesita"></textarea>
					            </div>
										</div>
										
										<span id="masLineas">
										
										</span>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="submit" value="Crear Contrato" class="btn btn-secondary py-3 px-4">
					            </div>
										</div>
		    					</div>
			          </form>
		    			</div>
		    			
		    		</div>
		    	</div>
    		</div>
    	</div>
    </section>



<script> $(document).ready(buscarServiciosHijasAjax()); </script>

<%@include file="/common/footer.jsp" %>