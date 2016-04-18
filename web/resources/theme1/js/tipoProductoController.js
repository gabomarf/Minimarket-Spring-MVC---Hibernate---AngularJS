var app = angular.module('tipos', [ 'ui.bootstrap' ]);

app.controller('TiposProductosController', [ '$scope', '$http', '$sce',
                                     
    function($scope, $http, $sce) {
        $scope.msge = "";
        //Mensaje de alerta que la acción fue realizada con exito.
        $scope.msgeOk = "<div class='alert alert-success container'><strong>La acción se ha realizado de forma exitosa</strong></div>";
        //Mensaje de alerta que la acción fue no fue realizada.
        $scope.msgeError = "<div class='alert alert-danger container'><strong>La acción no se ha podido realizar correctamente</strong> ¡Porfavor contactese con el administrador del sistema !</div>";
        $scope.tipos = [];
        $scope.tipoProducto = null;

        //Método para obtener todos lod tipos de productos.
        $scope.allTiposProductos = function() {
            $http.get('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/tipolist/lsttipos').success(function(data) {
                $scope.tipos = data; //obtiene los datos consegidos del GET 
                $scope.totalItems = $scope.tipos.length; // se obtiene el tamaño del arreglo obtenido
                $scope.numPerPage = 10; // cantidad de objetos obtenidos a mostrar por pagina
                $scope.currentPage = 1; // valor que la pagina se iniciara 

                $scope.maxSize = 5; 

                //Método para calcular el numro corrspondiente por pagina    
                $scope.numPages = function () {
                  return Math.ceil($scope.tipos.length / $scope.numPerPage);
                };

                //Método encargado de la paginator cuando se haga uso
                $scope.$watch("currentPage + numPerPage", function() {
                 var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                    , end = begin + $scope.numPerPage;

                 $scope.filteredtipos = $scope.tipos.slice(begin, end);
                });                                
            });
        };

        //Método para agregar un tipo de producto
        $scope.addTipos = function() {
            if($scope.nombreTipo !== null || $scope.nombreTipo!==""){
                $http.post('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/tipolist/lsttipos', 
                    {
                        nombreTipo: $scope.nombreTipo                                   
                    }
                ).success(function(data) {
                    if(data){
                        $scope.msge = $scope.msgeOk;
                        $scope.allTiposProductos();
                    }else{
                        $scope.allTiposProductos();
                    }
                }).error(function(data) {
                        $scope.msge = $scope.msgeError;
                });
            }else{
                $window.alert('Debe ingresar algo para añadirlo a la BD');
            }
        };

        //Método para boorar un tipo de producto.
        $scope.deleteTipo = function(id){
            $http.delete('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/tipolist/lsttipos/'+id).success(function(data) {
                if(data){
                    $scope.msge = $scope.msgeOk;
                    $scope.allTiposProductos();
                }else{
                    $scope.allTiposProductos();
                }
            }).error(function(data) {
                    $scope.msge = $scope.msgeError;
            });
        };

        //Método para obtener un tipo de producto.
        $scope.getTipoProducto = function(id) {
            $http.get('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/tipolist/lsttipos/'+id).success(function(data) {
                $scope.tipoProducto = data; 
            });
        };
        
        //Método para actualizar un tipo de producto.
        $scope.updateTipo = function(id){
            $http.put('http://localhost:8084/Minimarket-Hibernate-SpringMVC-AngularJS/tipolist/lsttipos/',
            {
                idTipoProducto: id,
                nombreTipo: $scope.tipoProducto.nombreTipo
            }
                    ).success(function(data) {
                if(data){
                    $scope.msge = $scope.msgeOk;
                    $scope.allTiposProductos();
                }else{
                    $scope.allTiposProductos();
                }
            }).error(function(data) {
                    $scope.msge = $scope.msgeError;
            });
            $scope.tipoProducto = null;
        };

        //Método que transforma el mensaje de acción en codigo HTML.
        $scope.renderHtml = function (htmlCode) {
            return $sce.trustAsHtml(htmlCode);
        };
    }
 ]);
