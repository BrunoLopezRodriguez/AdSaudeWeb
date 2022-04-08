<%@include file="/common/header.jsp" %>

<section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb">
    <div class="overlay"></div>
<div class="container">
    <div class="row d-md-flex justify-content-center">
        <div class="col-md-12">
            <div class="wrap-appointment d-md-flex">
                <div class="col-md-12 bg-primary p-5 heading-section heading-section-white">
                    <span class="subheading">Logueate!</span>
                    <h2 class="mb-4">Login</h2>
                    
                        <div class="row justify-content-center">
                                <div class="col-md-6">
                                    <div class="form-group">
                         <form method="get" action="/ADSaudeWeb/common/login-asistido.jsp">
    						<button type="submit" class="btn btn-secondary py-3 px-4">Soy asistido</button>
						</form>
                        </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                    <form method="get" action="/ADSaudeWeb/common/login-familiar.jsp">
    									<button type="submit" class="btn btn-secondary py-3 px-4">Soy familiar</button>
									</form>
                           </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                    <form method="get" action="/ADSaudeWeb/common/login-empleado.jsp">
    									<button type="submit" class="btn btn-secondary py-3 px-4">Soy empleado</button>
									</form>
                           </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                    <form method="get" action="/ADSaudeWeb/common/login-medico.jsp">
    									<button type="submit" class="btn btn-secondary py-3 px-4">Soy medico</button>
									</form>
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