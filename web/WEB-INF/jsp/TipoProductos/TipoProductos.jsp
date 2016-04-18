<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="tipos" >
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">       
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>
        <script src='//ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-route.js'></script>
        <script src='http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-resource.js'></script>
        <script type="text/javascript" src="<c:url value="/resources/js/tipoProductoController.js" />"></script>
        <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
  
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
        <script type="text/javascript">
            function LimpiarFormulario(){
                document.getElementById("nombreTipo").value = "";
            }
        </script>
    </head>

    <body ng-controller="TiposProductosController"  >   
        <!-- importa para el toobar de la cabecera -->
        <c:import url="../pagina/toobar.jsp" />          
       
        <div ng-bind-html="renderHtml(msge)"></div>
        <div class="section">
            <div class="container">
                <form class="form-inline">
                    <div class="form-group" col-md-12>
                        <label>Nombre del tipo de producto: </label>
                        <input type="text" minlength="1" class="form-control" id="nombreTipo" ng-model="nombreTipo" placeholder="ejemplo: Arroz" name="nombreTipo"/>
                    </div>
                    <button id="addBtn" class="btn btn-default" ng-click="addTipos()" onclick="LimpiarFormulario()">Añadir tipo de producto</button>
                </form>
                 <hr>
            </div>
        </div>
        <div class="section" >
            <div class="container">
                <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-heading"><span class="lead">Lista de tipos de productos </span></div>
                        <div class="tablecontainer">
                            <table class="table table-hover" ng-init="allTiposProductos()">
                                <thead>
                                    <tr >
                                        <th>#</th>
                                        <th>Nombre</th>
                                        <th>Operaciones</th>
                                        <!--<th class="text-center">Editar</th>-->
                                        
                                    </tr>
                                </thead>
                                <!-- iteritamos los tipos de productos que existen en la BD -->
                                <tbody ng-show="tipos!== null">
                                    <tr ng-repeat="Tipoproducto in filteredtipos" >
                                        <td>{{Tipoproducto.idTipoProducto}}</td>
                                        <td >{{Tipoproducto.nombreTipo}}</td>
                                        <!--<td class="text-center"><a href="" ng-click="getTipoProducto(Tipoproducto.idTipoProducto)" data-toggle="modal" data-target="#myModal"><i class="fa fa-fw fa-lg fa-pencil-square-o"></i></a></td>-->
                                        <td><a class="col-md-1 text-left" href="" ng-click="getTipoProducto(Tipoproducto.idTipoProducto)" data-toggle="modal" data-target="#myModal"><i class="fa fa-fw fa-lg fa-pencil-square-o"></i></a><a href="#" ng-click="deleteTipo(Tipoproducto.idTipoProducto)"><i class="fa fa-fw fa-lg -square-o fa-remove" style="color: red" ></i></a></td>
                                    </tr>								
                                </tbody>
                                <!-- fin de la iteración -->
                            </table>                        
                        </div>
                    </div>
                    <div class=" col-md-12 text-right">
                        <pagination total-items="totalItems" ng-model="currentPage" max-size="maxSize" class="pagination-sm" boundary-links="true" rotate="false" num-pages="numPages" items-per-page="numPerPage"></pagination>
                    </div>
                </div>                
            </div>
        </div>
        <div  ng-show="tipoProducto!==null">
            <!-- Modal para modificar el tipo de producto -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                  </div>
                  <div class="modal-body">
                    <form class="form-inline">
                        <div class="form-group" col-md-12 >
                            <label>Nombre del tipo de producto: </label>
                            <input type="text" minlength="1" class="form-control" id="nombreTipo" ng-model="tipoProducto.nombreTipo" name="nombreTipo">
                        </div>                    
                    
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" ng-click="updateTipo(tipoProducto.idTipoProducto)" onclick="LimpiarFormulario()" data-dismiss="modal">Modificar</button>
                </form>
                  </div>
                </div>
              </div>
            </div>
            <!-- fin del modal -->
        </div>
        <!-- import del footer de la pagina --> 
        <c:import url="../pagina/footer.jsp" />
    </body>
</html>