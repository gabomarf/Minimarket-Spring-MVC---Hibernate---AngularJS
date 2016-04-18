var app = angular.module('productos', [ 'ui.bootstrap' ]);

app.controller('ProductosController', [ '$scope', '$http', '$sce',
                                     
    function($scope, $http, $window, $sce){
        $scope.msge = "";
        //Mensaje de alerta que la acción fue realizada con exito.
        $scope.msgeOk = "<div class='alert alert-success container'><strong>La acción se ha realizado de forma exitosa</strong></div>";
        //Mensaje de alerta que la acción fue no fue realizada.
        $scope.msgeError = "<div class='alert alert-danger container'><strong>La acción no se ha podido realizar correctamente</strong> ¡Porfavor contactese con el administrador del sistema !</div>";
        $scope.Productos = [];
        $scope.Producto = null;
        $scope.tipos = [];
        
        //Método que obtiene los datos JSON de todos los productos
        $scope.allProductos = function() {
            $http.get('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/Producto/productos').success(function(data) {
                $scope.Productos = data; //obtiene los datos consegidos del GET 
                $scope.totalItems = $scope.Productos.length; // se obtiene el tamaño del arreglo obtenido
                $scope.numPerPage = 10; // cantidad de objetos obtenidos a mostrar por pagina
                $scope.currentPage = 1; // valor que la pagina se iniciara ;

                $scope.maxSize = 5;

                //Método para calcular el numro corrspondiente por pagina    
                $scope.numPages = function () {
                  return Math.ceil($scope.Productos.length / $scope.numPerPage);
                };

                //Método encargado de la paginator cuando se haga uso
                $scope.$watch("currentPage + numPerPage", function() {
                 var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                    , end = begin + $scope.numPerPage;

                 $scope.filteredproductos = $scope.Productos.slice(begin, end);
                });                                
            });
        };

        //Método para boorar un producto.
        $scope.deleteProducto = function(id){
            $http.delete('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/Producto/productos/'+id).success(function(data) {
                if(data){
                    $scope.msge = $scope.msgeOk;
                    $scope.allProductos();
                }else{
                    $scope.allTProductos();
                }
            }).error(function(data) {
                    $scope.msge = $scope.msgeError;
            });
        };

        //Método para obtener un producto.
        $scope.getProducto = function(id) {
            $http.get('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/Producto/productos/'+id).success(function(data) {
                $scope.Producto = data; 
            });
        };

        //Método para agregar un producto
        $scope.addProducto = function() {
            if($scope.nombreTipo !== null || $scope.nombreTipo!==""){
                $http.post('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/Producto/productos', 
                    {                        
                        tipoproducto : $scope.tipoproducto,
                        nombreProducto : $scope.nombreProducto,
                        descripccion : $scope.descripccion,
                        valor : $scope.valor,
                        stock : $scope.stock,
                        dsct : $scope.dsct,
                        codigo : $scope.codigo                      
                    }
                ).success(function(data) {
                    if(data){
                        $scope.msge = $scope.msgeOk;
                        $scope.allProductos();
                    }else{
                        $scope.allProductos();
                    }
                }).error(function(data) {
                        $scope.msge = $scope.msgeError;
                });
            }else{
                $window.alert('Debe ingresar algo para añadirlo a la BD');
            }
        };

        //Método para obtener todos lod tipos de productos.
        $scope.allTiposProductos = function() {
            $http.get('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/tipolist/lsttipos').success(function(data) {
                $scope.tipos = data;                                               
            });
        };

        //Método que transforma el mensaje de acción en codigo HTML.
        $scope.renderHtml = function (htmlCode) {
            return $sce.trustAsHtml(htmlCode);
        }; 

        //Método para actualizar un producto.
        $scope.updateProducto = function(id){
            $http.put('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/Producto/productos/',
            {
                idProducto: id,
                tipoproducto : $scope.Producto.tipoproducto,
                nombreProducto : $scope.Producto.nombreProducto,
                descripccion : $scope.Producto.descripccion,
                valor : $scope.Producto.valor,
                stock : $scope.Producto.stock,
                dsct : $scope.Producto.dsct,
                codigo : $scope.Producto.codigo    
            }).success(function(data) {
                if(data){
                    $scope.msge = $scope.msgeOk;
                    $scope.allProductos();
                }else{
                    $scope.allProductos();
                }
            }).error(function(data) {
                    $scope.msge = $scope.msgeError;
            });
            $scope.Producto = null;

        };
    }  
]);