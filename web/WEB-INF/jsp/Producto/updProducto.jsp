<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modificar Producto!</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-lg-5 control-label">Codigo del producto: </label>
                <div class="col-lg-7">
                    <input type="number" class="form-control" ng-model="Producto.codigo">
                </div>
            </div>
            
            <div class="form-group">
                <label class="col-lg-5 control-label">Nombre del Producto: </label>
                <div class="col-lg-7">
                    <input type="text" class="form-control" ng-model="Producto.nombreProducto">
                </div>
            </div>

            <div class="form-group"s>
                <label class="col-lg-5 control-label">Seleccione el tipo de producto: </label>
                <div class="col-lg-7" ng-init="allTiposProductos()">
                    <select class="form-control" ng-model="Producto.tipoproducto" ng-options="tipo as tipo.nombreTipo for tipo in tipos track by tipo.idTipoProducto" >
                        <option value="">--Elige el tipo de producto--</option>
                      </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-5 control-label">Descipción del producto: </label>
                <div class="col-lg-7">
                    <textarea class="form-control" rows="2" ng-model="Producto.descripccion"></textarea>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-5 control-label">Valor: </label>
                <div class="col-lg-7">
                    <input type="number" class="form-control" id="ejemplo_email_3" ng-model="Producto.valor">
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-5 control-label">Stock: </label>
                <div class="col-lg-7">
                    <input type="number" class="form-control" id="ejemplo_email_3" ng-model="Producto.stock">
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-5 control-label">Descuento: </label>
                <div class="col-lg-7">
                    <input type="number" class="form-control" id="ejemplo_email_3" ng-model="Producto.dsct">
                </div>
            </div>                

            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary" ng-click="updateProducto(Producto.idProducto)"  data-dismiss="modal">Modificar</button>
            </form>
          </div>
        
        </div>
    </div>
</div>