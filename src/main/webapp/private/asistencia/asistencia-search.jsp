<%@include file="/common/header.jsp" %>

<script>
function buscarTipoAsistenciaSearchAjax() {
          var url = '/ADSaudeWeb/asistido';
              $.ajax({           	
                 type: "GET",
                 url: url,
             data: "action=servicioHijaSearch",
             success: function(data) {
              for (i = 0; i<data.length; i++) {
                            $('#tipoServicioHija').append('<option value="'+data[i].id+'">'+data[i].nombre+'</option>');
              }
            }
          });
      }
function buscarAsistidoSearchAsistenciaAjax() {
    var url = '/ADSaudeWeb/asistido';
        $.ajax({           	
           type: "GET",
           url: url,
       data: "action=asistidoSearchAsistencia",
       success: function(data) {
        for (i = 0; i<data.length; i++) {
                      $('#asistidoSelect').append('<option value="'+data[i].id+'">'+data[i].nombre+'</option>');
        }
      }
    });
}
function buscarEmpleadoSearchAsistenciaAjax() {
    var url = '/ADSaudeWeb/asistido';
        $.ajax({           	
           type: "GET",
           url: url,
       data: "action=empleadoSearchAsistencia&tipoAsistencia="+$('#tipoServicioHija').val(),
       success: function(data) {
        for (i = 0; i<data.length; i++) {
                      $('#empleadoSelect').append('<option value="'+data[i].id+'">'+data[i].nombre+'</option>');
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
		    				<h2 class="mb-4">Busqueda de asistencias</h2>
		    				 <form action="<%=ControllerPath.MAIN_CONTEXT%>asistido" method="post">
		    				<input type="hidden" name="<%=ParameterNames.ACTION%>" value="<%=ActionNames.ASISTENCIA_SEARCH%>"/>
		    					<div class="row justify-content-center">
										<div class="col-md-6">
											<div class="form-group">
					              <input type="date" class="form-control" name="<%=ParameterNames.FECHA_DESDE%>" placeholder="Fecha Desde">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="date" class="form-control" name="<%=ParameterNames.FECHA_HASTA%>" placeholder="Fecha hasta">
					            </div>
										</div>
										<%if(usuario.getTipo()!=10||usuario.getTipo()!=20){ %>
										<div class="col-md-6">
											<div class="form-group">
					              <select class="form-control" id="asistidoSelect" name="<%=ParameterNames.ASISTIDO_ID%>" >
					              <option>Seleciona el Asistido</option>
					              </select>
					            </div>
										</div>
									<%} %>
										<div class="col-md-6">
											<div class="form-group">
					              <select class="form-control" id="tipoServicioHija" name="<%=ParameterNames.ASISTENCIA_ID%>" onchange="buscarEmpleadoSearchAsistenciaAjax()">
					              	<option>Seleciona el tipo de asistencia</option>
					              </select>
					            </div>
										</div>
										<%if(usuario.getTipo()!=30||usuario.getTipo()!=40){ %>
										<div class="col-md-6">
											<div class="form-group">
					              <select class="form-control" id="empleadoSelect" name="<%=ParameterNames.EMPLEADO_ID%>" >
					              <option>Selecione el tipo de asistencia primero</option>
					              </select>
					            </div>
										</div>
										<%} %>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="submit" value="Buscar" class="btn btn-secondary py-3 px-4">
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

<script> $(document).ready(buscarTipoAsistenciaSearchAjax());
$(document).ready(buscarAsistidoSearchAsistenciaAjax());
</script>

<%@include file="/common/footer.jsp" %>