<%@include file="/common/header.jsp" %>
<script>
function buscarTipoIncidenciaAjax() {
          var url = '/ADSaudeWeb/asistido';
              $.ajax({           	
                 type: "GET",
                 url: url,
             data: "action=tipoIncidenciaSearch",
             success: function(data) {
              for (i = 0; i<data.length; i++) {
                            $('#tipoIncidencia').append('<option value="'+data[i].id+'">'+data[i].nombre+'</option>');
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
		    				<span class="subheading">Panel de Incidencias</span>
		    				<h2 class="mb-4">Dinos tu incidencia</h2>
		    				<h3 class="mb-4"><a href="<%=ControllerPath.MAIN_CONTEXT%>asistido?action=<%=ActionNames.INCIDENCIA_SEARCH_C%>">Ver mis Incidencias</a></h3>
		    				 <form action="<%=ControllerPath.MAIN_CONTEXT%>asistido" method="post" class="appointment">
		    				<input type="hidden" name="<%=ParameterNames.ACTION%>" value="<%=ActionNames.INCIDENCIA_CREATE%>"/>
		    					<div class="row justify-content-center">
										<div class="col-md-6">
											<div class="form-group">
					              <input type="date" class="form-control" name="<%=ParameterNames.FECHA_INCIDENCIA%>">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <select name="<%=ParameterNames.TIPO_INCIDENCIA%>" class="form-control" id="tipoIncidencia">
					              
					              </select>
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					               <input type="text" class="form-control" name="<%=ParameterNames.RESUMEN%>" placeholder="Resumen corto">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <textarea name="<%=ParameterNames.DESCRPCION%>" class="form-control" rows="10" cols="40" placeholder="Describenos el problema"></textarea>
					            </div>
										</div>																				
										<div class="col-md-6">
											<div class="form-group">
					              <input type="submit" value="Enviar Incidencia" class="btn btn-secondary py-3 px-4">
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
    
    <script> $(document).ready(buscarTipoIncidenciaAjax()); </script>
    
    <%@include file="/common/footer.jsp" %>