<%@include file="/common/header.jsp" %>



<section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb">
			<div class="overlay"></div>
    	<div class="container">
    		<div class="row d-md-flex justify-content-center">
    			<div class="col-md-12">
	    			<div class="wrap-appointment d-md-flex">
		    			<div class="col-md-12 bg-primary p-5 heading-section heading-section-white">
		    				<span class="subheading">Familiares</span>
		    				<h2 class="mb-4">Adjunta a tu familiar</h2>
		    				 <form action="<%=ControllerPath.MAIN_CONTEXT%>asistido" method="post" class="appointment">
		    				<input type="hidden" name="<%=ParameterNames.ACTION%>" value="<%=ActionNames.FAMILIAR_SEARCH%>"/>
		    					<div class="row justify-content-center">
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="<%=ParameterNames.DNI_FAMILIAR%>" placeholder="DNI de tu familiar">
					            </div>
										</div>
										
										<div class="col-md-6">
											<div class="form-group">
					              <input type="submit" value="Buscar Familiar" class="btn btn-secondary py-3 px-4">
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