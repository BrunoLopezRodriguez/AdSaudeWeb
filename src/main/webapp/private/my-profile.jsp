<%@include file="/common/header.jsp" %>


	
	
		
	
		
	<section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb">
			<div class="overlay"></div>
    	<div class="container">
    		<div class="row d-md-flex justify-content-center">
    			<div class="col-md-12">
	    			<div class="wrap-appointment d-md-flex">
		    			<div class="col-md-12 bg-primary p-5 heading-section heading-section-white">
		    				<span class="subheading">Mi perfil</span>
		    	<div><h5><a href="<%=ControllerPath.MAIN_CONTEXT%>private/my-profile-editar.jsp">Editar perfil</a></h5></div>
		    					<div class="row justify-content-center">
		    					<div class="col-md-6">
											<div class="form-group">
											
					             <!-- Img del perfil -->
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
											
					              <p> Nombre : <%=usuario.getNombre()%></p>
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					             <p>1º Apellido : <%=usuario.getApellido1()%></p>
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					             <p>2º Apellido : <%=usuario.getApellido2() %></p>
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					             <p>Tlf : <%=usuario.getTlf() %></p>
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					            <p>Nif : <%=usuario.getNif() %></p>
					            </div>
										</div>							
										
										<div class="col-md-6">
											<div class="form-group">
					            <p>Domicilio : <%=usuario.getDomicilio()%></p>
					            </div>
										</div>
										
										<div class="col-md-6">
											<div class="form-group">
					    					<div class="input-wrap">
					            	
					            		<p>E-mail : <%=usuario.getEmail() %></p>
				            		</div>
					    				</div>
										</div>
				
										
		    					</div>
			         
		    			</div>
		    			
		    		</div>
		    	</div>
    		</div>
    	</div>
    </section>
	



<%@include file="/common/footer.jsp" %>