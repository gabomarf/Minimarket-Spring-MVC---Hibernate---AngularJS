<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="productos" >
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">       
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>
        <script src='//ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-route.js'></script>
        <script src='http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-resource.js'></script>
        <script type="text/javascript" src="<c:url value="/resources/js/productosController.js" />"></script>
        <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
  
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
        </head>

    <body ng-controller="ProductosController"  >  
        <!-- importa para el toobar de la cabecera -->
        <c:import url="../pagina/toobar.jsp" />          
       <!-- inscrusta mensaje de la acción realizada -->
        <div ng-bind-html="renderHtml(msge)"></div>
        
        <div class="section">
            <div class="container">
                <button type="button" data-toggle="modal" data-target="#myModalAgregar">Agregar Producto</button>                
                 <hr>
            </div>
        </div>
        <div class="section" >
            <div class="container">
                <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-heading"><span class="lead">Lista de tipos de productos </span></div>
                        <div class="tablecontainer">
                            <table class="table table-hover" ng-init="allProductos()">
                                <thead>
                                    <tr >
                                        <th>#Codigo</th>
                                        <th>Nombre</th>
                                        <th>Tipo de producto</th>
                                        <th>Descripción</th>
                                        <th>stock</th>
                                        <th>valor</th>
                                        <th>%descuento</th>
                                        <th>Operaciones</th>                                        
                                    </tr>
                                </thead>
                                <!-- iteritamos los productos que existen en la BD -->
                                <tbody ng-show="productos!== null">
                                    <tr ng-repeat="producto in filteredproductos" >
                                        <td>{{producto.codigo}}</td>
                                        <td>{{producto.nombreProducto}}</td>
                                        <td>{{producto.tipoproducto.nombreTipo}}</td>
                                        <td>{{producto.descripccion}}</td>
                                        <td>{{producto.stock}}</td>
                                        <td>{{producto.valor}}</td>
                                        <td>{{producto.dsct}}</td>
                                        <td><a class="col-md-4 text-left" href="" ng-click="getProducto(producto.idProducto)" data-toggle="modal" data-target="#myModal"><i class="fa fa-fw fa-lg fa-pencil-square-o"></i></a><a href="" ng-click="deleteProducto(producto.idProducto)"><i class="fa fa-fw fa-lg -square-o fa-remove" style="color: red" ></i></a></td>
                                    </tr>								
                                </tbody>
                                <!-- fin de la iteración -->
                            </table>                        
                        </div>
                    </div>
                    <!-- Paginator de la tabla -->
                    <div class=" col-md-12 text-right">
                        <pagination total-items="totalItems" ng-model="currentPage" max-size="maxSize" class="pagination-sm" boundary-links="true" rotate="false" num-pages="numPages" items-per-page="numPerPage"></pagination>
                    </div>
                    <!-- fin de la paginator -->
                </div>                
            </div>
        </div>
        <!-- Modal para Agregar producto -->
        <c:import url="addProducto.jsp" />
        
        <!-- Modal para actualizar producto -->
        <div  ng-show="Producto!==null" ng-init="allTiposProductos()">
            <c:import url="updProducto.jsp" />
        </div>
        
        
        
        <!-- import del footer de la pagina --> 
        <c:import url="../pagina/footer.jsp" />
    </body>
</html>