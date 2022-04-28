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
                    <form action="<%=ControllerPath.MAIN_CONTEXT%>asistido" method="post" class="appointment">
                     <input type="hidden" name="<%=ParameterNames.ACTION%>" value="<%=ActionNames.LOGINFAMILIAR%>"/>
                        <div class="row justify-content-center">
                                <div class="col-md-6">
                                    <div class="form-group">
                         <input type="text" name="<%=ParameterNames.EMAIL%>" class="form-control" placeholder="Email" value="<%=ParameterUtils.print(request.getParameter(ParameterNames.EMAIL))%>"/>
                        </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                          <input type="password" name="<%=ParameterNames.PASSWORD%>" class="form-control" placeholder="Password"/>
                        </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                    <label><input name="<%=ParameterNames.KEEP_AUTHENTICATED%>" value="true" type="checkbox" id="recuerdame" class="search3_extras_cb">Mantener sesion iniciada</label>
                          <input type="submit" value="Login" class="btn btn-secondary py-3 px-4">
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