<%@include file="/common/header.jsp" %>
<script>
function buscarLocalidadAjax() {
          var url = '/ADSaudeWeb/asistido';
          $("#localidad").empty();
              $.ajax({           	
                 type: "GET",
                 url: url,
             data: "action=localidadSearch&provincia="+$('#provincia').val(),
             success: function(data) {
              for (i = 0; i<data.length; i++) {
                            $('#localidad').append('<option value="'+data[i].id+'">'+data[i].nombre+'</option>');
              }
            }
          });
      } 
function buscarPaisAjax() {
    var url = '/ADSaudeWeb/asistido';
        $.ajax({     	
           type: "GET",
           url: url,
       data: "action=paisSearch",
       success: function(data) {
        for (i = 0; i<data.length; i++) {
                      $('#pais').append('<option value="'+data[i].id+'">'+data[i].nombre+'</option>');
        }
     }
    });
}
function buscarProvinciaAjax() {
    var url = '/ADSaudeWeb/asistido';
    	$("#provincia").empty();
        $.ajax({     	
           type: "GET",
           url: url,
       data: "action=provinciaSearch&pais="+$('#pais').val(),
       success: function(data) {
        for (i = 0; i<data.length; i++) {
                      $('#provincia').append('<option value="'+data[i].id+'">'+data[i].nombre+'</option>');
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
		    				<span class="subheading">Pide tu Registro</span>
		    				<h2 class="mb-4">Registro Gratis</h2>
		    				 <form action="<%=ControllerPath.MAIN_CONTEXT%>asistido" method="post" class="appointment">
		    				<input type="hidden" name="<%=ParameterNames.ACTION%>" value="<%=ActionNames.REGISTER%>"/>
		    					<div class="row justify-content-center">
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="<%=ParameterNames.NOMBRE%>" placeholder="Tu nombre">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="<%=ParameterNames.APELLIDO1%>" placeholder="Apellido 1">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="<%=ParameterNames.APELLIDO2%>" placeholder="Apellido 2">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="<%=ParameterNames.TELEFONO%>" placeholder="Numero de tlf">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="<%=ParameterNames.NIF%>" placeholder="Nif">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <select class="form-control" id="pais" name="<%=ParameterNames.PAIS%>" onchange="buscarProvinciaAjax()">
					              <option>Selecciona tu Pais</option>
					              </select>
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <select class="form-control" id="provincia" name="<%=ParameterNames.PROVINCIA%>" onchange="buscarLocalidadAjax()">
					              </select>
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <select class="form-control" id="localidad" name="<%=ParameterNames.LOCALIDAD%>">
					              </select>
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="<%=ParameterNames.DIRECCION%>" placeholder="Direccion">
					            </div>
										</div>
										
										<div class="col-md-6">
											<div class="form-group">
					    					<div class="input-wrap">
					            	
					            		<input type="text" class="form-control" name="<%=ParameterNames.EMAIL%>" placeholder="Email">
				            		</div>
					    				</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
					    					<div class="input-wrap">
					            		<input type="password" class="form-control" name="<%=ParameterNames.PASSWORD%>" placeholder="Password">
				            		</div>
					    				</div>
										</div>

										<div class="col-md-6">
											<div class="form-group">
					    					<div class="input-wrap">
					            		<input type="password" class="form-control" placeholder="Repeat Password">
				            		</div>
					    				</div>
										</div>
										
										<div class="col-md-6">
											<div class="form-group">
					              <input type="submit" value="Enviar Registro" class="btn btn-secondary py-3 px-4">
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
    
    <script> $(document).ready(buscarPaisAjax()); </script>
    <%@include file="/common/footer.jsp" %>