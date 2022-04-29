<%@include file="/common/header.jsp" %>


	<section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb">
			<div class="overlay"></div>
    	<div class="container">
    		<div class="row d-md-flex justify-content-center">
    			<div class="col-md-12">
	    			<div class="wrap-appointment d-md-flex">
		    			<div class="col-md-12 bg-primary p-5 heading-section heading-section-white">
		    				<span class="subheading">Edita tu perfil</span>
		    				<h2 class="mb-4">Editando</h2>
		    				 <form action="<%=ControllerPath.MAIN_CONTEXT%>asistido" method="post" class="appointment">
		    				 <%Integer tipo=usuario.getTipo();
		    				 	if(tipo==TipoUsuario.ASISTIDO||tipo==TipoUsuario.ASISTIDO_DTO){%>
		    				<input type="hidden" name="<%=ParameterNames.ACTION%>" value="<%=ActionNames.EDITAR_ASISTIDO%>"/>
		    				<%}else if (tipo==TipoUsuario.FAMILIAR || tipo==TipoUsuario.FAMILIAR_DTO){ %>
		    				<input type="hidden" name="<%=ParameterNames.ACTION%>" value="<%=ActionNames.EDITAR_FAMILIAR%>"/>
		    				<%} %>
		    					<div class="row justify-content-center">
										<div class="col-md-6">
											<div class="form-group">
											<p>Nombre: </p>
					              <input type="text" class="form-control" name="<%=ParameterNames.NOMBRE%>" value="<%=usuario.getNombre()%>">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
											<p>1º Apellido: </p>
					              <input type="text" class="form-control" name="<%=ParameterNames.APELLIDO1%>" value="<%=usuario.getApellido1()%>">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
											<p>2º Apellido: </p>
					              <input type="text" class="form-control" name="<%=ParameterNames.APELLIDO2%>" value="<%=usuario.getApellido2()%>">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
											<p>Telefono: </p>
					              <input type="text" class="form-control" name="<%=ParameterNames.TELEFONO%>" value="<%=usuario.getTlf()%>">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
											<p>Nif: </p>
					              <input type="text" class="form-control" name="<%=ParameterNames.NIF%>" value="<%=usuario.getNif()%>">
					            </div>
										</div>							
										
										<div class="col-md-6">
											<div class="form-group">
											<p>Direccion: </p>
					              <input type="text" class="form-control" name="<%=ParameterNames.DIRECCION%>" value="<%=usuario.getDomicilio()%>">
					            </div>
										</div>
										
										<div class="col-md-6">
											<div class="form-group">
					    					<div class="input-wrap">
					            	<p>Email: </p>
					            		<input type="email" class="form-control" name="<%=ParameterNames.EMAIL%>" value="<%=usuario.getEmail()%>">
				            		</div>
					    				</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
											<p><!-- Editar contraseña --> </p>
					             
					            </div>
										</div>
				
										<div class="col-md-6">
											<div class="form-group">
					              <input type="submit" value="Editar Perfil" class="btn btn-secondary py-3 px-4">
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


<%@include file="/common/footer.jsp" %>