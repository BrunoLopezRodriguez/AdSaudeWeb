

<%@include file="/common/header.jsp" %>

<section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb">
			<div class="overlay"></div>
    	<div class="container">
    		<div class="row d-md-flex justify-content-center">
    			<div class="col-md-12">
	    			<div class="wrap-appointment d-md-flex">
		    			<div class="col-md-12 bg-primary p-5 heading-section heading-section-white">
		    				<h2 class="mb-4">Busqueda de asistencias</h2>
		    				 <form action="/ADSaudeWeb/asistencia" method="post">
		    				<input type="hidden" name="action" value=""/>
		    					<div class="row justify-content-center">
										<div class="col-md-6">
											<div class="form-group">
					              <input type="date" class="form-control" name="fecha-desde" placeholder="Fecha Desde">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="date" class="form-control" name="fecha-hasta" placeholder="Fecha hasta">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="asistido-id" placeholder="asistido Id">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="asistencia-id" placeholder="asistencia Id">
					            </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
					              <input type="text" class="form-control" name="empleado-id" placeholder="empleado Id">
					            </div>
										</div>
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

<%@include file="/common/footer.jsp" %>